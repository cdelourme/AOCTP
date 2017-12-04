package model.pattern.activeObject;

import model.pattern.generator.IGenerator;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {
    private IGenerator generator;

    public GetValue(IGenerator generator) {
        this.generator = generator;
    }

    public Integer call() throws Exception {
        return this.generator.getValue();
    }
}
