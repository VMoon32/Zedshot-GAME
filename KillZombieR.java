import greenfoot.*;  

public class KillZombieR extends VisualEffects
{
    private int counter = 0;
    GifImage killR = new GifImage("killZomboR.gif");
    
    public void act()
    {
        setImage(killR.getCurrentImage());
        
        counter = counter + 1;
        
        if(counter > 60){
            this.getWorld().removeObject(this);
            
        }
    }
}
