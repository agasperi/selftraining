use actix_web::web::Data;
use actix_web::{App, HttpServer, Responder, HttpResponse, web};
use std::env;
use dotenvy::dotenv;
use diesel::PgConnection;
use diesel::r2d2::{ConnectionManager, Pool};

mod constants;
mod like;
mod likes;
mod tweet;
mod tweets;
mod schema;


async fn saludar() -> impl Responder {
    HttpResponse::Ok().body("Hola!")
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    dotenv().ok();
    let database_url = env::var("DATABASE_URL").expect("DATABASE_URL env var no encontrada");
    let manager = ConnectionManager::<PgConnection>::new(database_url);
    let pool = Pool::builder().build(manager).expect("No se pudo crear el pool");

    HttpServer::new(move || {
        App::new()
            .app_data(Data::new(pool.clone()))
            .route("/hola", web::get().to(saludar))
            .service(tweets::get_tweets)
            .service(tweets::get_tweet_by_id)
            .service(tweets::post_tweets)
            .service(likes::get_like_tweet_by_id)
            .service(likes::post_like_tweet_by_id)
            .service(likes::delete_like_tweet_by_id)
    })
    .bind(("localhost",8000))?
    .run()
    .await
}