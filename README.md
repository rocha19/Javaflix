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
  {
    "request": {
      "body": {
        "username": "string",
        "password": "string"
      },
    },

    "response": {
      "status": 201,
    }
  }
```

Access API:

`/api/login`

```json
  {
    "body": {
      "username": "string",
      "password": "string"
    },

    "response": {
      "status": 200,
      "body": {
        "token": "string",
        "id": "number" # userID
      }
    }
  }
```

Save a movie on favorites:

`/api/save`

```json
  {
    "request": {
      "header": {
        "Authorization": "token",
      },
    },

    "response": {
    "status": 201,
    "body": {
      "externalId": "number", # movieID
      "poster_path": "string",
      "title": "string",
      "overview": "string",
      "release_date": "string"
      }
    }  
  }
```

Find a list of movies favorites:

`/api/movies`

```json
  {
    "request": {
      "header" : {
        "Authorization": "token",
      }
    },

    "response": {
      "status": 200,
      "body": {
        [{
          "id": "number",
          "poster_path": "string",
          "title": "string",
          "overview": "string",
          "release_date": "string"
        }]
      }
    }
  }
```

Find a movie favorite:

`/api/movie/{id}`

```json
  {
    "request": {
      "header" : {
        "Authorization": "token",
      }
    },

    "response": {
      "status": 200,
      "body": {{
          "id": "number",
          "poster_path": "string",
          "title": "string",
          "overview": "string",
          "release_date": "string"
        }
      }
    }
  }
```
