# API REST SpringBoot Hibernate

Esto es una práctica de una api REST hecha en Java, utilizando SpringBoot para facilitar la creación de la aplicación

Esta aplicación está basada en un sistema CRUD.

Se necesitan programas de terceros para la correcta ejecución de la misma:

- Base de datos.

La aplicación trabaja con MySql. Utilizando una tabla sencilla

- base de datos: **products**.
- tabla: **products**.
- columnas: **id**(PK, NN, AI), **name**(NN).

![image](https://user-images.githubusercontent.com/103777150/202966198-e291d628-c92e-4b24-b803-a13063efdc4f.png)

## Acerca de los archivos.

La aplicación se divide en los siguientes paquetes:

![image](https://user-images.githubusercontent.com/103777150/202966537-da34da0f-6b38-4e6a-9bac-32094e4a97ee.png)

la clase ProductApiApplication en el paquete .products es la raíz del proyecto. Donde se ejecuta el método main()

El funcionamiento principal está dentro de la clase ProductREST. La cual contiene los métodos, los verbos y los endpoints en donde estos podrán ser llamados.

dentro de esta clase se encuentran los 4 métodos caracteristicos de un crud:

- Create: 

![image](https://user-images.githubusercontent.com/103777150/202967215-5fab4fd4-30ed-49f8-8f24-4433ff66df95.png)

- Read: 

  - Read all:

  ![image](https://user-images.githubusercontent.com/103777150/202967308-8ccb14b0-0801-498f-8813-bbc0b55a61a6.png)


  - ReadById: 
  
  ![image](https://user-images.githubusercontent.com/103777150/202967480-e4c132df-ff9f-4190-b36c-62dec246205a.png)


- Update:

![image](https://user-images.githubusercontent.com/103777150/202967640-41c942f5-7985-4831-8d8c-c13a23168740.png)

- Delete: 

![image](https://user-images.githubusercontent.com/103777150/202967687-d8511431-f82b-4bf7-9b96-fe84bb624c6c.png)


### PATHS

**localhost:8080**

*GET* -> /products

*GET* -> /products/{productId}

*POST* -> /products/body:{"name":name}

*PUT* -> /products/body:{"id":id, "name":name}

*DELETE* -> /products/{productId}


### Observaciones

Dentro de application.properties (application.yml) 
se encuentran configuraciones que son obligatorias para el funcionamiento de la api

![image](https://user-images.githubusercontent.com/103777150/202968649-f30cfbbf-3a92-44bd-82fc-c18140c6890c.png)

![image](https://user-images.githubusercontent.com/103777150/202969144-8b7a3d05-0456-427a-aa90-a38ad8cc5943.png)


### Dependencias Incluidas

![image](https://user-images.githubusercontent.com/103777150/202969230-567019be-9fc6-48da-8abe-cd235c2c7926.png)





