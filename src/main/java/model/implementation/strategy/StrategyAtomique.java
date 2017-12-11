package model.implementation.strategy;

import model.pattern.generator.IGenerator;
import model.pattern.strategy.IStrategy;

import java.util.LinkedList;

public class StrategyAtomique implements IStrategy {

    private IGenerator generator;

    @Override
    public void execute() {
            this.generator.getObss().forEach(p->{
                    try{
                p.update(generator).get();

            } catch (Exception ex){
                        System.out.println("An error occured on update (Atomique)");

                    }
        });
    }

    @Override
    public void generator(IGenerator generator) {
        this.generator = generator;
    }
}
