package aula7.exercicio12;

/**
 * Aqui é necessário analisar as operações e a impressão ao mesmo tempo. Quando dividimos 2 inteiros,
 * o resultado é um inteiro, e só depois armazenamos os resultado em um double, fazendo com que o valor
 * da variável resultado seja 2.0 e não 2.5. Quando estamos imprimindo, a expressão é executada da
 * esquerda para a direita. primeiro somamos valor e dividePor, e só ai concatenamos com String.
 * Na segunda impressão é o contrário, primeiro concatenamos primeiro com String, fazendo com que todas
 * as operações subsequentes também sejam concatenações, e não somas.
 */
class A {

    //     14
    //    2.010
    public static void main(String[] args) {
        int valor = 10;
        int dividePor = 4;
        double resultado = valor / dividePor;
        System.out.println(valor + dividePor + "");
        System.out.println("" + resultado + valor );
    }
}
