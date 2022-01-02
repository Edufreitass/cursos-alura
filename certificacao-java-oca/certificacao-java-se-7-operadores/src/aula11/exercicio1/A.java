package aula11.exercicio1;

/**
 * O código compila e imprime true e false.
 */
class A {

    // Compila e imprime true, false.
    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = "s" + "1";
        System.out.println(s1==s2);
        System.out.println(s1==("" + s2));
    }
}
