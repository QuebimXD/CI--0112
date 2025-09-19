public class Pokemon{
    private String NombreP;
    private int Nivel;
    private int Vida;
    private int Ataque;
    private int Defensa;
    private int Velocidad;
    private boolean Estado;

    public Pokemon(){
        NombreP = "";
        Nivel = 0;
        Vida = 0;
        Ataque = 0;
        Defensa = 0;
        Velocidad = 0;
        Estado = true;
    }
    public String getNombreP(){
        return NombreP;
    }
    public void setNombreP(String nombre){
        NombreP = nombre;
    }
    public int getNivel(){
        return Nivel;
    }
    public void setNivel(int nivel){
        Nivel = nivel;
    }
    public int getVida(){
        return Vida;
    }
    public void setVida(int vida){
        Vida = vida;
    }
    public int getAtaque(){
        return Ataque;
    }
    public void setAtaque(int ataque){
        Ataque = ataque;
    }
    public int getDefensa(){
        return Defensa;
    }
    public void setDefensa(int defensa){
        Defensa = defensa;
    }
    public int getVelocidad(){
        return Velocidad;
    }
    public void setVelocidad(int velocidad){
        Velocidad = velocidad;
    }
    public boolean getEstado(){
        return Estado;
    }
    public void setEstado(boolean estado){
        Estado = estado;
    }
}