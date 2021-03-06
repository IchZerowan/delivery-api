# Delivery Api "MrsAm"

Delivery API created for Chernihiv.It october 2021 olympiad 

- Has a lot web methods
- Supports MySQL db

## Methods description 
### Get companies
GET method returns the list of all the companies

**Request**
```
http://server:80/api/companies
```
**Response**
```json
[
   {
      "id":1,
      "name":"Da!Bro",
      "description":"ресторан"
   }
]
```
### Get company by id
GET method returns the information for the company with specified id

**Request**
```
http://server:80/api/companies?company_id=1
```
**Response**
```json
[
   {
      "id":1,
      "name":"Da!Bro",
      "description":"ресторан"
   }
]
```

### Get categories
GET method returns all the categories by the specified company ID

**Request**
```
http://server:80/api/categories?company_id=1
```
**Response**
```json
[
   {
      "id":1,
      "name":"Burgers"
   }
]
```

### Get category info by ID
GET method returns the information about the specified category 

**Request**
```
http://server:80/api/categories/1
```
**Response**
```json
{
   "id":1,
   "name":"Burgers"
}
```

### Get dish by category ID
GET method returns all dished for the specified category ID

**Request**
```
http://server:80/api/dishes?category_id=1
```
**Response**
```json
[
   {
      "id":1,
      "name":"Cheeseburger",
      "image":"cheeseburger.jpg",
      "description":"Tasty Cheeseburger",
      "price":50.0
   }
]
```

### Get dish by ID
GET method returns all dished for the specified ID

**Request**
```
http://server:80/api/dishes/1
```
**Response**
```json
{
   "id":1,
   "name":"Cheeseburger",
   "image":"cheeseburger.jpg",
   "description":"Tasty Cheeseburger",
   "price":50.0
}
```

### Create order 
POST method adds new order

**Request**
```
http://server:80/api/orders
```

**Body**
```json
{
    "phoneNumber": "+380999999999",
    "clientName": "Ihor",
    "dishes": [
        {
            "dishId": 2,
            "count": 2
        },
        {
            "dishId": 3,
            "count": 2
        }
    ]
}
```
**Response**
```json
{
    "id": 1,
    "total": 220.0,
    "phoneNumber": "+380999999999",
    "clientName": "Ihor",
    "dishes": [
        {
            "dish": {
                "id": 2,
                "name": "Margherita",
                "image": "margherita.jpg",
                "description": "Cheese Pizza",
                "price": 70.0
            },
            "price": 70.0,
            "count": 2
        },
        {
            "dish": {
                "id": 3,
                "name": "Hawaii",
                "image": "hawaii.jpg",
                "description": "Hawaii Pizza",
                "price": 80.0
            },
            "price": 80.0,
            "count": 1
        }
    ]
}
```

### Get order by ID 
GET method returns the information about the specified order
**Request**
```
http://server:80/api/orders/1
```

**Response**
```json
{
    "id": 1,
    "total": 220.0,
    "phoneNumber": "+380999999999",
    "clientName": "Ihor",
    "dishes": [
        {
            "dish": {
                "id": 2,
                "name": "Margherita",
                "image": "margherita.jpg",
                "description": "Cheese Pizza",
                "price": 70.0
            },
            "price": 70.0,
            "count": 2
        },
        {
            "dish": {
                "id": 3,
                "name": "Hawaii",
                "image": "hawaii.jpg",
                "description": "Hawaii Pizza",
                "price": 80.0
            },
            "price": 80.0,
            "count": 1
        }
    ]
}
```

## HOW TO DEPLOY

*DEPLOying on linux, cmon*

* First, clone repo to your server 
``` git clone https://github.com/IchZerowan/delivery-api ```
* Than, you must check enviroment
    * Check java jre ```java -version```, must be 11 version
    * Check java jdk ```javac -version```, must be 11 version (or higher, maybe, i dont know rly)
    * Check mysql ```mysql -v``` must BE
    * Check maven
    * Check application.properties in project by path
    *path_to_project/src/main/resources/application.properties*
    You may see some strings : 
        1. Just replace **db_example** to your **database name**  
        *spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/* **db_example**
        2. Just replace test for your username and password
            *spring.datasource.username=* **test**
            *spring.datasource.password=* **test**
    * Check that your database and user exists in mysql by commands
    ``` 
        mysql
        SHOW DATABASES;
        SELECT user FROM mysql.user;
    ```
    If you are cool enough and everything is correct - build and start the project
* Third, build your project
    *   Go to your project folder
    *   Build by command ``` mvn package -DskipTests ```
    *   Run from target by commands
    ``` 
        cd target
        java -jar %projectname%.jar
    ``` 
    **Congratulations, you're a great IT sweetie.**