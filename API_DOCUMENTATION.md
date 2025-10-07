# Documentación de APIs REST - Hotel Oasis Digital

## Base URL
```
http://localhost:8082/api
```

## Autenticación
Las APIs públicas no requieren autenticación. Para acceder al sistema web, usa:
- Admin: `admin` / `admin123`
- Recepcionista: `recepcion` / `recep123`
- Cliente: `cliente` / `cliente123`

---

## 📋 API de Clientes

### 1. Listar todos los clientes
**GET** `/api/clientes`

**Response:**
```json
[
  {
    "id": 1,
    "dni": "12345678",
    "nombre": "Juan",
    "apellido": "Pérez",
    "nacionalidad": "Peruana"
  }
]
```

### 2. Obtener cliente por ID
**GET** `/api/clientes/{id}`

**Response:**
```json
{
  "id": 1,
  "dni": "12345678",
  "nombre": "Juan",
  "apellido": "Pérez",
  "nacionalidad": "Peruana"
}
```

### 3. Buscar cliente por DNI
**GET** `/api/clientes/dni/{dni}`

**Response:**
```json
{
  "id": 1,
  "dni": "12345678",
  "nombre": "Juan",
  "apellido": "Pérez",
  "nacionalidad": "Peruana"
}
```

### 4. Crear nuevo cliente
**POST** `/api/clientes`

**Request Body:**
```json
{
  "dni": "87654321",
  "nombre": "María",
  "apellido": "García",
  "nacionalidad": "Peruana"
}
```

### 5. Actualizar cliente
**PUT** `/api/clientes/{id}`

**Request Body:**
```json
{
  "dni": "87654321",
  "nombre": "María",
  "apellido": "García López",
  "nacionalidad": "Peruana"
}
```

### 6. Eliminar cliente
**DELETE** `/api/clientes/{id}`

---

## 🏨 API de Habitaciones

### 1. Listar todas las habitaciones
**GET** `/api/habitaciones`

**Response:**
```json
[
  {
    "id": 1,
    "numero": "101",
    "estado": "DISPONIBLE",
    "precio": 250.00
  }
]
```

### 2. Obtener habitación por ID
**GET** `/api/habitaciones/{id}`

### 3. Listar por estado
**GET** `/api/habitaciones/estado/{estado}`

Estados válidos: `DISPONIBLE`, `OCUPADA`, `MANTENIMIENTO`

### 4. Crear nueva habitación
**POST** `/api/habitaciones`

**Request Body:**
```json
{
  "numero": "201",
  "estado": "DISPONIBLE",
  "precio": 180.00
}
```

### 5. Actualizar habitación
**PUT** `/api/habitaciones/{id}`

**Request Body:**
```json
{
  "numero": "201",
  "estado": "OCUPADA",
  "precio": 180.00
}
```

### 6. Eliminar habitación
**DELETE** `/api/habitaciones/{id}`

---

## 👥 API de Empleados

### 1. Listar todos los empleados
**GET** `/api/empleados`

**Response:**
```json
[
  {
    "id": 1,
    "nombre": "Carlos",
    "apellido": "Rodríguez",
    "cargo": "Recepcionista",
    "dni": "45678912"
  }
]
```

### 2. Obtener empleado por ID
**GET** `/api/empleados/{id}`

### 3. Crear nuevo empleado
**POST** `/api/empleados`

**Request Body:**
```json
{
  "nombre": "Ana",
  "apellido": "Martínez",
  "cargo": "Gerente",
  "dni": "98765432"
}
```

### 4. Actualizar empleado
**PUT** `/api/empleados/{id}`

**Request Body:**
```json
{
  "nombre": "Ana",
  "apellido": "Martínez Sánchez",
  "cargo": "Gerente General",
  "dni": "98765432"
}
```

### 5. Eliminar empleado
**DELETE** `/api/empleados/{id}`

---

## 📝 Ejemplos para Postman

### Colección de pruebas recomendada:

1. **Crear Cliente**
   - POST `http://localhost:8082/api/clientes`
   - Body: raw JSON

2. **Listar Habitaciones Disponibles**
   - GET `http://localhost:8082/api/habitaciones/estado/DISPONIBLE`

3. **Actualizar Estado de Habitación**
   - PUT `http://localhost:8082/api/habitaciones/1`
   - Body: `{"numero":"101","estado":"OCUPADA","precio":250.00}`

4. **Crear Empleado**
   - POST `http://localhost:8082/api/empleados`

---

## 🔧 Códigos de Respuesta HTTP

- `200 OK` - Solicitud exitosa
- `201 Created` - Recurso creado exitosamente
- `204 No Content` - Eliminación exitosa
- `404 Not Found` - Recurso no encontrado
- `400 Bad Request` - Error en los datos enviados

---

## 🗄️ Base de Datos

**Nombre:** `hotel_digital`
**Usuario:** `root`
**Password:** (vacío por defecto)

La aplicación crea automáticamente las tablas y datos de prueba al iniciar.
