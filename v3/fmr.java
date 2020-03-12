import java.util.regex.*;
import java.io.*;
import java.util.*;
public class fmr{
    public static void main(String[] args){
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-h")||args[i].equals("--help") || args[i].equals("-
help")){
                System.out.println("\r\nTakes in an input and a regrex and outputs 
any matches.\n ");
                System.out.print("Input: \n");
                System.out.println("  -f \t Denotes that the input will be a file 
name not a string.\n");
                System.out.println("\t Example: fmr -f 'filename.txt' '^this|test?'
\n\n");
                System.exit(0);
            }//if
        }//for
        int fileInput = -1;
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-f")){
               fileInput = i;
            }//if
        }//for
        if(fileInput != -1){
            String filename = args[fileInput + 1];
            Pattern pattern = Pattern.compile(args[fileInput + 2]);
            try {
                FileReader freader = new FileReader(filename);
                BufferedReader br = new BufferedReader(freader);
                try {
                    String line;
                    boolean found = false;
                    int lineNum = 1;
                    while((line = br.readLine()) != null) {
                        //System.out.println(s);
                        Matcher matcher = pattern.matcher(line);
                        while (matcher.find()) {
                            System.out.println(lineNum+":"+matcher.start());
                            found = true;
                        }
                        lineNum++;
                    }
                    if(!found){
                        System.out.println("No match found.");
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                } finally {
                    try {
                        freader.close();
                    } catch (IOException e) {
                        System.out.println("File did not close");
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }else{
            String line = args[0];
            String reg = args[1];
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(line);
            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.start()+":"+matcher.end());
                found = true;
            }
            if(!found){
                System.out.println("No match found.");
            }
        }
    }
}
