package Clases;


import java.io.Serializable;



/**
 * Lleva el control de las carateristicas del producto; Descripcion o Nombre, precio sin IVA, con IVA, identificacion
 * y el IVA aplicable en este momento a los productos
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
class Productos implements Serializable {
	
	private String descripcion;
	private float precioSinIVA;
	public static final int IVA=21;
	private float precioConIVA;
	private int cantidad;
	private int Id;
	private int cantidadEnTicket;
	
	/**
	 * Constructor que le asigna a un producto unas caracteristicas pasadas por parametro
	 * 
	 * @param nombre
	 * @param precioSinIVA
	 * @param cantidad
	 * @param Id
	 */
	
	public Productos (String nombre, float precioSinIVA, int cantidad, int Id){
		
		descripcion=nombre;
		this.precioSinIVA=precioSinIVA;
		precioConIVA=precioSinIVA+precioSinIVA*21/100;
		this.cantidad=cantidad;
		this.Id=Id;
	}
	
	/**
	 * Constructor por defecto de la clase Productos que inicializa los atributos de la clase a valores por defecto.
	 * 
	 */
	
	public Productos(){
		descripcion="";
		precioSinIVA=0;
		precioConIVA=0;
		cantidad=0;
		Id=0;
		cantidadEnTicket=0;
	}
	
	/**
	 * Metodo que se encarga de devolver el nombre o descripcion del producto.
	 * 
	 * @return descripcion
	 */
	
	
	public String DameNombre (){
		
		 
		return descripcion;
	}
	
	/**
	 * Método que devuelve el Identificador del producto
	 * 
	 * 
	 * @return Id
	 */
	
	public int DameID(){
		
		return Id;
	}
	
	/**
	 * Metodo que devuelve la cantidad del productos que hay en Stock
	 * 
	 * @return cantidad
	 */
	
	public int DameCantidadEnStock(){
		
		return cantidad;
	}
	
	/**
	 * Devuelve el Precio unitario del producto, es decir, no tiene el IVA aplicado.
	 * 
	 * 
	 * @return precioSinIVA
	 */
	
	public float DamePrecioSinIVA(){
		
		return precioSinIVA;
	}
	
	
	/**
	 * Devuelve el precio del producto con el IVA ya aplicado.
	 * @return precioConIVA
	 * 
	 */
	
	public float DamePrecioConIVA(){
		
		return precioConIVA;
	}
	
	
	/**
	 * Asigna al producto un nombre o una descripcion del mismo.
	 * 
	 * 
	 * @param descripcion
	 */

	
	public void AñadirNombre (String descripcion){
		
		 
		 this.descripcion=descripcion;
	}
	
	/**
	 * Añade el identificador del producto. Dicho identificador debe ser un numero
	 * 
	 * @param identificacion
	 */
	
	public void AñadirID(int identificacion){
		
		 Id=identificacion;
	}
	
	/**
	 * Añade la cantidad de productos que hay en el almacen.
	 * 
	 * @param cantidad
	 */
	
	public void AñadirCantidad(int cantidad){
		
		 this.cantidad=cantidad;
	}
	
	/**
	 * Asigna un precio unitario sin IVA aplicable
	 * 
	 * @param NuevoPrecio
	 */
	
	public void AñadirPrecioSinIVA(float NuevoPrecio){
		
		 precioSinIVA=NuevoPrecio;
	}
	
	
	/**
	 * Calcula el precio del producto con el IVA ya aplicado
	 * 
	 * @param NuevoPrecio
	 */
	
	public void AñadirPrecioConIVA(float NuevoPrecio){
		
	 precioConIVA=NuevoPrecio+(NuevoPrecio*0.21F);
	}
	
	/**
	 * Metodo que añade una cantidad de productos en el ticket de compra
	 * 
	 * @param cant
	 */

	
	public void AñadeCantidadTicket(int cant){
		cantidadEnTicket=cant;
	}
	
	/**
	 * Metodo que devuelve la cantidad de productos en el ticket
	 * 
	 * @return cantidadEnTicket
	 */
	
	public int DameCantidadTicket(){
		
		return cantidadEnTicket;
	}
	

	
}
