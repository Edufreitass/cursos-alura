package aula7.exercicio9;

/**
 * Dá NullPointerException ao tentar criar a segunda String.
 */
class A {

    // Compila e dá erro de execução ao tentar criar a segunda String.
    public static void main(String[] args) {
        String s = null;
        String s2 = new String(s);
        System.out.println(s2);
    }
}
