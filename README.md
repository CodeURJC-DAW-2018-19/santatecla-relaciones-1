[![Build Status](https://travis-ci.org/mamonreal/santatecla-relaciones-1.svg?branch=master)](https://travis-ci.org/mamonreal/santatecla-relaciones-1)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=mamonreal_santatecla-relaciones-1&metric=alert_status)](https://sonarcloud.io/dashboard?id=mamonreal_santatecla-relaciones-1)

# santatecla-relaciones-1

**Integrantes del grupo:**

Apellidos | Nombre | E-mail | Github 
--- | --- | --- | --- 
Monreal Velasco | Miguel Ángel | ma.monreal@alumos.urjc.es | mamonreal 
Gamero Bermejo | Jorge | j.gamero@alumnos.urjc.es | theyorch11
Amor Antolín | David | d.amora@alumnos.urjc.es | Almendron100

**Documento de requisitos:**  
https://docs.google.com/document/d/1UT6LcYCy5LInWHwbaAv2Tt3kwkTyI_fXCl3HWxxQbOU/edit

**Trello:**  
https://trello.com/b/eijxtnDK/daw-g-16  

**Actualización de la fase 2:**  
**Extracción del archivo *.jar***   
Para empaquetar la aplicación en un archivo *.jar* hemos añadido la configuración necesaria al archivo *pom.xml*  
*<start-class>es.urjc.code.daw.santatecla.relaciones.App.java</start-class>* en el apartado *<properties>*  
  A continuación, si estamos en *Eclipse*, selecionamos *Run as* -> *Maven Install*  
  Con esto generamos el archivo *relaciones-0.0.1-SNAPSHOT.jar*.  
  
**Screenshots:**  
![index](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/index.JPG)
![logout](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/logout.JPG)
![alumn-context](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/alumn-context.JPG)
![alumn-details](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/alumn-details.JPG)
![teacher-context](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/teacher-context.JPG)
![teacher-details](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/teacher-details.JPG)

**Screenshots Fase 2**

**Página de inicio:**
![Captura1](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Captura1.PNG)

**Logeado:**
![Captura2](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Captura2.PNG)

**Añadir unidad:**
![Captura3](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Captura3.PNG)

**Lista de unidades:**
![Captura5](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Captura5.PNG)

**Añadir relación:**
![Captura6](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Captura6.PNG)

**Contexto:**
![Captura7](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Captura7.PNG)

**Detalle:**
![Captura8](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Captura8.PNG)

**Añadir ficha:**
![Captura9](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Captura9.PNG)

## Diagramas
**Diagrama de clases:**
![Clases](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Clases.png)

**Diagrama de la base de datos:**
![BaseDatos](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/BaseDatos.PNG)

**Diagrama de navegación:**
![Navegacion](https://github.com/CodeURJC-DAW-2018-19/santatecla-relaciones-1/blob/master/screenshots/Navegacion.png)

**Configurar entorno de desarrollo**
- Descargar e instalar Spring Tools 4 Eclipse: https://spring.io/tools
- Descargar Github Desktop desde la página oficial de Github: https://desktop.github.com/
- Descargar MySql  y MySQL Workbench para la base de datos: https://dev.mysql.com/downloads/mysql/ y https://dev.mysql.com/downloads/workbench/
- Un a vez tenemos Github Desktop instalado en nuestro ordenador, deberemos iniciar sesión en la aplicación, para así de esta manera, poder importar nuestro proyecto directamente a nuestro ordenador. Una vez importado, abriremos la carpeta "relaciones" ubicada "normalmente" en la dirreción "/Documents/Github/santatecla-relaciones-1/backend".
- Para ejecutar la aplicación, deberemos lanzar la clase App con Sprin Boot App ubicada en "\Documents\GitHub\santatecla-relaciones-1\backend\relaciones\src\main\java\es\santatecla\App.java". Deberemos dirigirnos en nuestro navegador a la siguiente dirección https://localhost:8443
- Es necesaria la configuración de MySQL Workbench crear un esquema nuevo con el nombre que quieras, configuras las credenciales, normalente el usurio es "root" y la contraseña es "pass". No olvidarse de configurar en el pom.xml los ajustes de MySQL como la contraseña y el usuario además del nombre dado a nuestro esquema.
