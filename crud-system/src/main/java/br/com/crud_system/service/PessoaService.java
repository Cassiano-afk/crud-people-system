package br.com.crud_system.service;

import java.util.*;
import br.com.crud_system.model.Pessoa;

public class PessoaService {
    private List<Pessoa> pessoas = new ArrayList<>();
    private int nextId = 1;

    public Pessoa criarPessoas(String nome, int idade) {
        Pessoa pessoa = new Pessoa(nextId++, nome, idade);
        pessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> listarPessoas() {
        return new ArrayList<>(pessoas);
    }

    public Pessoa buscarPessoaPorId(int id) {
        return pessoas.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean atualizarPessoa(int id, String novoNome, int novaIdade) {
        Pessoa pessoa = buscarPessoaPorId(id);
        if (pessoa != null) {
            pessoa.setNome(novoNome);
            pessoa.setIdade(novaIdade);
            return true;
        }
        return false;
    }

    public boolean deletarPessoa(int id) {
        return pessoas.removeIf(p -> p.getId()  == id);
    }

}
