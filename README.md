# nmovie
## NMovie - Spring Boot & REST API's

### Technológiák:
- Java 17+
- Spring Boot 3.5.4
- Spring Web
- Spring Data JPA
- Lombok
- Hibernate
- REST API's
- Jakarta Validation
- Swagger
- Unit tesztek (JUnit 5 & Mockito & Spring Boot Test)

---

## Mi ez?  
Saját gyakorló projekt, ahol Spring Boot, JPA, Hibernate és Swagger használatával építek egy filmes REST API-t.  
A projektet folyamatosan bővítem, így gyakorlom a legújabb technológiákat és best practice-eket.

---

## Adatbázis beállítás
A projekt MySQL adatbázist használ. A `mysql` mappában található egy `nmovie_dump.sql` fájl, amely tartalmazza a szükséges adatbázis-struktúrát.

### 1. Hozd létre az adatbázist:  
- CREATE DATABASE nmovie;
### 2. Importáld a dumpot:  
- mysql -u root -p nmovie < sql/nmovie_dump.sql  
### 3. Indítsd az alkalmazást  


