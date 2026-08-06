package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    private final String nomeArquivo;
    private final Gson gson;

    public ConfigManager(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        //GsonBuilder cria um objeto Gson configurado
        //setPrettyPrinting faz o JSON salvo ficar formatado corretamente
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    public ConfiguracoesJogo carregar() {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Arqivo de configuração não encontrado. Usando valores padrão.");
            return new ConfiguracoesJogo();
        }
        try (FileReader reader = new FileReader(arquivo)) {
            //gson.fromJson() transforma os dados em JSON em objeto JAVA
            ConfiguracoesJogo config = gson.fromJson(reader, ConfiguracoesJogo.class);
            return (config != null) ? config : new ConfiguracoesJogo();
        } catch (IOException | JsonSyntaxException e) {
            System.out.println("Erro ao carregar o arquivo de configuração JSON: " + e.getMessage());
            return new ConfiguracoesJogo();
        }
    }
    public void salvar(ConfiguracoesJogo config) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            //gson.toJson() transforma o objeto Java em Json e escreve no arquivo
            gson.toJson(config, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de configuração JSON: " + e.getMessage());
        }
    }
}
