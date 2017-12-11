package model.implementation;

import model.pattern.generator.IGenerator;
import model.pattern.observer.IAsynchObserver;
import model.pattern.strategy.IStrategy;

import java.util.LinkedList;

public class Generator implements IGenerator {

    private IStrategy strategie;
    private int value= 1;

    /*************************Generator******************************/

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void generate() {
        this.value++;
        this.notifyObserver();
    }


    /*******************************END******************************/

    /*************************ClientStrategy******************************/
    @Override
    public void changeStrategy(IStrategy strategy) {
        this.strategie = strategy;
        this.strategie.generator(this);
    }

    /*******************************END******************************/

    private LinkedList<IAsynchObserver<IGenerator>> obss = new LinkedList<>();
    public LinkedList<IAsynchObserver<IGenerator>> getObss() {
        return obss;
    }
    /****************************Observer****************************/


    @Override
    public void attach(IAsynchObserver<IGenerator> o) {
        this.obss.add(o);
    }

    @Override
    public void detach(IAsynchObserver<IGenerator> o) throws Exception {
        if(!this.obss.contains(o)){
            this.obss.add(o);
        }else {
            throw new Exception("L'object existe déjà dans la liste.");
        }
    }

    @Override
    public void notifyObserver() {
        this.strategie.execute();
    }
/*******************************END*****************************/
}