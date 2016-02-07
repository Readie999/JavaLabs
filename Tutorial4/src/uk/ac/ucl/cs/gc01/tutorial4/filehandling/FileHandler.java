package uk.ac.ucl.cs.gc01.tutorial4.filehandling;
/**
 * This program reports the number of lines in each of the text files
 * that are specified.  If a file does not exist, or if
 * some error occurs when the attempt is made to read the file,
 * then an error message is printed (but the other files are
 * still processed). 
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileHandler {
	//Takes any number of filenames and calls the countLines method to count the individual number of lines
public static void main(String[] args) {
	String[] fileNames = {"file1.txt", "file4.txt", "file2.txt", "file3.txt"} ;
  
  for (int i = 0; i < fileNames.length; i++) {
     System.out.print(fileNames[i] + ":  ");
     countLines(fileNames[i]);
  }
	
}
/* Count the number of lines in each file and print the value
The try catch statements allow for any errors to be reported */
private static void countLines(String fileName) {
    
    try(BufferedReader in = new BufferedReader( new FileReader(fileName) )) {
       
       int lineCount = 0;  // number of lines read from the file
       int sum=0;
       String line = in.readLine();   // Read the first line.
       while (line != null) {
           lineCount++;               // Count this line.
           line = in.readLine();      // Read the next line.
       }
       System.out.println(lineCount + " lines");
       sum =sum + lineCount;
    }
    catch (FileNotFoundException e) {
        System.out.println("Cannot find the named file.");
    }
    catch (Exception e) {
       System.out.println("Error");
    }
 }
}
