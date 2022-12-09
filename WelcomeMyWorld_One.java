import greenfoot.*;

public class WelcomeMyWorld_One extends World
{
    GifImage start = new GifImage("Start.gif");
    public WelcomeMyWorld_One()
    {    
        super(900, 600, 1); 
        CrosshairLabel crosshairLabel = new CrosshairLabel("WelcomeMyWorld_One");
        addObject(crosshairLabel, 450, 300);
        
    }
    
    public void act(){
        setBackground(start.getCurrentImage());
    }
}
