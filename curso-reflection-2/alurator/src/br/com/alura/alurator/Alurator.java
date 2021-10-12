package br.com.alura.alurator;

import br.com.alura.alurator.conversor.ConversorXML;
import br.com.alura.alurator.ioc.ContainerIoC;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.ManipuladorObjeto;
import br.com.alura.alurator.reflexao.Reflexao;

import java.util.Map;

public class Alurator {

    private String pacoteBase;
    private ContainerIoC container;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
        this.container = new ContainerIoC();
    }

    public Object executa(String url) {
        Request request = new Request(url);
        String nomeControle = request.getNomeControle();
        String nomeMetodo = request.getNomeMetodo();
        Map<String, Object> params = request.getQueryParams();

        String fullyQualifiedName = pacoteBase + nomeControle;
        Class<?> classeControle = new Reflexao().getClasse(fullyQualifiedName);
        Object instanciaControle = container.getInstancia(classeControle);

        Object retorno = new ManipuladorObjeto(instanciaControle)
                .getMetodo(nomeMetodo, params)
                .comTratamentoDeExcecao((metodo, ex) -> {
                    System.out.println("Erro no método " + metodo.getName() + " da classe "
                            + metodo.getDeclaringClass().getName() + ".\n\n");
                    throw new RuntimeException("ERRO!");
                })
                .invoca();

        System.out.println(retorno);

        retorno = new ConversorXML().converte(retorno);

        return retorno;
    }
}
