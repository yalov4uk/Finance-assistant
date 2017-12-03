##TOFI API
###30.10.2017
нужна бд mysql
spring boot
CRUD restful api для всех таблиц
###Денис Гридюшко

###12.11.2017
add jwt authentication, add authentication with facebook access token

###Auth:
  * Each request should contain headers:
```
"Content-Type": "application/json"
```
  * Each request to secured resources should contain headers:
```
"token": "{token}"
```
###21.11.2017
add docker
###Quick start
environment:
* Docker-engine > v17.06
* Docker-compose > 1.17.0
```
sudo docker-compose build
sudo docker-compose up
```

###26.11.2017
Вот и я наконец добрался до проекта :)
http://dzianis.mooo.com/api/v1/users

###26.11.2017
refactor rest, add swagger-ui

Swagger-ui request:
  * GET *swagger-ui/index.html*
  * GET *api/v1/swagger.json*
  * GET *api/v1/swagger.yaml*
