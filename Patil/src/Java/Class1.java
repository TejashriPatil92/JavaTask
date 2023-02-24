package Java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Class1 
{
	 public static void main(String[] args) {

	        int minLines = 150;
	        int maxLines = 320;
	        String fileName = "Test File Finance.txt";

	        File file = new File("src/" + fileName);

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            int numLines = new Random().nextInt(maxLines - minLines) + minLines;
	            for (int i = 0; i < numLines; i++) {
	                String line = generateLine();
	                writer.write(line);
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static String generateLine() {
	        int minWords = 9;
	        int maxWords = 19;
	        String[] wordSeparators = {" ", "\t"};
	        Random random = new Random();
	        int numWords = random.nextInt(maxWords - minWords) + minWords;
	        StringBuilder lineBuilder = new StringBuilder();
	        for (int i = 0; i < numWords; i++) {
	            String word;
	            if (i == 0) {
	                word = generateFirstWord();
	            } else {
	                word = generateWord();
	            }
	            lineBuilder.append(word);
	            if (i < numWords - 1) {
	                lineBuilder.append(wordSeparators[random.nextInt(wordSeparators.length)]);
	            }
	        }
	        return lineBuilder.toString();
	    }

	    private static String generateFirstWord() {
	        return generateWord().substring(0, 1).toUpperCase() + generateWord().substring(1);
	    }

	    private static String generateWord() {
	        int minLength = 6;
	        int maxLength = 15;
	        String[] wordChars = {"abcdefghijklmnopqrstuvwxyz"};
	        Random random = new Random();
	        int length = random.nextInt(maxLength - minLength) + minLength;
	        StringBuilder wordBuilder = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            char c = wordChars[random.nextInt(wordChars.length)].charAt(0);
	            wordBuilder.append(c);
	        }
	        return wordBuilder.toString();
	    }

	}



