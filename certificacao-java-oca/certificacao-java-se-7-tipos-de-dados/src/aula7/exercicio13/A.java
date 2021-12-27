package aula7.exercicio13;

/**
 * O código não compila pois o método replace possui duas maneiras de ser invocado:
 * com dois chars ou com duas Strings. Foram passados uma String e um char, método que não existe.
 */
class A {

    // Não compila.
    public static void main(String[] args) {
        String s = "estudando para a certificação";
        s.replace("e", 'a');
        System.out.println(s);
    }
}
