import greenfoot.*; 
import java.time.*;

public class Protagonist extends Actor
{

    private String world;
    GreenfootSound backgroundMusic;

    private GifImage myGifStandingL = new GifImage("ProtaStandL.gif");
    private GifImage myGifStandingR = new GifImage("ProtaStandR.gif");
    private GifImage myGifRunR = new GifImage("protaYa0R.gif");
    private GifImage myGifRunL = new GifImage("protaYa0L.gif");
    private GifImage myGifStandingW1L = new GifImage("ProtaStand1L.gif");
    private GifImage myGifStandingW1R = new GifImage("ProtaStand1R.gif");
    private GifImage myGifRunW1R = new GifImage("protaWeapon1R.gif");
    private GifImage myGifRunW1L = new GifImage("protaWeapon1L.gif");
    private GifImage myGifStandingW2L = new GifImage("ProtaStand2L.gif");
    private GifImage myGifStandingW2R = new GifImage("ProtaStand2R.gif");
    private GifImage myGifRunW2R = new GifImage("protaWeapon2R.gif");
    private GifImage myGifRunW2L = new GifImage("protaWeapon2L.gif");
    private int verticalSpeed = 0;
    private int leftRight = 1;
    private int weaponOffor1or2 = 0;
    private int delayPush = 0;
    private int countImmunity = 0;
    private int counterImmunityTouching = 0;
    private int numberWorld;
    private int delayShoot = 0;
    private int bulletsCount = 0;
    public int bulletSpeed = 20;
    private int shotTime;
    private int life = 3;
    private int heart = 0;
    

    public Protagonist(String world){
        super();

        this.world = world;

    }

    public void act()
    {   
        checkWorld();

        checkFalling();

        checkCollisionZombie();

        checkCollisionWeapon();

        checkCollisionNewWorld();

        checkCollisionInvisible();

        stillAlive();
    }

    private void checkCollisionInvisible(){
        Actor wall;
        wall = getOneIntersectingObject(LimitWall.class); 

        if(wall != null){
            setLocation(getX() + 5, getY());
        }
    }

    private void checkCollisionNewWorld(){
        Actor level;
        level = getOneIntersectingObject(NextLevel.class); 
        
        switch(world){
            case "MyWorld_One":
                if(level != null){
            
                    Greenfoot.setWorld(new MyWorld_Two()); 
            
                }
                break;
            case "MyWorld_Two":
                if(level != null){
            
                    Greenfoot.setWorld(new MyWorld_Three()); 
            
                }
                break;
        }


    }
    
    
    private void checkWorld(){
        switch(world){
            case "MyWorld_One":
                checkAllKeysWorld1();
                break;
            case "MyWorld_Two":
                checkAllKeysWorld2();
                break;
            case "MyWorld_Three":
                checkAllKeysWorld3();
                break;
            
        }
    }

    private void checkAllKeysWorld1(){
        switch(weaponOffor1or2){
            case 0:
                checkKeysWorld1();
                break;
            case 1:
                checkKeysWeapon1World1();
                break;
            case 2:
                checkKeysWeapon2World1();
                break;
        }
    }

    private void checkAllKeysWorld2(){
        switch(weaponOffor1or2){
            case 0:
                checkKeysWorld2();
                break;
            case 1:
                checkKeysWeapon1World2();
                break;
            case 2:
                checkKeysWeapon2World2();
                break;
        }
    }
    
    private void checkAllKeysWorld3(){
        switch(weaponOffor1or2){
            case 0:
                checkKeysWorld3();
                break;
            case 1:
                checkKeysWeapon1World3();
                break;
            case 2:
                checkKeysWeapon2World3();
                break;
        }
    }

