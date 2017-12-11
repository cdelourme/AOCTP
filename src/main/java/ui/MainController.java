package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.implementation.Afficheur;
import model.implementation.Generator;
import model.implementation.strategy.StrategyAtomique;
import model.implementation.strategy.StrategySequentielle;
import model.pattern.activeObject.Generate;
import model.pattern.generator.IGenerator;
import model.pattern.proxy.Canal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MainController {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);

    /**********************************FXML Part************************************/
    @FXML
    private TextArea affich0;
    @FXML
    private TextArea affich1;
    @FXML
    private TextArea affich2;
    @FXML
    private TextArea affich3;

    private Afficheur modelAffich0;
    private Afficheur modelAffich1;
    private Afficheur modelAffich2;
    private Afficheur modelAffich3;
    private IGenerator gen;

    @FXML
    public void initialize() {

        initializeModel();

        affich0.textProperty().bind(modelAffich0.stackTrace);
        affich1.textProperty().bind(modelAffich1.stackTrace);
        affich2.textProperty().bind(modelAffich2.stackTrace);
        affich3.textProperty().bind(modelAffich3.stackTrace);
    }

    public void initializeModel() {
        gen = new Generator();

        modelAffich0 = new Afficheur();
        modelAffich0.initTrace("0 latence");
        modelAffich1 = new Afficheur();
        modelAffich1.initTrace("500 latence");
        modelAffich2 = new Afficheur();
        modelAffich2.initTrace("1000 latence");
        modelAffich3 = new Afficheur();
        modelAffich3.initTrace("1500 latence");

        Canal Canal1 = new Canal(gen,1000);
        Canal1.attach(modelAffich0);
        Canal Canal2 = new Canal(gen,2000);
        Canal1.attach(modelAffich1);
        Canal Canal3 = new Canal(gen,3000);
        Canal1.attach(modelAffich2);
        Canal Canal4 = new Canal(gen,4000);
        Canal1.attach(modelAffich3);

        gen.attach(Canal1);
        gen.attach(Canal2);
        gen.attach(Canal3);
        gen.attach(Canal4);

        gen.changeStrategy(new StrategySequentielle());

        launchGenerator();

    }

    private void launchGenerator(){

        scheduler.scheduleAtFixedRate(new Generate(gen), 0,5000,TimeUnit.MILLISECONDS);
    }
}
