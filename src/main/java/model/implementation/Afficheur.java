package model.implementation;

import javafx.beans.property.SimpleStringProperty;
import model.pattern.generator.IAfficheur;
import model.pattern.generator.IAsynchGenerator;

public class Afficheur implements IAfficheur {

    public SimpleStringProperty stackTrace;

    public void update(IAsynchGenerator subject) {
        try{
            addTrace(subject.getValue().get());
        }
        catch (Exception ex){

        }
    }

    private void addTrace(Integer newValue) {
        stackTrace.set(newValue + "\n" + stackTrace.getValue());
    }

    public void initTrace(String value) {
        stackTrace = new SimpleStringProperty(value);
    }
}
