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
####Requests:
  * POST *api/v1/auth/signup*
```json
{
	"user": {
		"name":"name",
		"password":"password",
		"email":"email"
	}
}
```
```json
{
    "user": {
        "id": 1,
        "name": "name",
        "email": "email",
        "password": "password"
    }
}
```
  * POST *api/v1/auth/signin*
```json
{
  	"email": "email",
    "password": "password"
}
```
```json
{
    "user": {
        "id": 1,
        "name": "name",
        "email": "email",
        "password": "password"
    },
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiaXNzIjoicGVyZmVjdC10ZWFtIn0.wjjPkscxj60DsdxsQY7_CAPWVEISk-oOuQ9MU9ZdUhI"
}
```
  * POST *api/v1/auth/signin/facebook*
```json
{
	"token": "token"
}
```
