# Rover de Marte

Proyecto Rover Java | Bootcamp ATL Academy

## Descripción
Este proyecto simula un **Rover de Marte** que se mueve sobre una cuadrícula representando la superficie del planeta.  
El rover puede recibir comandos de movimiento (`F` → forward, `B` → backward, `L` → left, `R` → right), detectar obstáculos y regresar a la última posición segura.  

Es un **proyecto backend** desarrollado como trabajo para el **Bootcamp de Backend con Java de ATL Academy**. Está diseñado con fines educativos, reforzando conceptos clave de desarrollo backend y buenas prácticas en Java.  

El proyecto incluye un pequeño front-end en desarrollo para demostraciones, pero su foco principal es la lógica de negocio y la arquitectura backend.

---

## Objetivos de Aprendizaje
Durante el desarrollo de este proyecto se reforzaron y aprendieron habilidades como:  
- **Programación orientada a objetos en Java** y diseño de clases para representar entidades y lógica de negocio.  
- **Spring Boot** para la creación de APIs REST, incluyendo `@RestController`, servicios e inyección de dependencias.  
- **Hibernate y JPA** para persistencia de datos en MySQL, gestionando relaciones y operaciones CRUD.  
- **Testing con JUnit** y desarrollo basado en pruebas (TDD) para la lógica del rover.  
- **Buenas prácticas de arquitectura**: separación en capas (controllers, services, repository, logic, utils).  
- **Gestión de dependencias con Maven**, incluyendo preparación para pruebas BDD con Cucumber.  
- **Manejo de DTOs** para intercambio de datos entre front y backend.  
- **Simulación de escenarios complejos**: movimientos sobre cuadrícula, detección de obstáculos y lógica de retroceso.  

---

## Tecnologías y Dependencias
- **Backend:** Java 17, Spring Boot, Hibernate, Lombok  
- **Base de datos:** MySQL (con WAMP y phpMyAdmin)  
- **Testing:** JUnit 5  
- **Cucumber:** dependencia incluida para futuras pruebas BDD  
- **Frontend (en desarrollo):** HTML, CSS, JavaScript  

Dependencias principales en Maven (`pom.xml`):  
- `spring-boot-starter-web`  
- `spring-boot-starter-data-jpa`  
- `mysql-connector-j`  
- `lombok`  
- `junit-jupiter`  
- `cucumber-java`, `cucumber-spring`, `cucumber-junit`  

---

## Requisitos Previos
- Java 17  
- Maven  
- WAMP para levantar la base de datos MySQL  
- phpMyAdmin para administración de la base de datos  

---

## Instalación y Ejecución
1. Levantar la base de datos MySQL con WAMP.  
2. Ejecutar el proyecto con Maven:  
```bash

mvn spring-boot:run
3. El servidor se ejecutará por defecto en http://localhost:8080.

##Endpoints REST

- RoverController: para manejar los comandos de movimiento del rover.

- ObstacleController: para manejar la gestión de obstáculos.

Ejemplo de uso:

POST http://localhost:8080/api/rover/command
Body: { "commands": ["F","F","R","F","L","B"] }

##Estructura del Proyecto

rover/
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  ├─ controllers/          
│  │  │  │  ├─ MapaController
│  │  │  │  ├─ ObstacleController
│  │  │  │  └─ RoverController
│  │  │  ├─ dto/                  
│  │  │  │  ├─ CommandDto
│  │  │  │  ├─ ObstacleDto
│  │  │  │  └─ RoverDto
│  │  │  ├─ logic/                
│  │  │  │  ├─ DefaultRoverMovement
│  │  │  │  └─ RoverNavigator
│  │  │  ├─ models/               
│  │  │  │  ├─ Direction
│  │  │  │  ├─ Map
│  │  │  │  ├─ Obstacle
│  │  │  │  └─ Rover
│  │  │  ├─ repository/           
│  │  │  │  ├─ ObstacleRepository
│  │  │  │  └─ RoverRepository
│  │  │  ├─ services/             
│  │  │  │  ├─ ObstacleService (interfaz)
│  │  │  │  ├─ ObstacleServiceImp
│  │  │  │  ├─ RoverService (interfaz)
│  │  │  │  └─ RoverServiceImp
│  │  │  └─ utils/                
│  │  │     ├─ MapWrapperUtils
│  │  │     └─ ObstacleBlockingUtils
│  │  └─ resources/
│  │     └─ static/               
│  └─ test/
│     └─ java/
│        ├─ logic/
│        │  └─ DefaultRoverMovementTest
│        ├─ utils/
│        │  ├─ MapWrapperUtilsTest
│        │  └─ ObstacleBlockingUtilsTest
└─ pom.xml


#Testing

El proyecto incluye tests unitarios con JUnit que cubren la lógica de movimiento del rover y utilidades.

- DefaultRoverMovementTest

- MapWrapperUtilsTest

- ObstacleBlockingUtilsTest


#Licencia

Proyecto con fines educativos desarrollado en el Bootcamp de ATL Academy.
