public class Bloque{
    private String color;
    /**
     * Metodo constructor de Bloque
     * @param el color del respectivo
     */
    public Bloque(String color){
        this.color = color;
    }

    /**
     * Metodo para cambiar el color para efectos de otras clases.
     * @param color el color que se desea cambiar
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     * getter del Color util para clase Pieza
     * @return el color del respectivo bloque
     */
    public String getColor(){
        return color;
    }
}