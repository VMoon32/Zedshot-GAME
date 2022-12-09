import greenfoot.*;  
import java.util.*;

public class MyWorld_Two extends World
{
    Counter score = new Counter("ZombiePoints : ");
    
    private GreenfootImage background;
    private int backgroundX;
    
    private static long scoreWorld_Two;

    public MyWorld_Two()
    {    
        
        super(900, 600, 1, false); 

        background = new GreenfootImage("world2.png");
        getBackground().drawImage(background, 0, 0);
        prepare();
         

    }
    public void act(){
        this.drawBackground();
        scoreWorld_Two = (long)score.getValue();
        delayZombie();
    }
    
    public static long getZPoints(){
        return scoreWorld_Two;
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

        Protagonist prota = new Protagonist("MyWorld_Two"); 
        addObject(prota, 450, 450);

        CrosshairLabel crosshairLabel = new CrosshairLabel("MyWorld_One");
        addObject(crosshairLabel, 800, 550);

        ZombieWorld_Two zombie = new ZombieWorld_Two();
        addObject(zombie, 900, 460);
        
        
        addObject(new Weapon1(), 800, 400);
        addObject(new Weapon2(), 1720, 165);
        addObject(new Weapon2(), 2500, 165);
        
        addObject(new NextLevel(),4000, 300);
        
        addObject(new InvisibleY2(),100, 407);
        
        
        platformsAir();
    }
    
    
    public void platformsAir(){
        
        addObject(new FloorVisualAir(), 1000, 300);
        addObject(new FloorVisualAir(), 1240, 275);
        addObject(new FloorVisualAir(), 1480, 250);
        addObject(new FloorVisualAir(), 1720, 225);
        
        addObject(new FloorVisualAir(), 3220, 300);
        addObject(new FloorVisualAir(), 2980, 275);
        addObject(new FloorVisualAir(), 2740, 250);
        addObject(new FloorVisualAir(), 2500, 225);
        
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
