/*
 * Clase tipo controlador de tablero
 * @ RodrigoLovers
 * @version 1.0
 */

public class Tablero {
    private String[][] tablero;
    private Pieza pieza; // referencia a la pieza que va cayendo
    private ArbolColores arbolColor;
    private int fila; 
    private int col;
    private int puntajePorFila; 
    private int puntajeFinal;
    private int contadorDominante;
    private String [] colores; 

    public Tablero(){
        tablero = new String[20][10];
        pieza = new Pieza();
        colores = pieza.getColores();
        contadorDominante = 0;
        iniciarTablero();
        //actualizarTablero();
    }

    public boolean colisionoPieza(Pieza pieza, int x, int y){
            for (int i = 0; i < pieza.getPieza().length; i++) {
                for (int j = 0; j < pieza.getPieza()[i].length; j++) {
                    Bloque bloque = pieza.getPieza()[i][j];
                    if (bloque != null) {
                    int filaB = x + i;
                    int colB = y + j;
                    if (filaB < 0 || filaB >= tablero.length || colB < 0 || colB >= tablero[0].length)
                        return true; // Se sale del tablero
                    if (!tablero[filaB][colB].equals("-"))
                        return true; // Choca con algo
                    }
                }
            }
        return false;
    }

    public void agregarPieza(Pieza pieza, int x, int y){
            for (int i = 0; i < pieza.getPieza().length; i++) {
                for (int j = 0; j < pieza.getPieza()[i].length; j++) {
                    Bloque bloque = pieza.getPieza()[i][j];
                    if(bloque != null){
                        int filaB = x + i; 
                        int colB = y + j;
                        if(filaB >= 0 && colB >= 0 && filaB < tablero.length && colB < tablero[0].length){
                            tablero[filaB][colB] = bloque.getColor();
                        }
                    } 
                }
            }
        this.pieza = new Pieza();
        for (int f = 0; f < tablero.length; f++) {
            if (verificarFilallena(f)) {
            eliminarFila(f);
             }   
        }
    }
    public void moverPieza(Pieza pieza, String movimiento){
        int fila = pieza.getFila();
        int col = pieza.getColumna();
        switch(movimiento){
            case "d": 
                col++;
                fila++;
                break;
            case "a":
                col--;
                fila++;
                break;
            case "s":
                fila++;
                break;
            default: 
                break;
        }
        if(colisionoPieza(pieza, fila, col)){
            int filaFinal =pieza.getFila();
            int colFinal = pieza.getColumna();
            agregarPieza(pieza, filaFinal, colFinal);
        }else{
            pieza.setFila(fila);
            pieza.setColumna(col);
        }
    }
    
    public int calcularFrecuenciaColorFila(String color, int fila){
        int contador = 0; 
        for (int i = 0; i < tablero[0].length; i++){
                if(tablero[fila][i].equals("color")){
                    contador++;
                }
        }
        return (int)(contador / 100);
    }

    public boolean verificarFilallena(int fila){
        boolean filaLlena = true;
        for(int i = 0; i < tablero[fila].length; i++){
            if(tablero[fila][i] == null || tablero[fila][i] == "-"){
                filaLlena = false;
            }
        }
        return filaLlena;
    }
    public void eliminarFila(int fila){
        if(verificarFilallena(fila)){
            eliminarFilaR(fila);
        }
    }
    private void eliminarFilaR(int fila){
        if(fila == 0){
            for(int i = 0; i < tablero[0].length; i++){
                tablero[fila][i] = "-";
            }
            return;
        }
            for(int i = 0; i < tablero[fila].length; i++){
                int nuevaFila = fila -1; 
                    tablero[fila][i] = tablero[nuevaFila][i];
            }
            eliminarFila(fila-1);
    }
    public int calcularPuntajePorFila(int fila){
        this.fila = fila;
        puntajePorFila = 0;
        String colorDominante = "";
        contadorDominante = 0;
        if (verificarFilallena(fila)){
            colorDominante = getColorDominante(colores[0], 0, colores[0]);
            puntajePorFila = arbolColor.posicionColor(colorDominante);
        }
        puntajeFinal += puntajePorFila;
        return puntajePorFila;
    }
    public String getColorDominante(String color, int indice, String mejorColor){
                int contador = 0;
                for (int i = 0; i < tablero[fila].length; i++){
                    if(tablero[fila][i].equals(color) && tablero[fila][i] != null){
                        contador++;
                    }
                }
                if(contador > contadorDominante){
                    contadorDominante = contador; 
                    mejorColor = color;
                }
                if(indice == colores.length - 1){
                    return mejorColor;
                }
                if(indice + 1 < colores.length){
                color = colores[indice + 1];
            }
        return getColorDominante(color, indice + 1, mejorColor);
    }
    public int getPuntajeFinal(){
        return puntajeFinal;
    }

    public void actualizarTablero(Pieza pieza) {
    String[][] copia = new String[tablero.length][tablero[0].length];

    // Copiamos el tablero actual
    for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero[0].length; j++) {
            copia[i][j] = tablero[i][j];
        }
    }

    // Dibujamos la pieza temporalmente (con colores y *)
    for (int i = 0; i < pieza.getPieza().length; i++) {
        for (int j = 0; j < pieza.getPieza()[i].length; j++) {
            Bloque b = pieza.getPieza()[i][j];
            if (b != null) {
                int fila = pieza.getFila() + i;
                int col = pieza.getColumna() + j;
                if (fila >= 0 && fila < tablero.length && col >= 0 && col < tablero[0].length) {
                    copia[fila][col] = pieza.getColorAnsi(b.getColor()) + "*" + "\u001B[0m";
                }
            }
        }
    }

    // Imprimimos la copia
    for (int i = 0; i < copia.length; i++) {
        for (int j = 0; j < copia[0].length; j++) {
            String celda = copia[i][j];
            if (celda == null || celda.equals(" ")) {
                System.out.print("  ");
            } else {
                System.out.print(celda);
            }
        }
        System.out.println();
    }
}

    public void iniciarTablero(){
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[0].length; j++){
                tablero[i][j] = "-";
            }
        }
    }
}