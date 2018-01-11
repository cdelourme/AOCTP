package model.pattern.generator;


import model.pattern.observer.IAsynchObserver;
import model.pattern.observer.IAsynchSubject;
import model.pattern.strategy.IClientStrategy;

import java.util.LinkedList;
import java.util.concurrent.Callable;

public interface IGenerator extends IAsynchSubject<IGenerator> , IClientStrategy {
    /**
     * Methode d'obtention de la valeur generée.
     * @return
     */
    Integer getValue();

    /**
     * Methode de generation d'une valeur
     */
    void generate();

    /**
     * Methode retournant la liste des observateurs
     * Pour la strategy
     * @return
     */
    LinkedList<IAsynchObserver<IGenerator>> getObss();
}
