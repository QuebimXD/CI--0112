public class Ataque{
    private String nombreA;
    private Elemento elementoA;
    private int potenciaA;
    private int ppMaxA;
    private int ppActualA;
    private int precisionA;
    private Elemento[] catalogoE;

    public Ataque(String n, Elemento e, int pot, int pM, int pre){
        this.nombreA = n;
        this.elementoA = e;
        this.potenciaA = pot;
        this.ppMaxA = pM;
        this.ppActualA = pM; //El pp actual es el maximo al inicio de cada Pokemon >:D
        this.precisionA = pre;

        this.catalogoE = new Elemento [] {
            new Elemento("Fuego", "Agua", "Planta"),
            new Elemento("Agua", "Planta", "Fuego"),
            new Elemento("Planta", "Fuego", "Agua"),
            new Elemento("Electrico", "Roca", "Agua"),
            new Elemento("Veneno", "Roca", "Planta"),
            new Elemento("Roca", "Agua", "Veneno"),
        };

    }

    public String getNombreA(){
        return nombreA;
    }
    public Elemento getElementoA(){
        return elementoA;
    }
    public int getPotenciaA(){
        return potenciaA;
    }
    public int getPpMaxA(){
        return ppMaxA;
    }
    public int getPpActualA(){
        return ppActualA;
    }
    public int getPrecisionA(){
        return precisionA;
    }
    public void setNombreA(String n){
        this.nombreA = n;
    }
    public void setElementoA(Elemento e){
        this.elementoA = e;
    }
    public void setPotenciaA(int p){
        this.potenciaA = p;
    }
    public void setPpMaxA(int p){
        this.ppMaxA = p;
    }
    public void setPpActualA(int a){
        this.ppActualA = a;
    }
    public void setPrecisionA(int pr){
        this.precisionA = pr;
    }


}   
