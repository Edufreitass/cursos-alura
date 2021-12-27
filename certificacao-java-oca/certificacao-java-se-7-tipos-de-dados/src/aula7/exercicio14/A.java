package aula7.exercicio14;

/**
 * Pensamos que pode ser gualherme, mas lembramos que String em Java é imutável e ela não foi reatribuída.
 * O = dá uma impressão de reatribuição de parte da String, mas isso não existe em Java, o lado esquerdo de uma
 * atribuição deve ser sempre uma variável e não uma chamada a um método. Por isso, a linha do substring não compila.
 */
class A {

    // Erro de compilação.
    public static void main(String[] args) {
        String s = "guilherme";
        s.substring(0,2) = "gua";
        System.out.println(s);
    }
}
