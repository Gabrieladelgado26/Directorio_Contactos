DIRECTORIO DE CONTACTOS

El presente proyecto es un DIRECTORIO DE CONTACTOS realizado como aplicación dirigida a la web en el entorno de desarrollo integrado NETBEANS, el cual permite agregar contactos ingresando datos de: nombre, apellido, dirección, teléfono y correo electrónico, además, internamente para cada contacto se crea un ID. 

Se utilizó como estructura de datos un árbol binario con el que se realizan las principales acciones como agregar un contacto y eliminar un contacto, pero además, la aplicación permite visualizar la información de un contacto, buscar contactos y ordenar ascendente y descendentemente los contactos de acuerdo con el dato que desde, es decir, organizar por nombre, apellido u otro atributo a excepción del ID.

REQUERIMIENTOS FUNCIONALES

- Agregar contacto: El usuario agrega un nuevo contacto al directorio. El nombre no puede repetirse en la lista, si se intenta agregar un contacto con nombre repetido, esté, no se agrega a la lista. 
- Localizar contacto: El usuario indica el nombre, apellido, dirección, teléfono o correo de un contacto para que el sistema lo busque rápidamente y lo muestre en la lista de contactos. Todos los contactos que coincidan con lo digitado por el usuario se mostraran en la tabla.
- Visualizar datos de contacto: El usuario selecciona el botón de visualizar para obtener la información del usuario que desea. La información del contacto debe ser mostrada. 
- Listar el directorio en In Orden: Se ordena la lista de contactos en el recorrido InOrden.
- Eliminar un contacto: El usuario selecciona la opción de eliminar un contacto especifico y lo elimina.
- Ordenar lista de contactos: Se ordena la lista de contactos en orden descendente o ascendente con base al campo que elija el usuario, la lista se puede ordenar por id, nombre, apellido, dirección, teléfono o correo.
- Visualizar contactos por secciones: El usuario selecciona la cantidad de contactos que desea visualizar en la tabla, ya sea 10, 25, 50 o 100, posteriormente permite recorrer por secciones (según la cantidad escogida) la totalidad de la lista de contactos.

CLASES JAVA

Se utilizaron cuatro clases para manejar los requerimiento funcionales de la aplicación, las cuales son:

- Persistencia: Permite guardar la información de los contactos en archivos de texto para mantener la persistencia en la aplicación.
- ContactoRepetidoException: Excepción propia que se lanza en caso de que el usuario desee ingresar un contacto con el mismo nombre.
- Contacto: Contiene los atributos de contacto y otros elementos, como métodos que serán llamados desde otra clase para realizar acciones como agregar contacto y otros.
- Directorio: Contiene los métodos donde se encuentra la lógica de programación para realizar algunos de los requerimientos funcionales.

SERVLETS

SvAgregar: Este servlet se encarga de manejar la solicitud del usuario para agregar un nuevo contacto al directorio, este servlet se comunica con la clase Directorio para ejecutar la lógica necesaria para agregar el contacto. Si se intenta agregar un contacto con un nombre que ya existe en la lista, se maneja la excepción ContactoRepetidoException.

SvEliminar: Este servlet gestiona la solicitud del usuario para eliminar un contacto específico del directorio, esta clase también interactúa con la clase Directorio para llevar a cabo la eliminación del contacto seleccionado por el usuario.

AUTORES

Adrian Camilo Castillo Angulo - Karoll Gabriela Delgado Charfuelan – Ana Cristina Mera Rodriguez
