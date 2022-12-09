import greenfoot.*;  
import javax.swing.JOptionPane;

public class Finish extends Actor
{
    private long maxScore;
    
    Finish(){
        setImage("Finish.png");
    }

    public void act()
    {
        checkEnd();
    }

    public void checkEnd(){
        Actor protagonist;
        protagonist = getOneIntersectingObject(Protagonist.class);
        
        maxScore=(MyWorld_One.getZPoints() + MyWorld_Two.getZPoints() + MyWorld_Three.getZPoints());
        
        
        if(protagonist != null){
            String inputValue=JOptionPane.showInputDialog("Hall Of Fame:");

            Greenfoot.setWorld(new RegisterRecords(inputValue, maxScore));
        }

    }
}
