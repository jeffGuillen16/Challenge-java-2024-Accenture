# Challenge 2024 Accenture

En este proyecto, implementé el patrón de diseño **MVC (Modelo-Vista-Controlador)**, una de las arquitecturas más populares para aplicaciones web. Este patrón permite separar claramente las responsabilidades, lo que facilita el mantenimiento y la escalabilidad del sistema. Las tres partes del patrón son:

- **Modelo (Entidad):** Representa los datos y la lógica de negocio. En este caso, diseñé las entidades necesarias para interactuar con la base de datos y procesar la información.
- **Vista:** Se encarga de la presentación de los datos al usuario. Aunque en este caso la vista es más simplificada, es clave para mostrar los resultados de las operaciones al usuario de manera clara y sencilla.
- **Controlador:** Es el intermediario entre el modelo y la vista. Maneja las solicitudes del usuario, llama al servicio adecuado y actualiza la vista con la información que necesita.

Además, la implementación del **servicio** permite centralizar la lógica de negocio, promoviendo una arquitectura limpia y desacoplada, lo que mejora la reutilización del código y facilita su extensión.

---

# Puntos de Venta - Endpoints

A continuación, se presentan las URLs para interactuar con los puntos de venta de la API.

## 1. Obtener todos los puntos de venta
**URL:** 
http://localhost:8080/costos

**Descripción:** Devuelve una lista de todos los puntos de venta.

## 2. Obtener un punto de venta específico
**URL:** 
GET /puntos-de-venta/{id}

**Descripción:** Devuelve los detalles de un punto de venta específico, utilizando su ID.

## 3. Crear un nuevo punto de venta
**URL:**
POST /puntos-de-venta
**Descripción:** Crea un nuevo punto de venta.

**Cuerpo (JSON):**
json
{
  "id": 1,
  "nombre": "Punto de Venta 1",
  "ubicacion": "Ubicación A"
}

PUT /puntos-de-venta/{id}
{
  "nombre": "Punto de Venta Actualizado",
  "ubicacion": "Ubicación B"
}

## 4. Eliminar un punto de venta
DELETE /puntos-de-venta/{id}

