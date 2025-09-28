public class Elemento {
    private String nombre;
    private String debilidad;
    private String fortaleza;

    public Elemento(String nombre, String debilidad, String fortaleza ){
            this.nombre = nombre;
            this.debilidad = debilidad;
            this.fortaleza = fortaleza;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDebilidades(String debilidad){
        this.debilidad = debilidad;
    }
    public void setFortaleza(String fortaleza){
        this.fortaleza = fortaleza;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDebilidad(){
        return debilidad;
    }
    public String getFortaleza(){
        return fortaleza;
    }
}
