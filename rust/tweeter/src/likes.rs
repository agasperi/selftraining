use std::str::FromStr;

use actix_web::{get, post, HttpResponse, web::{Path, Data}, delete};
use diesel::{r2d2::{Pool, ConnectionManager, PooledConnection}, PgConnection, RunQueryDsl, QueryDsl, ExpressionMethods};
use uuid::Uuid;
use crate::{constants::APPLICATION_JSON, like::Like};


#[get("/tweets/{id}/likes")]
pub async fn get_like_tweet_by_id(path: Path<String,>, pool: Data<Pool<ConnectionManager<PgConnection>>>) -> HttpResponse {
    let recordset: Vec<Like> = listar_likes(path, &mut pool.get().unwrap());

    HttpResponse::Ok()
        .content_type(APPLICATION_JSON)
        .json(recordset)
}

#[post("/tweets/{id}/likes")]
pub async fn post_like_tweet_by_id(path: Path<String,>, pool: Data<Pool<ConnectionManager<PgConnection>>>) -> HttpResponse {
    let id = path.into_inner();
    let new_like = Like::new(Uuid::from_str(&id).unwrap());

    diesel::insert_into(crate::schema::likes::table)
        .values(&new_like)
        .execute(&mut pool.get().unwrap())
        .unwrap();

    HttpResponse::Created()
        .content_type(APPLICATION_JSON)
        .json(&new_like)
}

#[delete("/tweets/{id}/likes")]
pub async fn delete_like_tweet_by_id(path: Path<String,>, pool: Data<Pool<ConnectionManager<PgConnection>>>) -> HttpResponse {
    use crate::schema::likes::dsl::*;

    let all_likes: Vec<Like> = listar_likes(path, &mut pool.get().unwrap());

    if all_likes.is_empty() {
        return HttpResponse::NoContent()
            .content_type(APPLICATION_JSON)
            .await
            .unwrap()
    }

    diesel::delete(likes.filter(id.eq(all_likes.first().unwrap().id)))
        .execute(&mut pool.get().unwrap())
        .unwrap();

    HttpResponse::NoContent()
        .content_type(APPLICATION_JSON)
        .await
        .unwrap()
}

fn listar_likes (path: Path<String,>, conn: &mut PooledConnection<ConnectionManager<PgConnection>>) -> Vec<Like> {
    use crate::schema::likes::dsl::*;
    let uuid = Uuid::from_str(&path.into_inner()).unwrap();

    let result = likes.filter(tweet_id.eq(uuid)).load(conn);

    match result {
        Ok(l) => l,
        Err(_) => vec![],
    }
}
