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
    /**
     * Metodo que retorna si la pieza ha chocado o se ha salido del tablero
     * @param pieza la pieza que esta cayendo y queremos posicionar
     * @param x posición de la fila actual
     * @param y posición de la columna actual
     * @return true si se cumple alguna condición de choque, false en caso contrario
     */
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

    public boolean finalizaJuego(Pieza pieza){
        boolean estado = false; //no ha finalizado el juego
        int contador = 0;
        while(contador != pieza.getPieza().length){
            int fila = pieza.getPieza().length;
            if(tablero[contador][5].equals("-") && contador < fila){ 
                estado = false;
                contador++;
            }else if (contador == fila){
                estado = false;
            }else if(!tablero[contador][5].equals("-")){
                estado = true;
                contador = pieza.getPieza().length;
            }
        }

        return estado;
    }

    /**
     * Metodo que agrega la pieza al tablero en una posición fija si cumple ciertas condiciones
     * @param pieza la pieza que esta cayendo y queremos posicionar
     * @param x posición de la fila actual
     * @param y posición de la columna actual
     * 
     */
    public void agregarPieza(Pieza pieza, int x, int y){
            for (int i = 0; i < pieza.getPieza().length; i++) {
                for (int j = 0; j < pieza.getPieza()[i].length; j++) {
                    Bloque bloque = pieza.getPieza()[i][j];
                    if(bloque != null){
                        int filaB = x + i; 
                        int colB = y + j;
                        if(filaB >= 0 && colB >= 0 && filaB < tablero.length && colB < tablero[0].length){
                            tablero[filaB][colB] = pieza.getColorAnsi(bloque.getColor()) + "*" + "\u001B[0m";
                        }
                    } 
                }
            }
        this.pieza = new Pieza();
    }

    /**
     * Metodo que mueve la pieza hacia la izquierda, derecha o hacia abajo una posición.
     * @param pieza la pieza que esta cayendo y queremos posicionar
     * @param movimiento movimiento que se quiere realizar
     * 
     */
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
    
    /**
     * Metodo que retorna la frecuencia de un color en base a cuanto aparece en una fila
     * @param color color que queremos calcular
     * @param fila fila donde queremos calcular la frecuencia
     * @return la frecuencia de un color en específico
     */
    public int calcularFrecuenciaColorFila(String color, int fila){
        int contador = 0; 
        for (int i = 0; i < tablero[0].length; i++){
                if(tablero[fila][i].equals("color")){
                    contador++;
                }
        }
        return (int)(contador / 100);
    }

    /**
     * Metodo que retorna si una fila se encunetra llena de bloques

     * @param fila fila que queremos verificar
     * @return true si esta llena, falso si no es el caso
     */
    public boolean verificarFilallena(int fila){
        boolean filaLlena = true;
        for(int i = 0; i < tablero[fila].length; i++){
            if(tablero[fila][i] == null || tablero[fila][i].equals("-")){
                filaLlena = false;
            }
        }
        return filaLlena;
    }
    /**
     * Metodo que llama a un método recursivo de eliminar filas y verificar que la fila esté llena antes de llamarlo
     * @param fila fila que se necesita eliminar
     *
     */
    public void eliminarFila(int fila){
        if(verificarFilallena(fila)){
            eliminarFilaR(fila);
        }
    }
    /**
     * Metodo recursivo que elimina una fila llena y reemplaza esta fila con las que se encuentran arriba de ella
     * @param fila fila que se requiere eliminar
     *
     */
    private void eliminarFilaR(int fila){
        //Caso base: cuando llegamos a la primera fila
        if(fila == 0){
            System.out.println("Llegue");
            for(int i = 0; i < tablero[0].length; i++){
                tablero[fila][i] = "-";
            }
            return;
        }
            for(int i = 0; i < tablero[0].length; i++){
                int nuevaFila = fila -1; 
                    String temp = tablero[nuevaFila][i];
                    tablero[fila][i] = temp;
            }
            eliminarFilaR(fila-1);
    }
    /**
     * Metodo que calcula el puntaje de esa fila en base a su color dominante
     * @param fila fila que queremos calcular el puntaje
     * @return el cálculo de esa fila
     */
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
    /**
     * Metodo recursivo para encontrar el color que más se repite en una fila
     * @param color la pieza que esta cayendo y queremos posicionar
     * @param indice indica que posición de la lista de colores se está calculando
     * @param mejorColor guarda el contador encontrado más alto
     * @return nombre del color dominante
     */
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
        /**
     * Metodo que retorna el puntaje de todas las filas eliminadas
     * @return el puntaje final
     */
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
    /**
     * Metodo que inicializa el tablero como vacío para empezar el juego
     * 
     */
    public void iniciarTablero(){
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[0].length; j++){
                tablero[i][j] = "-";
            }
        }
    }
}