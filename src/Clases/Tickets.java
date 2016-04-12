package Clases;
import java.io.Serializable;
import java.util.*;

/**
 * Clase que le da a los tickets una fecha determinada por la hora local del sistema, y un numero
 * de identificacion del cliente al que se asocia el ticket
 * 
 * 
 * @author Jorge Villalba Ruiz DNI; 47536486V
 * 
 * @since 1/06/2015
 * 
 * @version 1.1
 *
 */

@SuppressWarnings("serial")
class Tickets implements Serializable {
	
	private Date fecha;
	String idcliente;
	
	/**
	 * Constructor de la clase Tickets que se encarga de almacenar en el campo "fecha", la hora local del sistema
	 * 
	 */
	

	public Tickets(){
		
		GregorianCalendar fecha_ticket=new GregorianCalendar();
		
		fecha=fecha_ticket.getTime();
		
		
	}
	
	/**
	 * Metodo que añade un ID al ticket. El ID debe ser una cadena de caracteres
	 * 
	 * @param id
	 */
	
	public void AñadirIDTicket(String id){
		
		idcliente=id;
	}
	
	
	/**
	 * Metodo consultor que se encarga de devolver el id del ticket
	 * 
	 * @return
	 * 
	 *Devuelve el ID del ticket
	 */
	public String DameIDTicket(){
		
		return idcliente;
		
	}
	
	/**
	 * Metodo que se encarga de dar la hora de emision del ticket.
	 * 
	 * @return
	 */
	
	public Date DameFecha(){
		
		return fecha;
	}
	
	
}
