package aula5.exercicio2;

/**
 * O código compila e imprime 2.
 */
class B{
    void x(int... x) {
        System.out.println(x.length);
    }
}
class A {

    // Compila e ao rodar imprime 2.
    public static void main(String[] args) {
        new B().x(23789,673482);
    }
}
