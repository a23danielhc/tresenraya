import motor3R.TresEnRaya;

import java.util.Scanner;

public class InterfaceConsola {

    private TresEnRaya tablero;
    private Scanner sc;
    private int fila;
    private int columna;
    int dificultad = 1;

    InterfaceConsola(){
        tablero = new TresEnRaya();
        sc = new Scanner(System.in);
        presentarjuego();
        turnoJugador();
    }

    private void mostrarTablero(){
        System.out.println("Estado actual del tablero:");
        String[][] tablero = this.tablero.getTablero();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(tablero[i][j]);
                if (j == 0 || j == 1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    private void presentarjuego(){
        System.out.println("Bienvenido al juego de 3 en raya");
        mostrarTablero();
        System.out.println("Selecciona la dificultad del juego: ");
        System.out.println("1. Fácil");
        System.out.println("2. Intermedio");
        System.out.println("3. Difícil");
        dificultad = sc.nextInt();
    }

    private void turnoJugador(){
        System.out.println("Turno del jugador...");
        System.out.print("Introduce la fila: ");
        fila = sc.nextInt();
        System.out.print("Introduce la columna: ");
        columna = sc.nextInt();
        if (tablero.cambiarValorJugador(fila-1, columna-1)){
            mostrarTablero();
            System.out.println("Has ganado");
            return;
        } else {
            mostrarTablero();
            turnoMaquina();
        }

    }

    private void turnoMaquina(){
        System.out.println("Turno de la máquina...");
        if (tablero.cambiarValorMaquina(fila, columna, dificultad)){
            mostrarTablero();
            System.out.println("La máquina ha ganado");
            return;
        } else {
            mostrarTablero();
            turnoJugador();
        }
    }

    public static void main(String[] args) {
        new InterfaceConsola();
    }
}
