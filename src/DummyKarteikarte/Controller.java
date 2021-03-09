package DummyKarteikarte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
    public Button boldBtn;
    public Button underlineBtn;
    public Button italicBtn;
    public Button smallerBtn;
    public Button biggerBtn;

    @FXML
    WebView webView;

    private int fontSize = 10;

    @FXML
    public void initialize() {
        Path filePath = Paths.get("src/Karteikarte.html");
        try {
            webView.getEngine().loadContent(Files.readString(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void makeBold() {
        webView.getEngine().executeScript("document.execCommand(\"bold\");");
    }

    private void makeItalic() {
        webView.getEngine().executeScript("document.execCommand(\"italic\");");
    }

    @FXML
    private void makeUnderlined() {
        webView.getEngine().executeScript("document.execCommand(\"underline\");");
    }

    @FXML
    private void increaseFontSize() {
        fontSize += 3;
        webView.getEngine().executeScript("document.execCommand(\"fontSize\", false, \"7\");" +
                "var fontElements = window.getSelection().anchorNode.parentNode" +
                "fontElements.removeAttribute(\"size\");" +
                "fontElements.style.fontSize = \""+ fontSize + "px\";");    }

    @FXML
    private void decreaseFontSize() {
        fontSize -= 3;
        webView.getEngine().executeScript("document.execCommand(\"fontSize\", false, \"7\");" +
        "var fontElements = window.getSelection().anchorNode.parentNode" +
        "fontElements.removeAttribute(\"size\");" +
        "fontElements.style.fontSize = \""+ fontSize + "px\";");
    }


    //Bold
    //Italic
    //Unterstrichen
    //Größer/Kleiner
}
