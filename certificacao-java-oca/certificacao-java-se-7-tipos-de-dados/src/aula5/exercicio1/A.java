package aula5.exercicio1;

/**
 * O código compila e devido à regra de sempre invocar o mais específico, ele sempre invoca o método sem argumentos.
 * Portanto, o resultado é vazio/vazio. Lembre-se que em Java a ordem de definição de métodos não importa para a
 * invocação. Já a ordem das variáveis pode importar, caso uma dependa da outra.
 */
class B {
    void x() {
        System.out.println("vazio");
    }
    void x(String... args) {
        System.out.println(args.length);
    }
}
class C {
    void x(String... args) {
        System.out.println(args.length);
    }
    void x() {
        System.out.println("vazio");
    }
}
class A {

    // Compila e imprime vazio/vazio.
    public static void main(String[] args) {
        new B().x();
        new C().x();
    }
}