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