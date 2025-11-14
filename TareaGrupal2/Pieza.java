/*
 * Esta es la clase modelo del la pieza
 * @ RodrigoLovers
 * @version 1.0
 */

public class Pieza{
    private String nombre;
    private int fila;
    private int columna;
    private Bloque[][] pieza;  //inicialmente
    private Bloque[] bloques; // los 4 bloques con su color aleatorio
    private String [] colores = {"rojo", "amarillo", "verde", "morado", "azul", "naranja"};

    /**
     * Metodo que retorna la lista de colores que se tiene por predeterminado.
     * @return la lista de colores
     */
    public String[] getColores(){
        return colores;
    }

    /**
     * Metodo que retorna la posicion de la pieza, para efectos de Tablero
     * @return la fila en la que se encuentra
     */
    public int getFila(){
        return fila;
    }
    /**
     * Metodo que retorna la posicion de la columna, para efectos de Tablero
     * @return la columna en la que se encuentra
     */
    public int getColumna(){
        return columna;
    }
    /**
     * Metodo fijo que cambia la posicion de la pieza en filass en el tablero
     * @param f la nueva fila a la que cambiamos la pieza
     */
    public void setFila(int f){
        this.fila = f;
    }
    /**
     * Metodo fijo que cambia la posicionpieza en columnas en el tablero
     * @param c la nueva columna a la que cambiamos la pieza
     */
    public void setColumna(int c){
        this.columna = c;
    }

    /**
     * Metodo que retorna la pieza para efectos de Tablero
     * @return la pieza y su forma
     */
    public Bloque[][] getPieza(){
        return pieza;
    }

    public void setPieza(Bloque[][] p){
        this.pieza = p;
    }

    /**
     * Metodo constructor que inicializa la pieza, se escogen los colores de los bloques de esta y tambien su forma, de manera aleatoria.
     */
    public Pieza(){
        this.fila = 0;
        this.columna = 5;
        bloques = new Bloque[4];
        pieza = new Bloque[4][2]; //inicialmente, luego se cambia dependiendo de la forma
            
        for(int i = 0; i < bloques.length; i++){
            int indiceColor = (int)(Math.random() * 6);
            String color = colores[indiceColor];
            bloques[i] = new Bloque(color);
        }

        int indiceForma = (int)(Math.random() * 4);
        elegirForma(indiceForma);
    }

    /**
     * Metodo que imprime en consola la pieza, para efectos de la clase Tablero. Acude a getColorAnsi, para que en consola cada "bloque" tenga su respectivo color 
     */
    public void imprimirPieza(){
        for(Bloque [] filas: pieza){
            for(Bloque bloque: filas ){
                if(bloque != null){
                    System.out.print(getColorAnsi(bloque.getColor()) + "*"+ "\u001B[0m");
                } else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
       
    }
    /**
     * Metodo que retorna en codigo ANSI (Para efectos de terminal) el respectivo color de la lista
     * @param color el color que posee el bloque, con el swtich se verifica cual es.
     * @return el color respectivo en codigo ANSI. Si no es ninguno, retorna """
     */
    public String getColorAnsi(String color){
        switch(color.toLowerCase()){
            case "rojo":
             return "\u001B[31m";
            case "amarillo":
             return "\u001B[33m";
            case "verde":
             return "\u001B[32m";
            case "azul":
             return "\u001B[34m";
            case "morado":
             return "\u001B[35m";
            case "naranja":
             return "\u001B[38;5;208m";
            default:
             return "";
        }
    }
    /**
     * Metodo fijo que elige la forma de un bloque. Declara cuatro bloques y con el switch declara la forma de la pieza, que no es mas que una matriz.
     * @param indice el indice que define la forma. 0 es L, 1 es linea recta, 2 es la T y 3 es el cuadrado.
     */
    public void elegirForma(int indice){
        Bloque bloque1 = bloques[0];
        Bloque bloque2 = bloques[1];
        Bloque bloque3 = bloques[2];
        Bloque bloque4 = bloques[3];
        
        switch(indice){
            case 0:
                 Bloque[][] forma = {{bloque1, null}, {bloque2, null}, {bloque3, bloque4}};
                 pieza = forma;
                 nombre = "L";
                 break;
            case 1:
                Bloque[][] forma2 = {{bloque1}, {bloque2}, {bloque3}, {bloque4}};
                pieza = forma2;
                nombre = "Línea recta";
                break;
            case 2:
                Bloque[][] forma3 = {{bloque1, null}, {bloque2, bloque3}, {bloque4, null}};
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

    /**
     * Metodo fijo que se encarga de rotar la pieza a noventa grados en sentido horario.
     * la formula para rotar los bloques noventa grados es la siguiente: nuevo[j][fil - 1 - i] = pieza[i][j];. fil no es mas que pieza.length, i.e. la longitud de la pieza.
     */
    public void rotarPieza(){
        int fil = pieza.length;
        int col = pieza[0].length;
        Bloque [][] nuevo = new Bloque[col][fil];

        for(int i = 0; i < fil; i++){
            for(int j = 0; j < col; j++){
                if(pieza[i][j] != null)
                nuevo[j][fil - 1 - i] = pieza[i][j];
            }
        }
        pieza = nuevo;
    }

    public void rotarPiezaSinBugs(Tablero tablero){

        Bloque[][] original = copiarBloque(this.pieza);
        rotarPieza();
        int fila = this.fila;
        int col = this.columna;

        if (tablero.colisionoPieza(this, fila, col)) {

            this.columna++;
            if (!tablero.colisionoPieza(this, fila, this.columna)) {
                return;
            }
            this.columna -= 2; 
            if (!tablero.colisionoPieza(this, fila, this.columna)) {
                return;
            }
            this.columna++; // volver a posicion original
            this.pieza = original;
        }
    }
    //HACER JAVADOC
    public Bloque[][] copiarBloque(Bloque[][] matriz) {
        Bloque[][] copia = new Bloque[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                copia[i][j] = matriz[i][j];
            }
        }
        return copia;
    }

}