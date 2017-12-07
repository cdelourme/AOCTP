package model.implementation;

import model.pattern.generator.IGenerator;
import model.pattern.observer.IAsynchObserver;
import model.pattern.strategy.IStrategy;

import java.util.LinkedList;

public class Generator implements IGenerator {

    private IStrategy strategie;
    public IStrategy getStrategie() {
        return strategie;
    }

    public void setStrategie(IStrategy strategie) {
        this.strategie = strategie;
    }

    private int value= 1;

    /*************************Strategie******************************/

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void generate() {
        this.notifyObserver();
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