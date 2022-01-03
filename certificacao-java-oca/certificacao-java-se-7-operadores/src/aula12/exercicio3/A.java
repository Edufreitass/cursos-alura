package aula12.exercicio3;

/**
 * O código não compila pois tenta atribuir 15 a uma variável e conferir o valor 15 como se fosse um boolean.
 */
class A {

    // Não compila
    public static void main(String[] args) {
        int quantidade = 15;
        if(quantidade=15) {
            System.out.println("sim");
        } else {
            System.out.println("nao");
        }
    }
}
