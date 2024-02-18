package org.iesalandalus.programacion.reservashotel.vista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Regimen;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	private Consola() {

	}
	
	public static void mostrarMenu() {
		
	      System.out.println("--------------------------------------------------------------------------------------");
	      System.out.println("Opciones: ");
	      System.out.println("--------------------------------------------------------------------------------------");
	      System.out.println("");
	      for (int i = 0; i < Opcion.values().length; i++) {
	        	System.out.println(Opcion.values()[i].toString());
	       }
		
	}
	
	public static Opcion elegirOpcion() {
		int opciones;
		Opcion opcionElegida=Opcion.CONSULTAR_DISPONIBILIDAD;
		
		do {
			System.out.println("Introduzca la opcion a elegir");
			opciones=Entrada.entero();
		}while (opciones<0 || opciones>=Opcion.values().length);
		
		
		switch (opciones)
		
		{
			case 1:
				opcionElegida=Opcion.INSERTAR_HUESPED;
				break;
			case 2:
				opcionElegida=Opcion.BUSCAR_HUESPED;
				break;
			case 3:
				opcionElegida=Opcion.BORRAR_HUESPED;
				break;
			case 4:
				opcionElegida=Opcion.MOSTRAR_HUESPEDES;
				break;
			case 5:
				opcionElegida=Opcion.INSERTAR_HABITACION;
				break;
			case 6:
				opcionElegida=Opcion.BUSCAR_HABITACION;
				break;
			case 7:
				opcionElegida=Opcion.BORRAR_HABITACION;
				break;
			case 8:
				opcionElegida=Opcion.MOSTRAR_HABITACIONES;
				break;
			case 9:
				opcionElegida=Opcion.INSERTAR_RESERVA;
				break;
			case 10:
				opcionElegida=Opcion.ANULAR_RESERVA;
				break;
			case 11:
				opcionElegida=Opcion.MOSTRAR_RESERVAS;
				break;
			case 12:
				opcionElegida=Opcion.CONSULTAR_DISPONIBILIDAD;
				break;
			case 13:
				opcionElegida=Opcion.REALIZAR_CHECKIN;
				break;
			case 14:
				opcionElegida=Opcion.REALIZAR_CHECKOUT;
				break;
			case 0:
				opcionElegida=Opcion.SALIR;
				break;
				
		}
		
		return opcionElegida;	
	}
	
	public static Huesped leerHuesped() {
		
		
		try {
			System.out.println("Introduce un nombre: ");
			String nombre=Entrada.cadena();
			System.out.println("Introduce un dni: ");
			String dni=Entrada.cadena();
			System.out.println("Introduce un correo: ");
			String correo=Entrada.cadena();
			System.out.println("Introduce un telefono: ");
			String telefono=Entrada.cadena();
			System.out.println("Introduce una fecha nacimiento: ");
			LocalDate fechaNacimiento=leerFecha(Entrada.cadena());

			Huesped huesped=new Huesped( nombre, dni, correo, telefono, fechaNacimiento);
			return huesped;
			}
			catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return null;
			}
			catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
			}

	}
	
	public static Huesped getHuespedPorDni()  {
		try {
			System.out.println("Introduce un dni: ");
			String dni=Entrada.cadena();
			Huesped huesped=new Huesped( "Tesifon Linares", dni, "Tesi@gmail.com", "950112233", LocalDate.of(2002, 9, 15));
			return huesped;
			}
			catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			return null;
			}
			catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
			}
	}


	public static LocalDate leerFecha(String mensaje ) {
        String pattern = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
           
            LocalDate fechaLocalDate = LocalDate.parse(mensaje, formatter);
            return fechaLocalDate;
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	
	public static Habitacion leerHabitacion( ) {
	
			try {
			System.out.println("Introduce un planta: ");
			int planta=Entrada.entero();
			System.out.println("Introduce un puerta: ");
			int puerta=Entrada.entero();
			System.out.println("Introduce un precio: ");
			double precio=Entrada.real();
			String identificador=String.valueOf(planta)+String.valueOf(puerta);
			System.out.println("Introduce una  tipo de habitacion: ");
			TipoHabitacion tipoHabitacion=leerTipoHabitacion();

			Habitacion habitacion=new Habitacion( planta,puerta,precio,identificador,tipoHabitacion);
			return habitacion;
			}
			catch(NullPointerException e) {
				System.out.println(e.getMessage());
				return null;
        }
		
	}
	
	public static Habitacion leerHabitacionPorIdentificador() {
		
		try {
		System.out.println("Introduce un planta: ");
		int planta=Entrada.entero();
		System.out.println("Introduce un puerta: ");
		int puerta=Entrada.entero();
		
		Habitacion habitacion=new Habitacion( planta, puerta, 50, TipoHabitacion.DOBLE);
		return habitacion;
		}
		catch(IllegalArgumentException e){
		System.out.println(e.getMessage());
		return null;
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		return null;
		}
	}
	
	public static TipoHabitacion leerTipoHabitacion() {
		int eleccion=0;
		TipoHabitacion tipoHabitacionElegida=null;
		
		System.out.println("Introduce una numero para elegir el tipo de habitacion: ");
		System.out.println("1-SIMPLE, 2-DOBLE, 3-TRIPLE, 4-SUITE");
		eleccion = Entrada.entero();
		
		switch (eleccion)
		
		{
			case 1:
				tipoHabitacionElegida=TipoHabitacion.SIMPLE;
				break;
			case 2:
				tipoHabitacionElegida=TipoHabitacion.DOBLE;
				break;
			case 3:
				tipoHabitacionElegida=TipoHabitacion.TRIPLE;
				break;
			case 4:
				tipoHabitacionElegida=TipoHabitacion.SUITE;
				break;
		}
		
		return tipoHabitacionElegida;
	}
	
	public static Regimen leerRegimen() {
		int eleccion=0;
		Regimen RegimenElegido=null;
		
		System.out.println("Introduce una numero para elegir el tipo de regimen: ");
		System.out.println("1-SOLO ALOJAMIENTO, 2-ALOJAMIENTO Y DESAYUNO, 3-MEDIA PENSION, 4-PENSION COMPLETA");
		eleccion = Entrada.entero();
	
		switch (eleccion)
		{
			case 1:
				RegimenElegido=Regimen.SOLO_ALOJAMIENTO;
				break;
			case 2:
				RegimenElegido=Regimen.ALOJAMIENTO_DESAYUNO;
				break;
			case 3:
				RegimenElegido=Regimen.MEDIA_PENSION;
				break;
			case 4:
				RegimenElegido=Regimen.PENSION_COMPLETA;
				break;
		}
		
		return RegimenElegido;
	}
	
	
	public static Reserva leerReserva() {
		
		try {
			Huesped huesped=new Huesped(leerHuesped());
			Habitacion habitacion=new Habitacion(leerHabitacion());
			Regimen regimen=leerRegimen();
			System.out.println("Introduce una fecha de inicio de reserva");
			String fechaInicio=Entrada.cadena();
			LocalDate fechaInicioReserva=leerFecha(fechaInicio);
			System.out.println("Introduce una fecha de fin de reserva");
			String fechaFin=Entrada.cadena();
			LocalDate fechaFinReserva=leerFecha(fechaFin);
			System.out.println("Introduce el numero de personas");
			int numeroPersonas=Entrada.entero();

			

		Reserva reserva=new Reserva( huesped,habitacion, regimen,fechaInicioReserva,fechaFinReserva,numeroPersonas);
		return reserva;
		}
		catch(IllegalArgumentException e){
		System.out.println(e.getMessage());
		return null;
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		return null;
		}
	}
	
}
