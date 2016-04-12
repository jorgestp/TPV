package GUI;
import java.util.Scanner;

import Clases.*;

public class Interfaz_Textual {
	
	private Inventario inventario;
	
	private Ventas venta;
	private Scanner entrada;
	private Facturacion factura;
	
	
	
	public Interfaz_Textual(){
		inventario=new Inventario();
		inventario.Cargar();
		venta=new Ventas(inventario);
		factura=new Facturacion(venta);
		
		MensajeBienvenida();
		MenuPrincipal();
	}
	
	public void MensajeBienvenida(){
		
		
		
		System.out.println("*********************TPV**************************");
		System.out.println("Realizado por: Jorge Villalba Ruiz; DNI 47536486V");
		System.out.println();
		System.out.println();
		System.out.println("NOTA: El almacen ha sido llenado con 5 productos");
		System.out.println(" guardados en un archivo adjunto .bin, ");
		System.out.println("con el que se pueden realizar algunas pruebas");
		System.out.println("**************************************************");
		System.out.println();
		
	}
	
	
	
	public void MenuPrincipal(){
		
		entrada=new Scanner(System.in);
		
		boolean salida=false;
		
		do{
		
		System.out.println("Elija;");
		
		System.out.println("[I] para; INVENTARIO");
		
		System.out.println("[V] para; VENTAS");
		
		System.out.println("[F] para; FACTURACION");
		System.out.println("");
		System.out.println("[S] para; SALIR DEL PROGRAMA");
		
		String letra=entrada.nextLine();
		
		
		
		
		if(letra.equalsIgnoreCase("I")){
			
			ParteInventario();
			
		}else if(letra.equalsIgnoreCase("V")){
			
			ParteVentas();
			
		}else if(letra.equalsIgnoreCase("F")){
			
			ParteFacturacion();
			
		}else if(letra.equalsIgnoreCase("S")){
			
			System.out.println("El programa se cerrará..");
			System.exit(0);
			salida=true;
			
		}else{
			
			System.out.println("la letra " + letra + " no es reconocida. Intentelo de nuevo");
		}
					
			
		}while(!salida);
	}
	
	
	public void ParteInventario(){
		
		
		
		boolean fin=false;
		
		do{
			
		System.out.println("#### INVENTARIO ####");
			
		System.out.println("Seleccione una opcion;");
		
		System.out.println("[1] para: LISTA DE PRODUCTOS");
		
		System.out.println("[2] para: ALTA PRODUCTO");
		
		System.out.println("[3] para: BORRAR PRODUCTO");
		
		System.out.println("[4] para: MODIFICAR PRODUCTO");
		
		System.out.println("[5] para: GUARDAR LISTA");
		
		System.out.println("[6] para: CARGAR LISTA");
		
		System.out.println("[7] para: MENÚ PRINCIPAL");
		
		int opcion=entrada.nextInt();
		
		
		switch(opcion){
		
		case 1:
			
			inventario.ListadoEnAlmacen();
			break;
		case 2:
			
			inventario.AltaProductos();
			
			break;
			
		case 3:
			inventario.BajaProducto();
			
			break;
			
		case 4:
			
			inventario.ModificarProducto();
		
			break;
			
		case 5:
			inventario.Guardar();
			
			break;
			
		case 6:
			inventario.Cargar();
			
			break;
			
		case 7:
			MenuPrincipal();
			
			fin=true;
			
			
			break;
		}
		
		
		}while(!fin);
		
		
		
	}
	
	
	
	
	
	
	public void ParteVentas() {
		
		
		
		boolean fin=false;
		
		do{
			
		System.out.println("#### VENTAS ####");
			
		System.out.println("Seleccione una opcion;");
		
		System.out.println("[1] para: BUSCAR PRODUCTO ==> por ID");
		
		System.out.println("[2] para: BUSCAR PRODUCTO ==> por nombre");
		
		System.out.println("[3] para: CREAR TICKET");
		
		System.out.println("[4] para: GUARDAR TICKETS");
		
		System.out.println("[5] para: CARGAR TICKET");
		
		System.out.println("[6] para: MENÚ PRINCIPAL");
		
		
		
		
		
		int opcion=entrada.nextInt();
		
		
		switch(opcion){
		
		case 1:
			venta.BusquedaPorId();
			break;
		case 2:
			
			venta.BusquedaPorNombre();
			
			break;
			
		case 3:
			
			venta.CrearTicket();
			
			break;
			
		case 4:
			
			venta.Guardar();
		
			break;
			
		case 5:
			
			venta.Cargar();
			
			
			
			break;
			
		case 6:
			
			MenuPrincipal();
			fin=true;
			break;
			
		}
		
		
		}while(!fin);
		
		
	}

	public void ParteFacturacion() {
		
		
		
		boolean fin=false;
		
		do{
			
		System.out.println("#### FACTURACIÓN ####");
			
		System.out.println("Seleccione una opciÓn;");
		
		System.out.println("[1] para: ALTA DE CLIENTE");
		
		System.out.println("[2] para: MODIFICAR CLIENTE");
		
		System.out.println("[3] para: BAJA CLIENTE");
		
		System.out.println("[4] para: LISTA DE CLIENTES");
		
		System.out.println("[5] para: GUARDAR LISTA DE CLIENTES");
		
		System.out.println("[6] para: CARGAR LISTA DE CLIENTES");
		
		System.out.println("[7] para: CREAR FACTURA");
		
		System.out.println("[8] para: MENÚ PRINCIPAL");
		
		
		
		
		int opcion=entrada.nextInt();
		
		
		switch(opcion){
		
		case 1:
			factura.añadirCliente();
			
		case 2:
			
			
			
			break;
			
		case 3:
			
			factura.BorrarCliente();
			
			break;
			
		case 4:
			
			factura.Lista_Clientes();
			break;
			
		case 5:
			
			factura.Guardar();
		
			break;
			
		case 6:
			
			factura.Cargar();

			break;
			
		case 7:
			
			factura.CrearFactura();
			break;
			
		case 8:
			
			MenuPrincipal();
			fin=true;
			break;
			
		}
		
		
		}while(!fin);
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	System.out.println("Introduzca la cantidad de productos que va introducir en el almacen");
//	
//	
//	Scanner entrada=new Scanner(System.in);
//
//	
//	int numero=entrada.nextInt();
//	
//	for(int i=1; i<=numero;i++){
//		
//		inventario.AltaProductos();
//		
//		
//	}
	
//	boolean fin=false;
//	
//	do{
//		
//	System.out.println("Seleccione una opcion; ");
//	
//	System.out.println("[0] para: Listado del Almacen");
//	
//	System.out.println("[0] para: ALTA PRODUCTO");
//	
//	System.out.println("[0] para: BORRAR PRODUCTO");
//	
//	System.out.println("[0] para: Modificar producto del almacen");
//	
//	System.out.println("[0] para: Modificar producto del almacen");
//	
//	System.out.println("[0] para: Salir del programa");
//	
//	int opcion=entrada.nextInt();
//	
//	switch(opcion){
//	
//	case 0:
//		inventario.ListadoEnAlmacen();
//		
//	case 1:
//		inventario.AltaProductos();
//		
//		break;
//		
//	case 2:
//		inventario.BajaProducto();
//		
//		break;
//		
//	case 3:
//		
//		inventario.ModificarProducto();
//	
//		break;
//		
//	case 10:
//		
//		System.exit(0);
//		fin=true;
//	}
//	
//	
//	}while(!fin);
//	
//	
//	
//	
//	
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
