/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ){

        Generateur g = new GenerateurImpl();
        g.addObserver(new AfficheurImpl("a1"));
        g.addObserver(new AfficheurImpl("a2"));
        g.addObserver(new AfficheurImpl("a3"));
        while (((GenerateurImpl) g).generateValue() < 9){
            try{
                Thread.sleep(1000);
            }catch(Exception e) { System.out.println(e.getMessage()); }
        }
        System.out.println("Terminé.");
    }
}
