public class Pokemon{
    private String nombreP;
    private int nivelP;
    private int vidaP;
    private Elemento elementoP;
    private int ataqueP;
    private int defensaP;
    private int velocidadP;
    private boolean estadoP;
    private Ataque[] ataquesP;

    public Pokemon(String nP, int nivP, int vidaP, Elemento eP, int aP, int dP, int vP, boolean estP, Ataque[] ats){
        this.nombreP = nP;
        this.nivelP = nivP;
        this.vidaP = vidaP;
        this.elementoP = eP;
        this.ataqueP = aP;
        this.defensaP = dP;
        this.velocidadP = vP;
        this.estadoP = estP;
        this.ataquesP = ats;
    }
    
    public String getNombreP(){
        return nombreP;
    }
    public void setNombreP(String nombre){
        nombreP = nombre;
    }
    public int getNivelP(){
        return nivelP;
    }
    public void setNivelP(int nivel){
        nivelP = nivel;
    }
    public int getVidaP(){
        return vidaP;
    }
    public void setVidaP(int vida){
        vidaP = vida;
    }
    public int getAtaqueP(){
        return ataqueP;
    }
    public void setAtaqueP(int ataque){
        ataqueP = ataque;
    }
    public int getDefensaP(){
        return defensaP;
    }
    public void setDefensaP(int defensa){
        defensaP = defensa;
    }
    public int getVelocidadP(){
        return velocidadP;
    }
    public void setVelocidadP(int velocidad){
        velocidadP = velocidad;
    }
    public boolean getEstadoP(){
        return estadoP;
    }
    public void setEstadoP(boolean estado){
        estadoP = estado;
    }
    public Elemento getElementoP(){
        return elementoP;
    }
    public void setElementoP(Elemento e){
        this.elementoP = e;
    }
    public Ataque[] getAtaquesP(){
        return ataquesP;
    }
}