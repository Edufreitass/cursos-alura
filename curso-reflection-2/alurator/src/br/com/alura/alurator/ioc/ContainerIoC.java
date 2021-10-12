package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

public class ContainerIoC {

    private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();

    public Object getInstancia(Class<?> tipoFonte) {
        Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);

        if (tipoDestino != null) {
            return getInstancia(tipoDestino);
        }

        Stream<Constructor<?>> construtores =
                Stream.of(tipoFonte.getDeclaredConstructors());

        Optional<Constructor<?>> construtorPadrao = construtores
                .filter(construtor -> construtor.getParameterCount() == 0).findFirst();

        try {
            if (construtorPadrao.isPresent()) {
                Object instancia = construtorPadrao.get().newInstance();
                return instancia;
            } else {
                Constructor<?> construtor = tipoFonte.getDeclaredConstructors()[0];
                List<Object> params = new ArrayList<>();

                for (Parameter param : construtor.getParameters()) {
                    Class<?> tipoDoParametro = param.getType();
                    params.add(getInstancia(tipoDoParametro));
                }

                return construtor.newInstance(params.toArray());
            }

        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void registra(Class<?> tipoFonte, Class<?> tipoDestino) {
        boolean compativel = verificarCompatibilidade(tipoFonte, tipoDestino);
        if (!compativel) {
            throw new ClassCastException("Nao e possivel resolver " + tipoFonte.getName() + " para " + tipoDestino.getName());
        }
        mapaDeTipos.put(tipoFonte, tipoDestino);
    }

    private boolean verificarCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) {
        // verifica se tipoDestino é compatível com tipoFonte na raça
//        boolean compativel;
//
//        if (tipoFonte.isInterface()) {
//            compativel = Stream.of(tipoDestino.getInterfaces())
//                    .anyMatch(interfaceImplementada -> interfaceImplementada.equals(tipoFonte));
//        } else {
//            compativel = tipoDestino.getSuperclass().equals(tipoFonte) || tipoDestino.equals(tipoFonte);
//        }
//
//        return compativel;

        // verificar compatibilidade com API de Reflection
        return tipoFonte.isAssignableFrom(tipoDestino);
    }
}
