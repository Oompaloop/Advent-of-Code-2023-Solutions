import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws FileNotFoundException, IOException{
        String s = fileReader();
        calibrationParser(s);
    }

    public static String fileReader() throws FileNotFoundException{

        //Prompts user for a file's path
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file path: ");

        //Creates a file object using the file path (String) as input
        String filename = input.nextLine();
        File file = new File(filename);

        //Creates a Scanner object which reads and saves from the previously declared File object
        Scanner fileread = new Scanner(file);
        fileread.useDelimiter("\\Z");

        //Saves the contents of the previously declared Scanner object to a String
        String s = fileread.next();

        //closes Scanner streams and returns the String 's'
        fileread.close();
        input.close();

        return s;
    }

    public static int calibrationParser(String file){
        Scanner kek = new Scanner(file);

        int result = 0;
        while(kek.hasNextLine()){
            String line = kek.nextLine();
            String num = "";
            String output = "";
            for(char c : line.toCharArray()){
                if(Character.isDigit(c)){
                    num += c;
                }
            }
            
            output = num.substring(0,1) + num.substring(num.length()-1, num.length());
            System.out.println(output);

            int lineoutput = Integer.parseInt(output);
            result += lineoutput;
        }

        kek.close();
        System.out.print(result);
        return result;
    }
}
