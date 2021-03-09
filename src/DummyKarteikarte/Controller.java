package DummyKarteikarte;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
    @FXML
    WebView webView;

    @FXML
    public void initialize() {
        Path filePath = Paths.get("src/Karteikarte.html");
        try {
            webView.getEngine().loadContent(new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
