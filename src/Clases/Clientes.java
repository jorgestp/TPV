package Clases;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;



/**
 * Clase que lleva el control de los atributos o campos de los clientes; nombre, domicilio...
 * 
 * @author Jorge Villalba Ruiz DNI; 47536486V
 * 
 * @since 1/06/2015
 * 
 * @version 1.1
 * 
 *
 */


@SuppressWarnings("serial")
public class Clientes implements Serializable {

	
	private String nombre, apellidos, razonSocial,domicilio, idCliente;
	Date fechaAlta;
	private int cif;
	
	
	/**
	 * 
	 * Constructor que almacena en la variable "fechaAlta" la hora local del sistema para 
	 *saber cuándo se dió de alta un cliente en concreto .
	 *
	 * 
	 */
	
	public Clientes(){
		
		GregorianCalendar fecha=new GregorianCalendar();
		
		fechaAlta=fecha.getTime();
		
	}
	
	/**
	 * Metoro que devuelve el ID del cliente.
	 * 
	 * @return
	 * 
	 * Devuelve el ID del cliente.
	 */
	
	public String DameIDCliente(){
		
		return idCliente;
	}
	
	
	
	/**
	 * Motoro que devuelve el CIF o NIE del cliente.
	 * 
	 * @return
	 * Devuelve el CIF o NIE del cliente.
	 */
	
	
	public int DameCIF(){
		
		return cif;
	}
	
	
	/**
	 * Devuelve el nombre del cliente.
	 * 
	 * @return
	 */
	
	public String DameNombre(){
		
		return nombre;
	}
	
	/**
	 * 
	 * Devuelve el o los apellidos del cliente.
	 * 
	 * @return
	 */
	
	public String DameApellidos(){
		
		return apellidos;
	}
	
	
	/**
	 * Devuelve la razon social del cliente.
	 * 
	 * @return
	 */
	
	
	public String DameRazonSocial(){
		
		return razonSocial;
	}
	
	
	/**
	 * Devuelve el domicilio del cliente.
	 * 
	 * @return
	 */
	public String DAmeDomicilio(){
		
		return domicilio;
	}
	
	/**
	 * 
	 * Devuelve la fecha con la que ha sido de dado de alta
	 * 
	 * @return
	 */
	public Date FechaAlta(){
		
		return fechaAlta;
	}
	
	
	
	/**
	 * Se le pasa el valor de una variable String al nombre del cliente.
	 * 
	 * @param nombre
	 */
	
	public void IntroducirNombre(String nombre){
		
		this.nombre=nombre;
	}
	
	/**
	 * Almacena en la variable apellidos el valor pasado por el parametro String.
	 * 
	 * 
	 * @param apellidos
	 */
	
	public void IntorducirApellidos(String apellidos){
		
		this.apellidos=apellidos;
	}
	
	
	/**
	 * Almacena en la variable de la razon social el String que se le pasa por parámetro.
	 * 
	 * @param razonsocial
	 */
	
	public void IntroducirRazonSocial(String razonsocial){
		
		razonSocial=razonsocial;
	}
	
	
	/**
	 * Almacena en el domicilio el valor que se le pasa por el tipo String
	 * 
	 * @param domicilio
	 */
	
	public void IntroducirDomicilio(String domicilio){
		
		this.domicilio=domicilio;
	}
	
	/**
	 * Almacena en el campo cif el valor de CIF o NIE del cliente mediante un String
	 * 
	 * @param cif
	 */
	
	public void IntroducirCIF(int cif){
		
		 this.cif=cif;
	}
	
	
	/**
	 * Almacena en la variable idcliente la String que se le pasa por parámetro.
	 * 
	 * 
	 * @param idcliente
	 */
	public void Introducir_IDCliente(String idcliente){
		
		idCliente=idcliente;
	}
}
