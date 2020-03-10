import java.util.*;
import java.io.*;
import java.util.regex.*;
public class fmr{
	public static void main(String[] args){
		
		for(int i = 0; i < args.length; i ++){
			if(args[i].equals("-h")){
				System.out.println("This program takes in an input and regrex and outputs the found tokens of the regrex");
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
			String fileName = args[fileInput + 1];
			Pattern pattern = Pattern.compile(args[fileInput + 2]);
			
			try{
				FileReader freader = new FileReader(fileName);
				BufferedReader br = new BufferedReader(freader);
			}//try
			catch(Exception e){
				System.out.println("File not found");
			}//catch
		}//if
		else{

			String line = args[0];
			String regrex = args[1];

			Pattern pattern = Pattern.compile(regrex);
			Matcher matcher = pattern.matcher(line);

			boolean found = false;

			while(matcher.find()){
				System.out.println("I found text " + matcher.group() + " starting at index " + matcher.start() + " and ending at index " + matcher.end());
			}//while

			if(!found){
				System.out.println("No match found");
			}//if
		}//else
	}//main
}//class
