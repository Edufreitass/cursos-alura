package br.com.alura.java.io.teste;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TesteLeituraProperties {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("conf.properties"));

        String login = props.getProperty("login");
        String senha = props.getProperty("senha");
        String endereco = props.getProperty("endereco");

        System.out.println(login + ", " + senha + ", " + endereco);
    }

}
