package Vista;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Controlador.UsuarioControlador;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MENU - OPTION - ARRAY - SWICH
		// PRIMER INGRESO - BIENVENIDA A USUARIO QUE CORRESPONDA- VALIDACION
		//SWICH-> MENU DE CADA USUARIO.
	 
	//Menu ----> 
		UsuarioControlador controlador = new UsuarioControlador();
		
		
        String[] ingreso = {"Empleado Turismo", "Empleado Vtas", "Salir"};
       
      
        int opcionEmpleado;
        do {
            opcionEmpleado = JOptionPane.showOptionDialog(null, "Bienvenido al sistema de gestion"
            		+ "de destinos TRAVEL EASY \nPor favor ingrese con su usuario correspondiente.", null, 0, 0, null, ingreso, ingreso[0]);
           //deberia ser un INPUT PARA INGRESAR
            /*opcionEmpleado = (int) JOptionPane.showInputDialog(null, "Bienvenido al sistema de gestion"
            		+ "de destinos TRAVEL EASY \nPor favor ingrese con su usuario correspondiente.", null, 0, null, ingreso, ingreso[0]);
            */
            //VALIDAR INGRESO - METODO
            //JOptionPane.showInputDialog(null, opcionEmpleado);
          
            if (opcionEmpleado == 0) {
            	
            	String IngresoEmpT=JOptionPane.showInputDialog(null, "Ingrese contrasena");
            	if (IngresoEmpT.equalsIgnoreCase("mel")){
            		JOptionPane.showMessageDialog(null, "Ingreso con exito");           		   	
            	} else {
            		JOptionPane.showMessageDialog(null, "ERROR contrasena invalida");
            	}
            }
          // AGREGAR METODO PARA INGRESO- VAlIDACION
            
            
            
            switch (opcionEmpleado) {
                case 0:
                	String[] empleado_T = {"Agregar destino","Eliminar destino","Lista de destinos","Lista de paquetes","Modificar","Servicios Adicionales","Salir"};
               	
                	int opcionEmpleado_T=0;
              
                    do {
                    	opcionEmpleado_T = JOptionPane.showOptionDialog(null, "Eliga que desea hacer", null, 0, 0, null, empleado_T, empleado_T[0]);
                        
                       switch (opcionEmpleado_T) {
                            case 0: 
                            	JOptionPane.showMessageDialog(null, "Agrego destino");
                            	 
                            break;
                            case 1:
                            	JOptionPane.showMessageDialog(null, "Elimino destino");
                               
                                break;
                            case 2:
                            	JOptionPane.showMessageDialog(null, "Lista Destinos" );
                                break;
                            case 3: 
                            	JOptionPane.showMessageDialog(null, "Lista Paquetes");
                                break;
                            case 4:
                            	JOptionPane.showMessageDialog(null, "Modificar");
                            	// OPCIONES PARA MODIFICAR
                            	break;
                            case 5:
                            	JOptionPane.showMessageDialog(null, "Servicios Adicionales");	
                            	
                                break;
                            case 6:
                                JOptionPane.showMessageDialog(null, "Salio de Gestor de destinos");

                            default:
                                break;
                        }

                    } while (opcionEmpleado_T != 6);
              
                break;
              //FIN MENU EMPLEADO TURISMO GESTOR
                
                case 1: 
                    JOptionPane.showMessageDialog(null, "empleado Ventas");
                    String[] empleado_V = {"Ver lista Destinos"," Ver lista paquetes dsiponibbles"," Crear paquete"," Lista de servicios adicionales","Salir"};
                    
                	int opcionEmpleado_V=0;
              
                    do {
                    	opcionEmpleado_V = JOptionPane.showOptionDialog(null, "Eliga que desea hacer", null, 0, 0, null, empleado_V, empleado_V[0]);
                        
                       switch (opcionEmpleado_V) {
                            case 0: 
                            	JOptionPane.showMessageDialog(null, "Lista detallada de Destinos disponibles");
                            	break;
                            case 1:
                            	JOptionPane.showMessageDialog(null, "Lista detallada de Paquetes disponibles");
                               
                                break;
                            case 2: 
                            	JOptionPane.showMessageDialog(null, "Crear paquete");
                            	break;
                            case 3: 
                            	JOptionPane.showMessageDialog(null, "Lista de servicios adicionales");                       
                            	break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Salio de empleado de ventas");


                            default:
                                break;
                        }

                    } while (opcionEmpleado_V != 4);
              
                break;
            	//FIN MENU EMPLEADO VENTAS
                case 2:
                    JOptionPane.showMessageDialog(null, " Gracias por utilizar nuestros servicios TravelEasy");

                    break;


                default:
                    break;
            }
        } while ( opcionEmpleado != 2);
	
		
	//FIN MENU
	}

}
