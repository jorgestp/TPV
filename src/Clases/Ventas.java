package Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import java.util.*;

import Interface.Interface_1;
import Interface.Interface_2;




/**
 * La clase Ventas lleva el control de las posibles ventas de productos en la empresa.
 * 
 * Se encarga de la busqueda de productos para incluirlos en el ticket, crea los tickets, y los almacena en una lista
 * de Tickets
 * 
 * @author Jorge Villalba Ruiz DNI; 47536486V
 * 
 * @since 1/06/2015
 * 
 * @version 1.1
 */


@SuppressWarnings("serial")
public class Ventas implements Serializable, Interface_1, Interface_2  {

	
	private ArrayList<Productos> GenerandoTicket;
	private ArrayList<Productos> ListaProductosInventario;
	private Iterator<Productos> it;
	private Scanner entrada;
	private ArrayList<Tickets> tickets;
	private Iterator<Tickets> it2;
	
	/**
	 * Contructor de Ventas que pide por parametro una variable del tipo Inventario, e inicializa los campos de la clase
	 * 
	 * Al atributo ListaProductosInventario se le pasa la lista de Productos del almacen.
	 * 
	 * Se inicializa la Lista GenerandoTicket, que sirve para almacenar los productos que se venden en un ticket.
	 * 
	 * Se inicializa la lista de Ticket
	 * @see Inventario
	 * @param i
	 */
	
	public Ventas(Inventario i){
		ListaProductosInventario=i.DameListaProductos();
		GenerandoTicket=new ArrayList<Productos>();
		tickets=new ArrayList<Tickets>();
		entrada=new Scanner(System.in);
	}
	
	/**
	 * Busca en la lista un producto por su ID
	 * 
	 * @see HayCoincidenciaID
	 */
	
	public void BusquedaPorId(){//
		
		
		System.out.println("Introduzca ID del producto a vender");
		
		String id=entrada.nextLine();
		
		if(EsNumero(id)){
			
			int idProducto=Integer.parseInt(id);
			
			if(HayCoincidenciaID(idProducto)){
				
			}else{
				System.out.println("El PRODUCTO introducido no se encuentra en el sistema\n");
			}
			
		}else{
			System.out.println("Error al introducir ID. No es posible leer ese dato\n");
		}
	}
	
	/**
	 * Se recorre la lista de Productos para buscar el Id del producto. 
	 * 
	 * 
	 * 
	 * @param idProducto
	 * @return
	 * 
	 * TRUE si encuentra coincidencia
	 * FALSE si no hay coincidencia
	 */
	
	public boolean HayCoincidenciaID(int idProducto){
		
		it=ListaProductosInventario.iterator();
		
		while(it.hasNext()){
			Productos p=it.next();
			int identif=p.DameID();
			
				if(identif==idProducto){
					System.out.println("PRODUCTO ENCONTRADO; " + p.DameNombre());
					
					System.out.println("Introduzca Cantidad");
					String cantidad=entrada.nextLine();
					
					if(EsNumero(cantidad)){
						int cant=Integer.parseInt(cantidad);
						
						if(cant<=p.DameCantidadEnStock()&&cant>0){
							
							p.AñadeCantidadTicket(cant);
						
							
							Actuzlicacion_Almacen(p);
							
							System.out.println("**AÑADIDO**");
							
							GenerandoTicket.add(p);
							return true;
					}else{
						System.out.println("NO HAY CANTIDAD EN STOCK");
					}
							
				}else{
					System.out.println("ERROR; El CANTIDAD debe ser un numero\n");
				}	
				}
					
	}
		return false;
	}
		
	
	/**
	 * Se encarga de actualizar el Stock del almacen, restando la cantidad del stock, con lo que se va a vender.
	 * 
	 * @param p
	 */

	public void Actuzlicacion_Almacen(Productos p){
		
		p.AñadirCantidad(p.DameCantidadEnStock()-p.DameCantidadTicket());
	}
	
	/**
	 * Busca un producto por su nombre y lo introduce en la lista para la venta
	 * 
	 * 
	 */
	
	public void BusquedaPorNombre(){//
		
		System.out.println("Busqueda Por Nombre: ");
		String nombre=entrada.nextLine();
		
		if(CoincidenciaPorNombre(nombre)){
			
		}else{
			
			System.out.println("Error al introducir el NOMBRE. No se encuenta en el sistema\n");
		}
				
			
			
		}
	/**
	 * Recorre la lista de productos para ver si hay coincidencia con alguno
	 * 
	 * @param nombre
	 * @return
	 * 
	 * TRUE si encuentra coincidencia
	 * FALSE si no hay coincidencia
	 */
	
	
	public boolean CoincidenciaPorNombre(String nombre){
		
		
		it=ListaProductosInventario.iterator();
		while(it.hasNext()){
			Productos p=it.next();
			String nom=p.DameNombre();
			if(nombre.equals(nom)){
				System.out.println("PRODUCTO ENCONTRADO: "+ p.DameNombre());
				System.out.println("Introduzca Cantidad");
				String cant=entrada.nextLine();
				if(EsNumero(cant)){
					
					int cantidad=Integer.parseInt(cant);
					
					if(cantidad<p.DameCantidadEnStock()&&cantidad>0){
						
						p.AñadeCantidadTicket(cantidad);
						
						Actuzlicacion_Almacen(p);
						
						System.out.println("***AÑADIDO***");
						
						GenerandoTicket.add(p);
						return true;
						
					}else{
						
						System.out.println("NO HAY STOCK PARA ESTA CANTIDAD");
					
					}
					
				}else{
					
					System.out.println("ERROR; El CANTIDAD debe ser un numero");
				}
			}
		}
		
		return false;
	}
	
	
/**
 * 
 * Crea un nuevo ticket, al que se le pide por pantalla el id del cliente asociado a ese ticket
 * 
 * Ademas, añade el ticket a la lista de tickets
 */

	
	public void CrearTicket(){
		
		System.out.println("ID del Cliente; ");
	
		String id=entrada.nextLine();
		Tickets nuevo=new Tickets();
		nuevo.AñadirIDTicket(id);
		CabeceraTicket();
		CuerpoTicket();
		FinalTicket(nuevo);
		
		tickets.add(nuevo);
		
		
	}
	

