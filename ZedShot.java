import greenfoot.*;  


public class ZedShot extends MenuLabels
{
    
    
    private String []images = new String[]{
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-13.png",
        "images/pixil-layer-12.png",
        "images/pixil-layer-11.png",
        "images/pixil-layer-10.png",
        "images/pixil-layer-9.png",
        "images/pixil-layer-10.png",
        "images/pixil-layer-11.png",
        "images/pixil-layer-12.png",
        "images/pixil-layer-13.png"
    };
    private int currentImage = 0;
    private int delayZed = 0; 
    
    public void act()
    {
        moveTitle();
    }
    
    private void moveTitle(){
        delayZed++;
        
        if(delayZed == 5){
            currentImage = (currentImage + 1) % images.length;
            setImage(images[currentImage]);
            delayZed = 0;
        }
    }
}
