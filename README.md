# RouletteMasivian

Condiciones para ejecutar el proyecto

1. Tener instalado redis server


Instrucciones para ejecutar el proyecto

1. Descargar el repositorio
2. Importar el proyecto a un IDE como SpringBootSuite
3. Actualizar el proyecto, para esto se realiza: Clic derecho sobre el proyecto - Maven - update project
4. Se corre la aplicacion: Clic derecho - Run - Spring boot app

Url de los endpoint
1. Metodo POST crear ruleta: http://localhost:8080/roulette/create-roulette
2. Metodo PUT abrir ruleta: http://localhost:8080/roulette/open-roulette/"ID-RULETA"
3. Metodo PUT hacer apuesta: http://localhost:8080/roulette/wager/"ID-RULETA"
Para este endpoint se usa lo siguiente
HEADER 
key: "username", value: user
BODY
{	
    "betValue" : "8",	
    "userAmount": 1000
}

NOTA: betValue puede tener el valor de "red" o "black" y los numeros entre 0 y 36. userAmount es la cantidad que puede apostar, esta puede ser maximo de 10.000

4. Metodo PUT cerrar ruleta: http://localhost:8080/roulette/close-roulette/"ID-RULETA"
5. Metodo GET obtener todas las ruletas: http://localhost:8080/roulette/get-roulettes
