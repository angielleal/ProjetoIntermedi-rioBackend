package com.example.projeto.backend;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ServiceLocalizacao {

    private final String filePath = "localizacao.txt";

    public String consultarLocalizacao(String cep) {
        String apiUrl = "https://viacep.com.br/ws/" + cep + "/json";
        RestTemplate restTemplate = new RestTemplate();

        try {
            String resposta = restTemplate.getForObject(apiUrl, String.class);
            salvarEmArquivo(resposta);
            return resposta;

        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return "CEP não encontrado";
            } else {
                throw e;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar a API ViaCEP", e);
        }
    }

    public void processarDados(String dados) {
        if (dados != null && !dados.isEmpty()) {
            salvarEmArquivo("Dados brutos da API: " + dados);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Localizacao localizacao = objectMapper.readValue(dados, Localizacao.class);
                ObjectNode dadosProcessados = objectMapper.createObjectNode();

                dadosProcessados.put("CEP", localizacao.getCep());
                dadosProcessados.put("Logradouro", localizacao.getLogradouro().isEmpty() ? "Dados não disponíveis" : localizacao.getLogradouro());
                dadosProcessados.put("Complemento", localizacao.getComplemento().isEmpty() ? "Dados não disponíveis" : localizacao.getComplemento());
                dadosProcessados.put("Bairro", localizacao.getBairro().isEmpty() ? "Dados não disponíveis" : localizacao.getBairro());
                dadosProcessados.put("Localidade", localizacao.getLocalidade());
                dadosProcessados.put("UF", localizacao.getUf());
                dadosProcessados.put("IBGE", localizacao.getIbge());
                dadosProcessados.put("GIA", localizacao.getGia().isEmpty() ? "Dados não disponíveis" : localizacao.getGia());
                dadosProcessados.put("DDD", localizacao.getDdd());
                dadosProcessados.put("SIAFI", localizacao.getSiafi());

                String dadosFormatados = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dadosProcessados);
                salvarEmArquivo("Dados formatados:\n" + dadosFormatados);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void salvarEmArquivo(String conteudo) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(conteudo);
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
