# JVS-rentals-Website
 
## Project summary (Interview)

JVS Rentals is a bike/scooter rental booking website built as a Java web application.
It supports:

- User registration
- User login (session-based)
- Bike booking stored in MySQL
- Profile page that displays user information and booking history
- Logout

### Tech stack

- **Backend**
  - Java
  - Jakarta Servlets (`jakarta.servlet.*`) + JSP
  - JDBC (MySQL)
- **Frontend**
  - HTML, CSS
  - Bootstrap, jQuery
- **Database**
  - MySQL (`db/schema.sql`)
- **Build/Deploy**
  - Maven WAR
  - Tomcat 10.1+ (Jakarta)

### Core flow

- **Registration**: `Registration.html` → `Registration` servlet → inserts into `Rentals_data`
- **Login**: `Login.html` → `Login` servlet → validates credentials → stores session user (`session.setAttribute("user", ...)`)
- **Booking**: `BookNow.html` → `Book` servlet → inserts into `bookings`
- **Profile**: `Profile.jsp` → shows user details and “My Bookings” table
- **Logout**: `Logout` servlet → invalidates session

### Database tables

- `Rentals_data` (users)
- `bookings` (bookings linked to `Rentals_data(email)`)

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

### If you installed MySQL using Homebrew (mac)

If you cannot login as `root`, reset the root password first.

1) Stop MySQL:

```bash
brew services stop mysql
```

2) Start MySQL in safe mode (keep this terminal open):

```bash
mysqld_safe --skip-grant-tables --skip-networking
```

3) In a new terminal, login without password:

```bash
mysql -u root
```

4) Set root password (example: `root`):

```sql
FLUSH PRIVILEGES;
ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
FLUSH PRIVILEGES;
```

5) Exit MySQL and stop safe mode:

- `exit;`
- Go back to the safe-mode terminal and press `Ctrl+C`

6) Start MySQL normally:

```bash
brew services start mysql
```

7) Test:

```bash
mysql -u root -proot -e "SELECT 'OK' AS status;"
```

### Create tables

1) Start MySQL and login:

```bash
mysql -u root -p
```

2) Run the schema file:

```sql
SOURCE db/schema.sql;
```

Alternative (same result):

```bash
mysql -u root -p < db/schema.sql
```

3) Verify tables:

```sql
USE JVS_Rentals;
SHOW TABLES;
```

4) Verify your DB credentials in:

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