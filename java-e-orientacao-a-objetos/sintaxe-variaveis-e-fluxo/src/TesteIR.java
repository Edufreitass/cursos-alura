public class TesteIR {

    /*
    João está criando uma aplicação para calcular o IR a partir do salário.
    Ele olhou na tabela de IRPF e implementou as regras para 15% e 22.5%:
     */

    public static void main(String[] args) {

        double salario = 3300.0;

        if (salario < 2600.0) {
            System.out.println("A sua aliquota é de 15%");
            System.out.println("Você pode deduzir R$ 350");
        }

        if (salario < 3750.0) {
            System.out.println("A sua aliquota é de 22,5%");
            System.out.println("Você pode deduzir R$ 636");
        }
    }

}
