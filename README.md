# Flight Search API
## Expactations
- Data Modeling
- CRUD Operations
- Search API
- REST API
- Java (Spring/Spring Boot)
- Authentication
- Git Version Control System
- Documantation with Swagger UI

### Preferred version and DB information:
- JDK 17
- Spring Boot 3.2.2
- Apache Maven
- PostgreSQL Database

### Authentication & Security
- JWT Authentication and Spring Security is provided on this API

### Documentation:
- The documentation is reachable at **http://localhost:8080/swagger-ui/index.html**

### Info:
- In addition to the desired modeling structure, details such as bringing a single user, bringing all users and updating user information are provided.

## Endpoints:
### User-Controller
- /api/users/{id} **(PUT)**
- /api/users/{id} **(DELETE)**
- /api/users **(GET)**
### Flight-Controller
- /api/flights/{id} **(GET)**
- /api/flights/{id} **(PUT)**
- /api/flights/{id} **(DELETE)**
- /api/flights **(GET)**
- /api/flights **(POST)**
- /api/flights/search **(GET)**
### Airport-Controller
- /api/airport/{id} **(GET)**
- /api/airport/{id} **(PUT)**
- /api/airport/{id} **(DELETE)**
- /api/airports **(GET)**
- /api/airports **(POST)**
### Auth-Controller
- /api/auth/register **(POST)**
- /api/auth/login **(POST)**
### Mock-Controller
- /api/mock/import/flights **(GET)**
