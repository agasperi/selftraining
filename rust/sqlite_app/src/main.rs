use rusqlite::Connection;

fn main() {
    let conn = create_database();
    //create_table(&conn);
    //insert_user(&conn, "Arnoldo Enrique");

    let user = get_user(&conn,1);
    match user {
        Ok(user) =>  println!("user: {}", user),
        Err(e) => println!("Error: {}", e),
    }
    
}

fn create_database() -> Connection {
    let connection = Connection::open("users.db");
    match connection {
        Ok(_) => {
            println!("Conexion a base de datos exitosa");
            return connection.unwrap();
        }
        Err(e) => panic!("Error al conectarse a la base de datos, error: {}", e),
    }
}

fn create_table(connection: &Connection) {
    let result = connection.execute("
        CREATE TABLE users (
            id INTEGER PRIMARY KEY,
            name TEXT NOT NULL
        )
        ", []);
    match result {
        Ok(_) => {
            println!("Creacion de tabla exitosa");
        }
        Err(e) => panic!("Error creando la tabla, error: {}", e),
    }
}

fn insert_user(connection: &Connection, user: &str) {
    let result = connection.execute("INSERT INTO users(name) values (?1)", &[user]);
    match result {
        Ok(_) => {
            println!("Inserción de registro exitoso");
        }
        Err(e) => panic!("Error creando la tabla, error: {}", e),
    }
}

fn get_user(connection: &Connection, user_id: i32) -> Result<String,String> {
    let mut statement = connection.prepare("SELECT name FROM users WHERE id = ?1").expect("Error creando el statement");
    let users = statement.query_map([user_id], |row| {
        let name: String = row.get(0)?;
        Ok(name)
    }).expect("Error al obtener la consulta");

    for user in users {
        return Ok(user.unwrap());
    }

    Err("No se encontró el usuario".to_string())
}
