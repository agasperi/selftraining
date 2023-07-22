use uuid::Uuid;
use chrono::{NaiveDateTime, Utc};
use serde::{Deserialize, Serialize};

#[derive(Deserialize, Serialize)]
pub struct Tweet {
    id: Uuid,
    create_at: NaiveDateTime,
    message: String,
}

impl Tweet {
    pub fn new(message: String) -> Self {
        Self {
            id: Uuid::new_v4(),
            create_at: Utc::now().naive_utc(),
            message
        }
    }
}