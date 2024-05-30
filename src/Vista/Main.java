package Vista;
import java.util.List;

import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import Modelo.Destino;
import Modelo.Paquete;
import Modelo.Servicio_ad;
import Modelo.Usuario;
import Controlador.UsuarioControlador;
import Interfaces.Mostrar_Destinos;
import Controlador.DestinosControlador;
import Controlador.PaqueteControlador;
import Controlador.ServiciosAdControlador;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//Menu ----> 
		UsuarioControlador controlador = new UsuarioControlador();
		DestinosControlador controladorD = new DestinosControlador(); 
		PaqueteControlador controladorPaquete =new PaqueteControlador();
		ServiciosAdControlador controladorServicios = new ServiciosAdControlador();		
		
        String[] ingreso = {"Empleado Turismo", "Empleado Vtas", "Salir"};
      
        int opcionEmpleado;
        do {
            opcionEmpleado = JOptionPane.showOptionDialog(null, "Bienvenido al sistema de gestion"
            		+ "de destinos TRAVEL EASY \nPor favor ingrese con su usuario correspondiente.", null, 0, 0, null, ingreso, ingreso[0]);           
          
            if (opcionEmpleado == 0) {           	
            	String ingresoEmpleado;
                do {
                    ingresoEmpleado = JOptionPane.showInputDialog(null, "Ingrese su tipo de usuario (Empleado o Empleado Vtas):");
                } while (!Usuario.ValidarIngresoEmpleado(ingresoEmpleado));
           
            	
            }

           
            switch (opcionEmpleado) {
                case 0:
                	String[] empleado_T = {"Agregar destino","Agregar paquete", "Servicios Adicionales",
                			"Lista de destinos","Eliminar destino","Modificar","Salir"};
               	
                	int opcionEmpleado_T=0;
              
                    do {
                    	opcionEmpleado_T = JOptionPane.showOptionDialog(null, "Eliga que desea hacer", null, 0, 0, null, empleado_T, empleado_T[0]);
                        
                       switch (opcionEmpleado_T) {
                            case 0: 
                            	 Destino nuevoDestino = Destino.obtenerDatosDestino();
                                 if (nuevoDestino != null) {
                                     controladorD.addDestino(nuevoDestino);
                                 } else {
                                     System.out.println("Error al ingresar los datos del destino.");
                                 }
                                 break;
                			
                				
                            case 1:
                            	JOptionPane.showMessageDialog(null, "agregar paquete");
                            	Paquete nuevoPaquete = Paquete.obtenerDatosPaquete();
                                if (nuevoPaquete != null) {
                                	controladorPaquete.addPaquete(nuevoPaquete);
                                } else {
                                    System.out.println("Error al ingresar los datos del paquete.");
                                }
                                break;
                            	
                                
                            case 2: // SERVICIOS ADICIONALES AGREGAR
                            	Servicio_ad nuevoServicio = Servicio_ad.obtenerDatosServicio();
                                if (nuevoServicio != null) {
                                	controladorServicios.addServicio(nuevoServicio);
                                }
                                break;
                                
                            case 3:    //ME TRAE LA LISTA DE DESTINOS, Y BUSCA UNO POR NOMBRE                       	
                            	
                            	List<Destino> destinosList = controladorD.listarDestinos();
                                if (destinosList.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "No hay destinos disponibles");
                                    break;
                                }

                                String[] destinosL = new String[destinosList.size()];
                                for (int i = 0; i < destinosL.length; i++) {
                                    destinosL[i] = destinosList.get(i).getNombre();
                                }

                                String elegido = (String) JOptionPane.showInputDialog(
                                    null, 
                                    "Elija destinos", 
                                    null, 
                                    JOptionPane.QUESTION_MESSAGE, 
                                    null, 
                                    destinosL, 
                                    destinosL[0]
                                );

                                if (elegido != null) {
                                    // Encontrar el destino mediante su ID
                                    Destino destinoSeleccionado = null;
                                    for (Destino destino : destinosList) {
                                        if (destino.getNombre().equals(elegido)) {
                                            destinoSeleccionado = destino;
                                            break;
                                        }
                                    }

                                    // Muestra destino encontrado
                                    if (destinoSeleccionado != null) {
                                        JOptionPane.showMessageDialog(null, "Destino seleccionado: " + destinoSeleccionado.toString());
                                        // controladorD.updateDestino(destinoSeleccionado);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Destino no encontrado");
                                    }
                                }
                                break;
                                
                            	
                            case 4: JOptionPane.showMessageDialog(null, "Eliminar destino");
                        	String[] destinoEliminar = new String[controladorD.listarDestinos().size()];
            				for (int i = 0; i < destinoEliminar.length; i++) {
            					destinoEliminar[i] = Integer.toString(controladorD.listarDestinos().get(i).getId_destino());
            				}

            				String opcionselecEliminar = (String) JOptionPane.showInputDialog(null, "Seleccione destino", null, 0, null,
            						destinoEliminar, destinoEliminar[0]);

            				controladorD.deleteDestino(Integer.parseInt(opcionselecEliminar));
            				
                            break;
                            
                            case 5: 
                            JOptionPane.showMessageDialog(null, "Modificar- destino actualiza - elimina ");
                            
                           
                            String[] destinoUp = new String[controladorD.listarDestinos().size()];
                            for (int i = 0; i < destinoUp.length; i++) {
                                destinoUp[i] = Integer.toString(controladorD.listarDestinos().get(i).getId_destino());
                            }

                            String opcions = (String) JOptionPane.showInputDialog(null, "Seleccione destino", null, 0, null, destinoUp, destinoUp[0]);

                            Destino seleccionados= controladorD.getDestinoById(Integer.parseInt(opcions));

                            seleccionados.setNombre(JOptionPane.showInputDialog("Su nombre actual es " + seleccionados.getNombre() + "Ingrese uno nuevo: "));

                            controladorD.updateDestino(seleccionados);
                            
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
                    String[] empleado_V = {"Ver lista Destinos"," Ver lista paquetes diponibbles"," Crear paquete"," Lista de servicios adicionales","Salir"};
                    
                	int opcionEmpleado_V=0;
              
                    do {
                    	opcionEmpleado_V = JOptionPane.showOptionDialog(null, "Eliga que desea hacer", null, 0, 0, null, empleado_V, empleado_V[0]);
                        
                       switch (opcionEmpleado_V) {
                            case 0: 

                            	List<Destino> destinosList = controladorD.listarDestinos();
                                if (destinosList.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "No hay destinos disponibles");
                                    break;
                                }

                                String[] destinosL = new String[destinosList.size()];
                                for (int i = 0; i < destinosL.length; i++) {
                                    destinosL[i] = destinosList.get(i).getNombre();
                                }

                                String elegido = (String) JOptionPane.showInputDialog(
                                    null, 
                                    "Elija destinos", 
                                    null, 
                                    JOptionPane.QUESTION_MESSAGE, 
                                    null, 
                                    destinosL, 
                                    destinosL[0]
                                );

                                if (elegido != null) {
                                    // Encontrar el destino seleccionado
                                    Destino destinoSeleccionado = null;
                                    for (Destino destino : destinosList) {
                                        if (destino.getNombre().equals(elegido)) {
                                            destinoSeleccionado = destino;
                                            break;
                                        }
                                    }

                                    // Muestra destino
                                    if (destinoSeleccionado != null) {
                                        JOptionPane.showMessageDialog(null, "Destino seleccionado: " + destinoSeleccionado.toString());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Destino no encontrado");
                                    }
                                }
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


