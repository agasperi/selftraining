use diesel::prelude::{Insertable, Queryable};
use uuid::Uuid;
use chrono::{NaiveDateTime, Utc};
use serde::{Deserialize, Serialize};

#[diesel(table_name = crate::schema::likes)]
#[derive(Insertable, Queryable, Deserialize, Serialize)]
pub struct Like {
    pub id: Uuid,
    pub created_at: NaiveDateTime,
    tweet_id: Uuid,
}

impl Like {
    pub fn new(tweet_id: Uuid) -> Self {
        Self {
            id: Uuid::new_v4(),
            created_at: Utc::now().naive_utc(),
            tweet_id,
        }
    }
}
