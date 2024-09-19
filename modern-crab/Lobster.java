// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Lobster extends Actor
{

    /**
     * 
     */
    public Lobster()
    {
        turn(Greenfoot.getRandomNumber(360));
    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        eatCrab();
        initRotate();
        zombie();
        if (isGameLost()) {
            transitionToGameOverWorld();
        }
    }

    /**
     * 
     */
    public void initRotate()
    {
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(360) - 1);
        }
    }

    /**
     * 
     */
    public void moveAround()
    {
        move(4);
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (isAtEdge()) {
            turn(180);
        }
    }

    /**
     * 
     */
    public void eatCrab()
    {
        Actor crab = getOneIntersectingObject(Crab.class);
        if (crab != null) {
            World world = getWorld();
            world.removeObject(crab);
            Greenfoot.playSound("game-over-38511.wav");
        }
    }

    /**
     * 
     */
    public void zombie()
    {
        Actor worm = getOneIntersectingObject(Worm.class);
        World world = getWorld();
        if (worm != null) {
            getWorld().addObject( new  Lobster(), getX(), getY());
            Greenfoot.playSound("metal-pipe-230698.wav");
            getWorld().removeObject(worm);
        }
    }

    /**
     * 
     */
    public boolean isGameLost()
    {
        World world = getWorld();
        if (world.getObjects(Crab.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 
     */
    public void transitionToGameOverWorld()
    {
        World gameOverWorld =  new  GameOverWorld();
        Greenfoot.setWorld(gameOverWorld);
    }
}
