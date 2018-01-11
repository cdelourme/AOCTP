package model.pattern.generator;

import java.util.concurrent.Future;

public interface IAsynchGenerator {
    /**
     * Methode d'obtention de la valeur generée.
     * @return
     */
    Future<Integer> getValue();
}
