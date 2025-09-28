public class Elemento {
    private String nombre;
    private String debilidad;
    private String fortaleza;
    private Elemento[] catalogo;

    public Elemento(String nombre, String debilidad, String fortaleza ){
            this.nombre = nombre;
            this.debilidad = debilidad;
            this.fortaleza = fortaleza;
            this.catalogo = new Elemento[6];
    }
}
