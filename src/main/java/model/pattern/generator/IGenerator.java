package model.pattern.generator;


import model.pattern.observer.IAsynchObserver;
import model.pattern.observer.IAsynchSubject;
import model.pattern.strategy.IClientStrategy;

import java.util.LinkedList;
import java.util.concurrent.Callable;

public interface IGenerator extends IAsynchSubject<IGenerator> , IClientStrategy {
    Integer getValue();
    void generate();
    LinkedList<IAsynchObserver<IGenerator>> getObss();
}
