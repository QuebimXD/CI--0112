public class Tablero {
    private String[][] tablero;
    private Pieza pieza; // referencia a la pieza que va cayendo
    private ArbolColores arbolColor;
    private int fila; 
    private int col;
    private int puntajePorFila; 
    private int puntajeFinal;
    private int contadorDominante;

    public Tablero(){
        tablero = new String[20][10];
        iniciarTablero();
        actualizarTablero();
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

    public int calcularPuntajeFinal(){
        puntajePorFila = 0;
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