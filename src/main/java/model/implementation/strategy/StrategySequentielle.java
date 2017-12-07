package model.implementation.strategy;

import model.pattern.generator.IGenerator;
import model.pattern.strategy.IStrategy;

public class StrategySequentielle implements IStrategy {

    private IGenerator generator;


    @Override
    public void execute() {

    }

    @Override
    public void generator(IGenerator generator) {
        this.generator = generator;
    }
}
