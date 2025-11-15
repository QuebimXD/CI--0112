public class MatrizComida {
    private int [][] comida;
    private int[] filas;
    private int[] columnas;

    public MatrizComida(){
        comida = new int[1000][1000];
        int [] filas = {0, -1, -1, -1, 0, 1, 1, 1};
        int [] columnas = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int i = 0; i < 200; i++){
            int x = (int) (Math.random() * 1000);
            int y = (int) (Math.random() * 1000);
            if (comida[x][y] == 0){
                comida[x][y] = 1;
            }
            for (int j = 0; j < 8; j++){
                int dx = x + filas[j];
                int dy = y + columnas [j];
                if ( dx > 0 && dx < 8 && dy > 0 && dy < 8){
                    if(matriz[])
                }
            }
            int dx = 
        }
    }
}
