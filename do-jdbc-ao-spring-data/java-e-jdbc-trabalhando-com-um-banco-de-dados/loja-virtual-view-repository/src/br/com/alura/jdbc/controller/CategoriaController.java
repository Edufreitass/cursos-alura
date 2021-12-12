package br.com.alura.jdbc.controller;

import br.com.alura.jdbc.modelo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaController {

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Categoria de teste"));
        return categorias;
    }
}
