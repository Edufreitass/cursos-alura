package aula11.exercicio3;

/**
 * Compila e imprime true, true. Por mais que substring devolva uma nova String,
 * nesse caso ele devolveu a String inteira, a própria String.
 */
class A {

    // Compila e imprime true, true.
    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = s1.substring(0, 2);
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
