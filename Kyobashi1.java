import greenfoot.*;
//Hayden
/**
 * Functionality in this class:
 */
public class Kyobashi1 extends Trap//Hayden
{
    public int level = 0;
    private int delay = 11;    //Constructor for objects of class Kyobashi
    private int counterDelay = 0;
    private Ninja ninja;
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    GreenfootSound backgroundTheme = new GreenfootSound("ninja_backgroundtheme.mp3");
    // Levels
    // https://www.youtube.com/watch?v=9MdqA2oPqN0
    GreenfootSound goldenLotus = new GreenfootSound("GoldenLotus.mp3");
    DeathWorld deathWorld;
    public Kyobashi1(Ninja ninja)//Hayden
    {    
        super(); 
        this.ninja = ninja;
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()//Hayden
    {
        TextBoxKyo0 textboxkyo0 = new TextBoxKyo0();
        addObject (textboxkyo0, 380, 640-50+15);
        
        addObject(ninja, 100, 100);
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
                addObject(fence, 50*i+25, 25+j*700);
            }
            
            for (int i = 0; i<15; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i, 550-35);
        }
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        doorT10 door = new doorT10();
        addObject(door, 650, 475-50+15);
        
        doorT21 snowdoor = new doorT21();
        addObject(snowdoor, 375, 475-50+15);
        
        addShuriken s = new addShuriken();
        addObject(s, 95 , 195);
        HealthGlobe hg = new HealthGlobe();
        addObject(hg, 197, 90);
        makeAllIcons();
    }
    
   public void act()//Hayden Bill
   {
       counterDelay++;
       goldenLotus.setVolume(65);
       goldenLotus.playLoop();
       backgroundTheme.setVolume(65);
       //backgroundTheme.playLoop(); 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           clickSound.play();
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
       if (Greenfoot.isKeyDown("1")&&delay>10) 
       {
           Greenfoot.setWorld(new Inferno1(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("2")&&delay>10) 
       {
           Greenfoot.setWorld(new Inferno2(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("3")&&delay>10) 
       {
           Greenfoot.setWorld(new Inferno3(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("4")&&delay>10) 
       {
           Greenfoot.setWorld(new Inferno4(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("0")&&delay>10) 
       {
           Greenfoot.setWorld(new InfernoBossLevel(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("8")&&delay>10) 
       {
           Greenfoot.setWorld(new K12(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("7")&&delay>10)
       {
           Greenfoot.setWorld(new Snow3(ninja));
           delay = 0;
        }
       delay++;
       if (counterDelay >= 10)
       {
       healthCounter.setValue(ninja.getNINJAHP());
       shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
       powerCounter.setValue(ninja.getPOWERBAR());
       counterDelay -=10;
    }
       checkDoor();
       checkSnowDoor();
       checkInfernoDoor();
       t2Start();
   }
   public void makeAllIcons()//Sean
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
        //StealthIcon stealthicon = new StealthIcon();
        //addObject(stealthicon, 871, 308);
        DashIcon dashicon = new DashIcon();
        addObject(dashicon, 819, 308);
        //DoubleDamageIcon doubledamageicon = new DoubleDamageIcon();
        //addObject(doubledamageicon, 871, 308);
        MenuIcon menuIcon = new MenuIcon();
        addObject(menuIcon, 875, 605);
    }
   public Kyobashi1 getThisWorld()//Bill
   {
       return this;
   }
   
   public Ninja getNinja()//Bill
   {
       return ninja;
   }
   
   // Starting Levels
   
   public void k2Start() // [Sean]
   {
       K2 k2 = new K2(ninja);
       Greenfoot.setWorld(k2);
   }
   public void k3Start() // [Sean]
   {
       K3 k3 = new K3(ninja);
       Greenfoot.setWorld(k3);
   }
   public void addLevel()//Bill
   {
       level++;
       levelCounter.add(1);
   }
   public int getLevel()//Bill
   {
       return level;
   }
   public void checkDoor()//Hayden
   {
       if(ninja.checkDoor()==true)
       {
           goldenLotus.stop();
            Greenfoot.setWorld(new K2(ninja));
        }
   }
   public void checkInfernoDoor()//Hayden
   {
       if(ninja.checkInfernoDoor()== true)
       {
           goldenLotus.stop();
            Greenfoot.setWorld(new Inferno1(ninja));
        }
   }
   public void t2Start()//Hayden
   {
       if (ninja.checkDoorT21()==true)
       {
           goldenLotus.stop();
            Greenfoot.setWorld(new T21(ninja));
        }
    }
       public void checkSnowDoor()//Hayden
   {
       if(ninja.checkSnowDoor()==true)
       {
           goldenLotus.stop();
            Greenfoot.setWorld(new Snow1(ninja));
        }
   }
  }
