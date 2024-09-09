# Instructions
```
git clone address
```

## How to run front end

```
cd frontend
npm install
ng serve
```

## How to run back end
```
cd demo
mvn boot-strap:run
```

## Prerequisites
### if you want to make your own project
```
https://start.spring.io/
Maven;
Java;
3.3.3

com.example
demo
demo
Demo Project for Spring Boot
com.example.demo
Jar
17

Dependencies:
spring-boot-starter-data-jpa
spring-boot-starter-web
spring-boot-devtools
mysql-connector-j
spring-boot-starter-test
```
### First thing to do in demo

#### create packages:
```
config
controller : where you will be setting up the paths for where functions will be called
enitity: what you are taking out of the database with all it's properties, getters, and setters
repository: what queries you are making on top of what type of return it will give
service: calling the repository functions, an inbetween of the the repository and the controller
```

#### Install mysql
```
I use WSL: Windows Subsystem for Linux
see here for instructions: https://learn.microsoft.com/en-us/windows/wsl/install

sudo apt update
sudo apt install mysql-server
sudo systemctl start mysql
sudo systemctl enable mysql

sudo mysql_secure_installation

mysql -u root -p

save your username and password you'll need it later
```

#### Create Schema In mysql
```
// replace whatever is in <> with your chosen name
CREATE TABLE <tableName> (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NULL,
    first_name VARCHAR(255) NULL,
    last_name VARCHAR(255) NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

#### Connect mysql to demo
```
Look in demo/src/main/resources/application.properties

should look like this:
spring.application.name=demo

# MySQL configuration
spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
