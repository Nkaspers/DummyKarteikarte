package DummyKarteikarte;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
    public Button boldBtn;
    public Button underlineBtn;
    public Button italicBtn;
    public Button smallerBtn;
    public Button biggerBtn;
    public ChoiceBox<Integer> fontsizeCb;



    @FXML
    WebView webView;

    private int fontSize = 3;



    @FXML
    public void initialize() {

        fontsizeCb.getItems().addAll(1,2,3,4,5,6,7);
        fontsizeCb.setValue(fontSize);
        fontsizeCb.setOnAction((actionEvent -> {
            fontSize = fontsizeCb.getValue();
            webView.getEngine().executeScript("document.execCommand(\"fontSize\", false, \""+ fontSize +"\");");
        }));

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

    @FXML
    private void makeItalic() {
        webView.getEngine().executeScript("document.execCommand(\"italic\");");
    }

    @FXML
    private void makeUnderlined() {
        webView.getEngine().executeScript("document.execCommand(\"underline\");");
    }

    @FXML
    private void increaseFontSize() {
        if(fontSize<7){
            webView.getEngine().executeScript("document.execCommand(\"fontSize\", false, \""+ ++fontSize +"\");");
            fontsizeCb.setValue(fontSize);
        }
    }
    @FXML
    private void decreaseFontSize() {
        if(fontSize>1){
            webView.getEngine().executeScript("document.execCommand(\"fontSize\", false, \""+ --fontSize +"\");");
            fontsizeCb.setValue(fontSize);
        }

    }

}
