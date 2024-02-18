package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Simple extends Habitacion{

	private static final int NUM_MAXIMO_PERSONAS = 1;
	
	public Simple(int planta, int puerta, double precio) {
		
		//Llamamos al constructor de la clase padre con la palabra super
		super(planta,puerta,precio);
	}
	
	public Simple(Simple habitacionSimple) {
		//Llamamos al constructor de copia de la clase padre
		//No se añade la condición que comprueba si el objeto del parametro es null
		//porque será el constructor de copia de la clase padre el que realizará esa 
		//comprobación
		super(habitacionSimple);
	}
	
	//Se indica la anotacion @Override porque estamos sobrescribiendo el método abstracto
	@Override
	public int getNumeroMaximoPersonas() {
		return NUM_MAXIMO_PERSONAS;
	}
	
	@Override
	public String toString() {
		//Devolver el mismo toString que el de la clase Habitacion
		//Si no se implementa, recoge el toString de la clase padre (Habitacion)
		return super.toString() + ", habitaci�n simple, capacidad=" + NUM_MAXIMO_PERSONAS + " personas"; 
	}
}
