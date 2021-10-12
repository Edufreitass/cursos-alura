package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjetoCorretamente {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Class<SubControle> subControleClasse1 = SubControle.class;

        Class<?> subControleClasse2 =
                Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Class<?> controleClasse1 =
                Class.forName("br.com.alura.alurator.playground.controle.Controle");

        try {
            controleClasse1.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(e.getTargetException());
        }

//        controleClasse1.newInstance();

//        Constructor<SubControle> construtorSubControle =
//                subControleClasse1.getDeclaredConstructor();
//
//        System.out.println(construtorSubControle);
//
//        construtorSubControle.setAccessible(true);
//        Object subControle = construtorSubControle.newInstance();
//
//        System.out.println(subControle);
    }
}
