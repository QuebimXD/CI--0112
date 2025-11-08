import java.util.Scanner;

public class Juego{
    private Scanner sc;
    private Tablero tablero;
    private ArbolColores arbol;

    /*
     * Constructor de clase Juego. Inicializa el tablero, el arbol con la lista de los colores junto a una frecuencia inicial de cero, y el escaner.
     */
    public Juego(){
        tablero = new Tablero();
        arbol = new ArbolColores(p.getColores());
        sc = new Scanner(System.in);

    }

    /**
     * Metodo que inicia y controla el  flujo del juego en la consola, tiene la siguiente logica:
     * Genera una pieza aleatoria de las cuatro declaradas en Pieza. Le permite al usuario realizar movimientos con la pieza (incluyendo la rotacion), manejando el cuidado de las colisiones.
     * Actualiza el tablero, muestra el puntaje actual del tablero justo despues de que se realice un movimiento.
     * Verifica si la pieza colisiona o ha llegado a los limites del tablero; si no, se puede mover; si si, vuelve a crearse una pieza nueva.
     * Termina la partida si el tablero esta lleno (Es decir, no se pueden poner mas piezas), y muestra el puntaje final.
     */

    // POR HACER: piezaColisiono(Pieza pieza), rotarPieza(), moverPieza(Pieza pieza, String mov), tablero.tableroLleno(), tablero.getPuntajeFinal()
    public void jugar(){
        boolean jugando = true;
        while(jugando){

            //Sacamos una nueva pieza
            Pieza pieza = new Pieza();

            //Logica del movimiento, hasta que la pieza no haya tocado otras piezas, se seguiria moviendo la misma

            while(!piezaColisiono(pieza)){ //Hacer metodo que verifique esta colision
                
                tablero.actualizarTablero();
                System.out.println("###########\n" + "Puntaje actual: " + tablero.getPuntajeFinal()  + "\n###########");

                tablero.actualizarTablero();
                
                String mov = movimientoUsuario();
                if(mov.equals("r")){
                    pieza.rotarPieza();
                }else{
                    tablero.moverPieza(pieza, mov); //Por hacer
                }
                

                //Si el usuario ya no puede seguir se acaba la partida
                if(tablero.tableroLleno() ){
                    System.out.println("Perdiste :(");
                    jugando = false;
                }
            }

        }
        System.out.println("Puntaje final= " + tablero.getPuntajeFinal());

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
        return 0;
    }
}