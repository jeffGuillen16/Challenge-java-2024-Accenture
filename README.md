# Challenge 2024 Accenture

# Implementación del Patrón MVC en el Proyecto

Este proyecto se realizo con java 17 y Maven se implemento el patrón de diseño **MVC (Modelo-Vista-Controlador)**, una de las arquitecturas más populares para aplicaciones web. Este patrón permite separar claramente las responsabilidades, lo que facilita el mantenimiento y la escalabilidad del sistema. Las tres partes del patrón son:

## Modelo (Entidad)
Representa los datos y la lógica de negocio. En este caso, diseñé las entidades necesarias para interactuar con la base de datos y procesar la información.

## Vista
Se encarga de la presentación de los datos al usuario. Aunque en este caso la vista es más simplificada, es clave para mostrar los resultados de las operaciones al usuario de manera clara y sencilla.

## Controlador
Es el intermediario entre el modelo y la vista. Maneja las solicitudes del usuario, llama al servicio adecuado y actualiza la vista con la información que necesita.

## Manejo de Concurrencia y Estructuras de Datos

Además, la implementación del servicio permite centralizar la lógica de negocio, promoviendo una arquitectura limpia y desacoplada, lo que mejora la reutilización del código y facilita su extensión.

Para gestionar la concurrencia y optimizar el rendimiento, utilicé diferentes estructuras de datos según el caso:

- **`ConcurrentHashMap`** para manejar los puntos de entrega, garantizando acceso concurrente seguro sin bloqueos innecesarios.
- **`HashMap`** para almacenar los costos, ya que no requiere acceso concurrente y ofrece un rendimiento óptimo en escenarios de lectura/escritura controlados.

Esta elección de estructuras de datos mejora la eficiencia y la escalabilidad del sistema, asegurando un manejo adecuado de la concurrencia en operaciones críticas.


# Puntos de Venta - Endpoints

A continuación, se presentan las URLs para interactuar con los puntos de venta de la API.

## 1. Obtener todos los puntos de venta
**URL:** 
http://localhost:8080/puntos-de-venta

**Descripción:** Devuelve una lista de todos los puntos de venta.

## Obtener un punto de venta específico
**URL:** 
GET ->/puntos-de-venta/{id}

http://localhost:8080/puntos-de-venta/2

{
    "id": 2,
    "nombre": "GBA_1"
}

**Descripción:** Devuelve los detalles de un punto de venta específico, utilizando su ID.

## 2. Actualizar un punto de venta específico
PUT -> http://localhost:8080/puntos-de-venta/2
{
        "id": 2,
        "nombre": "Miamee"
    }

## 3. Crear un nuevo punto de venta
**URL:**
POST -> /puntos-de-venta

POST -> http://localhost:8080/puntos-de-venta
**Descripción:** Crea un nuevo punto de venta.

**Cuerpo (JSON):**
json
{
        "id": 12,
        "nombre": "Calle siempre viva 123"
    }

## 4. Eliminar un punto de venta
DELETE ->/puntos-de-venta/{id}

DELETE ->http://localhost:8080/puntos-de-venta/2


# Costos - Endpoints

A continuación, se presentan las URLs para interactuar con los puntos de venta de la API.

## 1. Obtener todos los puntos de venta
**URL:** 
http://localhost:8080/costos

**Descripción:** Devuelve una lista de todos los Costos entre los puntos de venta.

## 2. Crear un nuevo punto de venta
**URL:**
POST -> /costos/agregar



## 3. Eliminar un punto de venta
DELETE ->/costos/remover


