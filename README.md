# JVS-rentals-Website
 
## Project format (Maven)
 
This repository is now a standard Maven **WAR** project:
 
- **Java (Servlets/JDBC)**: `src/main/java`
- **Web files (HTML/CSS/images/JSP)**: `src/main/webapp`
- **Deployment descriptor**: `src/main/webapp/WEB-INF/web.xml`
 
## Requirements
 
- **JDK 8+**
- **Maven 3+**
- **Tomcat 10.1+** (because the code uses `jakarta.servlet.*`)
- **MySQL** (update credentials inside `src/main/java/Com/JVS/JDBC/JDBC_Driver.java`)

## Database (MySQL)

This project uses a MySQL database named `JVS_Rentals`.

1) Start MySQL and login:

```bash
mysql -u root -p
```

2) Run the schema file:

```sql
SOURCE db/schema.sql;
```

3) Verify your DB credentials in:

- `src/main/java/Com/JVS/JDBC/JDBC_Driver.java`

Current defaults:

- URL: `jdbc:mysql://localhost:3306/JVS_Rentals`
- Username: `root`
- Password: `root`
 
## Build
 
```bash
mvn clean package
```
 
Output WAR:
 
- `target/jvs-rentals-website-1.0.0.war`
 
## Import into Eclipse
 
- File
- Import
- Maven
- Existing Maven Projects
- Select this repo folder
 
## Run
 
- Deploy the generated WAR to Tomcat (or add the project to Tomcat in Eclipse).

Example Tomcat deploy (Tomcat 10.1+):

1) Copy WAR to Tomcat webapps folder:

```bash
cp target/jvs-rentals-website-1.0.0.war /path/to/apache-tomcat-10.1.x/webapps/
```

2) Start Tomcat:

```bash
/path/to/apache-tomcat-10.1.x/bin/startup.sh
```

3) Open in browser:

- `http://localhost:8080/jvs-rentals-website-1.0.0/`

Pages:

- `Home.html`
- `Login.html`
- `Registration.html`
- `BookNow.html`
- `Profile.jsp`

Servlet endpoints:

- `Login` (POST)
- `Registration` (POST)
- `Book` (POST)
- `Logout` (GET)