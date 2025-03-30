# API de Fiestas

Esta API permite gestionar eventos de fiestas. A continuación se describen los endpoints disponibles y ejemplos de su utilización.

## Endpoints

### Obtener Fiesta por Fecha

**GET** `/api/fiestas/{fecha}`

Obtiene la información de una fiesta para una fecha específica.

#### Ejemplo de uso:

GET "http://localhost:8080/api/fiestas/2024-07-26"

### Agregar Fiesta

**POST** `/api/fiestas`

Agrega una nueva fiesta.

#### Ejemplo de uso:

POST "http://localhost:8080/api/fiestas" -H "Content-Type: application/json" -d '{"fecha": "2024-08-03", "evento": "Concierto"}'

### Actualizar Fiesta

**PUT** `/api/fiestas/{fecha}`

Actualiza la información de una fiesta para una fecha específica.

#### Ejemplo de uso:

PUT "http://localhost:8080/api/fiestas/2024-08-03" -H "Content-Type: application/json" -d '{"fecha": "2024-08-03", "evento": "Nuevo Concierto"}'

### Eliminar Fiesta

**DELETE** `/api/fiestas/{fecha}`

Elimina una fiesta para una fecha específica.

#### Ejemplo de uso:

DELETE "http://localhost:8080/api/fiestas/2024-08-03"

## Errores

- **400 Bad Request**: Si los parámetros `fecha` o `evento` están ausentes o vacíos en las solicitudes POST o PUT.
- **404 Not Found**: Si no se encuentra una fiesta para la fecha especificada en las solicitudes GET o DELETE.

## Ejecución

Para ejecutar la aplicación, es necesario tener configurado un entorno de Spring Boot y ejecutar la clase `Practica4Application`.
