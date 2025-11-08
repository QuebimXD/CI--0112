import java.util.Scanner;

public class Juego{
    private Scanner sc;
    private Tablero tablero;
    private ArbolColores arbol;
    private Pieza p;

    /*
     * Constructor de clase Juego. Inicializa el tablero, el arbol con la lista de los colores junto a una frecuencia inicial de cero, y el escaner.
     */
    public Juego(){
        sc = new Scanner(System.in);
        p = new Pieza(); //Esta pieza solo para llamar a la lista de colores
    }

    /**
     * Metodo que inicia y controla el  flujo del juego en la consola, tiene la siguiente logica:
     * Genera una pieza aleatoria de las cuatro declaradas en Pieza. Le permite al usuario realizar movimientos con la pieza (incluyendo la rotacion), manejando el cuidado de las colisiones.
     * Actualiza el tablero, muestra el puntaje actual del tablero justo despues de que se realice un movimiento.
     * Verifica si la pieza colisiona o ha llegado a los limites del tablero; si no, se puede mover; si si, vuelve a crearse una pieza nueva.
     * Termina la partida si el tablero esta lleno (Es decir, no se pueden poner mas piezas), y muestra el puntaje final.
     */

    public void jugar(){

        boolean seguirJugando = true;
        while(seguirJugando){

            tablero = new Tablero();
            arbol = new ArbolColores(p.getColores());

            boolean juega = true;

            while(juega){

                //Sacamos una nueva pieza
                Pieza pieza = new Pieza();

                //Logica del movimiento, hasta que la pieza no haya tocado otras piezas, se seguiria moviendo la misma

                while(!tablero.colisionoPieza(pieza, pieza.getFila(), pieza.getColumna())){
                
                    tablero.actualizarTablero();
                    System.out.println("###########\n" + "Puntaje actual: " + tablero.getPuntajeFinal()  + "\n###########");
                    String mov = movimientoUsuario();

                    if(mov.equals("r")){
                        pieza.rotarPieza();
                    }else{
                        tablero.moverPieza(pieza, mov); //Por hacer
                    }
                
                    //Si el usuario ya no puede seguir se acaba la partida
                    if(tablero.colisionoPieza(pieza, pieza.getFila(), pieza.getColumna())){
                        System.out.println("Perdiste :(");
                        juega = false;
                        break; //Para el while de la colision
                    }
                }
                if(juega){
                    //Fijamos la pieza en donde se encuentre actualmente
                    tablero.agregarPieza(pieza, pieza.getFila(), pieza.getColumna());
                    //Eliminamos las filas llenas y hacemos la logica de ir calculando el puntaje
                    for(int f = 19; f >= 0; f--){
                        if(tablero.verificarFilallena(f)){
                            tablero.eliminarFila(f);
                            tablero.calcularPuntajePorFila(f);
                        }
                    }
                }
            }

            System.out.println("Puntaje final = " + tablero.getPuntajeFinal() + "\n");
            
            boolean ciclo = true;
            while(ciclo){
                try{
                    System.out.println("Quiere volver a jugar? s-si n-sno");
                    String r = sc.nextLine().trim().toLowerCase();
                
                    if(!(r.equals("s")) && !(r.equals("n"))){
                        System.out.println("Digite una opcion valida.");
                    }else if(r.equals("n")){
                        seguirJugando = false;
                        ciclo = false;
                        System.out.println("Termina partida. GG");
                    }else{
                        seguirJugando = true;
                        ciclo = false; //Si selecciona s entonces quiere volver a jugar
                    }
                }catch(Exception e){
                    System.err.println("Error ocurrido por: " + e);
                }
            }
        }
    }

    /**
     *Metodo que le pregunta al usuario que movimiento quiere realizar, w rota, a izquierda, d dereca, s va hacia abajo. Tambien maneja errores por si el ususario no ha digitado una leta de movimiento.
     *@ return la letra del movimiento seleccionada por el usuario.
     */
    private String movimientoUsuario(){
        String mov = null;
        boolean seguir = false;
        while(!seguir){
            try{
                System.out.println(" r-rotar, a-Izquierda, d-derecha, s-abajo ");
                mov = sc.nextLine().trim().toLowerCase();
                if((!mov.equals("r")) && (!mov.equals("a")) && (!mov.equals("d")) && (!mov.equals("s")) ){
                    System.out.println("Por favor realice un movimiento valido");
                    seguir = false;
                }else{
                    seguir = true;
                }
            }catch(Exception e){
                System.err.println("Error ocurrido por: " + e);
                seguir = false;
            }
        }
        return mov;
    }

    public int obtenerPuntaje(){
        return tablero.getPuntajeFinal();
    }
}