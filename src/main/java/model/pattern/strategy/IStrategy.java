package model.pattern.strategy;

public interface IStrategy {
    void execute();
    void generator(IGenerator generator);
}
