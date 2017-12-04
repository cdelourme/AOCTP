package model.pattern.observer;

import java.util.concurrent.Future;

public interface IAsynchObserver<T> {
    Future<Void> update(T subject);

}
