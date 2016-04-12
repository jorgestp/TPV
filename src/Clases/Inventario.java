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
 * LLeva a cabo la gestión del almacen.
 * 
 * Se encarga de añadir productos al almacen. Tambien puede modificar productos y eliminarlos del almacen
 * Implementa las interfaces Serializable e Interface_1
 * 
 * @author Jorge Villalba Ruiz DNI; 47536486V
 * 
 * @since 01/06/2015
 * 
 * @version 1.1
 * 
 * @see Productos
 */

@SuppressWarnings("serial")
public class Inventario implements Serializable, Interface_1, Interface_2 { 
	
	private ArrayList<Productos> ListaProducto;
	
	private Iterator<Productos> it;
	
	private Scanner entrada;
	
	/**
	 * Constructor de la clase Inventario que crea una lista de objetos de tipo Productos.
	 * 
	 */
	
	public Inventario(){
		
		ListaProducto=new ArrayList<Productos>();
		entrada=new Scanner(System.in);
	}
	
	/**
	 * 
	 * Motodo que permite añadir al principio de la lista, un producto.
	 * 
	 * Añade al producto el Nombre, precio unitario, cantidad y Numero de Identificacion. El sistema pide
	 * al usuario que introduza dichos datos de los productos. utliza la clase;
	 * @see EsNumero
	 * 
	 */

	public void AltaProductos(){
		boolean fuerabucle=false;
		Productos nuevo=new Productos();
		
		

		System.out.println("Introduce Nombre o Descripcion del producto");
		
		String nombre=entrada.nextLine();

		nuevo.AñadirNombre(nombre);
		
		System.out.println("Introduce Precio UNITARIO SIN IVA del producto");
		
		String nuevoP=entrada.nextLine();
		
		float nuevoprecio=Float.parseFloat(nuevoP);
			
		nuevo.AñadirPrecioSinIVA(nuevoprecio);
		
		nuevo.AñadirPrecioConIVA(nuevoprecio);

		System.out.println("Introduce Cantidad de Productos en el Almacen");
		
		String cant=entrada.nextLine();
		
		do{
				
		if(EsNumero(cant) && !cant.contains(".")){
			
			
			int cantidad=Integer.parseInt(cant);
			nuevo.AñadirCantidad(cantidad);
			fuerabucle=true;
			
		}else{
			System.out.println("Ha introducido un decimal o una letra. Introduzca numero ENTERO de cantidad de Producto");
			
		}
		}while(!fuerabucle);
		
		System.out.println("Introduce Numero de Identificacion del Producto");
		String ident=entrada.nextLine();
		int identificacion=Integer.parseInt(ident);
		
		nuevo.AñadirID(identificacion);
		
		System.out.println("***PRODUCTO AÑADIDO AL ALMACEN***");
		System.out.println();
		ListaProducto.add(nuevo);
		
	}
	
	/**
	 * Comprueba que el dato String se trata de digitos o si contiene alguna letra
	 * 
	 * @param cant
	 * @return Devuelve true si la cadena es solo de numero, o falso si no contiene unicamente numeros.
	 */
	
