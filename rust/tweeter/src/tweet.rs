use diesel::prelude::{Insertable, Queryable};
use uuid::Uuid;
use chrono::{NaiveDateTime, Utc};
use serde::{Deserialize, Serialize};

#[diesel(table_name = crate::schema::tweets)]
#[derive(Insertable, Queryable, Deserialize, Serialize)]
pub struct Tweet {
    id: Uuid,
    pub created_at: NaiveDateTime,
    message: String,
}

impl Tweet {
    pub fn new(message: String) -> Self {
        Self {
            id: Uuid::new_v4(),
            created_at: Utc::now().naive_utc(),
            message
        }
    }
}
