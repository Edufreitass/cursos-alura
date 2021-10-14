public class Teste {

    public static void main(String[] args) {

        Prioridade pMin = Prioridade.MIN;
        Prioridade pMax = Prioridade.MAX;

        System.out.println(pMin.name()); // MIN
        System.out.println(pMax.name()); // MAX

        System.out.println(pMin.ordinal()); // 0
        System.out.println(pMax.ordinal()); // 2

        System.out.println(pMin.getValor()); // 1
        System.out.println(pMax.getValor()); // 10

    }

}
