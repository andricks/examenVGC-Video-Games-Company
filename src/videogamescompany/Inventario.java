package videogamescompany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Borge
 */
public class Inventario {
    private String Franquicia;
    private String Nombre;
    private String Descripcion;
    private String Precio;
    private String Exixtencia;

    public Inventario(String Franquicia, String Nombre, String Descripcion, String Precio, String Exixtencia) {
        this.Franquicia = Franquicia;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Exixtencia = Exixtencia;
    }
    public Inventario(){
        
}

    public String getFranquicia() {
        return Franquicia;
    }

    public void setFranquicia(String Franquicia) {
        this.Franquicia = Franquicia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getExixtencia() {
        return Exixtencia;
    }

    public void setExixtencia(String Exixtencia) {
        this.Exixtencia = Exixtencia;
    }
    
    
}
