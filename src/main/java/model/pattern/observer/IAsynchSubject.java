package model.pattern.observer;

public interface IAsynchSubject<T> {
    void attach(IAsynchObserver<T> o);
    void detach(IAsynchObserver<T> o) throws Exception;
    void notifyObserver();
}
