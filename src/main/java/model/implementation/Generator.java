package model.implementation;

import model.pattern.generator.IGenerator;
import model.pattern.observer.IAsynchObserver;

import java.util.LinkedList;

public class Generator implements IGenerator {
    public Integer getValue() {
        return null;
    }

    public void generate() {

    }

    public LinkedList<IAsynchObserver<IGenerator>> getObss() {
        return null;
    }

    public void attach(IAsynchObserver<IGenerator> o) {

    }

    public void detach(IAsynchObserver<IGenerator> o) throws Exception {

    }

    public void notifyObserver() {

    }
}
