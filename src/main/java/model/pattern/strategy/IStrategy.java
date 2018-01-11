package model.pattern.strategy;

import model.pattern.generator.IGenerator;

/**
 * Interface des strategy
 */
public interface IStrategy {
    /**
     * Methode d'éwecution de la strategy
     */
    void execute();

    /**
     * Methode de configuration de la Strategy
     * @param generator
     */
    void generator(IGenerator generator);
}
