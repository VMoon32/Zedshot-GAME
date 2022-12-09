import greenfoot.*;  


public class Bullet extends Weapon
{
    public int speed = 20;
    
    public Bullet(int bulletSpeed){
        setImage("bullet.png");
        speed = bulletSpeed;
    }
    
    public void act()
    {
        move(speed);
        killBullet();
    }
    
    public void killBullet(){
        Actor zombie = getOneIntersectingObject(Zombie.class);
        Zombie kill = (Zombie)getOneIntersectingObject(Zombie.class);
        Counter score = (Counter) getWorld().getObjects(Counter.class).get(0);
        
        if(zombie != null){
            if(speed == 20){
                KillZombieR killAnimation = new KillZombieR();
                getWorld().addObject(killAnimation, getX() + 20, getY());
                
                Greenfoot.delay(0);
            }else if(speed == -20){
                KillZombieL killAnimation = new KillZombieL();
                getWorld().addObject(killAnimation, getX() - 20, getY());
                Greenfoot.delay(0);
            }
            Greenfoot.playSound("Golpe1.mp3");
            World world;
            world = getWorld();
            world.removeObject(zombie);
            score.add(kill.getScore());
            getWorld().removeObject(this);
        }else if(getX() >= getWorld().getWidth() - 1){
            getWorld().removeObject(this);
        }
    }
}
