use std::net::SocketAddr;

use tokio::{io::{AsyncWriteExt, BufReader, AsyncBufReadExt}, net::TcpListener, sync::broadcast};

#[tokio::main]
async fn main() {
    let listener = TcpListener::bind("localhost:8080").await.unwrap();
    let (tx, _rx) = broadcast::channel::<(String, SocketAddr)>(10);
    
    loop {
        let (mut socket, addr) = listener.accept().await.unwrap();
        let tx = tx.clone();
        let mut rx = tx.subscribe();

        tokio::spawn(async move{
            let (reader, mut writer) = socket.split();
            let mut buf_reader = BufReader::new(reader);
            let mut line = String::new();
            
            loop {
                tokio::select! {
                    _ = buf_reader.read_line(&mut line) => {
                        tx.send((line.clone(), addr)).unwrap();
                        line.clear();
                    }
                    result = rx.recv() => {
                        let (msg, msg_addr) = result.unwrap();
                        if addr != msg_addr {
                            writer.write_all(msg.as_bytes()).await.unwrap();
                        }
                    }
                }
            }
        });
    }
    
}
