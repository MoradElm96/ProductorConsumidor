package productorConsumidor;


import java.util.Random;


public class Productor implements Runnable {
   //objeto común
   private Buffer buffer;
   //clase random para numeros aleatorios
   private Random random;
   
   
    public Productor(Buffer buffer) {
       this.buffer= buffer;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
        	
        	//creamos un numero aleatorio
        	int number = random.nextInt(51);// genera numero entre 0 y 50
        	      	
        	
        	//mientras la cola esta llena duerme...
        	while(buffer.estaLleno()) {
        		// esperamos entre 0 y 5 segundos
        		int tiempoAdormir = random.nextInt(5000-1000)+1000;//(maximo-minimo)+minimo
        		try {
        			System.out.println("--------------Productor  esperando....--------------");
        			Thread.sleep(tiempoAdormir);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
        	}
        	
        	//anadimos a la cola
        	buffer.producir(number);
        	//imprimimos por pantalla el numero producido y el nombre del hilo que lo ha hecho.
        	System.out.println("Hilo PRODUCTO " + Thread.currentThread().getName() +  "  DEPOSITA el numero -----------------------=> "+ number + " del buffer");

        	
        	   
            }
        }
    }
