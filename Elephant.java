import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Sound played when the elephant eats a burger
    GreenfootSound elephantSound = new GreenfootSound("elephantsounds.mp3");
    // Arrays to store animation frames for right and left facing direction
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // Tracks which direction the elephant is currently facing
    String facing = "right";
    
    // Timer to control animation speed
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant()
    {
        // Facing Right images
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(75, 75);
        }
        // Facing Left images
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(75, 75);
        }
        
        // Start the animation timer and set the starting image
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    // Index to keep track of which frame to show
    int imageIndex = 0;
    public void animateElephant()
    {
        // Wait 300ms before changing image
        if(animationTimer.millisElapsed() < 300)
        {
            return;
        }
        // reset timer
        animationTimer.mark();
        // Change image based on current direction
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
            
        }
    
    }
    public void act()
    {
        // Check for user input to move right or left
        if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
            facing = "left";
        }
    
        else if(Greenfoot.isKeyDown("right"))
        {
            move(5);
            facing = "right";
        }
        
        // Check if the elephant touches a burger
        eat();
        
        // Animate the elephant
        animateElephant();
    }
    public void eat()
    {
        if(isTouching(Burger.class))
        {
            // Remove the burger
            removeTouching(Burger.class);
            // Spawn new burger
            MyWorld world = (MyWorld) getWorld();
            world.createBurger();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
