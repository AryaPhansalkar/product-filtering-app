# Product Filtering Application

A full-stack web application built using **Spring Boot** that allows users to filter products based on price and category. The frontend is built using HTML, CSS, and JavaScript, and the backend exposes REST APIs connected to a MySQL database.

---

## Tech Stack

* **Backend:** Java 17, Spring Boot, Spring Data JPA, Hibernate
* **Frontend:** HTML, CSS, JavaScript (Fetch API)
* **Database:** MySQL (Railway)
* **Build Tool:** Maven
* **Version Control:** Git & GitHub
* **Deployment:** Railway

---

## Setup & Deployment Guide (IntelliJ)

### 1) Generate Project using Spring Initializr

Go to: https://start.spring.io

Use the following settings:

* Project: Maven
* Language: Java
* Spring Boot: **3.2.x (recommended stable)**
* Packaging: Jar
* Java: 17

Add dependency:

* Spring Web

Download the project as ZIP.

---

### 2) Open Project in IntelliJ

* Extract the ZIP file
* Open IntelliJ
* Click **Open → Select the extracted folder**
* In IntelliJ click on settings button which you will see on the top right side of the screen
* Click **Project Structure**
* Ensure that SDK has Orcale OpenJDK (17 or higher depending the java version you selected in first step)
* Apply and close the tab when finished

---

###  3) Add Code & Dependencies

* Write your application code (Controllers, Models, Repository, etc.)
* Add required dependencies in `pom.xml` (JPA, MySQL, Thymeleaf if needed)

After editing `pom.xml`:

* Right click project → **Maven → Reload Project**

---

### 4) Push Project to GitHub
Create a repository on github and ensure it is public then write the following commands in the project terminal:

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/product-filtering-app.git
git push -u origin main
```

---

### 5) Create Database on Railway

1. On browser search Railway deploy. 
2. Go to Railway dashboard (You have to signup if you have not done it before)
3. Click **New Project → Add Database → MySQL**
4. Railway will automatically generate:

   * MYSQLHOST
   * MYSQLPORT
   * MYSQLDATABASE
   * MYSQLUSER
   * MYSQLPASSWORD

---

### 6) Deploy Backend Service

1. Click **New Project → Deploy from GitHub Repo**
2. Select your repository

---

### 7) Configure Build & Start Commands

In Railway service settings:

**Build Command:**

```bash
mvn clean package -DskipTests
```

**Start Command:**

```bash
java -jar target/ProductFiltering-0.0.1-SNAPSHOT.jar
```

---

### 8) Configure Environment Variables

In Railway → **Variables tab**, add these variables from your database (ensure database is created within the same project):

```text
MYSQLHOST=your_host
MYSQLPORT=3306
MYSQLDATABASE=railway
MYSQLUSER=root
MYSQLPASSWORD=your_password
```

---

### 9) Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://${MYSQLHOST}:${MYSQLPORT}/${MYSQLDATABASE}
spring.datasource.username=${MYSQLUSER}
spring.datasource.password=${MYSQLPASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=${PORT:8080}
```

---

### 10) Deploy

* Push changes to GitHub
* Railway will automatically build and deploy

---

## 11) Access the Application

After deployment:

* Generate domain from Railway
* In settings section of service naviagte to **networking**
* Click on Create Domain
* This will give you your domain
* Open in browser and paste your URL which will be in the form:

```
https://your-app.up.railway.app/
```

---

## API Endpoints

* Get all products:

```
/api/products
```

* Filter by category:

```
/api/products?category=Food
```

* Filter by price:

```
/api/products?price=500
```

* Combined filter:

```
/api/products?category=Food&price=500
```

---

## Features

* Filter products by category and price
* Dynamic frontend using Fetch API
* REST API backend
* Cloud deployment with Railway
* Clean UI with table display

---

## Notes

* Tests are skipped during deployment using:

```
-DskipTests
```

* Ensure correct environment variables are set in Railway
* Use stable Spring Boot version (3.x) to avoid compatibility issues


---
