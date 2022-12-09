import greenfoot.*;  
import java.util.*;

public class MyWorld_One extends World
{
    Counter score = new Counter("ZombiePoints : ");
    
    Protagonist prota; 

    private GreenfootImage background;
    private int backgroundX;
    static GreenfootSound backgroundMusic = new GreenfootSound("SonidoN1.wav");
    
    private static long scoreWorld_One;

    public MyWorld_One()
    {    

        super(900, 600, 1, false); 

        background = new GreenfootImage("fondo1.png");
        getBackground().drawImage(background, 0, 0);
        prepare();
        
        
    }
    

    
    public void act(){
        this.drawBackground();
        
        playMusic();
        
        scoreWorld_One = (long)score.getValue();
        
        delayZombie();
        
    }
    
    public static void playMusic()
    {
        backgroundMusic.playLoop();
    }
    
    public static void stopMusic()
    {
        backgroundMusic.stop();
    }

    public static long getZPoints(){
        return scoreWorld_One;
    }
    
    private void delayZombie(){
        if(Greenfoot.getRandomNumber(1000) < Greenfoot.getRandomNumber(20)){
            ZombieWorld_One zombie = new ZombieWorld_One();
            addObject(zombie, 900, 460);
            Greenfoot.playSound("ZombieSE.mp3");

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

        Protagonist prota = new Protagonist("MyWorld_One"); 
        addObject(prota, 450, 450);

        CrosshairLabel crosshairLabel = new CrosshairLabel("MyWorld_One");
        addObject(crosshairLabel, 800, 550);

        ZombieWorld_One zombie = new ZombieWorld_One();
        addObject(zombie, 900, 460);

        addObject(new Weapon1(), 900, 40);
        addObject(new Weapon1(), 2840, 140);
        addObject(new Weapon2(),2100, 160);
        addObject(new Weapon2(), 240, 425);

        addObject(new InvisibleY1(),100, 407);

        addObject(new NextLevel(),4000, 300);
        
        platformsAir();
    }

    public void platformsAir(){
        addObject(new FloorVisualAir(), 1300, 200);
        addObject(new FloorVisualAir(), 900, 100);
        addObject(new FloorVisualAir(), 950, 350);
        addObject(new FloorVisualAir(), 1700, 275);
        addObject(new FloorVisualAir(), 2100, 230);

        addObject(new FloorVisualAir(), 2600, 350);
        addObject(new FloorVisualAir(), 2840, 350);
        addObject(new FloorVisualAir(), 2840, 200);

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
