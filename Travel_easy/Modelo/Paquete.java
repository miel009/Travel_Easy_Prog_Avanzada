package Modelo;

import javax.swing.JOptionPane;

public class Paquete {
	private int id_paquete;
	private String nombreP;
	private String descripcion;
	private String tipo_turismo;
	private double precio;
	private int destino;
	
	
	public Paquete(int id_paquete, String nombreP, String descripcion, String tipo_turismo, double precio, int destino) {
		this.id_paquete=id_paquete;
		this.nombreP = nombreP;
		this.descripcion = descripcion;
		this.tipo_turismo = tipo_turismo;
		this.precio = precio;
		this.destino = destino;
		
		
		
	}
	public Paquete() {
	// PARA USO DE SINGLETON
	}
	
	public int getId_paquete() {
		return id_paquete;
	}
	// INCREMENTAL
	public void setId_paquete(int id_paquete) {
		this.id_paquete = id_paquete;
	}
	public String getNombreP() {
		return nombreP;
	}
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo_turismo() {
		return tipo_turismo;
	}

	public void setTipo_turismo(String tipo_turismo) {
		this.tipo_turismo = tipo_turismo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	



	/*@Override
	public String toString() {
		return "Paquete [id_paquete=" + id_paquete + ", descripcion=" + descripcion + ", tipo_turismo=" + tipo_turismo
				+ ", precio=" + precio + ", destino=" + destino + ", servicio_paquete=" + servicio_paquete + "]";
	}*/
	
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
		this.destino = destino;
	}
	@Override
	public String toString() {
	    return "Paquete:\n" +
	           "id_paquete: " + id_paquete + "\n" +
	           "descripcion: " + descripcion + "\n" +
	           "tipo_turismo: " + tipo_turismo + "\n" +
	           "precio: " + precio + "\n" ;
	}

	
	
	//VALIDACIONES
    private static String obtenerStringNoVacio(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input != null && !input.trim().isEmpty()) {
                return input;
            } else {
                JOptionPane.showMessageDialog(null, "Este campo no puede estar vacío.");
            }
        }
    }

    private static double obtenerPrecio() {
        while (true) {
            try {
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del paquete:"));
                if (precio > 0) {
                    return precio;
                } else {
                    JOptionPane.showMessageDialog(null, "El precio debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Entrada no válida. Ingrese un número.");
            }
        }
    }

	
	// add paquete
/*	   public static Paquete obtenerDatosPaquete() {
	        try {
	        	String nombreP = obtenerStringNoVacio("Ingrese nombre del paquete:");
	            String descripcion = obtenerStringNoVacio("Ingrese descripción del paquete:");
	            String tipo_turismo = obtenerStringNoVacio("Ingrese tipo de turismo:");
	            double precio = obtenerPrecio();
	            Destino destino = Destino.obtenerDatosDestino();
	           //Servicio_ad servicioAd = Servicio_ad.obtenerDatosServicio();
	           
	           

	            return new Paquete(nombreP, descripcion, tipo_turismo, precio);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error. Asegúrese de ingresar datos correctos.");
	            e.printStackTrace();
	            return null;
	        }
	    }*/
	
	
}
