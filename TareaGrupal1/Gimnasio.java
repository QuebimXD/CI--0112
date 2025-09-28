import java.util.Random;
public class Gimnasio {
    private String NombreEU;
    private String Ataque;
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
        System.out.println("Elija un ataque:");

    }
    public void ataqueNPC(){
        Random rand = new Random();
        int numA = rand.nextInt(4); // numero entre 0 y el 3

    }
    public void mostrarEntrenadores(){

    }
    public void combate(){

    }
    public int calcularDaño(int potencia, int presicion, int ataque, int defensa, int nivel){
        int daño = (((2 * nivel / 5 + 2)* potencia * presicion/ defensa)/ 50) + 2;
        return daño;
    }

}
