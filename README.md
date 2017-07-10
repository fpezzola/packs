
Sistema prepago:

Los servicios SOAP del Sistema prepago fueron mockeados con el soapUI en la siguiente dirección: 

http://localhost:8088/testprepaidservice/PrepaidService

El wsdl que tiene esa información se encuentra en src/main/resources/wsdl


----------------------------------


Script Bdd - mySQL:

El script se llama scriptPack.sql y tiene la creación del schema con la info estatica de los planes y bonos solicitados.

La info de los packs por número de teléfono se completa a través del servicio REST


----------------------------------


Resolucion:

Utilice spring boot con su tomcat integrado. Para levantar la aplicación se debe correr la clase Application.java o bien doble click en el jar que adjunto en el mail.

Versión de java: 1.8


1- Para realizar el alta de un pack para un usuario hay dos posibilidades:

POST – http://localhost:8080/packs/api/pack/purchase

Espera un json con la siguiente info:
•	Phone: 10 números
•	Pack: 01/02 (diario/semanal)	

Si se utiliza el postman se debe crear el json desde la pestaña “raw”.
 Ejemplo: {"phone":"1157186587","pack":"02"}


GET - http://localhost:8080/packs/api/pack/purchase/{phone}/{pack}

Ejemplo  http://localhost:8080/packs/api/pack/purchase/1111111111/01

ACLARACION: Realice las dos variantes por si no es posible la utilización de postman y resulta muy engorro enviar el json. 


----------------------------------



2-Para realizar la baja de todos los packs hay una sola petición:

DELETE - http://localhost:8080/packs/api/pack/delete/{phone}

Ejemplo: http://localhost:8080/packs/api/pack/delete/1111111111


----------------------------------


3-  Se utilizó el @Scheduled de spring y se ejecuta cada UN minuto, verificando que packs vencen en ese minuto y setenándoles el estado en V (VENCIDO)

La clase que tiene este método se llama ScheduledTasks.java
