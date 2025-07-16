package AllSolutions;

import java.io.FileWriter;
import java.io.IOException;

import com.github.javafaker.Faker;

public class CreateTextFile {

	public static class Test {
		public void textfile() throws IOException {
	        Faker f = new Faker();
	        long timeTaken = 0;
	        
	        try (FileWriter writer = new FileWriter("students_data.txt")) {
	            writer.write("=== Response ===\n");

	            for (int i = 1; i <= 100; i++) {
	            	long start = System.currentTimeMillis();
	                writer.write(f.name().fullName() + "\n");
	                long end = System.currentTimeMillis();
	                timeTaken = end - start;
	                writer.write("\n=== Time Taken ===\n");
	                writer.write(timeTaken + " ms\n");
	            }
   
	        }
	    }

	    public static void main(String[] args) throws IOException {
	        new Test().textfile();
	    }
}}
