package org.iesalandalus.programacion.reservashotel.modelo.negocio;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;


public class Habitaciones {
	
	private static ArrayList<Habitacion> coleccionHabitaciones;

	
	public Habitaciones() {
		coleccionHabitaciones=new ArrayList<Habitacion>();
	}
	

	public ArrayList<Habitacion> get() {
		ArrayList<Habitacion> copia=copiaProfundaHabitaciones();
		return copia;
	}
	
	
	private ArrayList<Habitacion> copiaProfundaHabitaciones() {
		ArrayList<Habitacion> copiahabitaciones=new ArrayList<Habitacion>();
		
		for (int i=0;i<coleccionHabitaciones.size();i++) {
			copiahabitaciones.add(new Habitacion(coleccionHabitaciones.get(i)));
		}
		
		return copiahabitaciones;
	}

	
	public ArrayList<Habitacion> get (TipoHabitacion tipoHabitacion) {
		
		if(tipoHabitacion!=null) {
			ArrayList<Habitacion> nuevoArray= new ArrayList<Habitacion>();

			for (int i=0;i<coleccionHabitaciones.size();i++) {
				if(coleccionHabitaciones.get(i).getTipoHabitacion().equals(tipoHabitacion)) {
					nuevoArray.add(coleccionHabitaciones.get(i));
				}
			
			}return nuevoArray;
		}else {throw new  NullPointerException("ERROR: No se puede insertar un tipo de habitacion nulo");}
	}
	
	
	public int getTamano() {
		return coleccionHabitaciones.size();
	}

	public void insertar (Habitacion habitacion) throws OperationNotSupportedException {
		boolean encontrado=false;
		
		if(habitacion!=null) {
			for (int i=0;i<coleccionHabitaciones.size();i++) {
				if(coleccionHabitaciones.get(i).getIdentificador().equals(habitacion.getIdentificador())) {
					encontrado = true;
					throw new OperationNotSupportedException("ERROR: Ya existe una habitación con ese identificador.");
				}
			}
			
			if(encontrado==false){
				coleccionHabitaciones.add(habitacion);
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede insertar una habitación nula.");
		}
	}

	public Habitacion buscar(Habitacion habitacion) {	
		Habitacion buscarHabitacion=null;
		int indice=0;
		
		if(habitacion!=null) {

			if (coleccionHabitaciones.contains(habitacion)) {
				indice=coleccionHabitaciones.indexOf(habitacion);
				buscarHabitacion=coleccionHabitaciones.get(indice);
				return buscarHabitacion;
				}else return null;
		}else {
			throw new NullPointerException("ERROR: No se puede buscar una habitación nula.");}
	}
	
	public void borrar (Habitacion habitacion) throws OperationNotSupportedException {
		boolean encontrado=false;
		
		if(habitacion!=null) {
		int indice=0;
			for (int i=0;i<coleccionHabitaciones.size();i++) {
				if(coleccionHabitaciones.get(i).equals(habitacion)) {
				encontrado=true;indice=i;
				}
			}
				
			if(encontrado==true){
				coleccionHabitaciones.remove(indice);
			}
			else {throw new OperationNotSupportedException("ERROR: No existe ninguna habitación como la indicada.");}	
		
		}else {throw new NullPointerException("ERROR: No se puede borrar una habitación nula.");}
	}
	
	

}


