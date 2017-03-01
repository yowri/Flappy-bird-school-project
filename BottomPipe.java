import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BottomPipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BottomPipe extends Actor
{
    int PIPE_SPEED = -4;
    /**
     * Act - do whatever the BottomPipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation( getX() + PIPE_SPEED, getY() );
    }    
}
