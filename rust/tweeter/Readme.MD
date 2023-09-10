# Probar endpoints

curl -X POST -d 'Este es un tweet muy interesante' \
    -H "Content-type: application/json" \
    http://localhost:8000/tweets

curl -X GET http://localhost:8000/tweets

curl -X GET http://localhost:8000/tweets/{id}

curl -X GET http://localhost:8000/tweets/{id}/likes

curl -X POST http://localhost:8000/tweets/{id}/likes

curl -X DELETE http://localhost:8000/tweets/{id}/likes