	/**
	 * 
	 * Metodo que comprueba que una cadena de entrada contiene solo numeros
	 * 
	 * Devuelve TRUE si contiene solo numeros, o FALSE si contiene almenos algún caracter que no es un número
	 */
	
	public boolean EsNumero(String id){
		
		for(int i=0;i<id.length();i++){
			
			if(!Character.isDigit(id.charAt(i))){
				return false;
			}
		}
		
		return true;

	}
	
	/**
	 * Calcula el precio total de un producto dependiendo de las unidades que se vendan de ese producto
	 * 
	 * @param p
	 * @return
	 * 
	 * El precio total del producto segun las unidades vendidas.
	 */

	
	public float PrecioConIVA(Productos p){
		
		float precio=p.DamePrecioConIVA()*p.DameCantidadTicket();
		
		return precio;
		
	}
		
		
	
	/**
	 * 
	 * Crea la cabezera del ticket, con las columnas ID, PRODUCTOS,CANTIDAD,PRECIO.
	 * 
	 */
	
	
	public void CabeceraTicket(){
		
		System.out.println("-----------------------------------------------------------------");
		String id="ID";
		String prod="PRODUCTOS";
		String cant="CANTIDAD";
		String precio="PRECIO";
		System.out.println(String.format("%2s", id)+String.format("%13s", prod)+
				String.format("%18s", cant)+String.format("%27s",precio));

	}
	
	/**
	 * 
	 * Da formato a los productos que se venden y que luego irá en el ticket
	 * @param t
	 */
	
	public void ProductoVendido(Productos t){
		
		System.out.println();
		System.out.println(String.format("%2s", t.DameID())+String.format("%13s",t.DameNombre())
				+String.format("%20d", t.DameCantidadTicket()) +String.format("%25.2f", PrecioConIVA(t)));
		
		
	}
	
	/**
	 * Recorre la lista de los productos del metodo anterior y los imprime por pantalla
	 * 
	 */
	
	public void CuerpoTicket(){
		it=GenerandoTicket.iterator();
		while(it.hasNext()){
			
			Productos t=it.next();
			
			ProductoVendido(t);
		}
		
	}
	
	/**
	 * Crea el final del Ticket, en que se introduce el precio final del ticket, el ID del cliente y la fecha del ticket
	 * 
	 * @param e
	 */
	public void FinalTicket(Tickets e){
		
		
		System.out.println();
		System.out.println();
		System.out.println("                                 " +"TOTAL:                "
		+ String.format("%.2f",TotalTicktes()));
		System.out.println();
		System.out.println("CLIENTE: " +e.DameIDTicket() + "  FECHA; " + e.DameFecha());
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("                   GRACIAS POR SU VISITA                         ");
		
		
		
		
		
	}
	
	/**
	 * Recorre la lista GenerandoTicket y calculael valor total de los productos de esa lista
	 * 
	 * @return
	 */
	
	public float TotalTicktes(){
		float totalTicket=0;
		it=GenerandoTicket.iterator();
		while(it.hasNext()){
			
			Productos p=it.next();
			
			totalTicket += PrecioConIVA(p);
		}
		
		
		return totalTicket;
	}
	
	/**
	 * Imprime la lista de los tickets
	 * 
	 */
	
	public void ListaTickets(){
		it2=tickets.iterator();
		while(it2.hasNext()){
			Tickets t=it2.next();
			
			System.out.println("Cliente; "+ t.DameIDTicket()+ ". Fecha; " + t.DameFecha());
			
		}
	}
	
	public ArrayList<Tickets> DameListaTicket(){
		
		return tickets;
	}
	
	public ArrayList<Productos> ListaProductosVendidos(){
		
		return GenerandoTicket;
	}
	
	/**
	 * 
	 * Guarda en un archivo archivoTicket.bin, una lista de ticket creados
	 */
	
	public void Guardar(){
		
		try{
			File fichero=new File("archivoTicket.bin");
			FileOutputStream fout =
			new FileOutputStream(fichero);
			ObjectOutputStream oos =
			new ObjectOutputStream(fout);
			oos.writeObject(tickets);
			oos.close();
			System.out.println("ARCHIVO GUARDADO CON ÉXITO");

			}
			catch(IOException e){
			System.out.println("Error en la escritura.");
			}
	}
	

	/**
	 * 
	 * Carga al programa una lista de tickets guardados con anterioriadad
	 * 
	 * El archivo debe ser con el nombre archivoTicket.bin
	 */
	
	@SuppressWarnings("unchecked")
	public void Cargar(){
		
		try{
			
			File fichero=new File("archivoTicket.bin");
			FileInputStream fin=
			new FileInputStream(fichero);
			ObjectInputStream ois =
			new ObjectInputStream(fin);
			tickets =(ArrayList<Tickets>)ois.readObject();
			ois.close();
			System.out.println("ARCHIVO CARGADO CON ÉXITO");
			}
			catch(Exception e){
			System.out.println("Error en la lectura.");
			}
	}
}
