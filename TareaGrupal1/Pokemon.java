/*
 * Esta es la clase modelo de Pokemon.
 * @ RodrigoLovers
 * @version 1.0
 */

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
    private int vidaMax;

/**
 *  Constructor de clase Pokemon.
 * 
 * @param nP nombre del pokemon
 * @param nivP nivel del pokemon
 * @param vidaP vida del pokemon
 * @param eP elemento  del pokemon
 * @param aP ataque del pokemon
 * @param dP defensa del pokemon
 * @param vP velocidad del pokemon
 * @param estP estado del pokemon
 * @param ats lista de ataques
 * @param vidaMax vida maxima del pokemon
 */

    public Pokemon(String nP, int nivP, int vidaP, Elemento eP, int aP, int dP, int vP, boolean estP, Ataque[] ats){
        this.vidaMax =vidaP;
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
    
    /**
    * Retorna el nombre del pokemon
    *
    * @return el nombre del pokemon
    */
    public String getNombreP(){
        return nombreP;
    }
        /**
    * Asigna el nombre del pokemon
    *
    * @param nombre nombre del pokemon
    */
    public void setNombreP(String nombre){
        nombreP = nombre;
    }
        /**
    * Retorna el nivel del pokemon
    *
    * @return el nivel del pokemon
    */
    public int getNivelP(){
        return nivelP;
    }
    /**
    * Asigna el nivel del pokemon
    *
    * @param nivel nivel del pokemon
    */
    public void setNivelP(int nivel){
        nivelP = nivel;
    }
    /**
    * Retorna la vida del pokemon
    *
    * @return la vida del pokemon
    */
    public int getVidaP(){
        return vidaP;
    }
    /**
    * Asigna la vida del pokemon
    *
    * @param vida  vida del pokemon
    */
    public void setVidaP(int vida){
        vidaP = vida;
    }
        /**
    * Retorna el numero de ataques del pokemon
    *
    * @return numero ataques del pokemon
    */
    public int getAtaqueP(){
        return ataqueP;
    }
        /**
    * Asigna el numero de ataques del pokemon
    *
    * @param ataque numero ataques del pokemon
    */
    public void setAtaqueP(int ataque){
        ataqueP = ataque;
    }
        /**
    * Retorna la defensa del pokemon
    *
    * @return defensa del pokemon
    */
    public int getDefensaP(){
        return defensaP;
    }
        /**
    * Asigna la defensa del pokemon
    *
    * @param defensa  defensa del pokemon
    */
    public void setDefensaP(int defensa){
        defensaP = defensa;
    }
        /**
    * Retorna la velocidad del pokemon
    *
    * @return velocidad  del pokemon
    */

    public int getVelocidadP(){
        return velocidadP;
    }
        /**
    * Asigna la velocidad del pokemon
    *
    * @param velocidad velocidad del pokemon
    */
    public void setVelocidadP(int velocidad){
        velocidadP = velocidad;
    }

        /**
    * Retorna el estado del pokemon
    *
    * @return el estado del pokemon
    */
    public boolean getEstadoP(){
        return estadoP;
    }
    /** Asigna el estado del pokemon
    * 
    * @param estado el estado del pokemon
    */  

    public void setEstadoP(boolean estado){
        estadoP = estado;
    }
    /** Retorna el elemento del pokemon
    *
    * @return el elemento del pokemon
    */
    public Elemento getElementoP(){
        return elementoP;
    }
    /** Asigna el elemento del pokemon
    *
    * @param e  elemento del pokemon
    */
    public void setElementoP(Elemento e){
        this.elementoP = e;
    }
    /**Retorna el elemento del pokemon
    *
    * @return  lista de ataques del pokemon
    */
    public Ataque getAtaquesP(int i){
        return ataquesP[i];
    }
    public int getVidaMax(){
        return vidaMax;
    }
    public int longAtaques(){
        return ataquesP.length;
    }
    /** Muestra los ataques guardados dentro de la lista interna de ataques
    *
    */
    public void mostrarAtaques(){
        for (int i = 0; i <ataquesP.length; i++){
            Ataque a = ataquesP[i];
            System.out.println((i + 1) + " " + a.getNombreA() + "\nElemento: " + a.getElementoA().getNombreElemento() +
             "\nPotencia: " + a.getPotenciaA() + "\n PP disponible: " + a.getPpActualA() + 
             "\nPrecision: " + a.getPrecisionA() + "\n");
        } 
    }
}