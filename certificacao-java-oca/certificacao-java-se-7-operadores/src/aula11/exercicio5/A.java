package aula11.exercicio5;

/**
 * O código não compila pois D não é do tipo C, e o método equals da classe C recebe um Object c no parâmetro
 * e tenta acessar um atributo que não existe na classe Object(no caso ele tenta acessar o atributo x).
 */
class A {

    // Não compila.
    public static void main(String[] args) {
        C a = new C();
        C b = new D();
        a.x = 1;
        b.x = 1;
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}

class B extends C{}

class C {
    int x;
    public boolean equals(Object c) {
        return c.x==x;
    }
}

class D {
    int x;
}
