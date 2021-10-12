package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaObjeto {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // url -> /controle/lista

        // 1ª forma de criar um objeto do tipo Class
        Class<Controle> controleClasse1 = Controle.class;

        // 2ª forma de criar um objeto do tipo Class
        Controle controle = new Controle();
        Class<? extends Controle> controleClasse2 = controle.getClass();

        // 3ª forma de criar um objeto do tipo Class
        Class<?> controleClasse3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Controle objetoControle = controleClasse1.newInstance();

        Object outroObjetoControle = controleClasse3.newInstance();

        System.out.println(objetoControle instanceof Controle);

        System.out.println(outroObjetoControle instanceof Controle);
    }
}
