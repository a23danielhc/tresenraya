package motor3R;

import javax.management.ConstructorParameters;

/**
 * Clase que implementa la lógica del juego de 3 en raya
 */
public class TresEnRaya {
   
    private String[][] tablero = new String[3][3];
    private String valorCheck;
    private boolean gana;

    /**
     * Constructor de la clase TresEnRaya
     */
    public TresEnRaya(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                tablero[i][j] = "_";
            }
        }
        gana = false;
    }

    /**
     * Método para obtener el tablero del juego
     * @return Devuelve el tablero del juego
     */
    public String[][] getTablero(){
        return tablero;
    }

    /**
     * Método para cambiar el valor de una casilla del tablero por parte del jugador
     * @param filaJugador: Fila en la que el jugador desea colocar su ficha
     * @param columnaJugador: Columna en la que el jugador desea colocar su ficha
     * @return Devuelve true si la máquina ha ganado la partida, false en caso contrario
     */
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

    /**
     * Método para cambiar el valor de una casilla del tablero por parte de la máquina
     * @param filaMaquina: Fila en la que la máquina desea colocar su ficha
     * @param columnaMaquina: Columna en la que la máquina desea colocar su ficha
     * @param dificultad: Nivel de dificultad del juego
     * @return Devuelve true si la máquina ha ganado la partida, false en caso contrario
     */    
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
    
    /**
     * Método para comprobar si alguien ha ganado la partida partiendo de la posición en que se colocó la última ficha para evitar comparar todo el tablero
     * @param fila: Fila en la que se ha colocado la última ficha
     * @param columna: Columna en la que se ha colocado la última ficha
     * @return Devuelve true si alguien ha ganado la partida, false en caso contrario
     */
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
