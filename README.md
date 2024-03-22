Proyecto de Gestión de Facturación Hotelera y Servicios de Alimentación

Este proyecto consiste en un sistema de gestión de facturación para un hotel, con un enfoque inicial en los servicios de alimentación. Sin embargo, se ha diseñado considerando una posible expansión para gestionar todos los costos dentro del hotel en el futuro.

Estructura del Proyecto:

El proyecto está organizado en varias clases y paquetes que cumplen diferentes funciones. A continuación, se describe cada clase y su funcionalidad:

Clases en el paquete principal:

1.	AdsToRoom.java: Esta interfaz está diseñada para futuras implementaciones, aunque actualmente no tiene uso específico.
2.	ArrayChef.java: Crea arreglos y listas de chefs para su gestión dentro del hotel.
3.	ArrayFood.java: Gestiona arreglos de platillos para el servicio de alimentación del hotel.
4.	ArrayGuest.java: Permite la gestión de arreglos de huéspedes dentro del hotel.
5.	Bill.java: Contiene los cálculos y la lógica para generar la factura final para los huéspedes, incluyendo los servicios de alimentación y posibles expansiones.
6.	Chef.java: Define el objeto chef y sus atributos dentro del sistema hotelero.
7.	ChefFileReader.java: Se encarga de leer una lista de chefs desde un archivo y proporciona métodos para su modificación.
8.	ChefRoom.java: Administra la asignación y modificación de chefs en las habitaciones del hotel.
9.	Employee.java: Define el objeto empleado del hotel, con sus características y funciones específicas.
10.	FoodFileReader.java: Lee una lista de platillos desde un archivo y proporciona métodos para su modificación dentro del sistema.
11.	FoodItems.java: Define el objeto platillo con sus atributos y métodos asociados.
12.	FoodRoom.java: Gestiona la disponibilidad y modificación de platillos en las habitaciones del hotel.
13.	Guest.java: Define el objeto huésped con sus atributos y funcionalidades dentro del sistema hotelero.
14.	Person.java: Define el objeto persona como una clase base para los empleados, chefs, huéspedes, etc.
15.	Reception.java: Es la clase principal (main) del proyecto, desde donde se realizan las llamadas a las demás clases para su utilización y gestión.
16.	Room.java: Gestiona las habitaciones del hotel, incluyendo la asignación y gestión de huéspedes en ellas.
    
Clases en otros paquetes:

1.	Paquete "Lecture": Contiene la clase Lecture.java, la cual se encarga de leer todos los datos de entrada necesarios para el funcionamiento del sistema.
2.	Paquete de Ejemplo de Importación de Lista de Personas: Este paquete ejemplifica cómo importar una lista predefinida de personas (en este caso, jugadores de un equipo), modificarla y utilizarla dentro del proyecto principal.
	
•	Person.java: Define el objeto persona como una clase base para la creación de objetos específicos como jugadores.
•	Player.java: Define el objeto jugador con sus atributos y métodos asociados.
•	Team.java: Crea una lista de jugadores, agrega el tipo de huésped "Deportista" a cada elemento y la importa desde un archivo de texto que puede ser modificado.

Ejecución del Programa

Para ejecutar el programa, se debe ejecutar la clase Reception.java, que actúa como el punto de entrada principal del sistema. Desde esta clase se pueden realizar todas las operaciones de gestión de huéspedes, chefs, platillos y habitaciones dentro del hotel, así como generar las facturas finales para los huéspedes.

A continuación se anexa un enlace al diagrama de clases del proyecto: https://drive.google.com/file/d/1PhIWYlfbepJSsuEDKzC6FyF7CIywr9d7/view?usp=sharing
