import java.util.Random;
public class Gimnasio {
    private String NombreEU;
    public Gimnasio(){
        NombreEU = "";
    }
    public void setNombreEntrenador(String nombreU){
        NombreEU = nombreU;
    }
    public String getNombreEntrenador(){
        return NombreEU;
    }
    public void elegirAtaque(){

    }
    public void ataqueNPC(){
        Random rand = new Random();
        int numA = rand.nextInt(4); // numero entre 0 y el 3
        
    }
    public void mostrarEntrenadores(){

    }
    public void combate(){

    }
}
