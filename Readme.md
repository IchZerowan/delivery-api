# Delivery Api "MrsAm"

Delivery API created for helping delivering food between some systems (server and your web application, your mobile app))

- Has a lot web methods
- Supports MySQL db

## Methods description 
### Get companies
GET method returns for you list of all companies

**Request**
```
http://server:80/api/companies
```
**Response**
> [{"id":1,"name":"Da!Bro","description":"ресторан"}]

### Get company by id
GET method returns for you information for company with your id,  *honey*

**Request**
```
http://server:80/api/companies?company_id=1
```
**Response**
> [{"id":1,"name":"Da!Bro","description":"ресторан"}]

### Get categories
GET method returns for you all categories for your company ID

**Request**
```
http://server:80/api/categories?company_id=1
```
**Response**
> [{"id":1,"name":"Burgers"}]

### Get category info by ID
GET method returns for you info about your category 

**Request**
```
http://server:80/api/categories/1
```
**Response**
> {"id":1,"name":"Burgers"}

### Get dish by category ID
GET method returns for you all dished for your category ID

**Request**
```
http://server:80/api/dishes?category_id=1
```
**Response**
> [{"id":1,"name":"Cheeseburger","image":"cheeseburger.jpg","description":"Tasty Cheeseburger","price":50.0}]


### Get dish by ID
GET method returns for you all dished for your category ID

**Request**
```
http://server:80/api/dishes/1
```
**Response**
> {"id":1,"name":"Cheeseburger","image":"cheeseburger.jpg","description":"Tasty Cheeseburger","price":50.0}

### Create order 
POST method adds new order

**Request**
```
http://server:80/api/orders
```

**Params**
```
param1 = 
param2 = 
param3 = 
```
**Response**
> RESPONSE

### Get order by ID 
GET method returns for you info about your order
**Request**
```
http://server:80/api/orders/1
```

**Response**
> {"id":1,"amount":100.0,"phoneNumber":"+380999999999","clientName":"Ihor","dishes":[]}


## HOW TO DEPLOY

*DEPLOying on linux, cmon*

* First, clone repo to your server 
``` git clone https://github.com/IchZerowan/delivery-api ```
* Then, you must check enviroment
    * Check java jre ```java -version``` must be 11 version
    * Check java jdk ```javac -version``` must be 11 version (or higher, mabe, i dont know rly)
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
    If you enough cool and all are correct - then build and start project
* Third - build your project
    *   Go to your project folder
    *   Build by command ``` mvn package -DskipTests ```
    *   Run from target by commands
    ``` 
        cd target
        java -jar %projectname%.jar
    ``` 
    **Congratulations, you're a great IT sweetie.**