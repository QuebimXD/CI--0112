public class Pieza{
    //private String[] colores;
    private String nombre;
    private Bloque[][] pieza;  //inicialmente
    private Bloque[] bloques; // los 4 bloques con su color aleatorio
    private int posicionBloque;
    private String [] colores = {"rojo", "amarillo", "verde", "morado", "azul", "naranja"};

    public Pieza(){
        posicionBloque = 0;
        bloques = new Bloque[4];
        pieza = new Bloque[4][2]; //inicialmente, luego se cambia dependiendo de la forma
        
        int indice2 = (int)(Math.random() * 4);

        for(int i = 0; i < bloques.length; i++){
            int indice = (int)(Math.random() * 4);
            String color = colores[indice];
            bloques[i] = new Bloque(color);
        }

    }
    public void imprimirPieza(){
        for(int i = 0; i < pieza.length; i++){
            for(int j = 0; j < pieza[0].length; j++){
                if(pieza[i][j] != null){
                    Bloque temp = pieza[i][j];
                    System.out.println(temp.getColor());
                }
                System.out.println();
            }
        }
       
    }

    public void elegirForma(int indice){
        Bloque bloque1 = bloques[0];
        Bloque bloque2 = bloques[1];
        Bloque bloque3 = bloques[2];
        Bloque bloque4 = bloques[3];
        
        switch(indice){
            case 0:
                 Bloque[][] forma = {{bloque1}, {bloque2}, {bloque3, bloque4}};
                 pieza = forma;
                 nombre = "L";
                 break;
            case 1:
                Bloque[][] forma2 = {{bloque1}, {bloque2}, {bloque3}, {bloque4}};
                pieza = forma2;
                nombre = "Línea recta";
                break;
            case 2:
                Bloque[][] forma3 = {{bloque1}, {bloque2, bloque3}, {bloque4}};
                pieza = forma3;
                nombre = "T";
                break;
            case 3:
                Bloque [][] forma4 = {{bloque1, bloque2}, {null, bloque3, bloque4}};
                pieza = forma4;
                nombre = "Z";
            default:
                break;
        }
    }
}