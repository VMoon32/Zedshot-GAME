import greenfoot.*;  

public class KillZombieL extends VisualEffects
{
    private int counter = 0;
    GifImage killL = new GifImage("killZomboL.gif");
    
    public void act()
    {
        setImage(killL.getCurrentImage());
        
        counter = counter + 1;
        
        if(counter > 60){
            this.getWorld().removeObject(this);
            
        }
    }
}