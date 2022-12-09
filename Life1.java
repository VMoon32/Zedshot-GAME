import greenfoot.*; 

public class Life1 extends Life
{
    private int currentImage = 0;
    private int delay = 0;
    
    private String []images = new String[]{
        "corazon1-aMano.png",
        "corazon2-aMano.png",
        "corazon3-aMano.png",
        "corazon4-aMano.png",
        "corazon5-aMano.png"
        
    };
    
    Life1(){
        
        setImage(images[currentImage]);
    }
    public void act()
    {
        moveHeart();
    }
    
    private void moveHeart(){
        delay++;
        if(delay == 8){
            
            currentImage = (currentImage + 1) % images.length;
            setImage(images[currentImage]);
            delay = 0;
        }
    }
    
    
}
