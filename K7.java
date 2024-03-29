import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K7 extends Trap////Hayden
{
    Ninja ninja;
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    int delay = 11;
    private List<NPCS> npcs;
    private int counterDelay = 0;
    GreenfootSound Peaceful = new GreenfootSound("Peaceful.mp3");
    static boolean played = false;
    /**
     * Constructor for objects of class K5.
     * 
     */
    public K7(Ninja ninja)//Hayden
    {
        super();
        this.ninja = ninja;
        prepare();
    }
       private void prepare(){//Hayden
                       for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 50*i+25, 25+j*(700-50));

        }
        for (int i = 0; i<12; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i+25, 160);
        }
        for (int i = 0; i<8; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 600, 50*i+325);
        }

        doorT10 doort10 = new doorT10();
        addObject(doort10, 80, 625+3-50+25);

        
        addObject(ninja, 100, 100);

        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 669, 630);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 660, 598-50);
        healthglobe.setLocation(658, 659-50);
        Lv1Melee redmm = new Lv1Melee(3, 1);
        addObject(redmm, 668, 387);
        Lv1Melee redmm2 = new Lv1Melee(3, 1);
        addObject(redmm2, 669, 466);
        
        Fence fence97 = new Fence();
        addObject(fence97, 362, 363);
        Fence fence98 = new Fence();
        addObject(fence98, 380, 683);
        Fence fence99 = new Fence();
        addObject(fence99, 77, 278);
        fence99.setLocation(73, 276);
        fence98.setLocation(376, 678);
        fence97.setLocation(360, 408);
        BlueRM bluerm = new BlueRM(3, 2);
        addObject(bluerm, 227, 331);
        BlueRM bluerm2 = new BlueRM(3, 2);
        addObject(bluerm2, 487, 545);
        Lv1Melee redmm3 = new Lv1Melee(1, 1);
        addObject(redmm3, 657, 105);
        Lv1Melee redmm4 = new Lv1Melee(3, 1);
        addObject(redmm4, 439, 342);
        Lv1Melee redmm5 = new Lv1Melee(3, 1);
        addObject(redmm5, 251, 519);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);

        addObject(levelCounter, 355, 730);
        addObject(ninja, 100, 100);
        levelCounter.setValue(4);
            
            makeAllIcons();
            
            
                npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }
    public void act()//Hayden bill
    {
        counterDelay++;
        if (!played){
            Peaceful.playLoop();
            played = !played;
        }
        if (Greenfoot.isKeyDown("h")&&delay>10) //bill
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
        }
        delay++;
    }
    public void makeAllIcons()//sean
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
    }
    public void checkDoor()//Hayden
    {
        if(ninja.checkDoor()==true){
            Peaceful.stop();
            Greenfoot.setWorld(new K8(ninja));}
    }

    public Ninja getNinja()//bill
    {
        return ninja;
    }
    public Trap getThisWorld()//bill
    {
        return this;
    }
   public void gameover(){//Hayden
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new K7(ninja));
    }}
