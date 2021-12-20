package aula2;

import java.util.*;

/**
 * O arquivo não compila pois não podemos ter um import após a definição de uma classe.
 */
public class Exercicio1 {

    // O arquivo não compila.
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();

        for (String arg : args) {
            if (new E().existe(arg))
                lista.add(arg);
        }
    }
}

import java.io.*;

class E {
    public boolean existe(String nome) {
        File f = new File(nome);
        return f.exists();
    }
}