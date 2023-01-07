package productorConsumidor;

import java.util.ArrayList;

public class Buffer {

	// controlar que cuando el array este vacio no se consuma mas y cuando este
	// lleno no se produzca mas

	ArrayList<Integer> buffer;

	//variable para tamaño el arraylist
	private int maxSize;

	public Buffer(int maxSize) {
		this.buffer = new ArrayList<>(maxSize);
		this.maxSize = maxSize;

	}

	// metodo para comprobar que esta vacia
    public synchronized boolean estaVacia() {
		//si esta vacia
		if(this.buffer.isEmpty()) {
			return true;
		}else {
		
		return false;
		}
	}
	
	
	
	// metodo para comprobar que esta llena

	public synchronized boolean estaLleno() {
		//si esta completa
		if(this.buffer.size()==maxSize) {
			return true;
		}else {
			return false;
		}
		
		
		
	}

	// metodo para anadir elemento a la cola
	public synchronized void producir(int elemento) {

		
		while(this.estaLleno())	{
			try {
				
			
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		buffer.add(elemento);
		//noticamos a los hilos
		notifyAll();

	}

	
	// obtener el primer elemento de la cola
	public synchronized int consumir() {

		
		while(this.estaVacia()) {
			try {
				
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//noticamos a los hilos
		notifyAll();

		//removemos el primer elemento del arrayList
		int element = buffer.remove(0);
		return element;
	}

}
