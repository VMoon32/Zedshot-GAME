import greenfoot.*; 
import java.util.*;

public class ZombieWorld_One extends Zombie
{
    private int currentImage = 0;
    private int delayRun = 0;  
    
    private String []imagesL = new String[]{
        "zL0.gif",
        "zL1.gif",
        "zL2.gif",
        "zL3.gif",
        "zL4.gif",
        "zL5.gif",
        "zL6.gif",
        "zL7.gif",
        "zL8.gif",
        "zL9.gif",
        "zL10.gif",
        "zL11.gif",
        "zL12.gif",
        "zL13.gif",
        "zL14.gif",
        "zL15.gif",
        "zL16.gif"
    };
      
    ZombieWorld_One(){
        super(10);
        setImage(imagesL[currentImage]);
    }
    
    public void act(){
        moveZombie();

        if(getX() < 1){
            getWorld().removeObject(this);
        }
        
        
    }
    

    private void moveZombie(){
        setLocation(this.getX() - 2, this.getY());
        moveWalkL();
    }
    
    private void moveWalkL(){
        setImage(imagesL[currentImage]);
        delayRun++;
        if(delayRun == 5){
            currentImage = (currentImage + 1) % imagesL.length;
            setImage(imagesL[currentImage]);
            delayRun = 0;
        }
    }

    
    
}
