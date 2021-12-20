package aula4.exercicio2;

import aula4.exercicio2.basico.Cliente;
import aula4.exercicio2.avancado.Cliente;

/**
 * O erro de ambiguidade é dado no import e não na utilização, portanto o arquivo não compila.
 */
class Teste {

    // O código não compila, erro ao tentar importar duas classes com o mesmo nome.
    public static void main(String[] args) {
        System.out.println("Bem vindo!");
    }
}
