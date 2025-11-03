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
        colores = pieza.getColores();
        contadorDominante = 0;
        iniciarTablero();
        actualizarTablero();
    }

    public boolean sePuedeColocarPieza(Pieza pieza, int x, int y){
        return false;
    }

    public void agregarPieza(Pieza pieza, int x, int y){
        if(x > 0 && y > 0 && x< tablero.length && y < tablero[0].length){
            //tablero[x][y] == pieza.getForma();
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
        if(fila - 1 < 0){
            return;
        }
        if(verificarFilallena(fila)){
            for(int i = 0; i < tablero[fila].length; i++){
                int nuevaFila = fila -1; 
                    tablero[fila][i] = tablero[nuevaFila][i];
            }
            eliminarFila(fila-1);
        }
    }
    public int calcularPuntajePorFila(int fila){
        this.fila = fila;
        puntajePorFila = 0;
        String colorDominante = "";
        if (verificarFilallena(fila)){
            colorDominante = getColorDominante(colores[0], 0, 0, colores[0]);
            puntajePorFila = arbolColor.posicionColor(colorDominante);
        }
        puntajeFinal += puntajePorFila;
        return puntajePorFila;
    }
    public String getColorDominante(String color, int indice, int contador, String mejorColor){
        if(color.equals(colores[colores.length-1]) && contador >= contadorDominante){
            return color;
        } else if(color.equals(colores[colores.length - 1])){
            return mejorColor;
        } 
        else{
            color = colores[indice + 1];
            for (int i = 0; i < tablero[fila].length; i++){
                if(tablero[fila][i].equals(color)){
                    contador++;
                }
            }
            if(contador > contadorDominante){
                contadorDominante = contador; 
                mejorColor = color;
            }
        }
        return getColorDominante(color, indice + 1, contador, mejorColor);
    }
    public int calcularPuntajeFinal(){
        return puntajeFinal;
    }

    public void actualizarTablero(){
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[0].length; j++){
                System.out.print(tablero[i][j]);
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