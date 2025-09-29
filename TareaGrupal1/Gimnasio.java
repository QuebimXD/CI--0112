import java.util.Random;
public class Gimnasio {
    private String NombreEU;
    private String Ataque;
    private Pokemon pokemon;

    public Gimnasio(){
        NombreEU = "";

    }
    public void setNombreEntrenador(String nombreU){
        NombreEU = nombreU;
    }
    public String getNombreEntrenador(){
        return NombreEU;
    }
    public int elegirAtaque(){
        System.out.println("Elija un ataque:");
        int ataque = 0;
        return ataque;
    
    }

    public void ataqueNPC(){
        Random rand = new Random();
        int numA = rand.nextInt(4); // numero entre 0 y el 3

    }

    public void mostrarEntrenadores(){

    }
    public void combate(){
        System.out.println("Comienza el combate");
        if (velocidad1 >=  velocidad2) {
            int ataque = elegirAtaque();
            int daño = calcularDaño(ataque, ataque, ataque, ataque, ataque);
            setVida(getVida - daño);
        }
    }

    

    public int calcularDaño(int potencia, int presicion, int ataque, int defensa, int nivel){
        int daño = (((2 * nivel / 5 + 2)* potencia * presicion/ defensa)/ 50) + 2;
        return daño;
    }

}
