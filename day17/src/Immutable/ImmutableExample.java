package Immutable;

import java.util.Date;
import java.util.StringTokenizer;  
import java.util.Random; 
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ImmutableExample
{
    public static void main(String[] args)
    {
        String name = DataGenerator.getNextName();
        Date dateOfBirth = DataGenerator.getNextDate();
        BufferedImage photo = DataGenerator.getNextPhoto();
            
        MutableIDCard id = new MutableIDCard(name,dateOfBirth,photo);

        Runnable officer = new Officer(id);

        name = DataGenerator.getNextName();
        dateOfBirth = DataGenerator.getNextDate();
        photo = DataGenerator.getNextPhoto();

        Runnable citizen = new Citizen(new MutableIDCard(name,dateOfBirth,photo));

        Thread t1 = new Thread(officer);
        Thread t2 = new Thread(citizen);
                  
        t1.start();
        t2.start();
    }
}

class DataGenerator
{
    private static StringTokenizer names = new StringTokenizer("John,Mary,Lisa",",");
    private static StringTokenizer dates = new StringTokenizer("23/6/1971,12/3/1985,9/8/2002",",");

    public synchronized static String getNextName()
    {
        if (names.hasMoreElements())
        {
            return (String)names.nextElement();
        }
            
        return "Not a name";
    }
      
    public synchronized static Date getNextDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String txtDate="1/1/1970";
            
        if(dates.hasMoreElements())
        {
            txtDate=(String)dates.nextElement();
        }

        try
        {
            return dateFormat.parse(txtDate);
        }
        catch (ParseException e) 
        {
        return new Date();
      }
    }
      
    public synchronized static BufferedImage getNextPhoto()
    {
        return new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);
    }
}

class MutableIDCard
{
    private final String name;
    private final Date dateOfBirth;
    private final BufferedImage photo;

    public MutableIDCard(String name,Date dateOfBirth,BufferedImage photo)
    {
        this.name = String.valueOf(name);
        this.dateOfBirth = new Date(dateOfBirth.getTime());
        this.photo = new BufferedImage(photo.getWidth(), photo.getHeight(), photo.getType());
    }

//    public void set(String name,Date dateOfBirth,BufferedImage photo)
//    {
//        check(name,dateOfBirth,photo);
//
//        synchronized(this)
//        {
//            this.name = String.valueOf(name);
//            this.dateOfBirth = new Date(dateOfBirth.getTime());
//            this.photo = new BufferedImage(photo.getWidth(), photo.getHeight(), photo.getType());
//        }
//    }
      
    public synchronized String getName()
    {
        return String.valueOf(name);
    }

    public synchronized Date getDateOfBirth()
    {
        return new Date(dateOfBirth.getTime());
    }

    public synchronized BufferedImage getPhoto()
    {
        return new BufferedImage(photo.getWidth(), photo.getHeight(), photo.getType());
    }

    public void check(String name,Date dateOfBirth,BufferedImage photo)
    {
        if (name==null || name.equals(""))
        {
            throw new IllegalArgumentException();
        }
            
        if (dateOfBirth==null)
        {
            throw new IllegalArgumentException();
        }
            
        long age=getAge(dateOfBirth);
            
        if (dateOfBirth==null || age<=0)
        {
            throw new IllegalArgumentException();
        }
            
        if (photo==null)
        {
            throw new IllegalArgumentException();
        }     
    }
      
    private long getAge(Date dateOfBirth)
    {
        long now = new Date().getTime();
        long age = now - dateOfBirth.getTime();
        return age;
    }
}

class Citizen implements Runnable
{
    private MutableIDCard id;
      
    public Citizen(MutableIDCard id)
    {

        this.id = new MutableIDCard(id.getName(), id.getDateOfBirth(), id.getPhoto());
    }
      
    public void run()
    {
        Random r = new Random();

        try
        {
            Thread.sleep(r.nextInt(2000));
        }
        catch (InterruptedException e)
      {
        e.printStackTrace();
      }

        String message = "Citizen\n";
        message += "the name on this id is "+id.getName()+"\n";
        message += "and the date of birth is "+id.getDateOfBirth();
            
        System.out.println(message);
    }
}

class Officer implements Runnable
{
    private MutableIDCard id;
      
    public Officer(MutableIDCard id)
    {
        this.id = new MutableIDCard(id.getName(), id.getDateOfBirth(), id.getPhoto());
    }
      
    public void run()
    {
        Random r=new Random();

        try
        {
            Thread.sleep(r.nextInt(2000));
        }
        catch (InterruptedException e)
      {
        e.printStackTrace();
      }

        String message = "Officer\n";
        message += "the name on this id is "+id.getName()+"\n";
        message += "and the date of birth is "+id.getDateOfBirth();

        System.out.println(message);
    }
}
