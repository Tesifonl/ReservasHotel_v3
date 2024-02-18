package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public enum TipoHabitacion {
	SUITE ("Suite"), SIMPLE ("Single"), DOBLE("Doble"), TRIPLE("Triple");
	
	private String cadenaAMostrar;

	private TipoHabitacion(String cadenaAMostrar) {
		this.cadenaAMostrar=cadenaAMostrar;
	}
	
    @Override
    public String toString() {
        return (this.ordinal() + 1) + ".-" + cadenaAMostrar;
    }
}
