# Servicio Autenticación — CiberMall

Microservicio Spring Boot 4 para autenticación JWT de la tienda CiberMall.

## Puerto
```
http://localhost:8084
```

## Endpoints públicos (sin token)

| Método | URL | Descripción |
|--------|-----|-------------|
| POST | `/auth/login` | Login → devuelve JWT + datos del usuario |
| POST | `/auth/registrar` | Registro → crea usuario con rol CLIENTE |
| GET | `/auth/distritos` | Lista todos los distritos de Lima |

### POST `/auth/login`
**Body:**
```json
{ "correo": "juan@example.com", "clave": "mi_clave" }
```
**Response 200:**
```json
{ "token": "eyJ...", "correo": "juan@example.com", "nombres": "Juan", "rol": "CLIENTE" }
```

### POST `/auth/registrar`
**Body:**
```json
{
  "correo": "juan@example.com",
  "clave": "mi_clave",
  "nombres": "Juan Carlos",
  "apePaterno": "García",
  "apeMaterno": "López",
  "nroDoc": "12345678",
  "telefono": "987654321",
  "direccion": "Av. Ejemplo 123",
  "idDistrito": 5
}
```
**Response 201:** objeto Usuario (sin clave)

### GET `/auth/distritos`
**Response 200:**
```json
[
  { "idDistrito": 1, "nombre": "Ate", "costoEnvio": 8.00 },
  ...
]
```

## Pasos para correr

### 1. Crear la base de datos
Ejecuta el archivo `src/main/resources/bd_autentication_cibermall.sql` en MySQL Workbench o tu cliente preferido.

### 2. Configurar credenciales MySQL
Edita `src/main/resources/application.properties`:
```properties
spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA
```

### 3. Correr el proyecto
```bash
# Con Maven
mvn spring-boot:run

# O desde tu IDE (IntelliJ / Eclipse / STS): Run As → Spring Boot App
```

## Notas
- El rol siempre se fuerza a `CLIENTE` en el registro público (el backend ignora cualquier otro valor enviado).
- CORS configurado para `http://localhost:4200` (Angular dev server).
- Eureka deshabilitado por defecto — actívalo si usas Eureka Server.
