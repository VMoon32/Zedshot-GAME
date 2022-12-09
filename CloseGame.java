import greenfoot.*; 
public class CloseGame extends World
{
    public CloseGame()
    {    
        super(900, 600, 1); 
        CrosshairLabel crosshairLabel = new CrosshairLabel("CloseGame");
        addObject(crosshairLabel, 430, 185);
    }
}
