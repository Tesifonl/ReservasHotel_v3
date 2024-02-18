package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Suite extends Habitacion {

	//Constantes
	private static final int NUM_MAXIMO_PERSONAS = 4;
	public static final int MIN_NUM_BANOS = 0;
	public static final int MAX_NUM_BANOS = 1;
	
	//Atributos
	public int numBanos;
	public boolean tieneJacuzzi;
	
	//Contructor
	public Suite(int planta, int puerta, double precio, int numBanos, boolean tieneJacuzzi) {
		//Llamamos al constructor de la clase padre para la planta, puerta y precio
		super(planta, puerta, precio);
		
		//Los otros dos atributos de la propia clase se asignan con los setters
		setNumBanos(numBanos);
		setTieneJacuzzi(tieneJacuzzi);
	}
	
	public Suite(Suite habitacionSuite) {
		//Llamamos al constructor de copia de la clase padre
		super(habitacionSuite);
		
		//Si el constructor de copia de la clase padre no lanza la excepcion por
		//objeto null, asignamos los datos a los atributos que faltan
		//Los otros dos atributos de la propia clase se asignan con los setters
		setNumBanos(habitacionSuite.numBanos);
		setTieneJacuzzi(habitacionSuite.tieneJacuzzi);
	}
	
	public int getNumBanos() {
		return numBanos;
	}
	
	public void setNumBanos(int numBanos) {
		if (numBanos < MIN_NUM_BANOS || numBanos > MAX_NUM_BANOS) {
			throw new IllegalArgumentException("ERROR: El n�mero de ba�os no puede ser inferior a " + MIN_NUM_BANOS +" ni superior a " + MAX_NUM_BANOS);
		}
		
		this.numBanos = numBanos;
	}
	
	public boolean isTieneJacuzzi() {
		return tieneJacuzzi;
	}
	
	public void setTieneJacuzzi(boolean tieneJacuzzi) {
		this.tieneJacuzzi = tieneJacuzzi;
	}
	
	@Override
	public int getNumeroMaximoPersonas() {
		return NUM_MAXIMO_PERSONAS;
	}
	
	@Override
	public String toString() {
		
		//Mismo toString que el de la clase Habitacion
		//Si no se implementa, recoge el toString de la clase padre (Habitacion)
		String texto = super.toString() + ", capacidad= " + NUM_MAXIMO_PERSONAS + " personas" +
				"ba�os= " + numBanos;
		
		if (tieneJacuzzi) {
			texto = texto + ", con Jacuzzi";
		}
		else {
			texto = texto + ", sin Jacuzzi";
		}
		
		return texto;
	}

}
