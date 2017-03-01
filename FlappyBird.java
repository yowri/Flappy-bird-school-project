import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    double dy = 0;
    double g = 1.3;
    double BOOST_SPEED = -12;
    
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // coecaraga die in the pipe
        if(isTouching(BottomPipe.class) || isTouching(TopPipe.class))
        {
            gameOver();
        }
        
        setLocation( getX(), (int)(getY()  + dy) );
        rotateFlappyBird();
        
        // Gebruiker drukt OMHOOG in.
        if(Greenfoot.isKeyDown("up") == true)
        {
            dy = BOOST_SPEED;
        }
        
        //als flappybird de onderkant raakt.
        if(getY() > getWorld().getHeight()){
                gameOver();
         }

        dy = dy + g;
    }
    
    public void gameOver(){
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        
        Greenfoot.stop();
    }
    
    public void rotateFlappyBird()
    {
        if (dy >= -25 && dy <= -5)
        {
            setRotation(-30);
        }
        else if (dy >= -5 && dy <= 15)
        {
            setRotation(30);
        }
        else if (dy >= 15 && dy <= 35)
        {
            setRotation(60);
        }
    }
}
