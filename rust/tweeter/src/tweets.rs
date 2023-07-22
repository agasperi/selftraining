use actix_web::{get, post, HttpResponse};
use crate::constants::APPLICATION_JSON;
use crate::tweet::Tweet;

#[get("/tweets")]
pub async fn get_tweets() -> HttpResponse {
    let response = "Hola Tweets";

    HttpResponse::Ok()
        .content_type(APPLICATION_JSON)
        .json(response)
}

#[post("/tweets")]
pub async fn post_tweets(req_body: String) -> HttpResponse {
    let nuevo_tweet = Tweet::new(req_body);

    HttpResponse::Ok()
        .content_type(APPLICATION_JSON)
        .json(&nuevo_tweet)
}