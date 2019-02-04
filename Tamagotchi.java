package tamagochi;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author thibault
 */
public class Tamagotchi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tama tamagotchi = new Tama();
        boolean gameOver = false;
        boolean timer = true;
        boolean mort = false;
        while (gameOver == false) {
            tamagotchi.eclore();
            while (timer) {
                LocalTime debut = LocalTime.now();
                while (mort == false) {
                    System.out.println();
                    tamagotchi.afficheStatus();
                    tamagotchi.choixActivitees();
                    if (tamagotchi.checkMort(mort) == true) {
                        mort = true;
                        break;
                    }
                    LocalTime fin = LocalTime.now();
                    Duration chrono = Duration.between(debut, fin);
                    if (chrono.toMinutes() > 3) {
                        tamagotchi.finDeTour();
                        break;
                    }
                }
                if (mort == true) {
                    break;
                }
            }
        }
    }
}
