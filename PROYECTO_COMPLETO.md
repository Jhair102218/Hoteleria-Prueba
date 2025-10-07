# 🏨 Sistema Hotelero Oasis Digital - Proyecto Completo

## 📋 Descripción General

Sistema web completo de gestión hotelera desarrollado con Spring Boot, Thymeleaf, Bootstrap y MySQL. Incluye autenticación con Spring Security, APIs REST completas para operaciones CRUD y un diseño moderno y responsivo.

---

## 🎨 Características Principales

### ✅ Frontend
- **Index atractivo** con información del hotel, habitaciones, servicios, horarios
- **Diseño responsivo** con colores llamativos (naranja #FF6B35, dorado #F7931E)
- **Secciones completas:**
  - Hero con navegación
  - Tipos de habitaciones con precios y características
  - Instalaciones del hotel
  - Galería de imágenes
  - Información útil (clima y tipo de cambio con APIs externas)
  - Mapa de ubicación
  - Horarios de atención
  - Contacto y redes sociales

### ✅ Sistema de Autenticación
- **Spring Security** configurado con 3 roles:
  - `ROLE_ADMIN` (admin/admin123)
  - `ROLE_RECEPCIONISTA` (recepcion/recep123)
  - `ROLE_CLIENTE` (cliente/cliente123)
- Página de login moderna con diseño split-screen
- Logout funcional
- Protección de rutas según rol

### ✅ Dashboard Diferenciado
- **Panel estadístico** con tarjetas animadas
- **Métricas en tiempo real:**
  - Total de habitaciones
  - Total de clientes
  - Habitaciones disponibles
  - Habitaciones ocupadas
  - Habitaciones en mantenimiento
- **Accesos rápidos** según rol del usuario
- Diseño moderno con colores corporativos

### ✅ Base de Datos MySQL
- Base de datos: `hotel_digital`
- **Modelos completos:**
  - Usuario (con roles y autenticación)
  - Cliente
  - Empleado
  - Habitacion
  - Reserva
- Inicialización automática de datos de prueba
- Relaciones entre tablas configuradas

### ✅ APIs REST Completas
Todas las APIs incluyen operaciones CRUD completas:

**Endpoints disponibles:**
- `/api/clientes` - Gestión de clientes
- `/api/habitaciones` - Gestión de habitaciones
- `/api/empleados` - Gestión de empleados

**Operaciones:**
- GET (listar todos)
- GET /{id} (obtener por ID)
- POST (crear)
- PUT /{id} (actualizar)
- DELETE /{id} (eliminar)

### ✅ APIs Externas Integradas
- **Meteosource API**: Clima en tiempo real de Lima
- **SUNAT API**: Tipo de cambio USD a PEN

---

## 🗂️ Estructura del Proyecto

```
src/main/
├── java/web_integrado/Hoteleria/
│   ├── config/
│   │   ├── SecurityConfig.java (Spring Security)
│   │   └── DataInitializer.java (Datos iniciales)
│   ├── model/
│   │   ├── Usuario.java
│   │   ├── Cliente.java
│   │   ├── Empleado.java
│   │   ├── Habitacion.java
│   │   └── Reserva.java
│   ├── repository/
│   │   ├── UsuarioRepository.java
│   │   ├── ClienteRepository.java
│   │   ├── EmpleadoRepository.java
│   │   ├── HabitacionRepository.java
│   │   └── ReservaRepository.java
│   ├── service/
│   │   ├── CustomUserDetailsService.java
│   │   ├── UsuarioService.java
│   │   ├── ClienteService.java
│   │   ├── EmpleadoService.java
│   │   ├── HabitacionService.java
│   │   └── ReservaService.java
│   ├── controller/
│   │   ├── LoginController.java
│   │   ├── DashboardController.java
│   │   ├── ClienteController.java
│   │   ├── EmpleadoController.java
│   │   ├── HabitacionController.java
│   │   ├── HistorialController.java
│   │   └── LogController.java
│   └── restControllers/
│       ├── ClienteRestController.java
│       ├── EmpleadoRestController.java
│       └── HabitacionRestController.java
└── resources/
    ├── application.properties (Configuración MySQL)
    ├── static/
    │   ├── css/index-styles.css
    │   ├── js/index-scripts.js
    │   └── images/ (8 imágenes del hotel)
    └── templates/
        ├── index.html
        ├── login.html
        ├── dashboard.html
        ├── clientes.html
        ├── empleados.html
        ├── habitaciones.html
        ├── historial.html
        ├── logs.html
        └── registro-cliente.html
```

---

## ⚙️ Configuración

### Base de Datos
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_digital
spring.datasource.username=root
spring.datasource.password=
```

### Puerto
```properties
server.port=8082
```

---

## 🚀 Cómo Ejecutar

1. **Asegúrate de tener MySQL instalado y corriendo**

2. **Clona y ejecuta:**
```bash
./mvnw spring-boot:run
```

3. **Accede a:**
- Index: http://localhost:8082/
- Login: http://localhost:8082/login
- Dashboard: http://localhost:8082/dashboard (requiere login)

---

## 📊 Pruebas con Postman

Ver archivo `API_DOCUMENTATION.md` para endpoints completos.

### Ejemplos rápidos:

**Listar habitaciones:**
```
GET http://localhost:8082/api/habitaciones
```

**Crear cliente:**
```
POST http://localhost:8082/api/clientes
Content-Type: application/json

{
  "dni": "12345678",
  "nombre": "Juan",
  "apellido": "Pérez",
  "nacionalidad": "Peruana"
}
```

**Actualizar habitación:**
```
PUT http://localhost:8082/api/habitaciones/1
Content-Type: application/json

{
  "numero": "101",
  "estado": "OCUPADA",
  "precio": 250.00
}
```

---

## 🎨 Paleta de Colores

- **Primario:** #FF6B35 (Naranja vibrante)
- **Acento:** #F7931E (Dorado)
- **Oscuro:** #1A1A2E (Azul oscuro)
- **Éxito:** #4ECDC4 (Turquesa)
- **Fondo:** #FFF8F0 (Crema cálido)

---

## 📱 Responsividad

El sistema es completamente responsivo con breakpoints optimizados para:
- Desktop (>768px)
- Tablet (768px)
- Mobile (<768px)

---

## 🔐 Usuarios de Prueba

| Usuario | Contraseña | Rol |
|---------|-----------|-----|
| admin | admin123 | Administrador |
| recepcion | recep123 | Recepcionista |
| cliente | cliente123 | Cliente |

---

## �� Dependencias Principales

- Spring Boot 3.5.6
- Spring Security
- Spring Data JPA
- MySQL Connector
- Thymeleaf
- Bootstrap 5.3.2
- Font Awesome 6

---

## ✨ Características Destacadas

1. ✅ Sistema completo sin frameworks frontend (solo Thymeleaf, CSS, JS)
2. ✅ Autenticación robusta con Spring Security
3. ✅ APIs REST completas con CRUD
4. ✅ Diseño moderno y atractivo
5. ✅ Integración con APIs externas
6. ✅ Base de datos MySQL configurada
7. ✅ Dashboards diferenciados por rol
8. ✅ Responsive design completo
9. ✅ Documentación de APIs para Postman
10. ✅ Datos de prueba preconfigurados

---

## 📄 Licencia

Proyecto educativo - Sistema Hotelero Oasis Digital 2025
