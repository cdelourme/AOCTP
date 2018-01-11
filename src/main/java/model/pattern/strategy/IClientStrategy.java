package model.pattern.strategy;

/**
 * Interface a implémenter dans l'élément utilisant une strategy
 */
public interface IClientStrategy {
    /**
     * Methode permettant le changement de Strategy
     * @param strategy
     */
    void changeStrategy(IStrategy strategy);
}
