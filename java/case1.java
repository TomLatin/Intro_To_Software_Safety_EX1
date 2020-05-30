import java.io.File;

//This class demonstrating the issues : ERR08-J. Do not catch NullPointerException or any of its ancestors
public class case1 {

    //This code example defines an theRightLength(File file,long camper) method that takes a File argument and long argument
    // and returns true if the given File length is equal to the long length that the function get.else return false.
    // Rather than checking to see whether the given File is null,
    // the method catches NullPointerException and returns false.
    public static void main(String[] args)
    {
        File f1=null;
        long camper=4;
        System.out.println(theRightLength(f1,camper));
    }

    public static boolean theRightLength(File file,long camper){
        try
        {
            if(file.length()==camper)
                 return true;
            else
                return false;
        }
        catch (NullPointerException e)
        {
            return false;
        }
    }

/**
 Options to improve functions:

 ---first option---
 *Explicit check of input:
 public static void main(String[] args)
 {
     File f1=null;
     long camper=4;
     System.out.println(theRightLength(f1,camper));
 }

 public static boolean theRightLength(File file,long camper){
     if(file==null)
          return false;
     if(file.length()==camper)
          return true;
     else
          return false;
 }

 ---second option---
 *The theRightLength function throws an exception and the main function catches it
 public static void main(String[] args)
 {
     File f1=null;
     long camper=4;
     try
     {
        System.out.println(theRightLength(f1,camper));
     }
     catch (NullPointerException e)
     {
        System.out.println(false);
     }
 }

 public static boolean theRightLength(File file,long camper) throws NullPointerException{
     if(file.length()==camper)
        return true;
     else
        return false;
 }
 **/
}