	public boolean EsNumero(String cant){
		
		for(int i=0;i<cant.length();i++){
			
			if(!Character.isDigit(cant.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Genera un mensaje en consola con un listado de los productos que se tiene en el almacen y sus respectivos campos.
	 *  
	 */
	
	public void ListadoEnAlmacen(){
		
		it=ListaProducto.iterator();
		
		
			
		
		
		while(it.hasNext()){
			Productos a=it.next();

			System.out.print(" #ID: " + a.DameID()+ " #PROD: " + a.DameNombre() + " #CANTIDAD: " 
			+ a.DameCantidadEnStock() + "  #PRECIO CON IVA: ");
			System.out.printf("%.2f", a.DamePrecioConIVA());
			System.out.println();
		}
		
	}
	
	/**
	 * Se pide por pantalla un producto a borrar, recorre la lista de productos, y si lo encuentra lo borra.
	 */
	
	public void BajaProducto(){
		
		it=ListaProducto.iterator();
		System.out.println("Introduce el producto para borrar");
		
		String descripcion=entrada.nextLine();
		
		
		
		while(it.hasNext()){
			Productos t=it.next();
			String producto= t.DameNombre();
			
			if(descripcion.equals(producto)){
				System.out.println("¿Estas seguro de borrar ese articulo?");
				System.out.println("[1]- SI");
				System.out.println("[2]- NO");
				String respuesta=entrada.nextLine();
				if(respuesta.equals("1")){
					
				it.remove();
				System.out.println("***PRODUCTO; " + t.DameNombre() + " , BORRADO CON ÉXITO");
				break;
				
				}else{
					System.out.println("Producto NO BORRADO");
				}
	
			}
		}		
	}
	
	/**
	 * Se pide un producto para modificar. Si encuentra el producto en la lista, se le pide los nuevos campos
	 * para modificarlos, sustituyendo la original
	 * 
	 */
	
	public void ModificarProducto(){
		
		System.out.println("Introduce el producto a buscar");
		
		String descripcion=entrada.nextLine();
		
		 it=ListaProducto.iterator();
		
		 
		 while (it.hasNext()){
			Productos t=it.next();
			String ProdAMod=t.DameNombre();
			
			if(descripcion.equals(ProdAMod)){
				System.out.println("Introduce nuevo Nombre al producto");
				String nuevonombre=entrada.nextLine();
				t.AñadirNombre(nuevonombre);
					
				System.out.println("Introduce nuevo precio");
				 String precio=entrada.nextLine();
				 
				float nuevoprecio=Float.parseFloat(precio);
				
				t.AñadirPrecioSinIVA(nuevoprecio);
				t.AñadirPrecioConIVA(nuevoprecio);
				
				System.out.println("Introduce nueva Cantidad en almacen");
				
				String cant=entrada.nextLine();
				
				if(EsNumero(cant)){
					int cantidad=Integer.parseInt(cant);
					t.AñadirCantidad(cantidad);
					System.out.println("PRODUCTO MODIFICADO CON ÉXITO");
					break;
				}
					

			   
			}
				
			
		}
		
	}
	
	
	
	/**
	 * Metodo que devuelve el tamaño de la lista de productos.
	 * 
	 * @return cantidad de productos en la lista.
	 */
	
	public int CantidadProductos(){
		int cantidad;
		
		cantidad=ListaProducto.size();
		
		return cantidad;
	}
	
	
	/**
	 * Metodo que devuelve la lista en sí de productos que hay en el almacen
	 * 
	 * @return Devuelve la lista de productos; ListaProducto
	 */
	
	
	public ArrayList<Productos> DameListaProductos(){
		
		return ListaProducto;
	}
	
	/**
	 * 
	 * Metodo que guarda en un archivo "archivo.bin" la lista de productos del almacen
	 */
	
	public void Guardar(){
		
		try{
			File fichero=new File("archivo.bin");
			FileOutputStream fout =
			new FileOutputStream(fichero);
			ObjectOutputStream oos =
			new ObjectOutputStream(fout);
			oos.writeObject(ListaProducto);
			oos.close();
			System.out.println("ARCHIVO GUARDADO CON ÉXITO");
			}
			catch(IOException e){
			System.out.println("Error en la escritura.");
			}
	}
	
	/**
	 * 
	 * Metodo que carga una lista de productos guardada en disco, en un fichero con nombre archivo.bin
	 */
	
	
	@SuppressWarnings("unchecked")
	public void Cargar(){
		
		try{
			
			File fichero=new File("archivo.bin");
			FileInputStream fin=
			new FileInputStream(fichero);
			ObjectInputStream ois =
			new ObjectInputStream(fin);
			ListaProducto =(ArrayList<Productos>)ois.readObject();
			ois.close();
			System.out.println("ARCHIVO CARGADO CON ÉXITO");
			}
			catch(Exception e){
			System.out.println("Error en la lectura.");
			}
	}
	
}
