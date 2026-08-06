package org.example;

public class ConfiguracoesJogo {
    private String nomeJogador;
    private int nivelDificuldade;
    private boolean audioHabilitado;
    private String resolucaoTela;

    public ConfiguracoesJogo() {
        this.nomeJogador = "Player1";
        this.nivelDificuldade = 2;
        this.audioHabilitado = true;
        this.resolucaoTela = "1280x720";
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(int nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public boolean isAudioHabilitado() {
        return audioHabilitado;
    }

    public void setAudioHabilitado(boolean audioHabilitado) {
        this.audioHabilitado = audioHabilitado;
    }

    public String getResolucaoTela() {
        return resolucaoTela;
    }

    public void setResolucaoTela(String resolucaoTela) {
        this.resolucaoTela = resolucaoTela;
    }
    public String toString() {
        String statusAudio = audioHabilitado ? "Habilitado" : "Desabilitado";
        return String.format(
                "--- Configurações Atuais ---\n" +
                        "Nome do Jogador: %s\n" +
                        "Nível de Dificuldade: %d\n" +
                        "Áudio: %s\n" +
                        "Resolução de Tela: %s\n" +
                        "---------------------------",
                nomeJogador, nivelDificuldade, statusAudio, resolucaoTela
        );
    }
}
