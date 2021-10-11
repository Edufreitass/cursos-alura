package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {

    private Object instancia;

    public ManipuladorObjeto(Object instancia) {
        this.instancia = instancia;
    }

    public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> params) {
        Stream<Method> metodos = Stream.of(instancia.getClass().getDeclaredMethods());
        Method metodoSelecionado = metodos.filter(metodo -> true)
                                            .findFirst()
                                            .orElseThrow(() -> new RuntimeException("Metodo nao encontrado"));

        try {
            Method metodo = instancia.getClass().getDeclaredMethod(nomeMetodo);
            return new ManipuladorMetodo(instancia, metodo);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
