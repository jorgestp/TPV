package Clases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import Interface.Interface_2;

/**
 * Esta clase es la encargada de llevar a cabo el control de los clientes, dandoles de alta,
 * modificarlos o borrarlos.
 * Ademas lleva el control de las facturas emitidas para un determinado cliente
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
public class Facturacion implements Serializable, Interface_2 {
	
	
	private ArrayList<Clientes> ListaClientes;
	private Iterator<Clientes> it;
	private Iterator<Productos> it2;
	private Iterator<Tickets> it3;
	private ArrayList<Tickets> ListaTicket;
	private ArrayList<Clientes> factura;
	private ArrayList<Productos> productosvendidos;
	private Scanner entrada;
	private Date fecha;

	/**
	 * Contructos que se le pasa por parametro una variable de tipo Ventas.
	 * Se encagra de inicizializar la lista dinamica de clientes con el nombre de ListaClientes
	 * Inicializa la variable ListaTicket con una copia de la lista de los Ticket de la clase Ventas.
	 * También iniciliza la lista productosvendidos con la lista de productos vendidos de la clase Ventas.
	 * 
	 * @param v
	 */
	public Facturacion(Ventas v){
		
		ListaClientes=new ArrayList<Clientes>();
		ListaTicket=v.DameListaTicket();
		productosvendidos=v.ListaProductosVendidos();
		factura=new ArrayList<Clientes>();
		entrada=new Scanner (System.in);
		GregorianCalendar fecha_ticket=new GregorianCalendar();
		
		fecha=fecha_ticket.getTime();
	}
	
	/**
	 * Metodo que se encarga de añadir un cliente a la lista de clientes
	 */
	
	public  void añadirCliente(){
		Clientes nuevo_cliente=new Clientes();
		
		System.out.println("Nombre del Cliente;");
		String nom=entrada.nextLine();
		nuevo_cliente.IntroducirNombre(nom);
		
		System.out.println("Apellidos del Cliente;");
		String apellidos=entrada.nextLine();
		nuevo_cliente.IntorducirApellidos(apellidos);
		
		System.out.println("Domicilio del Cliente;");
		String domicilio=entrada.nextLine();
		nuevo_cliente.IntroducirDomicilio(domicilio);
		
		System.out.println("Razon Social del Cliente;");
		String razonsocial=entrada.nextLine();
		nuevo_cliente.IntroducirRazonSocial(razonsocial);
		
		System.out.println("Numero ID para el Cliente");
		String idcliente=entrada.nextLine();
		nuevo_cliente.Introducir_IDCliente(idcliente);
		
		System.out.println("CIF/NIE del Cliente");
		String codigo=entrada.nextLine();
		int cif=Integer.parseInt(codigo);
		nuevo_cliente.IntroducirCIF(cif);
		
		ListaClientes.add(nuevo_cliente);
	}
	
	/**
	 * Metodo que busca un cliente en cuestión, y si lo encuentra en la lista, lo borra
	 * 
	 * 
	 */
	
	public void BorrarCliente(){
		
		System.out.println("Introduce nombre del cliente a borrar");
		String descripcion=entrada.nextLine();
		
		it=ListaClientes.iterator();
		
		while(it.hasNext()){
			Clientes t=it.next();
			String cliente= t.DameNombre();
			
			if(descripcion.equals(cliente)){
				System.out.println("¿Estas seguro de borrar ese ese cliente?");
				System.out.println("[1]- SI");
				System.out.println("[2]- NO");
				String respuesta=entrada.nextLine();
				if(respuesta.equals("1")){
					
				it.remove();
				System.out.println("***CLIENTE; " + t.DameIDCliente() + " , BORRADO CON ÉXITO");
				break;
				
				}else{
					System.out.println("cliente NO BORRADO");
				}
	
			}
		}
		
	}

	/**
	 * Imprime la lista de clientes que hay almacenados en un momento dado.
	 * 
	 * 
	 */
	

	public void Lista_Clientes(){
		it=ListaClientes.iterator();
		
		while(it.hasNext()){
			
			Clientes e=it.next();
			
			System.out.println("ID: "+ e.DameIDCliente()+" CLIENTE; "+ e.DameNombre()+" " +e.DameApellidos()+
					" , DIRECCION; c/ "+e.DAmeDomicilio()
					+ " , Razon Social; " +e.DameRazonSocial()+ " CIF; " + e.DameCIF());
			System.out.println("FECHA DE ALTA; "+e.FechaAlta());
			System.out.println();
			
		}
	}
	
	/**
	 * 
	 * Busca el id del cliente a modificar, y cambia los valores de sus campos por los
	 * introducidos por pantalla.
	 */
	
	public void ModificarCliente(){
		
		System.out.println("Introduce ID del Cliente a modificar; ");
		String idpantalla=entrada.nextLine();
		it=ListaClientes.iterator();
		
			while(it.hasNext()){
				
				Clientes c=it.next();
				String idcliente=c.DameIDCliente();
				
					if(idpantalla.equals(idcliente)){
						
						System.out.println("**Cliente Encontrado**");
						
						System.out.println("Nuevo Nombre del cliente;");
						String nuevonombre=entrada.nextLine();
						c.IntroducirNombre(nuevonombre);
							
						System.out.println("Nuevos Apellidos");
						String nuevoapellido=entrada.nextLine();
						c.IntorducirApellidos(nuevoapellido);
						
						System.out.println("Nueva Razon Social");
						String nuevarazonsocial=entrada.nextLine();
						c.IntroducirRazonSocial(nuevarazonsocial);
						
						System.out.println("Nuevo CIF/NIE;");
						String nuevoCIF=entrada.nextLine();
						int cif=Integer.parseInt(nuevoCIF);
						c.IntroducirCIF(cif);
						
						System.out.println("Nuevo Domicilio;");
						String nuevodomicilio=entrada.nextLine();
						c.IntroducirDomicilio(nuevodomicilio);
						
					}
				
			}
	}
	
	
	/**
	 * Crea la factura buscando los ticket de un cliente seleccionado
	 * 
	 */
	public void CrearFactura(){
		it3=ListaTicket.iterator();
		System.out.println("Introduce ID Cliente;");
		String numero=entrada.nextLine();
		
		
		while(it3.hasNext()){
			Tickets t=it3.next();
			String id=t.DameIDTicket();
				if(id.equals(numero)){
					
					System.out.println("Numero Factura;");
					String numeroFactura=entrada.nextLine();
					
					CabezeraFactura(numeroFactura);
					CuerpoFactura();
					FinalFactura();
					
				}
			
			
		
	}
		
	
	}
	
	/**
	 * Crea la cabecera de la Factura, donde va el nº de factura y la fecha de alta
	 * 
	 * @param NumeroFactura
	 */
	
	public void CabezeraFactura(String NumeroFactura){
		
		System.out.println("============================================================================");
		System.out.println("================================FACTURA=====================================");
		System.out.println("Nº;  "+NumeroFactura);
		System.out.println(fecha);
		System.out.println();
		String id="ID";
		String prod="PRODUCTOS";
		String cant="CANTIDAD";
		String precio="PRECIO";
		System.out.println(String.format("%2s", id)+String.format("%23s", prod)+
				String.format("%30s", cant)+String.format("%19s",precio));
		
	}
	
	/**
	 * recorre la lista de productos vendidos y la introduce en la factura.
	 * 
	 */
	
	public void CuerpoFactura(){
		it2= productosvendidos.iterator();
		
		while(it2.hasNext()){
			
			Productos p=it2.next();
			
			System.out.println();
			System.out.println(String.format("%2s", p.DameID())+String.format("%19s",p.DameNombre())
		+String.format("%29d", p.DameCantidadTicket())+String.format("%19.2f", DamePrecio(p)) );
			
		}

	}
	
	/**
	 * 
	 * Crea el final de la factura, donde se calcula el total de dicha factura y se añade a la lista de facturas
	 */
	
	public void FinalFactura(){
		Clientes c=new Clientes();
		System.out.println();
		System.out.println();
		System.out.println("                                 " +"TOTAL:                "
		+ String.format("%.2f",TotalFactura()));
		System.out.println();
	
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("                   GRACIAS POR SU VISITA                         ");
		
		factura.add(c);
		
	}
	
	public float DamePrecio(Productos p){
		return p.DamePrecioConIVA();
	}
	
	/**
	 * Calcula el precio de la factura con el IVA incluido
	 * 
	 * @return
	 * 
	 * Devuelve el total de la factura
	 */
	
	public float TotalFactura(){
		
		float totalFactura=0;
		it2=productosvendidos.iterator();
		while(it2.hasNext()){
			
			Productos t=it2.next();
			
			totalFactura +=PrecioConIVA(t);
		}
		
		
		return totalFactura;
	}
	
	
	public float PrecioConIVA(Productos p){
		
		float precio=p.DamePrecioConIVA()*p.DameCantidadTicket();
		
		return precio;
		
	}
	
	/**
	 * Guarda en el archivo archivoFactura.bin, el listado de facturas
	 * 
	 */
	
	public void Guardar(){
		
		try{
			File fichero=new File("archivoFactura.bin");
			FileOutputStream fout =
			new FileOutputStream(fichero);
			ObjectOutputStream oos =
			new ObjectOutputStream(fout);
			oos.writeObject(factura);
			oos.close();
			System.out.println("ARCHIVO GUARDADO CON ÉXITO");

			}
			catch(IOException e){
			System.out.println("Error en la escritura.");
			}
	}
	
	/**
	 * Carga desde el disco, el archivo archivoFactura.bin que contiene facturas guardadas anteriormente
	 * 
	 */
	
	
	@SuppressWarnings("unchecked")
	public void Cargar(){
		
		try{
			
			File fichero=new File("archivoFactura.bin");
			FileInputStream fin=
			new FileInputStream(fichero);
			ObjectInputStream ois =
			new ObjectInputStream(fin);
			factura =(ArrayList<Clientes>)ois.readObject();
			ois.close();
			System.out.println("ARCHIVO CARGADO CON ÉXITO");
			}
			catch(Exception e){
			System.out.println("Error en la lectura.");
			}
	}
}


