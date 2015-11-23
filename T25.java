import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T25 extends Trap
{
    static boolean played = false;
    GreenfootSound billin = new GreenfootSound("billin.mp3");
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private int counterDelay = 0;
    Ninja ninja;
    int delay = 11;
    public T25(Ninja ninja)
    {
        super();
        billin.setVolume(40);
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 50*i+25, 25+j*700);
        }
        BillBoss kyle = new BillBoss(5, 5);
        addObject(kyle, 150, 150);
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(25);
        addObject(ninja, 325, 325);
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
    }

    public void act()
    {
         if(!played)
        {
        billin.playLoop();
        played = !played;
        }
        createdoor();
        checkTeleport();
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            Menu menu = new Menu(getThisWorld());
            Greenfoot.setWorld(menu);
            delay = 0;

        }
        if(getObjects(Ninja.class).size() != 0 && counterDelay >= 10)
        {
            healthCounter.setValue(ninja.getNINJAHP());
            shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
            powerCounter.setValue(ninja.getPOWERBAR());
            counterDelay-= 10;
            checkDoor();
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 

            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
        delay++;
    }

    public void checkTeleport(){
        if(ninja.checkTeleport())
        {
            ninja.setLocation(325, 325);
        }
    }

    public void checkDoor()
    {

    }

    public Ninja getNinja()
    {
        return ninja;
    }
    
    public void checkDoorT21()
    {
         if(ninja.checkDoorT21()==true)
         {
             billin.stop();
            Greenfoot.setWorld(new Kyobashi3(ninja));
        }
    }
    public Trap getThisWorld()
    {
        return this;
    }
       public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new T25(ninja));
    }
     public boolean isbossthere(){
        List<Bosses> list = getObjects(BillBoss.class);
        if (list.size() >0){
            return true;
        }
        else{
            return false;
        }
    }
     public void createdoor(){
        if(isbossthere() == false){
        doorT10 doort10 = new doorT10();
        addObject(doort10, 375, 660);
        ninja.setProgress(2);
        }
    }
}