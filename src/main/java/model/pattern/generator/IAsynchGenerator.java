package model.pattern.generator;

import java.util.concurrent.Future;

public interface IAsynchGenerator {
    Future<Integer> getValue();
}
