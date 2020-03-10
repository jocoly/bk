import java.util.*;
import java.util.regex.*;
public class fmr{
	public static void main(String[] args){
		
		for(int i = 0; i < args.length; i ++){
			if(args[i].equals("-h")){
				System.out.println("This program takes in an input and regrex and outputs the found tokens of the regrex");
				System.exit(0);
			}//if
		}//for

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
	}//main
}//class
