package com.corporate.utils;

import java.io.IOException;

public class Varios_Metodos  {

    public static String NumerosTransacciones(String cadena) throws IOException {
        //String respuesta = "";
        String[] palabras = {"Transferencia", "con", "número", "de", "transacción", "has", "sido", "creada", "exitosamente."};
        String nueva = "";
        String[] partes = cadena.split(" ");
        for (int i = 0; i < partes.length; i++) {
            int x = 0;
            for (int j = 0; j < palabras.length; j++) {
                if (partes[i].equals(palabras[j])) {
                    x++;
                }
            }
            if (x == 0) {
                nueva = nueva + " " + partes[i] + " ";
            }
        }

        String[] partes2 = nueva.split(", ");String numeros = "";
        for(int i=0;i<partes2.length;i++)
        {numeros=numeros+";"+partes2[i].trim()+"";}
        System.out.println("=>2 "+numeros);
        return numeros;
    }

}
    
    

