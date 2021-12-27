package aula7.exercicio11;

/**
 * Não compila pois String possui diversos construtores que recebem um argumento:
 * o compilador não sabe qual deles você deseja invocar pois os tipos que são argumentos
 * do construtor não possuem herança entre si (um não herda necessariamente do outro).
 */
class A {

    // Não compila ao tentar invocar o construtor.
    public static void main(String[] args) {
        String s2 = new String(null);
        System.out.println(s2);
    }
}
