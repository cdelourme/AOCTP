package model.pattern.observer;

public interface ISubject<T> {
    void attach(IObserver<T> o);
    void detach(IObserver<T> o) throws Exception;
    void notifyObserver();
}
