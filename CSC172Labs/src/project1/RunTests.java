package project1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class RunTests {
	
	public static void main(String[] args) 
	{	
		//Sample Keys and Blocks
		//64 1s "1111111111111111111111111111111111111111111111111111111111111111"
		//56 1s "11111111111111111111111111111111111111111111111111111111"
		//56 0s "00000000000000000000000000000000000000000000000000000000"
		//64 0s "0000000000000000000000000000000000000000000000000000000000000000"
		//Odd Key 0s "11000100001000001000100000000010000000010000001000001011"
		runTests();
		promptED();
			
	}	
	
	/**
	 * This function runs the hard coded test cases provided by Prof. Polak
	 */
	public static void runTests()
	{
		System.out.println("Running Tests:");
		
		System.out.println("Output for: encryption(all ones, all ones)");
		System.out.println(Conversions.encryptBlock("1111111111111111111111111111111111111111111111111111111111111111"
				, "11111111111111111111111111111111111111111111111111111111"));
		
		
		System.out.println("Output for: encryption(all zeros, all ones)");
		System.out.println(Conversions.encryptBlock("0000000000000000000000000000000000000000000000000000000000000000"
				, "11111111111111111111111111111111111111111111111111111111"));
		
		
		System.out.println("Output for: encryption(all zeros, all zeros)");
		System.out.println(Conversions.encryptBlock("0000000000000000000000000000000000000000000000000000000000000000"
				, "00000000000000000000000000000000000000000000000000000000"));
		
		
		System.out.println("Output for: encryption(block, all ones), where: \n"
				+ "block = 1100110010000000000001110101111100010001100101111010001001001100");
		System.out.println(Conversions.encryptBlock("1100110010000000000001110101111100010001100101111010001001001100"
				, "00000000000000000000000000000000000000000000000000000000"));
		
		System.out.println("Output for: decryption(all ones, all ones)");
		System.out.println(Conversions.decryptBlock("1111111111111111111111111111111111111111111111111111111111111111", 
				"11111111111111111111111111111111111111111111111111111111"));
		
		System.out.println("Output for: decryption(all zeros, all ones)");
		System.out.println(Conversions.decryptBlock("0000000000000000000000000000000000000000000000000000000000000000", 
				"11111111111111111111111111111111111111111111111111111111"));
		
		System.out.println("Output for: decryption(all zeros, all zeros)");
		System.out.println(Conversions.decryptBlock("0000000000000000000000000000000000000000000000000000000000000000",
				"00000000000000000000000000000000000000000000000000000000"));
		
		System.out.println("Output for: decryption(block, all ones), where: \n"
				+ "block = 0101011010001110111001000111100001001110010001100110000011110101");
		System.out.println(Conversions.decryptBlock("0101011010001110111001000111100001001110010001100110000011110101",
				"11111111111111111111111111111111111111111111111111111111"));
		
		System.out.println("Output for: decryption(block, all ones), where: \n"
				+ "block = 0011000101110111011100100101001001001101011010100110011111010111");
		System.out.println(Conversions.decryptBlock("0011000101110111011100100101001001001101011010100110011111010111",
				"00000000000000000000000000000000000000000000000000000000"));
		
	}

	/**
	 * This function asks the user whether they want to encrypt or decrypt a file and pushes the results into another file of choice
	 */
	public static void promptED()
	{
		Scanner scan = new Scanner(System.in);
		String input = "";
		String filepath = "";
		String key = "";
		String outputfile = "";
		System.out.print("Do you want to encrypt or decrypt (E/D): ");
		input = scan.next();	
			
		
		while(!"E".equals(input) && !"D".equals(input) && !"e".equals(input) && !"d".equals(input))
		{
			System.out.println(input + " is an invalid input. Please Try again.");
			System.out.print("Do you want to encrypt or decrypt (E/D): ");
			input = scan.next();
		}
		if(input.equals("E") || input.equals("e"))
		{

			System.out.print("Filename: ");
			filepath = scan.next();
			System.out.print("Secret key: ");
			key = scan.next();
			System.out.print("Ouput file: ");
			outputfile = scan.next();
			
			String fileData;
			try {
				fileData = Conversions.getFileData(filepath);

				String binaryInput = Conversions.stringToBinaryString(fileData);
				String encrypted = Conversions.encryption(binaryInput, key);
				
				FileWriter fw = new FileWriter(outputfile);
				fw.write(encrypted);
				fw.close();

			} catch (IOException e) {
				System.out.println("Invalid Input Provided");
				e.printStackTrace();
			}
			
			
		}
		else if(input.equals("D") || input.equals("d"))
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
				fileData = Conversions.getFileData(filepath);
				
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
				System.out.println("Invalid Input Provided");
				e.printStackTrace();
			}
		}
		scan.close();
	}
}
