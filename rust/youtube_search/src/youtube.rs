use gloo_net::{http::Request, Error};
use serde::Deserialize;

use crate::env::API_KEY;

pub async fn search_youtube(text_to_search: String) -> Result<VideoItem, Error> {
    let youtube_url = format!(
        "https://youtube.googleapis.com/youtube/v3/search?part=snippet&q={}",
        text_to_search
    );
    let mut auth = String::from("Bearer ");
    auth.push_str(API_KEY);

    let response = Request::get(&youtube_url)
        .header("Authorizarion", &auth)
        .send()
        .await?;
    let search_result = response.json::<SearchResult>().await?;

    let video_empty = build_empty_video();
    let video = match search_result.items.first() {
        Some(video) => video,
        None => &video_empty,
    };
    web_sys::console::log_1(&text_to_search.into());
    Ok(video.clone())
}

fn build_empty_video() -> VideoItem {
    VideoItem {
        id: VideoItemId { kinde: "".to_string(), video_id: "".to_string() },
        snippet: VideoSnippet { title: "".to_string(), description: "".to_string() }
    }
}

#[derive(Deserialize)]
#[serde(rename_all = "camelCase")]
struct SearchResult {
    pub region_code: String,
    pub items: Vec<VideoItem>,
}

#[derive(Deserialize, Clone)]
pub struct VideoItem {
    pub id: VideoItemId,
    pub snippet: VideoSnippet,
}

#[derive(Deserialize, Clone)]
#[serde(rename_all = "camelCase")]
pub struct VideoItemId {
    pub kinde: String,
    pub video_id: String,
}

#[derive(Deserialize, Clone)]
pub struct VideoSnippet {
    pub title: String,
    pub description: String,
}