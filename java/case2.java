import java.io.*;
import java.util.LinkedList;

//This class demonstrating the issues : EXP01-J. Do not use a null in a case where an object is required
public class case2 {

    public static void main(String[] args)
    {
        File file = null; //Here I use a null in a case where an object is required
        LinkedList<File> listOfFiles = new LinkedList<File>();
        File f1 = new File("forCase1.txt");
        listOfFiles.add(f1);
        try
        {
            boolean ans = allFirstLinesEqual(file, listOfFiles);
            if(ans)
            {
                System.out.println("All the lines in the files are equal");
            }
            else
            {
                System.out.println("Not all the lines in the files are equal");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * The function assumes that the input is correct and that is the problem that leads to the problem I am demonstrating
     * that because I use a null when I needed to use object the program have an exception of NullPointerException
     * @param file
     * @param listOfFiles
     * @return true if all the first lines in the files in the list are equals to the first line of the file that the
     * function get
     * @throws IOException
     */
    private static boolean allFirstLinesEqual(File file, LinkedList<File> listOfFiles) throws IOException {
        if (listOfFiles.size() == 0) {
            System.out.println("listOfFiles doesnt contain any file");
            return false;
        }
        for (File f:listOfFiles)
        {
            BufferedReader fileBr = new BufferedReader(new FileReader(file));
            System.out.println("Didn't get to here,because the action above causes NullPointerException because I use a null in a case where an object is required");
            BufferedReader nextBr = new BufferedReader(new FileReader(f));
            String lineFile = fileBr.readLine();
            String lineNext = nextBr.readLine();
            if ( !(lineFile == null && lineNext == null) || !(lineFile.equals(lineNext)) )
            {
                return false;
            }
        }
        return true;
    }

    /**
     Options to improve functions:

     ---first option---
     *Explicit check of input:
     public static void main(String[] args)
     {
         File file = null; //Here I use a null in a case where an object is required
         LinkedList<File> listOfFiles = new LinkedList<File>();
         File f1 = new File("forCase1.txt");
         listOfFiles.add(f1);
         try
         {
             boolean ans = allFirstLinesEqual(file, listOfFiles);
             if(ans)
             {
                  System.out.println("All the lines in the files are equal");
             }
             else
             {
                  System.out.println("Not all the lines in the files are equal");
             }
         }
         catch (IOException e)
         {
             e.printStackTrace();
         }
     }

     private static boolean allFirstLinesEqual(File file, LinkedList<File> listOfFiles) throws IOException {
         if (file == null) {
             System.out.println("file doesnt exist");
             return false;
         }
         else if (listOfFiles.size() == 0) {
             System.out.println("listOfFiles doesnt contain any file");
             return false;
         }
         else //input is good
         {
             for (File f : listOfFiles) {
                 BufferedReader fileBr = new BufferedReader(new FileReader(file));
                 System.out.println("Didn't get to here,because the action above causes NullPointerException because I use a null in a case where an object is required");
                 BufferedReader nextBr = new BufferedReader(new FileReader(f));
                 String lineFile = fileBr.readLine();
                 String lineNext = nextBr.readLine();
                 if (!(lineFile == null && lineNext == null) || !(lineFile.equals(lineNext)))
                 {
                 return false;
                 }
             }
             return true;
         }
     }

     ---second option---
     *To use a Optional class and avoid the exception
     public static void main(String[] args)
     {
         File file = null; //Here I use a null in a case where an object is required
         LinkedList<File> listOfFiles = new LinkedList<File>();
         File f1 = new File("forCase1.txt");
         listOfFiles.add(f1);
         try
         {
             boolean ans = allFirstLinesEqual(Optional.ofNullable(file), listOfFiles);
             if(ans)
             {
                  System.out.println("All the lines in the files are equal");
             }
             else
             {
                 System.out.println("Not all the lines in the files are equal");
             }
         }
         catch (IOException e)
         {
             e.printStackTrace();
         }
     }

     private static boolean allFirstLinesEqual(Optional<File> file, LinkedList<File> listOfFiles) throws IOException {
         if (listOfFiles.size() == 0) {
             System.out.println("listOfFiles doesnt contain any file");
             return false;
         }
         for (File f:listOfFiles)
         {
             BufferedReader fileBr = new BufferedReader(new FileReader(file.orElse(new File("forCase1.txt"))));
             System.out.println("Didn't get to here,because the action above causes NullPointerException because I use a null in a case where an object is required");
             BufferedReader nextBr = new BufferedReader(new FileReader(f));
             String lineFile = fileBr.readLine();
             String lineNext = nextBr.readLine();
             if ( !(lineFile == null && lineNext == null) || !(lineFile.equals(lineNext)) )
             {
                 return false;
             }
         }
         return true;
     }

     ---third option---
     *Implicit check of input by try and catch in the function allFirstLinesEqual:
     public static void main(String[] args)
     {
         File file = null; //Here I use a null in a case where an object is required
         LinkedList<File> listOfFiles = new LinkedList<File>();
         File f1 = new File("forCase1.txt");
         listOfFiles.add(f1);
         try
         {
             boolean ans = allFirstLinesEqual(file, listOfFiles);
             if(ans)
             {
                 System.out.println("All the lines in the files are equal");
             }
             else
             {
                System.out.println("Not all the lines in the files are equal");
             }
         }
         catch (IOException e)
         {
              e.printStackTrace();
         }
     }

     private static boolean allFirstLinesEqual(File file, LinkedList<File> listOfFiles) throws IOException {
         if (listOfFiles.size() == 0) {
             System.out.println("listOfFiles doesnt contain any file");
             return false;
         }
         for (File f : listOfFiles)
        {
             try {
                 BufferedReader fileBr = new BufferedReader(new FileReader(file));
                 System.out.println("Didn't get to here,because the action above causes NullPointerException because I use a null in a case where an object is required");
                 BufferedReader nextBr = new BufferedReader(new FileReader(f));
                 String lineFile = fileBr.readLine();
                 String lineNext = nextBr.readLine();
                 if (!(lineFile == null && lineNext == null) || !(lineFile.equals(lineNext)))
                {
                 return false;
                }
             }
             catch (NullPointerException e)
             {
                 System.out.println("one or more files doesnt exist");
                 return false;
             }
         }
         return true;
     }

     ---fourth option---
     *The allFirstLinesEqual function throws an exception and the main function catches it
     public static void main(String[] args)
     {
         File file = null; //Here I use a null in a case where an object is required
         LinkedList<File> listOfFiles = new LinkedList<File>();
         File f1 = new File("forCase1.txt");
         listOfFiles.add(f1);
         try
         {
             boolean ans = allFirstLinesEqual(file, listOfFiles);
             if(ans)
             {
                 System.out.println("All the lines in the files are equal");
             }
             else
             {
                 System.out.println("Not all the lines in the files are equal");
             }
         }
         catch (NullPointerException e)
         {
            System.out.println("file doesnt exist");
         }
         catch (IOException e)
         {
             e.printStackTrace();
         }
     }

         private static boolean allFirstLinesEqual(File file, LinkedList<File> listOfFiles) throws IOException, NullPointerException {
         if (listOfFiles.size() == 0) {
             System.out.println("listOfFiles doesnt contain any file");
             return false;
         }
         for (File f:listOfFiles)
         {
             BufferedReader fileBr = new BufferedReader(new FileReader(file));
             System.out.println("Didn't get to here,because the action above causes NullPointerException because I use a null in a case where an object is required");
             BufferedReader nextBr = new BufferedReader(new FileReader(f));
             String lineFile = fileBr.readLine();
             String lineNext = nextBr.readLine();
             if ( !(lineFile == null && lineNext == null) || !(lineFile.equals(lineNext)) )
             {
                 return false;
             }
         }
         return true;
     }

     */
}
