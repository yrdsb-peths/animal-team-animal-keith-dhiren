import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Burger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Burger extends Actor
{
    
    /**
     * Act - do whatever the Burger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Speed at which the burger falls
    int speed = 1;
    public void act()
    {
        // Move the burger down
        setLocation(getX(), getY() + speed);
        
        // Get a reference to the world the burger is in
        MyWorld world = (MyWorld) getWorld();
        // Check if the burger has reached the bottom of the screen
        if(getY() >= world.getHeight()){
            // Trigger game over and remove the burger from the world
            world.gameOver();
            world.removeObject(this);
        }
    }
    public void setSpeed(int spd){
        speed = spd;
    }
}
