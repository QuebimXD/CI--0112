public class Pieza{
    //private String[] colores;
    private String nombre;
    private Bloque[][] pieza;  //inicialmente
    private Bloque[] bloques; // los 4 bloques con su color aleatorio
    //private int posicionBloque;
    private String [] colores = {"rojo", "amarillo", "verde", "morado", "azul", "naranja"};

    public Pieza(){
        //posicionBloque = 0;
        bloques = new Bloque[4];
        pieza = new Bloque[4][2]; //inicialmente, luego se cambia dependiendo de la forma
        
        

        for(int i = 0; i < bloques.length; i++){
            int indice = (int)(Math.random() * 4);
            String color = colores[indice];
            bloques[i] = new Bloque(color);
        }
        int indice2 = (int)(Math.random() * 4);
        elegirForma(indice2);
        imprimirPieza();
        System.out.println(nombre);

    }
    public void imprimirPieza(){
        for(Bloque [] filas: pieza){
            for(Bloque bloque: filas ){
                if(bloque != null){
                    System.out.print(bloque.getColor() + " ");
                } else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
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
                Bloque [][] forma4 = {{bloque1, bloque2}, {bloque3, bloque4}};
                pieza = forma4;
                nombre = "Cuadrado";
            default:
                break;
        }
    }

    public void rotarPieza(String movimiento){
        //rotación de acuerdo a las manecillas del reloj, es decir siempre hacia la derecha dependiendo de su rotación actual
        int fil = pieza.length;
        int col = pieza[0].length;
        Bloque [][] nuevo = new Bloque[col][fil];

        for(Bloque[] filas: pieza){
            for(int i = pieza.length; i < 0; i++){
                nuevo[0][i] = pieza[i][0];
            }
        }
    }
}