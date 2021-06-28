/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogamescompany;

/**
 *
 * @author Kevin Borge
 */
public class compra {
   private String cantidad;
   private String Nombre;
   private String Total;

    public compra(String cantidad, String Nombre, String Total) {
        this.cantidad = cantidad;
        this.Nombre = Nombre;
        this.Total = Total;
    }
   
    compra(){
    
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }
    
   
}
