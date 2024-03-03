# API REST de Gestión de Tareas

Esta es una API REST desarrollada con Spring Boot que permite gestionar una lista de tareas. La API proporciona operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para las tareas, permitiendo a los usuarios administrar sus tareas de manera efectiva.

## Especificaciones

- Cada tarea tiene los siguientes campos:
    - `id`: Identificador único de la tarea.
    - `titulo`: Título de la tarea.
    - `descripcion`: Descripción detallada de la tarea.
    - `completada`: Indicador booleano que indica si la tarea está completada o no.
    - `fechaCreacion`: Fecha de creación de la tarea.

- La API ofrece los siguientes endpoints:
    - `GET /tareas`: Obtener todas las tareas.
    - `GET /tareas/{id}`: Obtener una tarea por su ID.
    - `POST /tareas`: Crear una nueva tarea.
    - `PUT /tareas/{id}`: Actualizar una tarea existente.
    - `DELETE /tareas/{id}`: Eliminar una tarea por su ID.

## Tecnologías Utilizadas

- Spring Boot: Framework de desarrollo de aplicaciones Java.
- Spring Web: Para crear controladores REST.
- Spring Data JPA: Para interactuar con la base de datos.
- Base de datos H2 (opcional): Base de datos en memoria para almacenar las tareas.

## Ejecución del Proyecto

1. Clona este repositorio a tu máquina local.
2. Abre el proyecto en tu IDE de preferencia (por ejemplo, IntelliJ IDEA, Eclipse).
3. Ejecuta la aplicación Spring Boot.
4. La API estará disponible en la URL: `http://localhost:8080`.

## Uso de la API

Puedes utilizar herramientas como Postman, curl o cualquier cliente HTTP para probar los endpoints de la API y gestionar las tareas.

### Ejemplo de solicitud GET:

