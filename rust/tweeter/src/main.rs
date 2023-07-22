use actix_web::{App, HttpServer};

mod constants;
mod tweet;
mod tweets;

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(move || {
        App::new()
        .service(tweets::get_tweets)
        .service(tweets::post_tweets)
    })
    .bind(("localhost",8000))?
    .run()
    .await
}
