import java.util.Scanner;

public class Juego{
    private Scanner sc;
    private Tablero tablero;
    private ArbolColores arbol;

    public Juego(){
        tablero = new Tablero();
        Pieza p = new Pieza();
        arbol = new ArbolColores(p.getColores());
        sc = new Scanner(System.in);

    }


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
                    pieza.rotarPieza(); //Por hacer 
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