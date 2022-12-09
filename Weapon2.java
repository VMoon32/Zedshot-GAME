import greenfoot.*; 

public class Weapon2 extends Weapon
{

    private int levitater = -1;
    private int delay = 0;
    private int bulletsCount = 0;
    
    public Weapon2(){
        setImage("weapon2.png");
    }
    
    public void act()
    {
       moveWeapon();
       checkCollisionProta();
       setLevitator();
    }
    
    private void moveWeapon(){
        setLocation(getX(), getY() + levitater);
    }
    
    private void setLevitator(){
        if(delay > 0){
                delay--;
                return;
            }
                
        levitater = levitater * -1;
        delay = 30;
        
    }
    
    private void checkCollisionProta(){
        Actor prota;
        prota = getOneIntersectingObject(Protagonist.class); 
        
        if(prota != null){
            getWorld().removeObject(this);
            
        }
    }
}