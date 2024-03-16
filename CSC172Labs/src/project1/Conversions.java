package project1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Conversions {
	
	//CONSTANTS
	public static final int BLOCK_SIZE = 64;
	public static final int KEY_SIZE = 56;
	
	public static final int[] pTransform = {
			16, 7, 20, 21, 29, 12, 28, 17,
			1, 15, 23, 26, 5, 18, 31, 10,
			2, 8, 24, 14, 32, 27, 3, 9,
			19, 13, 30, 6, 22, 11, 4, 25
			};
	
	public static final char hexchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	public static final String[][] sBox = new String[][] {
            {"01100011", "01111100", "01110111", "01111011", "11110010", "01101011", "01101111", "11000101", "00110000", "00000001", "01100111", "00101011", "11111110", "11010111", "10101011", "01110110"},
            {"11001010", "10000010", "11001001", "01111101", "11111010", "01011001", "01000111", "11110000", "10101101", "11010100", "10100010", "10101111", "10011100", "10100100", "01110010", "11000000"},
            {"10110111", "11111101", "10010011", "00100110", "00110110", "00111111", "11110111", "11001100", "00110100", "10100101", "11100101", "11110001", "01110001", "11011000", "00110001", "00010101"},
            {"00000100", "11000111", "00100011", "11000011", "00011000", "10010110", "00000101", "10011010", "00000111", "00010010", "10000000", "11100010", "11101011", "00100111", "10110010", "01110101"},
            {"00001001", "10000011", "00101100", "00011010", "00011011", "01101110", "01011010", "10100000", "01010010", "00111011", "11010110", "10110011", "00101001", "11100011", "00101111", "10000100"},
            {"01010011", "11010001", "00000000", "11101101", "00100000", "11111100", "10110001", "01011011", "01101010", "11001011", "10111110", "00111001", "01001010", "01001100", "01011000", "11001111"},
            {"11010000", "11101111", "10101010", "11111011", "01000011", "01001101", "00110011", "10000101", "01000101", "11111001", "00000010", "01111111", "01010000", "00111100", "10011111", "10101000"},
            {"01010001", "10100011", "01000000", "10001111", "10010010", "10011101", "00111000", "11110101", "10111100", "10110110", "11011010", "00100001", "00010000", "11111111", "11110011", "11010010"},
            {"11001101", "00001100", "00010011", "11101100", "01011111", "10010111", "01000100", "00010111", "11000100", "10100111", "01111110", "00111101", "01100100", "01011101", "00011001", "01110011"},
            {"01100000", "10000001", "01001111", "11011100", "00100010", "00101010", "10010000", "10001000", "01000110", "11101110", "10111000", "00010100", "11011110", "01011110", "00001011", "11011011"},
            {"11100000", "00110010", "00111010", "00001010", "01001001", "00000110", "00100100", "01011100", "11000010", "11010011", "10101100", "01100010", "10010001", "10010101", "11100100", "01111001"},
            {"11100111", "11001000", "00110111", "01101101", "10001101", "11010101", "01001110", "10101001", "01101100", "01010110", "11110100", "11101010", "01100101", "01111010", "10101110", "00001000"},
            {"10111010", "01111000", "00100101", "00101110", "00011100", "10100110", "10110100", "11000110", "11101000", "11011101", "01110100", "00011111", "01001011", "10111101", "10001011", "10001010"},
            {"01110000", "00111110", "10110101", "01100110", "01001000", "00000011", "11110110", "00001110", "01100001", "00110101", "01010111", "10111001", "10000110", "11000001", "00011101", "10011110"},
            {"11100001", "11111000", "10011000", "00010001", "01101001", "11011001", "10001110", "10010100", "10011011", "00011110", "10000111", "11101001", "11001110", "01010101", "00101000", "11011111"},
            {"10001100", "10100001", "10001001", "00001101", "10111111", "11100110", "01000010", "01101000", "01000001", "10011001", "00101101", "00001111", "10110000", "01010100", "10111011", "00010110"}
    };
	
    
    //1.3 REQUIRED METHODS
    
    /**
	 * This method takes in two binary sequences and applies the XOR function
	 * @param binary1
	 * @param binary2
	 * @return
	 */
	public static String xorIt(String binary1, String binary2)
	{
		int dif = Math.abs(binary1.length() - binary2.length());
		if(binary1.length() > binary2.length())
		{
			for(int i = 0; i < dif; i++)
			{
				binary2 = "0" + binary2;
			}
		}
		else if(binary2.length() > binary1.length())
		{
			for(int i = 0; i < dif; i++)
			{
				binary1 = "0" + binary1;
			}
				
		}
		
		//now both sequences are of the same length
		String xor = "";
		for(int i = 0; i < binary1.length(); i++)
		{
			if((binary1.charAt(i) == binary2.charAt(i)))
			{
				xor += "0";
			}
			else
			{
				xor += "1";
			}
		}
		return xor;
		
	}
    
	/**
	 * This function shift the binary sequence left by 1 unit
	 * @param binaryInput
	 * @return
	 */
	public static String shiftIt(String binaryInput)
	{
		String str = binaryInput.substring(1) + "0";
		
		return str;
	}
	
	/**
	 * This function permutes the provided binary sequence by the defined permutation matrix (pTransform)
	 * @param binaryInput
	 * @return
	 */
	public static String permuteIt(String binaryInput)
	{
		
		if(binaryInput.length() != 32)
		{
			System.out.println("INVALID permuteIt INPUT");
			return null;
		}
		
		//each number represents which element should  be in what order
		//i.e. element at index 16 of input is index 1 of the new sequence
		String newSeq = "";
		for(int i = 0; i < 32; i++)
		{
			//subtract by 1 bc pTransform is 1 based but java indexes are 0 based
			newSeq += (binaryInput.charAt(pTransform[i]-1));
		}
		return newSeq;
	}

	/**
	 * This function takes in a binary sequence, converts it into hexadecimal and then computes the correct
	 * permutation based on the rijndael matrix 
	 * @param binary
	 * @return
	 */
	public static String SubstitutionS(String binary)
	{

		if(binary.length() != 8)
		{
			System.out.println("INVALID INPUT PASSED TO SubstitutionS");
			return null;
		}
			
		//grab each value in the hexadecimal representation
		String hex = Conversions.binaryToHexa(binary);
		char row = hex.charAt(0);
		char col = hex.charAt(1);
		
		//converting from characters to integers in range 0 to F
		//this accounts for if the value was an integer from 0 to 9
		//since Integer.valueOf returns the ascii value
		//ascii of '0' is 48
		int rowNum = Integer.valueOf(row) - 48;
		int colNum = Integer.valueOf(col) - 48;
		
		//if the value is > 9 then it was a letter
		//ascii of 'A' is 65; subtract by 55 such that
		//A correspondes to 10
		if((Integer.valueOf(row) - 48) > 9)
		{
			rowNum = Integer.valueOf(row) - 55;
		}
		if((Integer.valueOf(col) - 48) > 9)
		{
			colNum = Integer.valueOf(col) - 55;
		}
				
		//completing the sbox transformation
		return sBox[rowNum][colNum];
	}
	
	/**
	 * This function computes the defined F round function on the provided sequence with the provided subkey
	 * @param rightHalf
	 * @param subkey
	 * @return
	 */
	public static String functionF(String rightHalf, String subkey)
	{
		if( rightHalf.length() != BLOCK_SIZE/2 || subkey.length() != BLOCK_SIZE/2)
		{
			System.out.println("INVALID SIZE OF RIGHTHALF OR SUBKEY PASSED INTO functionF");
			return null;
		}
		
		//conducting xor with the subkey
		String postXor = Conversions.xorIt(rightHalf, subkey);
		String newSeq = "";
		//prepping to compute the Rinjndael S-Box transformation
		for(int i = 0 ; i < 4; i++)
		{
			//sublist is the groups of 8 elements from the postXor sequence
			String sublist = postXor.substring(8*i, 8*i + 8);
			
			//computing the Rijndael X-box transformation
			newSeq += (Conversions.SubstitutionS(sublist));
		}
		
		newSeq = Conversions.permuteIt(newSeq);
		
		return newSeq;
	}

	/**
	 * This function computes the encryption algorithm on a block of binary input of length 64
	 * @param block
	 * @param inputKey
	 * @return
	 */
	public static String encryptBlock(String block, String inputKey)
	{
		if(block.length() != BLOCK_SIZE)
		{
			System.out.println("BAD BLOCK SIZE INPUT to encryptBlock. Expected Length " + BLOCK_SIZE + ".");
			return null;
		}
		if(inputKey.length() != KEY_SIZE)
		{
			System.out.println("BAD KEY SIZE INPUT to encryptBlock. Expected Length " + KEY_SIZE + ".");
			return null;
		}
			
		//initialization of variables
		String[] subkeys = Conversions.keyScheduleTransform(inputKey);
		//creating left and right sequences
		String leftBlock = block.substring(0, (BLOCK_SIZE/2));
		String rightBlock = block.substring((BLOCK_SIZE/2));
		
		for(int i = 0; i < 10; i++)
		{
			String tempLeft = leftBlock;
			leftBlock = rightBlock;
			
			//put right half through the functionF with the first subkey
			String newseq = Conversions.functionF(rightBlock, subkeys[i]);
			//right block becomes the left block xored with the f(prev right)
			rightBlock = Conversions.xorIt(tempLeft, newseq);
		}
		
		//finally combine the two left and right sequences
		leftBlock += rightBlock;
		return leftBlock; //return as a string
	}

	/**
	 * This function decrypts the block using the provided key
	 * @param block
	 * @param key
	 * @return
	 */
	public static String decryptBlock(String block, String key)
	{
		
		String[] keys = Conversions.keyScheduleTransform(key);
		
		//populate the first left and right value
		String left = block.substring(0, (BLOCK_SIZE/2));
		String right = block.substring(BLOCK_SIZE/2);
		
		for(int i = 0; i < 10; i++)
		{
			String tempRight = right;
			right = left;
			left = Conversions.xorIt(Conversions.functionF(left, keys[9-i]), tempRight);
		}
		
		//combine both halves
		left += right;
		return left;
	}
	
	/**
	 * This function takes in a longBinaryInput and inputkey and encrypts the input in batches of 64
	 * elements using the encryptBlock() function
	 * @param longBinaryInput
	 * @param inputKey
	 * @return
	 */
	public static String encryption(String longBinaryInput, String inputKey)
	{
		
		String block = "", encrypted = "";

		//encrypt in 64 bit blocks
		int i;
		for(i = 0 ; i < (longBinaryInput.length() / BLOCK_SIZE); i++)
		{
			block = longBinaryInput.substring(BLOCK_SIZE * i, (BLOCK_SIZE * i) + BLOCK_SIZE);
			encrypted += (Conversions.encryptBlock(block, inputKey));
		}
		
		//encrypt remaining less than 64 bit block
		block = longBinaryInput.substring(i * BLOCK_SIZE);
		for(int j = 0; j < BLOCK_SIZE - (longBinaryInput.length() - (i * BLOCK_SIZE)); j++)
		{
			block = "0" + block;
		}
		encrypted += (Conversions.encryptBlock(block, inputKey));

		return encrypted;
	}

	/**
	 * This function takes in a longBinaryInput and inputkey and decrypts the input in batches of 64
	 * elements using the decryptBlock() function
	 * @param longBinaryInput
	 * @param inputKey
	 * @return
	 */
	public static String decryption(String longBinaryInput, String inputKey)	
	{
		
		String decrypted = "";
		if(longBinaryInput.length() % 64 != 0) 
			System.out.println("Incomplete decryption");
		
		String temp = "";
		int i;
		for(i = 0 ; i < longBinaryInput.length() / BLOCK_SIZE; i++)
		{
			temp = longBinaryInput.substring(BLOCK_SIZE * i, (BLOCK_SIZE * i) + BLOCK_SIZE);
			decrypted += Conversions.decryptBlock(temp, inputKey);
		}
		
		return decrypted;
	}

	/**
	 * This function makes all 10 keys for the encryption/decryption algorithm storing them in an arraylist of integer arraylists
	 * @param inputkey
	 * @return
	 */
	public static String[] keyScheduleTransform(String inputKey)
	{
		//validate that the input is of size 56
		if(inputKey.length() != KEY_SIZE)
		{
			System.out.println("INPUT OF keyScheduleTransform INCORRECT SIZE");
			return null;
		}
		
		String[] subKeys = new String[10];
		
		//creating original left and right subkeys
		String leftKey = inputKey.substring(0, (KEY_SIZE/2));
		String rightKey = inputKey.substring(KEY_SIZE/2);
		
		for(int i = 0; i < 10; i++)
		{
			//left shift both halves
			leftKey = Conversions.shiftIt(leftKey);
			rightKey = Conversions.shiftIt(rightKey);

			//Creating the i(th) subkey from the first 32 elements of the left and right halves
			String iSubKey = leftKey;
			iSubKey += rightKey.substring(0, 4);
			
			//adding the i(th) subkey to the array of keys
			subKeys[i] = (iSubKey);
		}
		
		return subKeys;
	}
	
	
	
	
	//MY HELPER FUNCTIONS
	/**
	 * This method converts a binary sequence into a String of hexadecimal values
	 * i.e. converts from base 2 to base 16
	 * @param binary
	 * @return
	 */
	public static String binaryToHexa(String binary)
	{
		int len = binary.length();
		
		String hexa = "";
		if(len % 4 != 0)
		{
			System.out.println("Incomplete quartet passed");
			return null;
		}

		for(int i = 0; i < len/4; i++)
		{
			int binval = 0;
			for(int j = 0; j < 4; j++)
			{
				binval += Math.pow(2, 3 - j) * (binary.charAt(4*i + j)-48);
			}
			hexa = hexa + (String.valueOf(hexchars[binval]));
			
		}
		
		return hexa;
	}
		
	/**
     * this function reads data from a file and returns it as a string
     * @param filepath
     * @return
     * @throws IOException
     */
	public static String getFileData(String filepath) throws IOException 
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

	/**
	 * This function takes a String and converts each character to its binary form
	 * and returns the binary sequences appended together in a string
	 * @param s any String input
	 * @return
	 */
	public static String stringToBinaryString(String s)
	{
		String bin = "";
		for(int i = 0 ; i < s.length(); i++)
		{
			char charAtI = s.charAt(i);
			ArrayList<Integer> binArray = Conversions.decimalToBinary(charAtI);
			for(int j = 0 ; j < binArray.size(); j++)
			{
				bin += binArray.get(j);
			}
		}
		return bin;
	}
	
	/**
	 * This function converts any base 10 integer input into base 2
	 * and returns this value as an ArrayList of integers
	 * @param dec
	 * @return
	 */
	public static ArrayList<Integer> decimalToBinary(int dec)
	{
		
       // array to store binary number 
		ArrayList<Integer> binaryNum = new ArrayList<Integer>();
		int[] binary = new int[1000]; 
		for(int i = 0; i < 1000; i++)
		{
			binary[i] = Integer.MAX_VALUE;
		}
       // counter for binary array 
       int i = 0; 
       while (dec > 0)  
       { 
           // storing remainder in binary array 
           binary[i] = dec % 2; 
           dec = dec / 2; 
           i++; 
       } 
       
       for(int j = 0; j < binary.length; j++)
       {
       	if(binary[j] == 0 || binary[j] == 1)
       	{
       		binaryNum.add(binary[j]);
       	}
       }
       
       if(binaryNum.size() != 8)
       {
       	int sizedif = 8 - binaryNum.size();
       	for(int j = 0; j < sizedif; j++)
       	{
       		binaryNum.add(0);
       	}
       }
       //binary array in reverse order 
       Collections.reverse(binaryNum);
  
		return binaryNum;
	}

	/**
	 * This is a helper method to create a simple string from the arraylist input
	 * @param array
	 * @return String representation of the array
	 */
	public static String arrayToString(ArrayList<Integer> array)
	{
		String s = "";
		for(int i = 0; i < array.size(); i++)
		{
			s += array.get(i);
		}
		return s;
	}
}
	







