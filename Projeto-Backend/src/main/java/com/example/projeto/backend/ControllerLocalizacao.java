package com.example.projeto.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/localizacao")
public class ControllerLocalizacao {
    private final ServiceLocalizacao serviceLocalizacao;
    private final List<String> dadosApiList;
    @Autowired
    public ControllerLocalizacao(ServiceLocalizacao serviceLocalizacao) {
        this.serviceLocalizacao = serviceLocalizacao;
        this.dadosApiList = new ArrayList<>();
    }
    @GetMapping("/ajuda")
    public String obterAjuda() {
        return "{\n" +
                "  \"estudante\": \"Angiel Leal\",\n" +
                "  \"projeto\": \"Projeto Intermediario Backend\"\n" +
                "}";
    }
    @GetMapping("/consulta")
    public ResponseEntity<String> consultarLocalizacao(String cep) {
        String resultado = serviceLocalizacao.consultarLocalizacao(cep);
        dadosApiList.add(resultado);
        return ResponseEntity.ok(resultado);
    }
    @PostMapping("/salvar")
    public ResponseEntity<String> enviarDadosApi(@RequestBody String dados) {
        serviceLocalizacao.processarDados(dados);
        return ResponseEntity.ok("Dados salvos com sucesso");
    }
}