    private void checkKeysWorld1(){

        MyWorld_One worldOne;
        worldOne = (MyWorld_One)getWorld();

        if(Greenfoot.isKeyDown("Right")){
            leftRight = 1;

            setImage(myGifRunR.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                worldOne.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            leftRight = 0;

            setImage(myGifRunL.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                worldOne.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingL.getCurrentImage());
            }else{
                setImage(myGifStandingR.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunL.getCurrentImage());
                }else{
                    setImage(myGifRunR.getCurrentImage());
                }
                jump();
            }

        }
    }

    private void checkKeysWorld2(){

        MyWorld_Two world;
        world = (MyWorld_Two)getWorld();

        if(Greenfoot.isKeyDown("Right")){
            leftRight = 1;

            setImage(myGifRunR.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                world.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            leftRight = 0;

            setImage(myGifRunL.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                world.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingL.getCurrentImage());
            }else{
                setImage(myGifStandingR.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunL.getCurrentImage());
                }else{
                    setImage(myGifRunR.getCurrentImage());
                }
                jump();
            }

        }
    }
    
    private void checkKeysWorld3(){

        MyWorld_Three world;
        world = (MyWorld_Three)getWorld();

        if(Greenfoot.isKeyDown("Right")){
            leftRight = 1;

            setImage(myGifRunR.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                world.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            leftRight = 0;

            setImage(myGifRunL.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                world.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingL.getCurrentImage());
            }else{
                setImage(myGifStandingR.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunL.getCurrentImage());
                }else{
                    setImage(myGifRunR.getCurrentImage());
                }
                jump();
            }

        }
    }

    private void checkKeysWeapon1World1(){
        MyWorld_One worldOne;
        worldOne = (MyWorld_One)getWorld();

        shoot();

        if(Greenfoot.isKeyDown("Right")){
            bulletSpeed = 20;
            leftRight = 1;

            setImage(myGifRunW1R.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                worldOne.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            bulletSpeed = -20;
            leftRight = 0;

            setImage(myGifRunW1L.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                worldOne.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingW1L.getCurrentImage());
            }else{
                setImage(myGifStandingW1R.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() == true || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunW1L.getCurrentImage());
                }else{
                    setImage(myGifRunW1R.getCurrentImage());
                }
                jump();
            }

        }
    }

    private void checkKeysWeapon1World2(){
        MyWorld_Two world;
        world = (MyWorld_Two)getWorld();
        shoot();

        if(Greenfoot.isKeyDown("Right")){
            bulletSpeed = 20;
            leftRight = 1;

            setImage(myGifRunW1R.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                world.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            bulletSpeed = -20;
            leftRight = 0;

            setImage(myGifRunW1L.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                world.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingW1L.getCurrentImage());
            }else{
                setImage(myGifStandingW1R.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() == true || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunW1L.getCurrentImage());
                }else{
                    setImage(myGifRunW1R.getCurrentImage());
                }
                jump();
            }

        }
    }
    
    private void checkKeysWeapon1World3(){
        MyWorld_Three world;
        world = (MyWorld_Three)getWorld();
        shoot();

        if(Greenfoot.isKeyDown("Right")){
            bulletSpeed = 20;
            leftRight = 1;

            setImage(myGifRunW1R.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                world.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            bulletSpeed = -20;
            leftRight = 0;

            setImage(myGifRunW1L.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                world.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingW1L.getCurrentImage());
            }else{
                setImage(myGifStandingW1R.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() == true || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunW1L.getCurrentImage());
                }else{
                    setImage(myGifRunW1R.getCurrentImage());
                }
                jump();
            }

        }
    }

    private void checkKeysWeapon2World1(){
        MyWorld_One worldOne;
        worldOne = (MyWorld_One)getWorld();
        shoot();

        if(Greenfoot.isKeyDown("Right")){
            bulletSpeed = 20;
            leftRight = 1;

            setImage(myGifRunW2R.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                worldOne.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            bulletSpeed = -20;
            leftRight = 0;

            setImage(myGifRunW2L.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                worldOne.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingW2L.getCurrentImage());
            }else{
                setImage(myGifStandingW2R.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() == true || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunW2L.getCurrentImage());
                }else{
                    setImage(myGifRunW2R.getCurrentImage());
                }
                jump();
            }

        }
    }

    private void checkKeysWeapon2World2(){
        MyWorld_Two world;
        world = (MyWorld_Two)getWorld();
        shoot();

        if(Greenfoot.isKeyDown("Right")){
            bulletSpeed = 20;
            leftRight = 1;

            setImage(myGifRunW2R.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                world.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            bulletSpeed = -20;
            leftRight = 0;

            setImage(myGifRunW2L.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                world.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingW2L.getCurrentImage());
            }else{
                setImage(myGifStandingW2R.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() == true || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunW2L.getCurrentImage());
                }else{
                    setImage(myGifRunW2R.getCurrentImage());
                }
                jump();
            }

        }
    }
    
    private void checkKeysWeapon2World3(){
        MyWorld_Three world;
        world = (MyWorld_Three)getWorld();
        shoot();

        if(Greenfoot.isKeyDown("Right")){
            bulletSpeed = 20;
            leftRight = 1;

            setImage(myGifRunW2R.getCurrentImage());

            setLocation(getX() + 5, getY());
            if(getX() > 700){
                world.changeBackgroundX(5);
                setLocation(getX() - 5, getY());
            }
        }else if(Greenfoot.isKeyDown("Left")){
            bulletSpeed = -20;
            leftRight = 0;

            setImage(myGifRunW2L.getCurrentImage());

            setLocation(getX() - 5, getY());
            if(getX() < 200){
                world.changeBackgroundX(-5);
                setLocation(getX() + 5, getY());
            }
        }else{
            if(leftRight < 1 ){
                setImage(myGifStandingW2L.getCurrentImage());
            }else{
                setImage(myGifStandingW2R.getCurrentImage());
            }

        }

        if(Greenfoot.isKeyDown("space")){
            if(onGround() == true || getY() > 450){
                if(leftRight < 1 ){
                    setImage(myGifRunW2L.getCurrentImage());
                }else{
                    setImage(myGifRunW2R.getCurrentImage());
                }
                jump();
            }

        }
    }

    private void falling(){
        setLocation(getX(), getY() + verticalSpeed);
        verticalSpeed = verticalSpeed + 1;
    }

    private boolean onGround(){
        Actor groundBelow;
        groundBelow = getOneObjectAtOffset(0, 48, FloorVisualAir.class);

        if(groundBelow != null){
            return true;
        }else{
            return false;
        }
    }

    private void checkFalling(){

        if(onGround() == true || getY() > 450){ 
            verticalSpeed = 0;
        }else{
            falling();
        }
    }

    private void jump(){
        verticalSpeed = -20;
        Greenfoot.playSound("Salto.mp3");
        falling();
    }

    private void checkCollisionZombie(){
        Actor enemy;
        enemy = getOneIntersectingObject(Zombie.class); 

        if(countImmunity < 400 && counterImmunityTouching < 1)
        {

            if(enemy != null){

                Blood blood = new Blood();
                getWorld().addObject(blood, getX(), getY());
                setLocation(getX() - 30, getY() - 30);

                countImmunity = 100;
                counterImmunityTouching = counterImmunityTouching + 1;
                life--;
                Greenfoot.playSound("Golpe.mp3");
                Greenfoot.delay(0);
            }

        }else{
            countImmunity = countImmunity - 1;
            if(countImmunity == 0){
                counterImmunityTouching = 0;
            }
        }

    }

    private void stillAlive(){

        switch(life){
            case 2:
                if(heart < 1){
                    Counter score = (Counter) getWorld().getObjects(Counter.class).get(0);
                    score.add(-20);
                    getWorld().addObject(new Life4(), 250, 40);
                }
                heart = 1;
                break;
            case 1:
                if(heart < 2){
                    Counter score = (Counter) getWorld().getObjects(Counter.class).get(0);
                    score.add(-40);
                    getWorld().addObject(new Life4(), 150, 40);
                }
                heart = 2;
                break;
            case 0:
                Greenfoot.setWorld(new GameOver()); 
                break;

        }
    }

    private void checkCollisionWeapon(){
        weapon1();
        weapon2();
    }

    private void weapon1(){
        Actor weapon1;
        weapon1 = getOneIntersectingObject(Weapon1.class); 

        if(weapon1 != null){
            weaponOffor1or2 = 1;
            bulletsCount = 10;
            shotTime = 10;
        }
    }

    private void weapon2(){
        Actor weapon2;
        weapon2 = getOneIntersectingObject(Weapon2.class); 

        if(weapon2 != null){
            weaponOffor1or2 = 2;
            bulletsCount = 10;
            shotTime = 50;
        }
    }

    private void shoot(){
        if(delayShoot > 0){
            delayShoot--;
            return;
        }

        if(Greenfoot.isKeyDown("X") || Greenfoot.isKeyDown("M")){
            if(!Greenfoot.isKeyDown("space")){
                if(bulletsCount != 0){
                    getWorld().addObject(new Bullet(bulletSpeed), getX(), getY());
                    bulletsCount--;
                    delayShoot = shotTime;
                }
            }
        }
        if(bulletsCount == 0){
            weaponOffor1or2 = 0;
        }
    }
}
