package model.pattern.observer;

public interface IObserver<T> {
    void update(T subject);
}
