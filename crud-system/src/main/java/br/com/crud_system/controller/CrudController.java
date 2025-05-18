package br.com.crud_system.controller;

import java.util.Scanner;

import br.com.crud_system.service.PessoaService;
import br.com.crud_system.model.Pessoa;

public class CrudController {
    private PessoaService pessoaService = new PessoaService();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Criar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Buscar Pessoa por ID");
            System.out.println("4. Atualizar Pessoa");
            System.out.println("5. Deletar Pessoa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    deletar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void criar() {
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        pessoaService.criarPessoas(nome, idade);
        System.out.println("Pessoa criada com sucesso!");
    }

    private void listar() {
        for (Pessoa p : pessoaService.listarPessoas()) {
            System.out.println(p);
        }
    }

    private void buscar() {
        System.out.print("Digite o ID da pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Pessoa p = pessoaService.buscarPessoaPorId(id);
        if (p != null) {
            System.out.println("Pessoa encontrada: " + p);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    private void atualizar() {
        System.out.print("ID da pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        boolean atualizado = pessoaService.atualizarPessoa(id, nome, idade);
        System.out.println(atualizado ? "Pessoa atualizada!" : "Pessoa não encontrada.");
    }

    private void deletar() {
        System.out.print("ID da pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean deletado = pessoaService.deletarPessoa(id);
        System.out.println(deletado ? "Pessoa removida!" : "Pessoa não encontrada.");
    }
}
