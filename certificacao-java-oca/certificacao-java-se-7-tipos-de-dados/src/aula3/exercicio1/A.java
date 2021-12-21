package aula3.exercicio1;

/**
 * Não existe conflito de nomes entre variável membro e método ou variável membro e variável local.
 * Ao invocar o método c, por causa do shadowing da variável c, não acessamos a variável membro, sem alterá-la.
 * O resultado é a impressão dos valores 10 e 10 novamente.
 */
class B{
    int c;
    void c(int c) {
        c = c;
    }
}

class A {

    // Compila e roda, imprimindo outro resultado.
    public static void main(String[] args) {
        B b = new B();
        b.c = 10;
        System.out.println(b.c);
        b.c(30);
        System.out.println(b.c);
    }
}
