package com.openbootcamp;

import java.io.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println(reverse("Hola mundo"));

        //1
        String[] uni = {"Oso", "Tigre", "Delfin", "Leon"};
        recorrerUni(uni);

        //2
        Integer[][] bi = new Integer[2][3];
        bi[0][0]=1;
        bi[0][1]=2;
        bi[0][2]=3;
        bi[1][0]=4;
        bi[1][1]=5;
        bi[1][2]=6;
        recorrerBi(bi);

        //3
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.remove(1);
        vector.remove(2);
        System.out.println(vector);

        //4
        //en un overload se duplicaria la capacidad y ocuparia mucha memoria.

        //5
        ArrayList<String> arrayL = new ArrayList<>();
        arrayL.add("Perro");
        arrayL.add("Mono");
        arrayL.add("Tucan");
        arrayL.add("Caballo");
        LinkedList<String> linkedL = new LinkedList<>();
        linkedL.add("Perro");
        linkedL.add("Mono");
        linkedL.add("Tucan");
        linkedL.add("Caballo");
        recorrerArrayLinked(arrayL, linkedL);

        //6
        ArrayList<Integer> intList = new ArrayList<>();
        rellenar(intList);

        //7
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Numerador: ");
        int numerador = scanner1.nextInt();
        System.out.print("Denominador: ");
        int denominador = scanner1.nextInt();
        DividePorCero(numerador, denominador);

        //8
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Texto para copiar: ");
        String copiar = scanner2.next();
        System.out.print("Texto en donde pegar: ");
        String pegar = scanner2.next();
        copiarYPegar(copiar, pegar);
    }
    public static String reverse(String text){
        String txet = "";
        for(int i = text.length()-1; i>=0; i--){
            txet = txet + text.charAt(i);
        }
        return text + " = " + txet;
    }
    public static void recorrerUni(String[] uni){
        for(int i = 0; i < uni.length; i++){
            System.out.println(uni[i]);
        }
    }
    public static void recorrerBi(Integer[][] bi){
        for(int i = 0; i < bi.length; i++){
            for(int j = 0; j < bi[i].length; j++){
                System.out.println("el array en [" + i +"][" + j +"] es " + bi[i][j]);
            }
        }
    }

    public static void recorrerArrayLinked(ArrayList<String> array, LinkedList<String> linked){
        for(int i = 0; i< array.size(); i++){
            System.out.println("ArrayList: " + array.get(i));
            System.out.println("LinkedList: " + linked.get(i));
        }
    }

    public static void  rellenar(ArrayList<Integer> array){
        for(int i = 0; i <= 10; i++){
            if(i%2!=0){
                array.add(i);
            }
        }
        System.out.println(array);
    }

    public static void DividePorCero (int numerador, int denominador) {
        try{
            System.out.println(numerador / denominador);
        }catch(ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }finally{
            System.out.println("Demo de codigo");
        }
    }

    public static void copiarYPegar(String fileIn, String fileOut){

        try {
            InputStream in = new FileInputStream(fileIn);
            byte[] texto = in.readAllBytes();
            in.close();
            PrintStream out = new PrintStream(fileOut);
            out.write(texto);
            out.close();
        }catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
