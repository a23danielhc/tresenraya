package motor3R;

public class TresEnRaya {
   
    private String[][] tablero = new String[3][3];
    private String valorCheck;
    private boolean gana;

    public TresEnRaya(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                tablero[i][j] = "_";
            }
        }
        gana = false;
    }

    public String[][] getTablero(){
        return tablero;
    }

    public boolean cambiarValorJugador(int filaJugador, int columnaJugador){
        if (!tablero[filaJugador][columnaJugador].equals("_")){
            return false;
        } else {
            tablero[filaJugador][columnaJugador] = "X";
        }
        if (alguienGano(filaJugador, columnaJugador)){
            return true;
        } else {return false;}
    }

    public boolean cambiarValorMaquina(int filaMaquina, int columnaMaquina, int dificultad){
        if (dificultad == 1) {
            filaMaquina = (int)(Math.random() * 3); // Generate random value within the valid range of the game board
            columnaMaquina = (int)(Math.random() * 3); // Generate random value within the valid range of the game board
            if (!tablero[filaMaquina][columnaMaquina].equals("_")){
                cambiarValorMaquina(filaMaquina, columnaMaquina, dificultad); // Pass the correct arguments to the recursive call
            } else {
                tablero[filaMaquina][columnaMaquina] = "O";
            }
            if (alguienGano(filaMaquina, columnaMaquina)){
                return true;
            } else {return false;}
        }
        //TO-DO: Implementar la lógica para los niveles de dificultad 2 y 3.
        else {
            return false;
        }
    }

    public boolean alguienGano(int fila, int columna){
        valorCheck = tablero[fila][columna];
        // Comprobar si ha ganado en la fila
        for (int i = 0; i < 3; i++){
            if (!tablero[fila][i].equals(valorCheck)){
                break;
            }
            if (i == 2){
                gana = true;
            }
        }
        // Comprobar si ha ganado en la columna
        for (int i = 0; i < 3; i++){
            if (!tablero[i][columna].equals(valorCheck)){
                break;
            }
            if (i == 2){
                gana = true;
            }
        }
        // Comprobar si ha ganado en la diagonal
        if (fila == columna){
            for (int i = 0; i < 3; i++){
                if (!tablero[i][i].equals(valorCheck)){
                    break;
                }
                if (i == 2){
                    gana = true;
                }
            }
        }
        // Comprobar si ha ganado en la diagonal inversa
        if (fila + columna == 2){
            for (int i = 0; i < 3; i++){
                if (!tablero[i][2-i].equals(valorCheck)){
                    break;
                }
                if (i == 2){
                    gana = true;
                }
            }
        }
        if (gana){
            return true;
        } else {
            return false;
        }
    }
}
