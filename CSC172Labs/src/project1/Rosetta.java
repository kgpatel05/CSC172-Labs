package project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rosetta {

	public static void main(String[] args) 
	{		
		//64 1s "1111111111111111111111111111111111111111111111111111111111111111"
		//56 1s "11111111111111111111111111111111111111111111111111111111"
		//56 0s "00000000000000000000000000000000000000000000000000000000"
		//64 0s "0000000000000000000000000000000000000000000000000000000000000000"
		////Users/krishpatel/Documents/rochester/courses/spring24/csc172/CSC172-Labs/CSC172Labs/src/project1/testing.txt
		
//		Tests.runTests();
		promptED();
	}

	private static void promptED()
	{
		Scanner scan = new Scanner(System.in);
		String input = "";
		String filepath = "";
		String key = "";
		String outputfile = "";
		System.out.print("Do you want to encrypt or decrypt (E/D): ");
		input = scan.next();
		if(input.equals("E"))
		{

			System.out.print("Filename: ");
			filepath = scan.next();
			System.out.print("Secret key: ");
			key = scan.next();
			System.out.print("Ouput file: ");
			outputfile = scan.next();
			
			String fileData;
			try {
				fileData = getFileData(filepath);

				String binaryInput = Conversions.stringToBinaryString(fileData);
				String encrypted = Conversions.encryption(binaryInput, key);
				
				FileWriter fw = new FileWriter(outputfile);
				fw.write(encrypted);
				fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else if(input.equals("D"))
		{
			System.out.print("Filename: ");
			filepath = scan.next();
			System.out.print("Secret key: ");
			key = scan.next();
			System.out.print("Ouput file: ");
			outputfile = scan.next();
			
			String fileData;
			try {
				//filedata is in binary format
				fileData = getFileData(filepath);
				
				String decryptedBinaryBlocks = Conversions.decryption(fileData, key);
				
				String decryptedMessage = "";
				//creating a byte from 8 bits
				for(int i = 0; i < decryptedBinaryBlocks.length()/8; i++)
				{
					ArrayList<Integer> sublist = new ArrayList<Integer>();
					for(int j = 0; j < 8; j++)
					{
						sublist.add(decryptedBinaryBlocks.charAt(8*i + j) - 48);
					}
					
					String sublistArray = Conversions.arrayToString(sublist);
					int asciiValue = Integer.parseInt(sublistArray,2);
					decryptedMessage += (char) asciiValue;
				}
				
				FileWriter fw = new FileWriter(outputfile);
				fw.write(decryptedMessage);
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		scan.close();
	}
	
    /**
     * this function reads data from a file and returns it as a string
     * @param filepath
     * @return
     * @throws IOException
     */
	private static String getFileData(String filepath) throws IOException 
	{
	  StringBuilder sb = new StringBuilder();
	  FileReader fr = new FileReader(filepath);
	  BufferedReader br = new BufferedReader(fr);
	  String line;
	  while ((line = br.readLine()) != null) 
	  {
	    sb.append(line);
	  }
	  br.close();
	  return sb.toString().trim();
	}
}
