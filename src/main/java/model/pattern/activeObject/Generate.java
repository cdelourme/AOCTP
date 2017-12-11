package model.pattern.activeObject;

import model.pattern.generator.IGenerator;

public class Generate  implements Runnable{

    private IGenerator gen;

    public Generate(IGenerator gen){
        this.gen = gen;
    }

    @Override
    public void run() {
        gen.generate();
    }
}
