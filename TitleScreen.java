import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    // Label to show the game title
    Label titleLabel = new Label("Hungry Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        // Add the game title label in the center of the screen
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        // Add other starting screen objects
        prepare();
    }

    public void act()
    {
        // Start the game if the player presses the space key
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Add a decorative elephant image to the screen
        Elephant elephant = new Elephant();
        addObject(elephant,492,103);
        // Add a label to instruct the user to press space to start
        Label label = new Label("Press <space> to Start", 30);
        addObject(label,255,266);
        label.setLocation(314,269);
        label.setLocation(291,269);
        label.setLocation(291,269);
        label.setLocation(286,263);
        // Add a label to show the controls
        Label label2 = new Label("Use ← and → to Move", 30);
        addObject(label2,278,327);
    }
}
