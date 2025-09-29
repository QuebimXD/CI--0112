public class Entrenador {
    private String nombre;
    private Pokemon[] equipoPokemon;

    
    public Entrenador(String nombre){
        this.nombre = nombre;   
        equipoPokemon = new Pokemon[2];
    }
    public Pokemon [] getEquipoPokemon(){
        return equipoPokemon;
    }
    public boolean equipoDebilitado(){
        int pokemonesDerrotados = 0;
        for (int i = 0; i < equipoPokemon.length; i++){
            if(equipoPokemon[i].getVida() == 0){
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
            if(equipoPokemon[i-1] != null){
                Pokemon [] listaTemp = new Pokemon[equipoPokemon.length];
                for(int j = 0; j<equipoPokemon.length; j++){
                    listaTemp[j] = equipoPokemon[j];
                }
                listaTemp[i-1] = pokemon;
                equipoPokemon = listaTemp;
            }
    }
    public void mostrarInfoEquipoPokemon(){
        for(int j = 0; j < equipoPokemon.length; j++){
            Pokemon i = equipoPokemon[j];
            System.out.println("Nombre: " + i.getNombreP() + "\nVida: " + i.getVida() + "\nNivel: " + i.getNivel() +
                                "\nAtaque: " + i.getAtaque() + "\nDefensa: " + i.getDefensa() + "\nVelocidad: " + 
                                i.getVelocidad() + "\nEstado: " + i.getEstado());
        }
    }
    public void mostrarEquipoPokemon(){
        for (int i = 0; i<equipoPokemon.length; i++){
            Pokemon j = equipoPokemon[i];
            System.out.println("Nombre: " + j.getNombreP());
        }
    }
}
