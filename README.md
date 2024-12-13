# BancoDelTiempo
Banco del Tiempo - MVP

Contexto
Una pequeña asociación lleva a cabo en su barrio una iniciativa vecinal que gestiona un banco del tiempo. Quieren una aplicación con la cual los encargados del proyecto puedan gestionar ese banco del tiempo.
Objetivo.

Descripción

Banco del Tiempo es una aplicación desarrollada en Java con Spring Boot que permite a los usuarios gestionar su tiempo como una moneda de intercambio. La versión MVP (Producto Mínimo Viable) incluye las funcionalidades básicas de registro de usuarios, publicación y asignación de tareas, así como la gestión de una cuenta bancaria de tiempo, empleando unas monedas llamadas "Kairós".

Historias de Usuario

Registro de Usuarios:

- Como usuario, quiero registrarme en la aplicación proporcionando mis datos personales, para poder acceder a sus funcionalidades.

Criterios de aceptación:

- Debo poder crear un perfil con nombre, email y número de teléfono.

- Debo poder actualizar o eliminar mi perfil.

Publicación de Anuncios:

- Como usuario, quiero publicar anuncios para solicitar ayuda en tareas específicas, para encontrar personas que me ayuden.

Criterios de aceptación:

- Debo poder crear un anuncio con título, descripción, fecha y pago en tiempo.

- Solo podré editar o eliminar mis propios anuncios.

Asignación de Tareas:

- Como usuario, quiero asignarme a una tarea publicada por otro usuario, para poder ganar tiempo.

Criterios de aceptación:

- Debo poder aceptar una tarea publicada.

- Una vez asignada, no debe estar disponible para otros usuarios.

Gestión de Cuenta Bancaria de Tiempo:

- Como usuario, quiero agregar o quitar tiempo de mi cuenta bancaria al completar o solicitar tareas, para gestionar mi saldo de tiempo.

Criterios de aceptación:

- Al completar una tarea, el tiempo acordado se suma a mi cuenta.

- Al solicitar una tarea, el tiempo acordado se descuenta de mi cuenta.

Requisitos Técnicos

Tecnologías Utilizadas

- Lenguaje: Java

- Framework: Spring Boot

- Base de Datos: MySQL o H2 para el desarrollo y pruebas.

- Herramientas de Construcción: Maven

- Control de Versiones: Git y GitHub

- Pruebas Unitarias: JUnit y Mockito

- API Testing: Postman

Arquitectura

Modelo-Vista-Controlador (MVC):

La aplicación sigue una arquitectura basada en MVC, separando la lógica de negocio (Servicios), la persistencia (Repositorios) y las APIs (Controladores REST).

Entidades Principales:

Usuario: Representa a los usuarios registrados.

Anuncio (Advertisement): Representa las tareas publicadas.

Cuenta Bancaria (Account): Gestión de saldo de tiempo de los usuarios.

API REST:

Usuarios:

Endpoints para CRUD (Create, Read, Update, Delete).

Anuncios:

Endpoints para publicar, consultar, editar y asignar tareas.

Cuentas:

Endpoints para consultar y modificar el saldo de tiempo.

Dependencias Clave

Spring Boot Starter Web: Para construir las APIs REST.

Spring Boot Starter Data JPA: Para la persistencia de datos.

H2 Database: Base de datos en memoria para pruebas.

MySQL Connector: Para integración con MySQL.

Lombok: Para reducir el boilerplate de código.

JUnit y Mockito: Para pruebas unitarias.

Diagrama UML

Puedes encontrar el diagrama UML del proyecto en el siguiente enlace:
Diagrama UML del Banco del Tiempo

Futuras Características

En futuras versiones del proyecto, se implementarán las siguientes mejoras:

Encriptación de Contraseñas:

Mejora de seguridad para proteger los datos de los usuarios.

Valoraciones:

Los usuarios podrán calificar a otros después de completar una tarea.

Transferencias de Saldo:

Los usuarios podrán transferir saldo de tiempo a otros usuarios.

Roles de Usuario:

Se implementarán roles de administrador y usuario, cada uno con diferentes permisos.

<h2> Modelo de ER </h2>
<p> 
<img src="https://github.com/GuadalupeGFigueroa/BancoDelTiempo/blob/dev/Modelo%20ER.png"heigt=50%>
</p>

<h2> Diagrama UML <h2>
<p>
<img src="https://github.com/GuadalupeGFigueroa/BancoDelTiempo/blob/dev/Modelo%20ER.png"heigt=50%>
</p>

<h2>Test unitarios<h2>
<p> 
<img src="https://github.com/GuadalupeGFigueroa/BancoDelTiempo/blob/dev/Test%20de%20cobertura%2075%2C21%25.png"heigt=50%>
</p>

<h3>Developper: Guadalupe García Figueroa</h3>
