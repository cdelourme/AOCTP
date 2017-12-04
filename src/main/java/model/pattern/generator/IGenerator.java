package model.pattern.generator;


import model.pattern.observer.IAsynchObserver;
import model.pattern.observer.IAsynchSubject;

import java.util.LinkedList;

public interface IGenerator extends IAsynchSubject<IGenerator> {
    Integer getValue();
    void generate();
    LinkedList<IAsynchObserver<IGenerator>> getObss();
}
