package productorConsumidor;


public class Principal {

	//constante para el tamaño del array
    public static final int TAMANIO_COLA = 10;

    public static void main(String[] args) {
    	
    	Buffer buffer = new Buffer(TAMANIO_COLA); // array de 10 posiciones

		// un hilo productor
		Productor hiloProdc = new Productor(buffer);

		// un hilo consumidor
		Consumidor hiloCons = new Consumidor(buffer);

		// ARRAY DE HILOS
		int numeroHilosConsumidores = 4;
		int numeroHilosProductores = 4;
		Thread[] tp = new Thread[numeroHilosProductores];
		Thread[] tc = new Thread[numeroHilosConsumidores];

		// lanzamos los hilos productores
		for (int i = 0; i < tp.length; i++) {

			tp[i] = new Thread(hiloProdc);

			tp[i].start();

		}

		// lanzamos el hilo consumidor
		for (int i = 0; i < tc.length; i++) {

			tc[i] = new Thread(hiloCons);

			tc[i].start();

		}
		
		
		
    }
}



