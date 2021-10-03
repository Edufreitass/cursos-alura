package br.com.alura.threads;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("isso é a thread main");

        Thread.sleep(5000); //milissegundos (5 * 1000 = 5s)
    }
}