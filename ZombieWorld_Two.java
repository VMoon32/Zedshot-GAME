import greenfoot.*; 
import java.util.*;

public class ZombieWorld_Two extends Zombie
{
    private int currentImage = 0;
    private int delayRun = 0;  
    private int offsetX = -2;
    private int offsetDirection = -1;

    private String []imagesR = new String[]{
            "zombo0.gif",
            "zombo1.gif",
            "zombo2.gif",
            "zombo3.gif",
            "zombo4.gif",
            "zombo5.gif",
            "zombo6.gif",
            "zombo7.gif",
            "zombo8.gif",
            "zombo9.gif",
            "zombo10.gif",
            "zombo11.gif",
            "zombo12.gif",
            "zombo13.gif",
            "zombo14.gif",
            "zombo15.gif",
            "zombo16.gif"
        };

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

    ZombieWorld_Two(){
        super(20);
        
    }

    public void act(){
        moveZombie();
        bounceEdge();
    }

    private void moveZombie(){
        setLocation(this.getX() + offsetX, this.getY());

        switch(offsetDirection){
            case -1:
                moveWalkL();
                break;
            case 1:
                moveWalkR();
                break;
        }
    }

    private void bounceEdge(){
        if(isAtEdge()){
            offsetX = offsetX * -1;
            offsetDirection = offsetDirection * -1;
        }
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

    private void moveWalkR(){
        setImage(imagesR[currentImage]);
        delayRun++;
        if(delayRun == 5){
            currentImage = (currentImage + 1) % imagesR.length;
            setImage(imagesR[currentImage]);
            delayRun = 0;
        }
    }
}
