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

        String arr_input[] = new String[8 + 1];
        int arr_tablero[][] = new int[8 + 1][8 + 1];
        
        String[] arr_con_parentesis;
        String[] arr_sin_parentesis = new String[8 + 1];
        
        String[] xy;
        String x,y;
        //String[] xy2;
        //String x2,y2;
        
        int num_x,num_y, tamano_tab = 8, atacante_x, atacante_y;
        private int contador_reinas = 0;
        
        int text_input;
        String valor_ingresado;
        //String valor_ingresado_estatico = "[\"(1,1)\",\"(2,5)\",\"(3,8)\",\"(4,6)\",\"(5,3)\",\"(6,7)\",\"(7,2)\",\"(8,4)\"]";
        Scanner input_coordenadas = new Scanner(System.in);
        //["(1,1)","(2,5)","(3,8)","(4,6)","(5,3)","(6,7)","(7,2)","(8,4)"]
        
        Boolean reiniciar = true;

        public void Principal() { 
            
            while(reiniciar){
            
                System.out.print("\n-------------------------Problema de las 8 Reinas.-------------------------------- \nREGLAS: "
                        + "\n1.- Recuerda como se imprime un arreglo, es de izquierda a derecha (te ayudara a ubicar correctamente)"
                        + "\n2.- Mantener el formato como este : [\"(1,1)\",\"(2,5)\",\"(3,8)\",\"(4,6)\",\"(5,3)\",\"(6,7)\",\"(7,2)\",\"(8,4)\"]\n");

                System.out.print("\nPorfavor ingresa 8 posiciones respetando el formato: ");

                 //text_input = input_coordenadas.nextInt();
                  //valor_ingresado = Integer.toString(text_input);
                  //input[] = {valor_ingresado};

                valor_ingresado = input_coordenadas.next(); 
                //System.out.println(valor_ingresado);

                try {

                    String expSubString = valor_ingresado.substring(2,63);


                    //System.out.println(expSubString);

                    arr_con_parentesis = expSubString.split ("\",\"");
                    String part1 = arr_con_parentesis[0];
                    //System.out.println(part1);



                    /*for(int i=0; i<con_parentesis.length;i++){

                        sin_parentesis[i+1] = con_parentesis[i];

                        String a = sin_parentesis[i+1].substring(1,4);

                        String[] xy = a.split(",");
                        x = xy[0];
                        y = xy[1];

                        //System.out.println(x2+y2);
                        //if(i != 0){
                            //input[i] = x + "-" + y;
                            //System.out.println(input[i]);
                        //}


                        //System.out.println(parts[i].substring(1,4));
                        //parts2.add(parts[i].substring(1,4));
                    }*/

                    //for(int i=0; i<parts2.size();i++){
                        //System.out.println(parts2.get(i).toString());
                    //}

                    System.out.print("\n");

                    reiniciar = false;
                    Algoritmo(arr_tablero);
                    Imprime(arr_tablero);
                    
                    if(contador_reinas == 8){
                     System.out.println("------------------¡FELICIDADES GANASTE!------------------");
                    }



                }catch(Exception ex){
                    System.out.println("      ¡¡PORFAVOR AGREGA UN FORMATO SIMILAR AL REGLAMENTO!!     ");
                }
            }

        }
    
        public void Algoritmo(int tab[][] ){    
            
            int status = 1;                      

            for(int num=0; num<arr_con_parentesis.length;num++){
                
                arr_sin_parentesis[num+1] = arr_con_parentesis[num];
                
                String a = arr_sin_parentesis[num+1].substring(1,4);
                
                String[] xy = a.split(",");
                x = xy[0];
                y = xy[1];
                num_x = Integer.parseInt(x);
                num_y = Integer.parseInt(y);
                
                
                if ( tab[num_x][num_y] == 0 ) {   
               
                    for ( int i = 1; i <= tamano_tab; i++ ){
                        for ( int j = 1; j <= tamano_tab; j++ ) { 

                            if ( tab[i][j]  != 0) {  //Evalua que no exista cero al recorrer, es decir ubica una reina cercana
                            // Evalua si la reina ataca en misma columna o fila
                                if ((( num_x == i) || (num_y == j ))  || (Math.abs(num_x - i) == Math.abs(num_y - j )) ) {

                                    status = 2;
                                    atacante_x = i;
                                    atacante_y = j;
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
                    System.out.println("Fallaste con los numeros: " + num_x + "  " + num_y);
                }else if (status == 2){
                    System.out.println("La Reina en la posicion: " + "(" + atacante_x + "," + atacante_y + ")" + " Te ha derrotado, intenta cambiar la ubicacion: " + "("  + num_x + "," + num_y + ")");
                    System.out.println("\n");
                    break;
                }else{
                    //System.out.println("No fallastes");
                    arr_tablero[num_x][num_y] = ++contador_reinas; //registra el numero de reina en la posicion
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



