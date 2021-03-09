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

    private int fontSize = 10;

    @FXML
    public void initialize() {
        Path filePath = Paths.get("src/Karteikarte.html");
        try {
            webView.getEngine().loadContent(new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void makeBold() {
        webView.getEngine().executeScript("document.execCommand(\"bold\");");
    }

    private void makeItalic() {
        webView.getEngine().executeScript("document.execCommand(\"italic\");");
    }

    private void makeUnderlined() {
        webView.getEngine().executeScript("document.execCommand(\"underline\");");
    }

    private void increaseFontSize() {
        fontSize += 3;
        webView.getEngine().executeScript("document.execCommand(\"fontSize\", false, \"7\");" +
                "var fontElements = window.getSelection().anchorNode.parentNode" +
                "fontElements.removeAttribute(\"size\");" +
                "fontElements.style.fontSize = \""+ fontSize + "px\";");    }

    private void decreaseFontSize() {
        fontSize -= 3;
        webView.getEngine().executeScript("document.execCommand(\"fontSize\", false, \"7\");" +
        "var fontElements = window.getSelection().anchorNode.parentNode" +
        "fontElements.removeAttribute(\"size\");" +
        "fontElements.style.fontSize = \""+ fontSize + "px\";");
    }
}
