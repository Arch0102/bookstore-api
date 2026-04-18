# bookstore-api

API REST para la gestión de una librería en línea, desarrollada con Spring Boot como parte del taller práctico de Desarrollo Empresarial.

## Tecnologías

- Java 17
- Spring Boot
- Spring Security + JWT (jjwt 0.12.3)
- Spring Data JPA
- H2 (desarrollo) / PostgreSQL (producción)
- Maven
- SpringDoc OpenAPI (Swagger)

## Requisitos previos

- Java 17 o superior
- Maven 3.8 o superior
- Git 2.x

## Configuración y ejecución local

### 1. Clonar el repositorio

```bash
git clone https://github.com/Arch0102/bookstore-api.git
cd bookstore-api
```

### 2. Configurar variables de entorno

El proyecto usa H2 en memoria para desarrollo. No se requiere configuración adicional de base de datos. El secret JWT está definido directamente en `application.yml`.

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación levanta en: `http://localhost:8080`

### 4. Consola H2 (base de datos en memoria)

```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:bookstoredb
Usuario: sa
Contraseña: (vacía)
```

### 5. Documentación Swagger

```
http://localhost:8080/swagger-ui/index.html
```

## Flujo de autenticación

### Registrar usuario ADMIN

```
POST http://localhost:8080/auth/register
Content-Type: application/json

{
    "name": "Admin Test",
    "email": "admin@test.com",
    "password": "admin1234",
    "role": "ROLE_ADMIN"
}
```

### Login

```
POST http://localhost:8080/auth/login
Content-Type: application/json

{
    "email": "admin@test.com",
    "password": "admin1234"
}
```

Copiar el campo `token` de la respuesta y usarlo en el header de las requests protegidas:

```
Authorization: Bearer <token>
```

## Endpoints principales

### Autenticación (público)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /auth/register | Registro de usuario |
| POST | /auth/login | Login y obtención de token JWT |

### Libros (GET público, escritura solo ADMIN)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /books | Listar libros con paginación |
| GET | /books/{id} | Obtener libro por ID |
| POST | /books | Crear libro |
| PUT | /books/{id} | Actualizar libro |
| DELETE | /books/{id} | Eliminar libro |

### Autores (GET público, escritura solo ADMIN)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /authors | Listar autores |
| GET | /authors/{id} | Obtener autor por ID |
| GET | /authors/{id}/books | Listar libros por autor |
| POST | /authors | Crear autor |
| PUT | /authors/{id} | Actualizar autor |
| DELETE | /authors/{id} | Eliminar autor |

### Categorías (GET público, escritura solo ADMIN)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /categories | Listar categorías |
| GET | /categories/{id} | Obtener categoría por ID |
| GET | /categories/{id}/books | Listar libros por categoría |
| POST | /categories | Crear categoría |
| PUT | /categories/{id} | Actualizar categoría |
| DELETE | /categories/{id} | Eliminar categoría |

### Pedidos
| Método | Endpoint | Acceso | Descripción |
|--------|----------|--------|-------------|
| POST | /orders | USER autenticado | Crear pedido |
| GET | /orders/my | USER autenticado | Ver mis pedidos |
| GET | /orders | Solo ADMIN | Ver todos los pedidos |

## Estructura del proyecto

```
com.taller.bookstore
├── config/
├── controller/
├── dto/
│   ├── request/
│   └── response/
├── entity/
├── exception/
│   ├── custom/
│   └── handler/
├── mapper/
├── repository/
├── security/
└── service/
    └── impl/
```

## Flujo Git

- `main` — rama de producción
- `develop` — rama de integración
- `feature/auth-module` — módulo de autenticación (mergeado)
- `feature/book-catalog` — catálogo de libros (mergeado)
- `feature/order-management` — gestión de pedidos (mergeado)
- `feature/author-category` — autores y categorías (mergeado)
