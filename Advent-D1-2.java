import java.io.*;
import java.util.*;

public class Main2{

    public static void main(String[] args) throws FileNotFoundException, IOException{
        String s = fileReader();
        calibrationParser(s);
    }

    public static String fileReader() throws FileNotFoundException{

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file path: ");

        String filename = input.nextLine();
        File file = new File(filename);

        Scanner fileread = new Scanner(file);
        fileread.useDelimiter("\\Z");

        String s = fileread.next();

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

            line = line.replaceAll("one", "1");
            line = line.replaceAll("two", "2");
            line = line.replaceAll("three", "3");
            line = line.replaceAll("four", "4");
            line = line.replaceAll("five", "5");
            line = line.replaceAll("six", "6");
            line = line.replaceAll("seven", "7");
            line = line.replaceAll("eight", "8");
            line = line.replaceAll("nine", "9");

            for(int i = 0; i < line.length(); i++){
                Character c = line.charAt(i);
                if(Character.isDigit(c)){
                    num += c;
                }
            }
            
            output = num.substring(0,1) + num.substring(num.length()-1, num.length());
            //System.out.println(output);

            int lineoutput = Integer.parseInt(output);
            result += lineoutput;
        }

        kek.close();
        System.out.print(result);
        return result;
    }
}
