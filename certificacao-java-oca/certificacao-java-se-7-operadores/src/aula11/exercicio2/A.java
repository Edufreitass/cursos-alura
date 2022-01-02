package aula11.exercicio2;

/**
 * Compila e imprime false, false, uma vez que a String 2 vale s.
 */
class A {

    // Compila e imprime false, false.
    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = s1.substring(0, 1) + s1.substring(1,1);
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
