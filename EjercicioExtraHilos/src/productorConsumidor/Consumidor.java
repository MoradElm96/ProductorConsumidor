package productorConsumidor;


import java.util.Random;

public class Consumidor implements Runnable {

	   //objeto común
	   private Buffer buffer;
	   //clase random para numeros aleatorios
	   private Random random;

    public Consumidor(Buffer buffer) {
       this.buffer=buffer;
        this.random = new Random();
    }

    @Override
    public void run() {
    	
    	while(true) {
    		
    		//si la cola esta vacia, esperamos un tiempo aleatorio
    		
    		while(buffer.estaVacia()) {
    			
    		
        		int tiempoAdormir = random.nextInt(5000-1000)+1000;// esperamos entre 0 y 5 segundos
        		try {
        			System.out.println("--------------Consumidor  esperando....--------------");
        			Thread.sleep(tiempoAdormir);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
    		}
    		
    		
    			//obtenemos el numero del principio y lo borramos, lo borra el metodo que hay en la clase buffer
    			int number = buffer.consumir();          
    			System.out.println( "Hilo CONSUMIDOR " + Thread.currentThread().getName() +  "  RECOGE el numero--------------------------=> "+ number + " del buffer ");
    		
    		
    	}	
    	}
}
        
    
