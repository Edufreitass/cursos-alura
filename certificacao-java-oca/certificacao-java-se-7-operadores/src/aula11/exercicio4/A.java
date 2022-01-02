package aula11.exercicio4;

/**
 * O código imprime false e true. Note que o método equals não foi sobrescrito. O código imprime false e true.
 * As duas referências são diferentes (false), e o método equals não foi sobrescrito, mas como estamos usando
 * uma referência do tipo C, o retorno ainda é true.
 */
class A {

    // Compila e imprime false, true.
    public static void main(String[] args) {
        C a = new C();
        C b = new B();
        a.x = 1;
        b.x = 1;
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}

class B extends C{}

class C {
    int x;
    public boolean equals(C c) {
        return c.x==x;
    }
}