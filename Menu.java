import greenfoot.*;  

public class Menu extends World
{
    
    GreenfootSound musicMenu = new GreenfootSound("SonidoN2.mp3");
    private Crosshair crosshair = new Crosshair();
    private Gun gun = new Gun();
    private int option = 0;
    private int delay = 0;
    
    public Menu()
    {    
        super(900, 600, 1); 
        prepare();
    }
    
    public void act(){
        playMusic();
        moveMenu();        
    }
    
    private void playMusic()
    {
        musicMenu.playLoop();
        
    }
    
    private void prepare()
    {
        imagesMenu();
        addObject(crosshair,201,262);
        addObject(gun,450,300);
    }
    
    private void imagesMenu(){
        ZedShot zedShot = new ZedShot();
        addObject(zedShot,449,301);

    }
    
    private void moveMenu(){
            delayCrosshair();
            selectActionOfCrosshairAndGun();
        }   
    
    private void delayCrosshair(){
            if(delay > 0){
                delay--;
                return;
            }
            
            if(Greenfoot.isKeyDown("Up")){
                Greenfoot.playSound("Beep.mp3");
                option--;
                delay = 10;
            }
        
            if(Greenfoot.isKeyDown("Down")){
                Greenfoot.playSound("Beep.mp3");
                option++;
                delay = 10;
            }
            
            if(option>=4){
                option=0;
            }
            
            if(option<0){
                option=3;
            }
        }
        
    private void selectActionOfCrosshairAndGun(){
        switch(option){
                
                    case 0:
                        crosshair.setLocation(201,262);
                        gun.setLocation(450,300);
                        break;
                    case 1:
                        crosshair.setLocation(201,340);
                        gun.setLocation(450,389);
                        break;
                    case 2:
                        crosshair.setLocation(201,427);
                        gun.setLocation(450,488);
                        break;    
                    case 3:
                        crosshair.setLocation(201,509);
                        gun.setLocation(450,582);
                        gun.act();
                        break;
                    }
                    
        if(Greenfoot.isKeyDown("Space") || Greenfoot.isKeyDown("Enter")){
                
                switch(option){
                    case 0:
                        Greenfoot.playSound("Pistol.mp3");
                        Greenfoot.setWorld(new WelcomeMyWorld_One());
                        musicMenu.stop();
                        
                        break;
                    case 1: 
                        Greenfoot.playSound("Pistol.mp3");
                        Greenfoot.setWorld(new Records());
                        musicMenu.stop();
                        break;
                    case 2: 
                        Greenfoot.playSound("Pistol.mp3");
                        Greenfoot.setWorld(new InstructionsHow());
                        musicMenu.stop();
                        break;
                    case 3:
                        Greenfoot.playSound("Pistol.mp3");
                        Greenfoot.setWorld(new CloseGame());
                        musicMenu.stop();
                        break;
                }
            }
        }
    }
