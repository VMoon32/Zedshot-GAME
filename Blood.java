import greenfoot.*;  


public class Blood extends VisualEffects
{
    private int counter = 0;
    GifImage bloodExplode = new GifImage("blood.gif");
    
    public void act()
    {
        setImage(bloodExplode.getCurrentImage());
        
        counter = counter + 1;
        
        if(counter > 50){
            this.getWorld().removeObject(this);
        }
    }
}
