package aula7.exercicio15;

/**
 * Os dois métodos retornam -1 quando não encontram nada, portanto, o segundo resultado é -2.
 * Como a posição começa em 0, o resultado das letras e são 5 e 8, totalizando 13.
 */
class A {

    // O código imprime 13 e -2.
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("guilherme");
        System.out.println(sb.indexOf("e") + sb.lastIndexOf("e"));
        System.out.println(sb.indexOf("k") + sb.lastIndexOf("k"));
    }
}
