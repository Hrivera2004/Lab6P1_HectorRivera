
package s6_areglos_hectorrivera;

import java.util.Random;
import java.util.Scanner;


public class S6_Areglos_HectorRivera {
    
    
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    
    
    
    public static void main(String[] args) {
        System.out.println("------------Menu------------");
        System.out.println("1.Arreglo Scanner\n2.Areglo random\n3.encontrar el menor\n4.Suma entre arreglos \n5.Salir del programa");
        int opc = sc.nextInt();
        
        System.out.println("Ingrese un tamaño para el arrgelo");
        int size = sc.nextInt();
        int [] arg1= new int[size];
        ;
        int numeros [] = new int [size];
        
        
        while (opc !=5){
            switch(opc){
                case 1:{
                    arg1 = leer_scanner(size);  
                    print(arg1);
                    System.out.println("La suma es: "+sumar(arg1));
                }break;
                    
                case 2:{
                    arg1 = leer_random(size);
                    print(arg1);
                }break;
                
                case 3:{
                    arg1 = leer_random(size);
                    print(arg1);
                    System.out.println("El menor es: " + menor(arg1));
                }break;
                
                case 4:{
                    arg1 = leer_scanner(size);
                    int[] arg2 = new int[size];
                    arg2 = leer_random(size);
                    suma(arg1,arg2,size);
                    print(arg1);
                    
                }break;
                
                default:
                    System.out.println("Ingrese un valor valido");
                    System.out.println("1.Metodo bubble \n5.Salir del programa");
                    opc = sc.nextInt();
            }
        System.out.println("------------Menu------------");
        System.out.println("1.Arreglo Scanner\n2.Areglo random\n3.encontrar el menor\n4.Suma entre arreglos \n5.Salir del programa");
        opc = sc.nextInt();
        
        System.out.println("Ingrese un tamaño para el arrgelo");
        size = sc.nextInt();
        arg1= new int[size];
        }
        
    }
    public static int[] suma (int[] arg1,int[] arg2,int size){
        int[] temporal = new int[size];
        for (int i = 0; i < arg1.length; i++) {
            temporal[i]= arg1[i] + arg2[i];
            System.out.println(arg1[i]+" + "+arg2[i]+" = "+temporal[i]);
        }
        return temporal;
    }
    public static int[] leer_random(int size){
        int[] temporal = new int[size];
        for (int i = 0; i < temporal.length; i++) {
            temporal[i]=rd.nextInt(19)+1;
        }  
        return temporal;
    }
    
    public static int[] leer_scanner(int size){
        int[] temporal = new int[size];
        for (int i = 0; i < temporal.length; i++) {
            temporal[i]=sc.nextInt();
        }  
        return temporal;
    }
    public static void print(int[] arg1){
        for (int i = 0; i < arg1.length; i++) {
             System.out.println("pos: "+i+" = "+arg1[i]);
        }
    }
    public static int sumar(int arreglo []){
        int sum = 0;
        for (int i = 0; i < arreglo.length; i++) {
            sum += arreglo[i];
        }
        return sum;
    }
    public static int menor(int arreglo[] ){
        int menor = arreglo[0];
        for (int j = 0; j < arreglo.length; j++) {
            int num = arreglo[j];
                if(num<menor){
                    menor=num;
                }
        }
        return menor;
    }
}
