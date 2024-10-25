# eDemocracy

### Overview
eDemocracy is a web-based application that empowers citizens to actively participate in democratic processes. 
The platform enables users to engage in political discussions, vote on critical issues, and directly communicate 
their opinions and needs to government representatives, fostering a transparent and participatory governance model.
This application will greatly simplify the process of acquiring personal documents and certificates. Please look inside
the folder ` screenshots ` for a preview of the application.

## Features
* Voting System: Citizens can vote on issues and policies.
* Discussion Forums: Engage in political discussions and debates.
* Feedback to Representatives: Provide direct feedback to government officials.
* User Authentication: Secure login for registered users.
* Real-Time Updates: Stay informed about recent policy changes and updates.

## Tech Stack
* Frontend: HTML, CSS, Bootstrap
* Backend: Java, Spring Boot
* Database: MySQL
* API: RESTful services
* Version Control: Git

## Installation
### Prerequisites
* Java JDK 11+
* Maven
* MySQL
* XAMPP

### Steps 
1. Clone the respository:

```git clone https://github.com/your-username/eDemocracy.git ```
   
```cd eDemocracy```

2. Configure the application.properties file to connect to your MySQL database:

``` spring.datasource.url=jdbc:mysql://localhost:3305/baza ```

``` spring.datasource.username=admir ```

``` spring.datasource.password=admir ```

3. Build the project:

` mvn clean install `

4. Run the application:

`mvn spring-boot:run `

5. Open the application:

` localhost:8080 `


