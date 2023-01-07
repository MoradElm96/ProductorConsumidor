# ProductorConsumidor
El problema del productor consumidor
Problema: productores y consumidores. 
En un cierto programa se tienen procesos que producen números y procesos que leen esos números. 
Todos los números se introducen en una cola (o vector) limitada. 

Todo el mundo lee y escribe de/en esa cola. Cuando un productor quiere poner un número tendrá que comprobar si la cola está llena.
Si está llena, espera un tiempo al azar. Si no está llena pone su número en la última posición libre. Cuando un lector quiere leer, examina si la cola está vacía.
Si lo está espera un tiempo al azar, y sino coge el número que haya al principio de la cola y ese número ya no está disponible para el siguiente. 

Crear un programa que simule el comportamiento de estos procesos evitando problemas de entrelazado e inanición.
El tamaño de la cola debe estar definido por una constante.
