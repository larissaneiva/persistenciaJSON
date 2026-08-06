package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final ConfigManager manager = new ConfigManager("config_jogo.json");
    private static final Scanner scanner = new Scanner(System.in);
    private static ConfiguracoesJogo configuracoes;

    public static void main(String[] args) {
        configuracoes = manager.carregar();
        System.out.println("Painel de configurações do Jogo");
        int opcao = 0;
        while (opcao != 5) {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1: verConfiguracoes(); break;
                    case 2: alterarNomeJogador(); break;
                    case 3: alterarNivelDificuldade(); break;
                    case 4: alterarAudio(); break;
                    case 5: alterarResolucaoTela(); break;
                    case 6:
                        System.out.println("Salvando configurações..."); break;
                    default:
                        System.out.println("Opção inválida!!!"); break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número.");
                scanner.nextLine();
            }
        }
        manager.salvar(configuracoes);
        System.out.println("Configurações salvas em 'config_jogo.json'.");
    }
    private static void exibirMenu(){
        System.out.println("-------------------------------------");
        System.out.println("\n------ MENU DE CONFIGURAÇÕES ------");
        System.out.println("1. Ver Configurações Atuais");
        System.out.println("2. Alterar nome do Jogador");
        System.out.println("3. Alterar nível de dificuldade (1-3)");
        System.out.println("4. Habilitar/Desabilitar Áudio");
        System.out.println("5. Alterar resolução de tela");
        System.out.println("6. Salvar e Sair");
        System.out.println("-------------------------------------");
        System.out.print("Escolha uma opção: ");
    }
    private static void verConfiguracoes(){
        System.out.println(configuracoes.toString());
    }
    private static void alterarNomeJogador(){
        System.out.println("Digite o novo nome do jogador: ");
        String novoNome = scanner.nextLine();
        configuracoes.setNomeJogador(novoNome);
        System.out.println("Nome do jogador alterado para: " + novoNome);
    }
    private static void alterarNivelDificuldade(){
        System.out.println("Digite o novo nível de dificuldade (1 = Fácil, 2 = Médio, 3 = Difícil): ");
        try {
            int novoNivel = scanner.nextInt();
            scanner.nextLine();
            if (novoNivel >= 1 && novoNivel <= 3){
                configuracoes.setNivelDificuldade(novoNivel);
                System.out.println("Nível de dificuldade alterado para: " + novoNivel);
            } else {
                System.out.println("Nível inválido. Use 1, 2 ou 3.");
            }
        } catch (InputMismatchException e){
            System.out.println("Entrada inválida. Digite um número.");
            scanner.nextLine();
        }
    }
    private static void alterarAudio(){
        boolean audioAtual = configuracoes.isAudioHabilitado();
        configuracoes.setAudioHabilitado(!audioAtual);
        String novoStatus = configuracoes.isAudioHabilitado() ? "HABILITADO" : "DESABILITADO";
        System.out.println("Áudio agora está: " + novoStatus);
    }
    private static void alterarResolucaoTela(){
        System.out.println("Digite a nova resolução da tela: (Ex.: 1080x720)");
        String novaResolucao = scanner.nextLine();
        configuracoes.setResolucaoTela(novaResolucao);
        System.out.println("Resolução da tela alterada para: " + novaResolucao);
    }
}