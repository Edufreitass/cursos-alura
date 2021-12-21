package aula6.exercicio1;

/**
 * O array começa na posição 0, portanto, o primeiro caractere removido se encontra na posição 2, o i.
 * Ele remove todos os caracteres até a posição 3, exceto o da posição 3, portanto somente o i é removido.
 */
class A {

    // O código compila e imprime gulherme.
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("guilherme").delete(2,3);
        System.out.println(sb);
    }
}