package aula2.exercicio2;

/**
 * Imprime 48, pois a atribuição de objetos é feita por cópia da referência, criamos somente um único objeto do tipo B.
 */
class B {
    int v = 15;
}

class A {

    // Imprime 48.
    public static void main(String[] args) {
        B x = new B();
        B y = x;
        y.v++;
        x.v++;
        B z = y;
        z.v--;
        System.out.println(x.v + y.v + z.v);
    }
}