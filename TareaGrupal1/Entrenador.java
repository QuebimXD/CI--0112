public class Entrenador {
    private String nombreE;
    private Pokemon[] equipoPokemon;

    
    public Entrenador(String nombre){
        this.nombreE = nombre;   
        this.equipoPokemon = new Pokemon[3];
    }
    public Entrenador(String nombre, Pokemon [] equipoPokemon){
        this.nombreE = nombre;
        this.equipoPokemon = equipoPokemon;
    }

    public String getNombreE(){
        return  nombreE;
    }
    public void setNombreE(String n){
        this.nombreE = n;
    }

    public Pokemon getEquipoPokemon(int i){
        return equipoPokemon[i];
    }
    public int largoListaP(){
        return equipoPokemon.length;
    }


    public Pokemon getPrimerPokemon(){
        if (equipoPokemon[0] == null){
            System.out.println("Este equipo aún no tiene pokemones asignados.");
        }
        return equipoPokemon[0];
    }
    public boolean equipoDebilitado(){
        int pokemonesDerrotados = 0;
        for (int i = 0; i < equipoPokemon.length; i++){
            if(equipoPokemon[i].getVidaP() == 0){
                pokemonesDerrotados++;
            }
        }
        if(pokemonesDerrotados == equipoPokemon.length){
            return true;
        }
        return false;
    }
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
    public void mostrarEquipoPokemon(){
        for (int i = 0; i<equipoPokemon.length; i++){
            Pokemon j = equipoPokemon[i];
            System.out.println((i+1) + j.getNombreP());
        }
    }
}
