package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaWebService implements Callable<String> {

    private PrintStream saida;

    public ComandoC2ChamaWebService(PrintStream saida) {
        this.saida = saida;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Servidor recebeu comando c2 - WebService");

        saida.println("processando comando c2 - WebService");

        Thread.sleep(25000);

        int numero = new Random().nextInt(100) + 1;

        System.out.println("Servidor finalizou comando c2 - WebService");
        return Integer.toString(numero);
    }
}
