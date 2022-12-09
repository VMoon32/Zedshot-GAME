import greenfoot.*;  

public abstract class Labels extends Actor
{
    /**
     * Act - do whatever the Labels wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveOrActivate();
    }
    
    public abstract void moveOrActivate();
}
