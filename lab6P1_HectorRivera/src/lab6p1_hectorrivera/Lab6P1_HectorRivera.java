
package lab6p1_hectorrivera;

import java.util.Random;
import java.util.Scanner;


public class Lab6P1_HectorRivera {
    
    static Scanner sc = new Scanner(System.in);
    static Scanner scS = new Scanner(System.in);
    
    static Random rd = new Random();
    
    public static void main(String[] args) {
        System.out.println("------------------Menu------------------");
        System.out.println("1. Ejercicio práctico 1 – Conjuntos\n2. Ejercicio práctico 2 – ¿Cuántos primos tienes?\n3. Salir");
        int opc = sc.nextInt();
        while(opc!=3){
            switch(opc){
                case 1:{
                    System.out.println("Size set1: ");
                    int s1 =sc.nextInt();
                    mayor(s1);
                    char[] set1 = new char [s1];
                    genRandCharArray(set1);
                    System.out.println("Set1: ");
                    print(set1);

                    System.out.println("Size set2: ");
                    int s2 =sc.nextInt();
                    mayor(s2);
                    char[] set2 = new char[s2];
                    genRandCharArray(set2);
                    System.out.println("Set2: ");
                    print(set2);
                    
                    System.out.println("\nOpciones\n1.Intersecion\n2.differencia");
                    int opc2 = sc.nextInt();
                    while(opc2>3 && opc2<0){
                        System.out.println("Ingrese una opcion correcta: ");
                        opc2 = sc.nextInt();
                    }
                    switch(opc2){
                        case 1:{
                            int size=0;
                            char[] inter=new char[size(set1,set2,size)];
                            intersection(set1,set2,inter);
                            System.out.println("Interseciones: ");
                            for (int i = 0; i < inter.length-1; i++) {
                                if(inter[i]!=inter[i+1]){
                                System.out.print("["+inter[i]+"]");
                                }
                            }
                            System.out.println();


                        }break;
                        case 2:{
                            int size=set1.length+set2.length;
                            char[] dif=new char[size];
                            dif(set1,set2,dif);
                            System.out.println("Differencia: ");
                            for (int i = 0; i < dif.length-1; i++) {
                                if(dif[i]!=dif[i+1]&& dif[i]!=0 ){
                                System.out.print("["+dif[i]+"]");
                                }
                            }
                            System.out.println();    
                        }break;
                    }  
                }break;
                
                case 2:{
                    System.out.println("Ingrese el tamaño a genrar: ");
                    int size = sc.nextInt();
                    
                    while(size<=0){
                        System.out.println("Ingrese un numero valido mayor que 0: ");
                        size = sc.nextInt();
                    }   
                    int [] randAr = new int[size];
                    
                    System.out.println("Ingrese el limite inferior: ");
                    int min = sc.nextInt();
                    System.out.println("Ingrese el limite superior: ");
                    int max = sc.nextInt();
                    System.out.println();
                    while(min>max){
                        System.out.println("Error ingrese un rango valido");
                        System.out.println("Ingrese el limite inferior: ");
                        min = sc.nextInt();
                        System.out.println("Ingrese el limite superior: ");
                        max = sc.nextInt();
                        System.out.println( );
                    }
                    genRandArray(randAr,max,min);
                    for (int i = 0; i < randAr.length; i++) {
                        System.out.print("["+randAr[i]+"]");
                    }
                    System.out.println();
                    int[] rand = new int[size];
                    
                    getTotalPrimeCount(randAr,rand);
                    
                    for (int i = 0; i < rand.length; i++) {
                        System.out.print("["+rand[i]+"]");
                    }
                    System.out.println();
                }break;
                
                default:
                    System.out.println("Ingrese un valor permitido");
            }//switch
            System.out.println("------------------Menu------------------");
            System.out.println("1. Ejercicio práctico 1 – Conjuntos\n2. Ejercicio práctico 2 – ¿Cuántos primos tienes?\n3. Salir");
            opc = sc.nextInt();
        }// fin while
    }// fin main
    

    public static int mayor(int integer){
        while (integer<=0){
            System.out.println("Intoduzca un valor valido mayor que 0");
            integer = sc.nextInt();
        }
        return integer;
    }// fin mayor
    public static void print (char arreglo[]){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("["+arreglo[i]+"]");
        }
        System.out.println("");
    }// fin print
    
    //Metodos ejercicio 1
    public static char[] genRandCharArray(char arreglo[]){
        for (int i = 0; i < arreglo.length; i++) {
            int rand = rd.nextInt(7)+65; 
            arreglo[i] =(char)rand;
        }
        
        return arreglo;   
    }// fin genRand
    
    public static char[] intersection(char[] set1, char[] set2,char[] inter){
        int cont=0; 
        for (int i = 0; i < set1.length; i++) {
            for (int j = 0; j < set2.length; j++) {
                if(set1[i]==set2[j]){
                    inter[cont]= set1[i];
                    cont++; 
                }
            }
        }// fin for
        return inter;
    }
    public static char[] dif(char[] set1, char[] set2,char[] dif){
        int cont=0;
        boolean ver=true;;
        for (int i = 0; i < set1.length; i++) {
            ver=true;
            for (int j = 0; j < set2.length; j++) {
                if(set1[i]==set2[j]){
                    ver=false;
                }      
            }
            if (ver) {
                dif[cont] = set1[i]; 
                cont++;
            }
        }// fin for
        return dif;
    }
    public static int size(char[] set1, char[] set2, int size){
        for (int i = 0; i < set1.length; i++) { 
            for (int j = 0; j < set2.length; j++) {
                if(set1[i]==set2[j]){
                    size++; 
                }
            }
        }// fin for
        return size;
    }
    
//Metodos ejercicio 2
    public static int[] genRandArray(int[] randAr,int max, int min){
        for (int i = 0; i < randAr.length; i++) {
            randAr[i] = rd.nextInt((max-min)+1)+min;
        }
        return randAr;
    }
    public static boolean isPrime (int entero){
        boolean prime;
        if (entero%2==0) {
            prime = false;
        }else{
            prime = true;
        }
        return prime;
    } 
    public static int countPrimeFactors(int entero){
        int cont=0;
        for (int i = 0; i < entero; i++) {
            if(isPrime(i)){
                if(entero%i==0){
                    cont++;
                }
            }
        }
        return cont;
    }
    public static int[] getTotalPrimeCount(int[] randAr,int[]rand){
        for (int i = 0; i < randAr.length; i++) {
            rand[i]=countPrimeFactors(randAr[i]);
        }
        return rand;
    }
}
