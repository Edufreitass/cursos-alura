package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCollections {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Eduardo");
        nomes.add("Ana");
        nomes.add("Isaias");
        nomes.add("Carlos");
        nomes.add("Marcos");
        nomes.add("João");
        nomes.add("Tatiana");
        nomes.add("Gabriel");
        nomes.add("Sara");
        nomes.add("Beatriz");

        /**
         * Ordenada a lista especificada em ordem crescente, de acordo com a ordem natural de seus elementos.
         */
        Collections.sort(nomes);
        System.out.println("Lista Ordenada: " + nomes);

        /**
         * O método reverse() serve para inverter a ordem de uma lista.
         * Às vezes precisamos imprimir uma lista de nomes do último para o primeiro,
         * ou uma lista de ids do maior para o menor e é nestas horas que utilizamos
         * o reverse para inverter a ordem natural da lista para nós.
         */
        Collections.reverse(nomes);
        System.out.println("Lista Invertida: " + nomes);

        /**
         * O método shuffle() serve para embaralhar a ordem de uma lista.
         * Por exemplo em um caso de um sistema de sorteio, em que precisamos
         * de uma ordem aleatória na nossa lista, utilizamos o método shuffle para embaralhá-la.
         */
        Collections.shuffle(nomes);
        System.out.println("Lista Embaralhada: " + nomes);

        /**
         * O método singletonList() nos devolve uma lista imutável que contêm um único elemento especificado.
         * Ele é útil quando precisamos passar um único elemento para uma API que só aceita uma Collections daquele elemento.
         */
        List<String> list = Collections.singletonList("E");
        System.out.println("Lista Imutável: " + list);

        /**
         * O método nCopies() nos retorna uma lista imutável com a quantidade escolhida de um determinado elemento.
         * Se temos uma lista específica e precisamos obter uma outra lista imutável , contendo diversas cópias de um destes objetos,
         * utilizamos o método nCopies(). O bom deste método é que mesmo que nós solicitemos uma lista com um número grande,
         * como 10000 objetos, ele na verdade se referencia a apenas um, ocupando assim um pequeno espaço.
         *
         * Este método também é utilizado para inicializar Listas recém criadas com Null,
         * já que ele pode rapidamente criar diversos objetos, deste modo:
         */
        List<String> copies = new ArrayList<>(Collections.nCopies(10, (String) null));
        System.out.println(copies);
    }
}
