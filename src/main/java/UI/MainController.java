package UI;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import model.implementation.Generator;
import model.pattern.generator.IGenerator;
import model.pattern.observer.IAsynchObserver;
import model.pattern.proxy.Canal;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    /**********************************FXML Part************************************/
    @FXML
    private TextArea aff1;
    @FXML
    private TextArea aff2;
    @FXML
    private TextArea aff3;
    @FXML
    private TextArea aff4;

    private StringProperty stackTrace1 = new SimpleStringProperty("aff1");
    private StringProperty stackTrace2 = new SimpleStringProperty("aff2");
    private StringProperty stackTrace3 = new SimpleStringProperty("aff3");
    private StringProperty stackTrace4 = new SimpleStringProperty("aff3");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aff1.textProperty().bind(stackTrace1);
        aff2.textProperty().bind(stackTrace2);
        aff3.textProperty().bind(stackTrace3);
        aff4.textProperty().bind(stackTrace4);

        IGenerator gen = new Generator();

        IAsynchObserver<IGenerator> obsGen = new Canal(gen,1);
        gen.attach(obsGen);
        gen.generate();
    }
}
