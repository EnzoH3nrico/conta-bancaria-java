import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Documentacao {

    public void modDocumentacao(MoedasAPI recordTeste) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escrita = new FileWriter(recordTeste.base_code() + "json");

        escrita.write(gson.toJson(recordTeste));
        escrita.close();
    }
}
