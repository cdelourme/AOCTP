import model.implementation.Afficheur;
import model.implementation.Generator;
import model.pattern.generator.IGenerator;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ){

        IGenerator g = new Generator();
        g.attach(new Afficheur("a1"));
        g.attach(new Afficheur("a2"));
        g.attach(new Afficheur("a3"));
        while (g.generate() < 9){
            try{
                Thread.sleep(1000);
            }catch(Exception e) { System.out.println(e.getMessage()); }
        }
        System.out.println("Terminé.");
    }
}
