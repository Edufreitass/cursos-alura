package aula12.exercicio2;

/**
 * O código não compila pois a variável valor é final e não pode ser alterada, mas tentamos efetuar uma atribuição dentro do if.
 */
class B{
    final boolean valor = false;
}

class A {

    // Não compila.
    public static void main(String[] args) {
        B b = new B();
        if(b.valor = true) {
            System.out.println("verdadeiro");
        }
    }
}
