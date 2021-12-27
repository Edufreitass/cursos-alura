package aula7.exercicio4;

/**
 * A resposta certa é Caelum e Caelum - Ensino e Inovação.
 */
class A {

    // Caelum e Caelum - Ensino e Inovação.
    public static void main(String[] args) {
        String s = "Caelum";
        s.concat(" - Ensino e Inovação");
        System.out.println(s);

        StringBuffer t = new StringBuffer("Caelum");
        t.append(" - Ensino e Inovação");
        System.out.println(t);
    }
}
