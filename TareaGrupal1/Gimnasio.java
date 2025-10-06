import java.util.Random;
public class Gimnasio {
    private String NombreEU;
    private String Ataque;
    private Pokemon pokemon;
    private Entrenador[] entrenadores;
    CatalogoP pokemones = new CatalogoP();
    
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

    public void entrenadores(){

    }

    Entrenador fuego = new Entrenador("Axel Llama", 
    new Pokemon[]{
            pokemones.getListaP(0),
            pokemones.getListaP(6)
    });
    Entrenador agua = new Entrenador("Mariana Azul", 
    new Pokemon[]{
            pokemones.getListaP(1),
            pokemones.getListaP(10)
    });
    Entrenador planta = new Entrenador("Raimundo Raiz", 
    new Pokemon[]{
            pokemones.getListaP(2),
            pokemones.getListaP(11)
    });
    Entrenador lider = new Entrenador("Violeta Prisma", 
    new Pokemon[]{
            pokemones.getListaP(4),
            pokemones.getListaP(7),
            pokemones.getListaP(8)
    });
}
