# Javaflix API

## Objective

  Application creation to disciple `Object-oriented programming with Java`

## check features implemented

* Objects              👌🏾
* Encapsulation
* Constructor          👌🏾
* Access modifier      👌🏾
* Heritage             👎🏾  
* Composition          👌🏾
* Polimorfism          👌🏾
* Overwrite
* Overload
* Abstract Class       👌🏾
* Interface            👌🏾
* Exceptions           👌🏾
* MVC architecture     👌🏾
* Graphical interface  👌🏾 React.js
* Persistence          👌🏾 SQlite

## Run application

  `mvn spring-boot:run`

## Short Documentation

### Routes

Register um user to access service:

`/api/register`

```json
  body : {
    "username": "string",
    "password": "string"
  }

  response : {
    "status": 201,
  }
```

Access API:

`/api/login`

```json
  body : {
    "username": "string",
    "password": "string"
  }

  response : {
  "status": 200,
  "token": "string"
  }
```

Save a movie on favorites:

`/api/save`

```json
  header : {
    "Authorization": "token",
  }

  body : {
    "id": "number",
    "poster_path": "string",
    "title": "string",
    "overview": "string",
    "release_date": "string"
  }

  response : {
    "status": 201
  }
```

Find a list of movies favorites:

`/api/movies`

```json
  header : {
    "Authorization": "token",
  }

  response : {
    "status": 200
    body: {
      [{
        "id": "number",
        "poster_path": "string",
        "title": "string",
        "overview": "string",
        "release_date": "string"
      }]
    }
  }
```

Find a movie favorite:

`/api/movie/{id}`

```json
  header : {
    "Authorization": "token",
  }

  response : {
    "status": 200
    body: {{
        "id": "number",
        "poster_path": "string",
        "title": "string",
        "overview": "string",
        "release_date": "string"
      }
    }
  }
```
