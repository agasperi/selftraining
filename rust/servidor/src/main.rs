use std::fs;
use std::io::{Read, Write};
use std::net::{TcpListener,TcpStream};

fn main() {
    let address = "localhost:8000";
    let listener = TcpListener::bind("localhost:8000").unwrap();
    println!("Servidor iniciado en {}.", &address);

    for s in listener.incoming() {
        let stream = s.unwrap();
        handle_connection(stream)
    }
}

fn handle_connection(mut stream: TcpStream) {
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).unwrap();
    println!("Stream recibido!");
    println!("{}", String::from_utf8_lossy(&buffer[..]));
    
    let get = b"GET /index HTTP/1.1";
    if buffer.starts_with(get) {
        send_index(stream);
    } else {
        send_not_found(stream);
    }

}

fn build_response(content: String, http_status: u32) -> String {
    format!("HTTP/1.1 {} OK\r\nContent-Length: {}\r\n\r\n{}",
        http_status,
        content.len(),
        content)
}

fn send_index(mut stream: TcpStream) {
    let content = fs::read_to_string("index.html").unwrap();
    let response = build_response(content, 200);
    stream.write(response.as_bytes()).unwrap();
    stream.flush().unwrap();
}

fn send_not_found(mut stream: TcpStream) {
    let content = fs::read_to_string("404.html").unwrap();
    let response = build_response(content, 400);
    stream.write(response.as_bytes()).unwrap();
    stream.flush().unwrap();
}