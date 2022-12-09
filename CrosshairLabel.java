import greenfoot.*; 
import javax.swing.JOptionPane;

public class CrosshairLabel extends Labels
{
    private int delay = 0;
    private String world;
    private long timeClock;

    public CrosshairLabel(String world)
    {
        super();
            
        this.world = world;
        
        setImage("crosshair.png");
        
        moveOrActivate();
    }
    
    public void moveOrActivate(){
        if(Greenfoot.isKeyDown("X") || Greenfoot.isKeyDown("M")){
            
            switch(world){
                case "WelcomeMyWorld_One":
                    rotate();
                    Greenfoot.setWorld(new MyWorld_One());
                    break;
                case "Records":
                    rotate();
                    MyWorld_One.stopMusic();
                    Greenfoot.setWorld(new Menu());
                    break;
                case "How":
                    rotate();
                    Greenfoot.setWorld(new Menu());
                    break;
                case "CloseGame":
                    rotate();
                    Greenfoot.stop();
                    break; 
                case "MyWorld_One":
                    rotateInGame();
                    break;
                case "GameOver":
                    rotate();
                    rotate();
                    MyWorld_One.stopMusic();
                    Greenfoot.setWorld(new Menu());
                    break;
            }
            
        }
    }
    
    
    
    private void rotate(){
    
        for(int rotate = 0; rotate < 5; rotate = rotate + 1){
            if(rotate == 0){
                setRotation(45);
            }else if(rotate ==1){
                setRotation(90);
            }else if(rotate ==2){
                setRotation(45);
            }else if(rotate ==3){
                setRotation(90);
            }else if(rotate ==4){
                setRotation(45);
            }else{
                setRotation(65);
            }
            Greenfoot.delay(20);
        }
        
    }
    
    private void rotateInGame(){
    
        for(int rotate = 0; rotate < 5; rotate = rotate + 1){
            if(rotate == 0){
                setRotation(45);
            }else if(rotate ==1){
                setRotation(90);
            }else if(rotate ==2){
                setRotation(45);
            }else if(rotate ==3){
                setRotation(90);
            }else if(rotate ==4){
                setRotation(90);
            }else{
                setRotation(90);
            }
            Greenfoot.delay(0);
        }
        
    }
    
    
}
