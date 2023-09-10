//#[macro_use]
//extern crate diesel;

use std::str::FromStr;

use actix_web::{get, post, HttpResponse, web::{Path, Data}};
use diesel::{r2d2::{ ConnectionManager, Pool }, PgConnection, RunQueryDsl, QueryDsl, ExpressionMethods};
use uuid::Uuid;
//use actix_web::web::Data;
use crate::{constants::APPLICATION_JSON, tweet::Tweet};
/*use crate::tweet::Tweet;
use diesel::r2d2::{ ConnectionManager, Pool };
use diesel::{ PgConnection, ExpressionMethods, RunQueryDsl };
use diesel::query_dsl::methods::{ LimitDsl, OrderDsl };
use crate::schema::tweets::dsl::*;*/
//use super::schema::tweets;

// Tweets

#[get("/tweets")]
pub async fn get_tweets(pool: Data<Pool<ConnectionManager<PgConnection>>>) -> HttpResponse {
    use crate::schema::tweets::dsl::*;

    let result = tweets.load(&mut pool.get().unwrap());

    let recordset: Vec<Tweet> = match result {
        Ok(t) => t,
        Err(_) => vec![],
    };

    HttpResponse::Ok()
        .content_type(APPLICATION_JSON)
        .json(recordset)
}

#[get("/tweets/{id}")]
pub async fn get_tweet_by_id(path: Path<String,>, pool: Data<Pool<ConnectionManager<PgConnection>>>) -> HttpResponse {
    use crate::schema::tweets::dsl::*;

    let uuid = Uuid::from_str(&path.into_inner()).unwrap();
    let result = tweets.filter(id.eq(uuid)).load(&mut pool.get().unwrap());

    let recordset: Vec<Tweet> = match result {
        Ok(t) => t,
        Err(_) => vec![],
    };

    HttpResponse::Ok()
        .content_type(APPLICATION_JSON)
        .json(recordset)
}

#[post("/tweets")]
pub async fn post_tweets(req_body: String, pool: Data<Pool<ConnectionManager<PgConnection>>>) -> HttpResponse {
    let nuevo_tweet = Tweet::new(req_body);
    
    diesel::insert_into(crate::schema::tweets::table)
        .values(&nuevo_tweet)
        .execute(&mut pool.get().unwrap()).expect("Error al insertar tweet");

    HttpResponse::Created()
        .content_type(APPLICATION_JSON)
        .json(&nuevo_tweet)
}

/*
#[get("/tweets")]
pub async fn get_tweets(pool: Data<Pool<ConnectionManager<PgConnection>>>) -> HttpResponse {
    let mut conn = pool.get().expect(" No pude obtener conexión a la base de datos");

    let result = tweets
        .order(created_at.desc())
        .limit(10) // sería bueno parametrizar este valor
        .load::<Tweet>(&mut conn);

    let response = match result {
        Ok(tws) => tws,
        Err(_) => vec![],
    };

    HttpResponse::Ok()
        .content_type(APPLICATION_JSON)
        .json(response)
}

#[post("/tweets")]
pub async fn post_tweets(req_body: String, pool: Data<Pool<ConnectionManager<PgConnection>>>) -> HttpResponse {
    let nuevo_tweet = Tweet::new(req_body);
    let conn = pool.get().expect(" No pude obtener conexión a la base de datos");

    diesel::insert_into(tweets)
        .values(&nuevo_tweet)
        .execute(&conn).expect("Error al insertar tweet");

    HttpResponse::Created()
        .content_type(APPLICATION_JSON)
        .json(&nuevo_tweet)
}
*/