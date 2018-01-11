package model.pattern.activeObject;

        import model.pattern.generator.IAsynchGenerator;
        import model.pattern.observer.ISubject;

        import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    private ISubject<IAsynchGenerator> subject;

    /**
     * Constructeur
     * @param asynchroneGenerator
     */
    public Update(ISubject<IAsynchGenerator> asynchroneGenerator) {
        this.subject = asynchroneGenerator;
    }

    /**
     * Methode appelé lors de l'appel programmé
     * Appel le notify Observer du subject
     * @return
     * @throws Exception
     */
    public Void call() throws Exception {
        this.subject.notifyObserver();
        return null;
    }
}
