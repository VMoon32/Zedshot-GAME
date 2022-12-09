
import greenfoot.*;  
import java.util.*;

public class MyWorld_Three extends World
{
    Counter score = new Counter("ZombiePoints : ");
    
    private GreenfootImage background;
    private int backgroundX;
    private static long scoreWorld_Three;


    public MyWorld_Three()
    {    
        
        super(900, 600, 1, false); 

        background = new GreenfootImage("fondo3.png");
        getBackground().drawImage(background, 0, 0);
        prepare();
         //Greenfoot.playSound("SonidoN2.mp3");

    }
    public void act(){
        
        this.drawBackground();
        
        scoreWorld_Three = (long)score.getValue();

        delayZombie();
    }
    
    
    public static long getZPoints(){
        return scoreWorld_Three;
    }
    
    private void delayZombie(){
        if(Greenfoot.getRandomNumber(1000) < Greenfoot.getRandomNumber(20)){
            ZombieWorld_Two zombie = new ZombieWorld_Two();
            addObject(zombie, 900, 460);

        }

    }

    private void prepare()
    {
        Life1 life1 = new Life1();
        addObject(life1, 50, 40);
        Life2 life2 = new Life2();
        addObject(life2, 150, 40);
        Life3 life3 = new Life3();
        addObject(life3, 250, 40);

        addObject(score,800,30);

        Protagonist prota = new Protagonist("MyWorld_Three"); 
        addObject(prota, 400, 500);

        CrosshairLabel crosshairLabel = new CrosshairLabel("MyWorld_Two");
        addObject(crosshairLabel, 800, 550);

        ZombieWorld_Two zombie = new ZombieWorld_Two();
        addObject(zombie, 900, 500);
        
        
        addObject(new Weapon1(), 600, 280);
        
        addObject(new Weapon2(), 1800, 94);
        addObject(new Weapon1(), 2750, 79);
        
        addObject(new InvisibleY3(),100, 407);
        
        addObject(new Finish(),4000, 400);
        
        platformsAir();
    }
    
    
    public void platformsAir(){
        
        
        addObject(new FloorVisualAir(), 600, 335);
        addObject(new FloorVisualAir(), 950, 244);
        addObject(new FloorVisualAir(), 1250, 378);
        
        addObject(new FloorVisualAir(), 1820, 360);
        addObject(new FloorVisualAir(), 1820, 150);
         addObject(new FloorVisualAir(), 2100, 260);
        
        addObject(new FloorVisualAir(), 3200, 380);
        addObject(new FloorVisualAir(), 2980, 275);
        addObject(new FloorVisualAir(), 2755, 138);
        
        
    }

    public void changeBackgroundX(int changeX){

        backgroundX = backgroundX - changeX;

        for(int i = 0; i < this.giveMeAllActors().size(); i++){
            if(this.giveMeAllActors().get(i).getClass() != Protagonist.class && this.giveMeAllActors().get(i).getClass() != CrosshairLabel.class && this.giveMeAllActors().get(i).getClass() != Counter.class && this.giveMeAllActors().get(i).getClass() != Life1.class && this.giveMeAllActors().get(i).getClass() != Life2.class && this.giveMeAllActors().get(i).getClass() != Life3.class && this.giveMeAllActors().get(i).getClass() != Life4.class){

                this.giveMeAllActors().get(i).setLocation(this.giveMeAllActors().get(i).getX() - changeX, this.giveMeAllActors().get(i).getY());

            }
        }

    }

    public void drawBackground(){
        this.getBackground().drawImage(background, backgroundX, 0);
    }

    public List<Actor> giveMeAllActors(){
        List<Actor> allActors;
        allActors = this.getObjects(Actor.class);
        return allActors;
    }
}
