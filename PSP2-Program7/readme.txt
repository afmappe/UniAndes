(CSOF 5101) CONCEPTOS AVANZADOS EN INGENIERÍA DE SOFTWARE  
Andrés Felipe Mape
02/05/2017

Requerimientos 
Java versión 8

Archivos
	Los archivos que lee deben se en formato cvs
	Los enlementos de cada linea deben estar separasdos por ;
	La primera linea debe tener la plantilla x;y;loc
ejemplo:
x;y;loc
130;186;386
650;699;
99;132;
150;272;
128;291;
302;331;
95;199;
945;1890;
368;788;
961;1601;

un archivo con esta estructura se encuentra en la ruta"PSP2-Program7\src\program7\src\resources\Test1"

Repositorio https://github.com/afmappe/UniAndes.git
Heroku https://arcane-sea-79165.herokuapp.com/psp7

Instrucciones
Utilizando la consola como administrador sigua los siguientes pasos: 

1. Utilize el comando git clone https://github.com/afmappe/UniAndes.git
2. Ubicarse en la capeta donde se encuentra la entrega luego en la carpeta “src\program6” Ejemplo D:\Proyectos\UniAndes\PSP2-Program7\src\program7
3. Ejecute el siguiente comando: mvn clean install
4. Ejecute el siguiente comando: mvn site para generar la documentacion JavaDoc
4. Ejecute el siguiente comando: java -cp target/program7-1.0.jar edu.uniandes.ecos.PSP2.App.App

Nota 
En esta entrega no se inyectan defectos
El JavaDoc esta en la carpeta de los formatos