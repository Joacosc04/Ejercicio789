package com.sorprendente;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("¿SABIAS QUE PUDES COPIAR Y PEGAR CUALQUIER ARCHIVO SOLO CONSIGUIENDO LAS RUTAS DONDE SE ENCUENTRAN LOS ARCHIVOS?");
        System.out.println("Solo tienes que responder bien unas preguntas");
        int[] preguntas = {5, 18, 63, 16};
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("2 + 3", 0);
        mapa.put("37 - 19", 1);
        mapa.put("7 * 9", 2);
        mapa.put("64 / 4", 3);
        try {
            calcular(mapa, preguntas);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("Felicidades, has desbloqueado el copiado y pegado rapido");
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Texto para copiar: ");
        String copiar = scanner2.next();
        System.out.print("Texto en donde pegar: ");
        String pegar = scanner2.next();
        copiarYPegar(copiar, pegar);
    }
    public static void calcular(HashMap<String, Integer> mapa, int[] preguntas){
        Scanner scanner = new Scanner(System.in);
        for(Map.Entry elemento : mapa.entrySet()){
            System.out.println(elemento.getKey());
            Integer i = Integer.parseInt(String.valueOf(elemento.getValue()));
            int j = scanner.nextInt();
            do {
                if (j == preguntas[i]) {
                    elemento.setValue(j);
                }else {
                    System.out.println("Ese no es el resultado "+elemento.getKey());
                    j = scanner.nextInt();
                    continue;
                }
            }while(j!=preguntas[i]);
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
