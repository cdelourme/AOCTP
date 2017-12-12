package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import model.implementation.Afficheur;
import model.implementation.Generator;
import model.implementation.strategy.StrategyAtomique;
import model.implementation.strategy.StrategySequentielle;
import model.pattern.activeObject.Generate;
import model.pattern.generator.IGenerator;
import model.pattern.proxy.Canal;
import model.pattern.strategy.IStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MainController {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    /**********************************FXML Part************************************/
    @FXML
    private TextArea affich0;
    @FXML
    private TextArea affich1;
    @FXML
    private TextArea affich2;
    @FXML
    private TextArea affich3;

    @FXML
    private Text strategieValue;

    @FXML
    private void setSequentielle(){
        strategieValue.setText("Strategie : Sequentielle");
        setStrategie(new StrategySequentielle());
    }

    @FXML
    protected void setAtomique(){
        strategieValue.setText("Strategie : Atomique");
        setStrategie(new StrategyAtomique());
    }

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
        modelAffich1.initTrace("100 latence");
        modelAffich2 = new Afficheur();
        modelAffich2.initTrace("25 latence");
        modelAffich3 = new Afficheur();
        modelAffich3.initTrace("1500 latence");

        Canal Canal1 = new Canal(gen,0);
        Canal1.attach(modelAffich0);
        Canal Canal2 = new Canal(gen,100);
        Canal2.attach(modelAffich1);
        Canal Canal3 = new Canal(gen,250);
        Canal3.attach(modelAffich2);
        Canal Canal4 = new Canal(gen,400);
        Canal4.attach(modelAffich3);

        gen.attach(Canal1);
        gen.attach(Canal2);
        gen.attach(Canal3);
        gen.attach(Canal4);

        setStrategie(new StrategySequentielle());
        strategieValue.setText("Strategie : Sequentielle");

        launchGenerator();

    }

    private void setStrategie(IStrategy strategie){
        gen.changeStrategy(strategie);
    }

    private void launchGenerator(){
        scheduler.scheduleAtFixedRate(new Generate(gen), 0,1000,TimeUnit.MILLISECONDS);
    }
}
