import greenfoot.*; 

public class GameOver extends World
{
    public GameOver()
    {    
        super(900, 600, 1); 
        CrosshairLabel crosshairLabel = new CrosshairLabel("GameOver");
        addObject(crosshairLabel, 430, 185);
        Greenfoot.playSound("Muerte.mp3");
        
        
    }
}
