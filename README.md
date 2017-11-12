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
    "name": "name",
    "password": "password",
    "email": "email"
}
```
  * POST *api/v1/auth/signin*
```json
{
  	"email": "email",
    "password": "password"
}
```
  * POST *api/v1/auth/signin/facebook*
```json
{
	"token": "token"
}
```
