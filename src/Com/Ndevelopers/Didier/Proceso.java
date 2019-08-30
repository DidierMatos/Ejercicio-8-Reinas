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

        String input[] = {"0-0","1-1","1-2","3-8","4-6","5-3","6-7","7-2","8-4"};
        int tablero[][] = new int[8 + 1][8 + 1];
        
        String x,y;
        int num_x,num_y, tamano_tab = 8;
        private int contador_reinas = 0;

        public void Principal() { 

            Algoritmo(tablero);

            Imprime(tablero);

        }
    
        public void Algoritmo(int tab[][] ){    
            
            int status = 1;                      

            for(int num = 1; num<input.length;num++){
                String[] xy = input[num].split("-");
                x = xy[0];
                y = xy[1];
                num_x = Integer.parseInt(x);
                num_y = Integer.parseInt(y);
                
                //System.out.println(x + " " + y);
                
                
                if ( tab[num_x][num_y] == 0 ) {   
               
                    for ( int i = 1; i <= tamano_tab; i++ ){
                        for ( int j = 1; j <= tamano_tab; j++ ) { 

                            if ( tab[i][j]  != 0) {  //Evalua que no exista cero al recorrer, es decir ubica una reina cercana
                            // Evalua si la reina ataca en misma columna o fila
                                if ((( num_x == i) || (num_y == j ))  || (Math.abs(num_x - i) == Math.abs(num_y - j )) ) {

                                status = 0;
                                break;
                                }
                            }
                        } 
                    }

                } else{
             
                    
                    status = 0;

                    break;
                }
                
                if ( status == 0){
                    System.out.println("Fallaste con los numeros" + num_x + "  " + num_y);
                }else{
                    //System.out.println("No fallastes");
                    tablero[num_x][num_y] = ++contador_reinas; //registra el numero de reina en la posicion
              }
                
                
            }
            
            



        }

        public void Imprime(int tablero_final[][]) {      
            
            for ( int k = 1; k <= tamano_tab; k++ ) {
                for ( int j = 1; j <= tamano_tab; j++) {
                    System.out.printf("%5d", tablero_final[k][j]);
                } 
                System.out.println("\n");
            }

        }
    
    }



