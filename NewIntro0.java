import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewIntro0 extends Trap
{
        Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Boy boy;
    int delay = 0;
    int timer = 0;
    /**
     * Constructor for objects of class Intro0.
     * 
     */
    private GreenfootSound bloodBourne = new GreenfootSound("Bloodborne - Celestial Emissary.mp3");
    // Sound from https://www.youtube.com/watch?v=jKfavoLsQWc
    public NewIntro0(Boy boy)
    {
        super();
        this.boy = boy;
        
        prepare();        
        bloodBourne.setVolume(25);
    }
    
    public void prepare(){
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 50*i+25, 25+j*700);
        }

        for(int i = 1;i<8; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 50*i+25, 500);
        }
        for (int i = 0; i < 4; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 540, 425+ 50*i+100);
        }

        addObject(boy, 157, 653-50);
        
        addObject(levelCounter, 825, 103);
        levelCounter.setValue(0);
        
        Bed bed = new Bed();
        addObject(bed, 100, 657-50);
        OldManBotIntro0 oldmanbotintro0 = new OldManBotIntro0();
        addObject(oldmanbotintro0, 270, 647-50);
        Door door = new Door();
        addObject(door, 106, 415);
        door.setLocation(73, 408);
        removeObject(door);
        doorT10 doort10 = new doorT10();
        addObject(doort10, 72, 414);
        doort10.setLocation(67, 410);
    }

        public void act(){
      bloodBourne.playLoop();
       
      delay++;
      
      timer++;
      if (Greenfoot.isKeyDown("escape") && delay > 20) 
      //want to be all keys
      {
          bloodBourne.stop();
          Greenfoot.setWorld(new NewIntro2(boy));
          
      }
      else
      checkDoor();
    }
    public void makeAllIcons()
    {
    }
      public void checkDoor()
       {
        if(boy.checkDoor()==true)
        {
            bloodBourne.stop();
            Greenfoot.setWorld(new NewIntro2(boy));
        }
       }
      public Boy getBoy()
      {
       return boy;
      }
      public Trap getThisWorld()
     {
       return this;
     }
        public void gameover(){
       boy.setHP(boy.getArmor());
       Greenfoot.setWorld(new NewIntro0(boy));
    }
}