package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Triple extends Habitacion {

	//Constantes
	private static final int NUM_MAXIMO_PERSONAS = 3;
	public static final int MIN_NUM_BANOS = 0;
	public static final int MAX_NUM_BANOS = 1;
	public static final int MIN_NUM_CAMAS_INDIVIDUALES = 0;
	public static final int MAX_NUM_CAMAS_INDIVIDUALES = 3;
	public static final int MIN_NUM_CAMAS_DOBLES = 0;
	public static final int MAX_NUM_CAMAS_DOBLES = 1;
	
	//Atributos
	private int numBanos;
	private int numCamasIndividuales;
	private int numCamasDobles;
	
	//Constructor
	public Triple(int planta, int puerta, double precio, int numBanos, int numCamasIndividuales, int numCamasDobles) {
		//Llamamos al constructor de la clase padre para la planta, puerta y precio
		super(planta, puerta, precio);
		
		//Los otros dos atributos de la propia clase se asignan con los setters
		setNumBanos(numBanos);
		setNumCamasIndividuales(numCamasIndividuales);
		setNumCamasDobles(numCamasDobles);
	}
	
	public Triple(Triple habitacionTriple) {
		//Llamamos al constructor de copia de la clase padre
		super(habitacionTriple);
		
		//Si el constructor de copia de la clase padre no lanza la excepcion por
		//objeto null, asignamos los datos a los atributos que faltan
		setNumBanos(habitacionTriple.numBanos);
		setNumCamasIndividuales(habitacionTriple.numCamasIndividuales);
		setNumCamasDobles(habitacionTriple.numCamasDobles);
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
	public int getNumCamasIndividuales() {
		return numCamasIndividuales;
	}
	
	public void setNumCamasIndividuales(int numCamasIndividuales) {
		this.numCamasIndividuales = numCamasIndividuales;
		//Valido el numero de camas
		validaNumCamas();
	}
	
	public int getNumCamasDobles() {
		return numCamasDobles;
	}
	
	public void setNumCamasDobles(int numCamasDobles) {
		this.numCamasDobles = numCamasDobles;
		validaNumCamas();
	}
	
	public void validaNumCamas() {
		if (this.numCamasIndividuales < MIN_NUM_CAMAS_INDIVIDUALES || 
			this.numCamasIndividuales > MAX_NUM_CAMAS_INDIVIDUALES) {
			throw new IllegalArgumentException("ERROR: El n�mero de camas individuales de una habitaci�n triple no puede ser inferior a" + MIN_NUM_CAMAS_INDIVIDUALES + " ni mayor que " + MAX_NUM_CAMAS_INDIVIDUALES);
		}
		
		if (this.numCamasDobles < MIN_NUM_CAMAS_DOBLES || 
				this.numCamasIndividuales > MAX_NUM_CAMAS_DOBLES) {
				throw new IllegalArgumentException("ERROR: El n�mero de camas dobles de una habitaci�n triple no puede ser inferior a" + MIN_NUM_CAMAS_DOBLES + " ni mayor que " + MAX_NUM_CAMAS_DOBLES);
			}
		
		if (this.numCamasDobles == MAX_NUM_CAMAS_DOBLES &&
			this.numCamasIndividuales > MAX_NUM_CAMAS_INDIVIDUALES - 1) {
				throw new IllegalArgumentException("ERROR: El n�mero de camas de la habitaci�n no es el correcto.");
		}
		
		if (this.numCamasIndividuales == MAX_NUM_CAMAS_INDIVIDUALES &&
			this.numCamasDobles > MIN_NUM_CAMAS_DOBLES) {
				throw new IllegalArgumentException("ERROR: El n�mero de camas de la habitaci�n no es el correcto.");
		}
	}
	
	@Override
	public int getNumeroMaximoPersonas() {
		return NUM_MAXIMO_PERSONAS;
	}
	
	@Override
	public String toString() {
		//Devolver el mismo toString que el de la clase Habitacion
		//Si no se implementa, recoge el toString de la clase padre (Habitacion)
		return super.toString() + ", capacidad= " + NUM_MAXIMO_PERSONAS + " personas" +
			"ba�os= " + numBanos + ",camas individuales= " + numCamasIndividuales + ", camas dobles= " + numCamasDobles; 
	}
}