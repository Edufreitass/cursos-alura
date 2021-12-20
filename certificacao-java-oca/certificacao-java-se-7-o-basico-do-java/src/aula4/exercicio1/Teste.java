package aula4.exercicio1;

import aula4.exercicio1.modelo.Cliente;

/**
 * Ocorre um erro de compilação na classe Teste ao tentar importar uma classe não acessível a outros pacotes.
 */
class Teste {

    // Não compila: erro na classe Teste.
    public static void main(String[] args) {
        new Cliente("guilherme").imprime();
    }
}
