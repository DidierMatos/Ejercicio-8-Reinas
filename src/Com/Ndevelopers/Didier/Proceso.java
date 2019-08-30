package Com.Ndevelopers.Didier;

import java.util.Scanner;
 import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author DidierMatos
 */

    public class Proceso {

        String input[] = {"0-0","1-5","2-7","4-8","3-6","7-1","5-3","6-4","8-4"};
        int tablero[][] = new int[8 + 1][8 + 1];
        
        String x,y;
        int num_x,num_y;

        public void Principal() { 

            Algoritmo(tablero);

            Imprime(tablero);

        }
    
        public void Algoritmo(int tab[][] ){    
                                
            for(int num = 1; num<input.length;num++){
                String[] xy = input[num].split("-");
                x = xy[0];
                y = xy[1];
                num_x = Integer.parseInt(x);
                num_y = Integer.parseInt(y);
                
                System.out.println(x + " " + y);
            }



        }

        public void Imprime(int tablero_final[][]) {      


        }
    
    }



