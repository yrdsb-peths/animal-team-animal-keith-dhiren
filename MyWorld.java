import greenfoot.*;

public class MyWorld extends World {
    // Track the player's score
    public int score = 0;
    // Label to display the current score
    public Label scoreLabel;
    // Game level
    int level = 1;
    public MyWorld() {
        //Create the new world
        super(600, 400, 1, false);
        
        // Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //Create a label
        scoreLabel = new Label(0, 40);
        addObject(scoreLabel, 20, 20);
        
        // Spawn first burger
        createBurger();
    }
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    public void increaseScore(){
        score++; // Increase score by one
        scoreLabel.setValue(score); // Update label
        // Increase level every 5 points
        if(score % 5 ==0){
            level += 1;
        }
    }
    public void createBurger(){
        // Create a pizza at a random x quordinate
        Burger burger = new Burger();
        burger.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(burger, x, y);
    }
}