package aula4.exercicio3;

/**
 * O código compila, mas como não chamamos nenhum construtor, o único objeto criado que se assemelha a B,
 * porém não é B, é um array do tipo B, com 100 espaços. Nenhum objeto é criado.
 * Note que para criar devemos, por padrão, invocar o construtor.
 */
class B{

}
class A {

    // Compila e nenhum objeto do tipo B é criado.
    public static void main(String[] args) {
        B[] bs = new B[100];
        System.out.println("Finalizando!");
    }
}
