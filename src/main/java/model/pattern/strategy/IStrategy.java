package model.pattern.strategy;

import model.pattern.generator.IGenerator;

public interface IStrategy {
    void execute();
    void generator(IGenerator generator);
}
