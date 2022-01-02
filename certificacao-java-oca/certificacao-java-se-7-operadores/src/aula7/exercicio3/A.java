package aula7.exercicio3;

/**
 * Mesmo c sendo null, por estarmos usando o operador &, a segunda parte da expressão (c.getPreco() > 10000) será
 * avaliada, causando uma NullPointerException na chamada do método getPreco() caso c seja null.
 * Poderíamos evitar isso usando o operador de curto-circuito, &&.
 */
public class A {

    // O código a seguir pode lançar um NullPointerException. Como evitar isso mantendo a mesma lógica?
    // R: Trocando & por &&
    void metodo(Carro c) {
        if (c != null & c.getPreco() > 100000) {
            System.out.println("possivel sequestro");
        }
    }
}

class Carro {

    private Long preco;

    public Long getPreco() {
        return preco;
    }
}
