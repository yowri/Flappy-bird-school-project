import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    int pipeCounter = 0;
    int flappyCounter = 0;
    int PIPE_SPACING = 150;
    int score = 0;
    int FIRST_PIPE = 240;
    Score scoreObj = null;
    int PIPE_HEIGHT;

    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        // Set paint order
        setPaintOrder(Score.class, GameOver.class, FlappyBird.class, TopPipe.class, BottomPipe.class);
        
        // Maak nieuwe flappybird
        FlappyBird flappy = new FlappyBird();
        
        addObject(flappy, 100, getHeight()/2);
        
        // Maak scoreobject
        scoreObj = new Score();
        scoreObj.setScore(0);
        
        // Voeg scoreobject toe
        addObject(scoreObj, 50, 25);
        
    }
    
    public void act()
    {
        pipeCounter++;
        if ( pipeCounter % 75 == 0)
        {
            createPipes();
        }
        
        if(pipeCounter > FIRST_PIPE)
        {
            if ( flappyCounter % 75 == 0)
            {
                score++;
                scoreObj.setScore(score);
            }
            flappyCounter++;
        }
    }
    
    private void createPipes()
    {
        BottomPipe bottomPipe = new BottomPipe();
        TopPipe topPipe = new TopPipe();
        
        
        int randomGetal = Greenfoot.getRandomNumber(170);
        GreenfootImage image = new GreenfootImage("top_pipe.png");
        PIPE_HEIGHT = image.getHeight();
        
        addObject(bottomPipe, getWidth(), 500-randomGetal);
        addObject(topPipe, getWidth(), 80-randomGetal);
        
        randomGetal = 0;

    }
}
