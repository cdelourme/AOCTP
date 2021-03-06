package model.pattern.activeObject;

import model.pattern.generator.IGenerator;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {
    private IGenerator generator;

    /**
     * Constructeur
     * @param generator
     */
    public GetValue(IGenerator generator) {
        this.generator = generator;
    }

    /**
     * Methode appelé lors de l'appel programmé
     * Appel le getvalue du generateur
     * @return
     * @throws Exception
     */
    public Integer call() throws Exception {
        return this.generator.getValue();
    }
}
