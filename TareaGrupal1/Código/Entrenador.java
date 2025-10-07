/*
 * Esta es la clase Entrenador que controla a los equipos Pokemon
 * @ RodrigoLovers
 * @version 1.0
 */

public class Entrenador {
    private String nombreE;
    private Pokemon[] equipoPokemon;

    /**
 *  Constructor de clase Entrenador.
 * 
 * @param nombre nombre del ataque
 */
    public Entrenador(String nombre){
        this.nombreE = nombre;   
        this.equipoPokemon = new Pokemon[3];
    }
    /**
 *  Constructor de clase Entrenador.
 * 
 * @param nombre del entrenador
 * @param equipoPokemon lista de pokemones
 *
 */
    public Entrenador(String nombre, Pokemon [] equipoPokemon){
        this.nombreE = nombre;
        this.equipoPokemon = equipoPokemon;
    }

    /**
    * Retorna el nombre del entrenador
    *
    * @return el nombre entrenador
    */

    public String getNombreE(){
        return  nombreE;
    }
    
    /**
    * Asigno el nombre del entrenador
    *
    * @param n nombre entrenador
    */

    public void setNombreE(String n){
        this.nombreE = n;
    }

    
    /**
    * Retorna un pokemon en una posicion escogida por el usuario
    *
    * @param i  posicion escogida
    * @return el pokemon que está en la posicion
    */

    public Pokemon getEquipoPokemon(int i){
        return equipoPokemon[i];
    }
    /**
    * Retorna la longitud del equipo pokemon
    *
    * @return longitud equipo
    */
    public int largoListaP(){
        return equipoPokemon.length;
    }

    /**
    * Retorna el primer pokemon del equipo, y si es null, avisa que el equipo no tiene asignados pokemones todavía
    *
    * @return el primer pokemon del equipo
    */
    public Pokemon getPrimerPokemon(){
        if (equipoPokemon[0] == null){
            System.out.println("Este equipo aún no tiene pokemones asignados.");
        }
        return equipoPokemon[0];
    }
        /**
    * Retorna true si todos los pokemones del equipo se debilitaron
    *
    * @return estado del equipo
    */
    public boolean equipoDebilitado(){
        int pokemonesDerrotados = 0;
        for (int i = 0; i < equipoPokemon.length; i++){
            if(equipoPokemon[i].getVidaP() <= 0){
                pokemonesDerrotados++;
            }
        }
        if(pokemonesDerrotados == equipoPokemon.length){
            return true;
        }
        return false;
    }
        /**
    * Agrega al equipo un pokemon si hay espacios disponibles
    *
    * @param pokemon  pokemon a agregar
    */

    public void agregarAlEquipoPokemon(Pokemon pokemon){
        int i = 0;
        boolean seAgrego = false;
        while (i < equipoPokemon.length && !seAgrego){
            if(equipoPokemon[i] == null){
                equipoPokemon[i] = pokemon;
                seAgrego = true;
            }
            i++;
        }
    }
        /**
    * Muestra toda la información de los pokemones del equipo
    *
    */
    public void mostrarInfoEquipoPokemon(){
        String estado = "";
        for(int j = 0; j < equipoPokemon.length; j++){
            
            Pokemon i = equipoPokemon[j];
            if(i.getEstadoP()){
                estado = "Vivo";
            } 
            else {
                estado = "Debilitado";
            }
            System.out.println("Nombre: " + i.getNombreP() + "\nVida: " + i.getVidaP() + "\nNivel: " + i.getNivelP() +
                                "\nAtaque: " + i.getAtaqueP() + "\nDefensa: " + i.getDefensaP() + "\nVelocidad: " + 
                                i.getVelocidadP() + "\nEstado: " + estado + "\n");
        }
    }
    /**
    * Muestra los nombres del equipo pokemon
    *
    */
    public void mostrarEquipoPokemon(){
        for (int i = 0; i<equipoPokemon.length; i++){
            Pokemon j = equipoPokemon[i];
            System.out.println((i+1) + " " + j.getNombreP());
        }
    }
}
