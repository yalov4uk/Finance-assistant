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

Now we have entities:
account
category
transaction
transfer

All this entities have methods:
  * POST /api/v1/transfers/ - create new record
```json
 {
    "transfer":{
            
            "value": 10,
            "note": "money transfer 2",
            "date": "2017-08-07",
            "source_account_id": 1,
            "destination_account_id": 6,
            "user": 1
        }
 }
```
  * PUT /api/v1/transfers/ - update existing record
```json
  {
    "transfer":{
            "id": 1,
            "value": 10,
            "note": "money transfer 1",
            "date": "2017-08-07",
            "source_account_id": 1,
            "destination_account_id": 6,
            "user": 1
        }
 }
```
  * DELETE /api/v1/transfers/ - delete exist
```json
    {
    "transfer":{
            "id": 1
        }
    }
```
   
  * GET /api/v1/transfers/ - Get all entity records whitch were post by logined user.
```json
 {
    "transfers": [
        {
            "id": 1,
            "value": 20,
            "note": "money transfer 1",
            "date": "2017-08-07",
            "source_account_id": 1,
            "destination_account_id": 6,
            "user": 1
        },
        {
            "id": 2,
            "value": 10,
            "note": "money transfer 2",
            "date": "2017-08-07",
            "source_account_id": 1,
            "destination_account_id": 6,
            "user": 1
        }
    ]
}
```
  * GET /api/v1/transfers/1/ - Get transfer with id=1.
```json
 {
    "transfer": {
        "id": 1,
        "value": 20,
        "note": "money transfer 1",
        "date": "2017-08-07",
        "source_account_id": 1,
        "destination_account_id": 6,
        "user": 1
    }
}
```
  
  Don't forget to add "token":"your token" in request headers.
  
  Entities examples:
```json
 /api/v1/categories/1/
  {
    "category": {
        "id": 1,
        "name": "For Car",
        "icon": "1.png",
        "category_type": 1,
        "user_id": 1
    }
}
/api/v1/transfers/1/
 {
    "transfer": {
        "id": 1,
        "value": 20,
        "note": "money transfer 1",
        "date": "2017-08-07",
        "source_account_id": 1,
        "destination_account_id": 6,
        "user": 1
    }
}
/api/v1/transactions/1/
{
    "transaction": {
        "id": 1,
        "value": 50,
        "note": "shampoo for my car",
        "date": "2017-08-07",
        "user_id": 1,
        "category_id": 1,
        "account_id": 1
    }
}
/api/v1/accounts/1/
{
    "account": {
        "id": 1,
        "name": "card1",
        "icon": "1.png",
        "initial_balance": 100,
        "initial_date": "2017-08-07",
        "user_id": 1
    }
}

```