# Microservice


### Run the app

(1) Run PostgreSQL 
```
cd bootcamp-ms-profile/docker
docker-compose up -d
```

(2)  Run the Build and Run the microservice
```
bootcamp-prj> mvn clean install
cd bootcamp-ms-profile
bootcamp-prj/cd bootcamp-ms-profile> mvn clean install
```

Run the class  `BootcampProfileApplication`

(3) Check if the app is up and running `http://localhost:8084/roles`


### Roles
```
GET http://localhost:8084/users
DELETE http://localhost:8084/users/USER_ROLE
POST http://localhost:8084/users
{
    "name": "editor",
    "description": "editor"
}
```

### Users
```
GET http://localhost:8084/users                     (get all)
GET http://localhost:8084/users/202201151824        (get byId)
DELETE http://localhost:8084/users/202201151824     (delete user)
PUT http://localhost:8084/users/202201151824/true   (enable user)

POST http://localhost:8084/users                    (create new user)
{
    "userName": "Ermal",
    "firstName": "Ermal",
    "lastName": "Aliraj",
    "email": "ermal.aliraj@gmail.com",
    "phone": "phone",
    "enabled": false
}

PUT http://localhost:8084/users/202201151824        (add roles to user)
[
    {
        "id": "02"
    }
]
```

### Postgres DB

Connect from the client
```
url: jdbc:postgresql://localhost:3433/CampusDB
username: campus
password: campus
```

### Run Docker Services
```
cd ./docker
docker-compose up -d
```


### Links
- [Campus](https://github.com/ermalaliraj/campus)