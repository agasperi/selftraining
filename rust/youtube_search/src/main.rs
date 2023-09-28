use wasm_bindgen::{JsCast, UnwrapThrowExt};
use web_sys::{InputEvent, Event, HtmlInputElement};
use yew::{function_component, Html, html, Callback, Properties, use_state, UseStateHandle};

use crate::youtube::search_youtube;

mod env;
mod youtube;

fn main() {
    yew::Renderer::<App>::new().render();
}

#[derive(Clone)]
struct Video {
    id: String,
    title: String,
}
#[function_component()]
fn App() -> Html {
    let video : UseStateHandle<Option<Video>> = use_state(|| None);

    let on_search = {
        let video_cloned = video.clone();
        Callback::from(move |text_to_search: String| {
            let video_cloned = video_cloned.clone();
            wasm_bindgen_futures::spawn_local(async move {
                match search_youtube(text_to_search).await {
                    Ok(video_item) => video_cloned.set(Some(Video {
                            id: video_item.id.video_id,
                            title: video_item.snippet.title,
                        })),
                    Err(e) => {
                        web_sys::console::log_1(&e.to_string().into())
                    }
                }
            });
        })
    };

    let video_section = match (*video).clone(){
        Some(video_cloned) => html! {<VideoSection title={video_cloned.title} id={video_cloned.id}/>},
        None => html! {},
    };
    html! {
        <main>
        <VideoControl on_search={on_search}/>
        {video_section}
        </main>
    }
}

#[derive(Properties, PartialEq)]
struct VideoControlProps {
    on_search: Callback<String>,
}
#[function_component()]
fn VideoControl(props: &VideoControlProps) -> Html {
    let text_to_search = use_state(|| String::new());

    let handle_input = {
        let text_to_search = text_to_search.clone();
        Callback::from(move |input_event| {
            let text = get_value_from_input_event(input_event);
            text_to_search.set(text);
        })
    };

    let on_search_pressed = {
        let on_search = props.on_search.clone();
        Callback::from(move |_| {
            on_search.emit(text_to_search.to_string());
        })
    };

    html! {
        <div>
            <div>{"Ingresa una palabra"}</div>
            <div><input type="text" oninput={handle_input} /></div>
            <div><button onclick={on_search_pressed}>{"¡Buscar!"}</button></div>
        </div>
    }
}

#[derive(Properties, PartialEq)]
struct VideoSectionProps {
    id: String,
    title: String,
}
#[function_component()]
fn VideoSection(props: &VideoSectionProps) -> Html {
    let yt_url = format!("https://www.youtube.com/embed/{}", props.id);
    let yt_title = format!("{}", props.title);
    html! {
        <div>
            <iframe width="560" height="315" src={yt_url} title={yt_title} frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"></iframe>
        </div>
    }
}

fn get_value_from_input_event(e: InputEvent) -> String {
    let event: Event = e.dyn_into().unwrap_throw();
    let event_target = event.target().unwrap_throw();
    let target: HtmlInputElement = event_target.dyn_into().unwrap_throw();
    target.value()
}