import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ArmazenamentoAPI{

    public MoedasAPI acharRecord(String tipoMoeda){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/760578e7c4f5d406af2014fe/latest/" + tipoMoeda))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MoedasAPI.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Estamos com erro para rodar a API");
        }
    }
}
