package model.pattern.proxy;

import model.pattern.activeObject.GetValue;
import model.pattern.activeObject.Update;
import model.pattern.generator.IAsynchGenerator;
import model.pattern.generator.IGenerator;
import model.pattern.observer.IAsynchObserver;
import model.pattern.observer.IObserver;
import model.pattern.observer.ISubject;

import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements ISubject<IAsynchGenerator>, IAsynchObserver<IGenerator>, IAsynchGenerator {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
    private IGenerator generator;
    private int latence;

    public Canal(IGenerator generator, int latence) {
        this.generator = generator;
        this.latence = latence;
    }

    /****************************ISubject****************************/
    private LinkedList<IObserver<IAsynchGenerator>> obss = new LinkedList<IObserver<IAsynchGenerator>>();

    public void attach(IObserver<IAsynchGenerator> o) {
        this.obss.add(o);
    }

    public void detach(IObserver<IAsynchGenerator> o) throws Exception {
        if(!this.obss.contains(o)){
            this.obss.add(o);
        }else {
            throw new Exception("L'object existe déjà dans la liste.");
        }
    }

    public void notifyObserver() {
        this.obss.forEach((p) -> p.update(this) );
    }
    /*******************************END*****************************/


    /*****************************IAsynchObs************************/
    public Future<Void> update(IGenerator subject) {
        return scheduler.schedule(new Update(this),latence, TimeUnit.MILLISECONDS);
    }
    /*******************************END*****************************/


    /*******************************IAsynchroneGenerator***********/
    public Future<Integer> getValue(){
        return scheduler.schedule(new GetValue(this.generator),latence,TimeUnit.MILLISECONDS);
    }
    /*******************************END*****************************/

}