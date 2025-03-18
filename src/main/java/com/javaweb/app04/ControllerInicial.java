package com.javaweb.app04;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerInicial {

    @RequestMapping("/")
    public String home() {
        return "home.html";
    }

    @RequestMapping("/perfil")
    public String perfil() {
        return "perfil.html";
    }

    @RequestMapping("/cep/{cep}")
    @ResponseBody
    public String cep(@PathVariable String cep) {
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception exception) {
            return "Erro ao consultar o CEP: " + exception.getMessage();
        }
    }
}
