package br.com.bytebank.banco.teste;

public class Teste {

    public static void main(String[] args) {

        // inicializa o array com 0
        int[] idades = new int[5];

        /*
        // posicao 0 contém o valor 29
        idades[0] = 29;
        idades[1] = 39;
        idades[2] = 49;
        idades[3] = 59;
        idades[4] = 69;

        // idade1 receber o valor da posicao 0
        int idade1 = idades[0];

        // imprime o valor da posicao 0 que é igual a 29
        System.out.println(idade1);

        System.out.println(idades.length);

        for (int i = 0; i < idades.length; i++) {
            System.out.println(idades[i]);
        }
         */

        for (int i = 0; i < idades.length; i++) {
            idades[i] = i * i;
        }

        for (int i = 0; i < idades.length; i++) {
            System.out.println(idades[i]);
        }

    }

}
