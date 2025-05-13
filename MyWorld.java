import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    public Label scoreLabel;
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
        
        createBurger();
    }
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
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