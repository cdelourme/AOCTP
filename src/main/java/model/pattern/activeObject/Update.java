package model.pattern.activeObject;

        import model.pattern.generator.IAsynchGenerator;
        import model.pattern.observer.ISubject;

        import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    private ISubject<IAsynchGenerator> subject;

    public Update(ISubject<IAsynchGenerator> asynchroneGenerator) {
        this.subject = asynchroneGenerator;
    }

    public Void call() throws Exception {
        this.subject.notifyObserver();
        return null;
    }
}
