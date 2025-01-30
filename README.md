# Challenge 2024 Accenture

Estoy muy emocionado de compartir mi participación en el *Challenge 2024 de Accenture*. Este desafío me permitió aplicar mis conocimientos en desarrollo y arquitectura de software de manera práctica.

En este proyecto, implementé el patrón de diseño **MVC (Modelo-Vista-Controlador)**, una de las arquitecturas más populares para aplicaciones web. Este patrón permite separar claramente las responsabilidades, lo que facilita el mantenimiento y escalabilidad del sistema. Las tres partes del patrón son:

- **Modelo (Entidad):** Representa los datos y la lógica de negocio. En este caso, diseñé las entidades necesarias para interactuar con la base de datos y procesar la información.
- **Vista:** Se encarga de la presentación de los datos al usuario. Aunque en este caso la vista es más simplificada, es clave para mostrar los resultados de las operaciones al usuario de manera clara y sencilla.
- **Controlador:** Es el intermediario entre el modelo y la vista. Maneja las solicitudes del usuario, llama al servicio adecuado, y actualiza la vista con la información que necesita.

Además, implementé un **cache** utilizando `ConcurrentHashMap` para almacenar los puntos de ventas y los costos. Opté por esta estructura en lugar de un `HashMap` tradicional debido a su capacidad para manejar un alto grado de concurrencia, lo que mejora la eficiencia y el rendimiento en un entorno multihilo. Este enfoque permite que múltiples hilos puedan acceder y modificar el cache de manera segura sin bloquear el acceso.

La implementación del **servicio** permite centralizar la lógica de negocio, promoviendo una arquitectura limpia y desacoplada, lo que mejora la reutilización del código y facilita su extensión.

