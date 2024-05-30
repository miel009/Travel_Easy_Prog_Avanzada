package Modelo;

import javax.swing.JOptionPane;

public class Destino {
	private int id_destino;
	private String nombre;
	private String descripcion;
	private String pais;
	private String zonaGeo;
	private String recomendaciones; 
	private String temporada_ideal;
	private int rango_edad; 
	private String transporte;
	private String tipo_turismo;
	private String servicios_requeridos;
	
	
	public Destino(String nombre, String descripcion, String pais, String zonaGeo,
			String recomendaciones, String temporada_ideal, int rango_edad, String transporte, String tipo_turismo,String servicios_requeridos) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pais = pais;
		this.zonaGeo = zonaGeo;
		this.recomendaciones = recomendaciones;
		this.temporada_ideal = temporada_ideal;
		this.rango_edad = rango_edad;
		this.transporte = transporte;
		this.tipo_turismo = tipo_turismo;
		this.servicios_requeridos= servicios_requeridos;
	}
	
	public Destino() {
		
	}	
	
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getZonaGeo() {
		return zonaGeo;
	}
	public void setZonaGeo(String zonaGeo) {
		this.zonaGeo = zonaGeo;
	}
	public String getRecomendaciones() {
		return recomendaciones;
	}
	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
	public String getTemporada_ideal() {
		return temporada_ideal;
	}
	public void setTemporada_ideal(String temporada_ideal) {
		this.temporada_ideal = temporada_ideal;
	}
	public int getRango_edad() {
		return rango_edad;
	}
	public void setRango_edad(int rango_edad) {
		this.rango_edad = rango_edad;
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	public String getTipo_turismo() {
		return tipo_turismo;
	}
	public void setTipo_turismo(String tipo_turismo) {
		this.tipo_turismo = tipo_turismo;
	}
	
	public String getServicios_requeridos() {
		return servicios_requeridos;
	}
	public void setServicios_requeridos(String servicios_requeridos) {
		this.servicios_requeridos = servicios_requeridos;
	}
	
	
    
	@Override
	public String toString() {
	    return "Destino:\n" +
	           "ID: " + id_destino + "\n" +
	           "Nombre: " + nombre + "\n" +
	           "Descripción: " + descripcion + "\n" +
	           "País: " + pais + "\n" +
	           "Zona Geográfica: " + zonaGeo + "\n" +
	           "Recomendaciones: " + recomendaciones + "\n" +
	           "Temporada Ideal: " + temporada_ideal + "\n" +
	           "Rango de Edad: " + rango_edad + "\n" +
	           "Transporte: " + transporte + "\n" +
	           "Tipo de Turismo: " + tipo_turismo + "\n" +
	           "Servicios Requeridos: " + servicios_requeridos;
	}

	// Métodos de validación
    private static String obtenerStringNoVacio(String mensaje) {
    	 while (true) {
    	        String cadena = JOptionPane.showInputDialog(mensaje);
    	        if (cadena != null && !cadena.trim().isEmpty()) {
    	            // Verificar si la cadena contiene solo letras
    	            if (cadena.matches("[A-Za-z ]*")) {
    	                return cadena;
    	            } else {
    	                JOptionPane.showMessageDialog(null, "Este campo debe contener solo letras.");
    	            }
    	        } else if (cadena == null) {
    	            JOptionPane.showMessageDialog(null, "Este campo no puede estar vacío.");
    	        } else {
    	            JOptionPane.showMessageDialog(null, "Este campo no puede estar vacío.");
    	        }
    	    }
    	}
    
    private static int obtenerRangoEdad() {
        while (true) {
            try {
                int rangoEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese rango de edad:"));
                if (rangoEdad > 0) {
                    return rangoEdad;
                } else {
                    JOptionPane.showMessageDialog(null, "El rango de edad debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Entrada no válida. Ingrese un número entero.");
            }
        }
    }


    public static Destino obtenerDatosDestino() {
    	//PARA addDestino.
        try {
            String nombre = obtenerStringNoVacio("Ingrese nombre del destino:");
            String descrip = obtenerStringNoVacio("Ingrese descripción:");
            String pais = obtenerStringNoVacio("Ingrese nombre del país:");
            String zonaGeo = obtenerStringNoVacio("Ingrese zona geográfica:");
            String recomendaciones = obtenerStringNoVacio("Ingrese recomendaciones:");
            String temporada_ideal = obtenerStringNoVacio("Ingrese temporada ideal:");
            int rangoEdad = obtenerRangoEdad();
            String transp = obtenerStringNoVacio("Ingrese tipo de transporte:");
            String tipoTurismo = obtenerStringNoVacio("Ingrese tipo de turismo:");
            String serviciosAd = obtenerStringNoVacio("Ingrese servicios adicionales:");

            return new Destino(nombre, pais, zonaGeo, descrip, recomendaciones, temporada_ideal,
                    rangoEdad, transp, tipoTurismo, serviciosAd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. Asegúrese de ingresar datos correctos.");
            e.printStackTrace();
            return null;
        }
    }
    

   

}
