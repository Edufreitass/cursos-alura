public class MultiplosDeTresAteCem {

    public static void main(String[] args) {

        // 1 opcao
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }

        // 2 opcao
        for (int i = 3; i < 100; i += 3) {
            System.out.println(i);
        }

    }

}
