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
	private static ArrayList<Integer> xorIt(ArrayList<Integer> binary1, ArrayList<Integer> binary2)
	{
		ArrayList<Integer> xor = new ArrayList<Integer>();
		int dif = Math.abs(binary1.size() - binary2.size());
		if(binary1.size() > binary2.size())
		{
			for(int i = 0; i < dif; i++)
			{
				binary2.add(0, 0);
			}
		}
		else if(binary2.size() > binary1.size())
		{
			for(int i = 0; i < dif; i++)
			{
				binary1.add(0,0);
			}
				
		}
		
		//now both sequences are of the same length
		for(int i = 0; i < binary1.size(); i++)
		{
			if((binary1.get(i) == binary2.get(i)))
			{
				xor.add(0);
			}
			else
			{
				xor.add(1);
			}
		}
		return xor;
		
	}
    
	/**
	 * This function shift the binary sequence in an arraylist, left by 1 unit
	 * @param binaryInput
	 * @return
	 */
	private static ArrayList<Integer> shiftIt(ArrayList<Integer> binaryInput)
	{
		binaryInput.add(0);
		binaryInput.remove(0);
		return binaryInput;
	}
	
	/**
	 * This function permutes the provided binary sequence by the defined permutation matrix
	 * @param binaryInput
	 * @return
	 */
	private static ArrayList<Integer> permuteIt(ArrayList<Integer> binaryInput)
	{
		
		if(binaryInput.size() != 32)
		{
			System.out.println("Invalid input");
			return null;
		}
		
		//each number represents which element should  be in what order
		//i.e. element at index 16 of input is index 1 of the new sequence
		ArrayList<Integer> newSeq = new ArrayList<Integer>();
		for(int i = 0; i < 32; i++)
		{
			newSeq.add(binaryInput.get(pTransform[i]-1));
		}
		return newSeq;
	}

	private static ArrayList<Integer> SubstitutionS(ArrayList<Integer> binary)
	{

		if(binary.size() != 8)
		{
			System.out.println("Invalid input passed");
			return null;
		}
			
		//grab each value in the hexadecimal representation
		String hex = Conversions.binaryToHexa(binary);
		char row = hex.charAt(0);
		char col = hex.charAt(1);
		
		//converting from characters to integers in range 0 to F
		int rowNum = Integer.valueOf(row) - 48;
		int colNum = Integer.valueOf(col) - 48;
		
		//if the value is > 9 then it was a letter
		if((Integer.valueOf(row) - 48) > 9)
		{
			rowNum = Integer.valueOf(row) - 55;
		}
		if((Integer.valueOf(col) - 48) > 9)
		{
			colNum = Integer.valueOf(col) - 55;
		}
				
		//completing the sbox transformation
		ArrayList<Integer> subS = new ArrayList<Integer>();
		String binaryStr = sBox[rowNum][colNum];
		for(int i = 0; i < 8; i++)
		{
			subS.add(Integer.valueOf(binaryStr.charAt(i)) - 48);
		}
		return subS;
	}
	
	/**
	 * This function computes the defined F round function on the provided sequence with the provided subkey
	 * @param rightHalf
	 * @param subkey
	 * @return
	 */
	public static ArrayList<Integer> functionF(ArrayList<Integer> rightHalf, ArrayList<Integer> subkey)
	{
		if( rightHalf.size() != BLOCK_SIZE/2 || subkey.size() != BLOCK_SIZE/2)
		{
			System.out.println("The righthalf sequence or the subkey are not the correct lengths");
			return null;
		}
		
		
		//conducting xor with the subkey
		ArrayList<Integer> postXor = Conversions.xorIt(rightHalf, subkey);
		ArrayList<Integer> newSeq = new ArrayList<Integer>();
		//prepping to compute the Rinjndael S-Box transformation
		for(int i = 0 ; i < 4; i++)
		{
			//sublist is the groups of 8 elements from the postXor sequence
			ArrayList<Integer> sublist = new ArrayList<Integer>();
			for(int j = 0; j < 8; j++)
			{
				sublist.add(postXor.get((8*i) + j));
			}
			
			//computing the Rijndael X-box transformation
			newSeq.addAll(Conversions.SubstitutionS(sublist));
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
			System.out.println("BAD BLOCK SIZE INPUT. Expected Length " + BLOCK_SIZE + ".");
			return null;
		}
		if(inputKey.length() != KEY_SIZE)
		{
			System.out.println("BAD KEY INPUT. Expected Length " + KEY_SIZE + ".");
			return null;
		}
		
		ArrayList<Integer> blockArrayList = new ArrayList<Integer>();
		for(int i = 0; i < block.length(); i++)
		{
			blockArrayList.add(block.charAt(i) - 48);
		}
		ArrayList<Integer> keyArray = new ArrayList<Integer>();
//		System.out.println(Conversions.arrayToString(blockArrayList));
		for(int i = 0; i < inputKey.length(); i++)
		{
			keyArray.add(inputKey.charAt(i) - 48);
		}
//		System.out.println(Conversions.arrayToString(keyArray));
		//initialization of variables
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> subkeys = Conversions.keyScheduleTransform(keyArray);
		//creating left and right sequences
		for(int i = 0; i < (BLOCK_SIZE/2); i++) //block_size/2 will be 32
		{
			left.add(i, blockArrayList.get(i));
			right.add(i, blockArrayList.get(i+(BLOCK_SIZE/2)));
		}
		
		
		for(int i = 0; i < 10; i++)
		{
			ArrayList<Integer> tempLeft = left;
			left = right;
			
			//put right half through the functionF with the first subkey
			ArrayList<Integer> newseq = Conversions.functionF(right, subkeys.get(i));
			//right block becomes the left block xored with the f(prev right)
			right = Conversions.xorIt(tempLeft, newseq);
		}
		
		//finally combine the two left and right sequences
		left.addAll(right);
		return Conversions.arrayToString(left);
	}
	
	public static String decryptBlock(String block, String key)
	{
		
		ArrayList<Integer> blockArrayList = new ArrayList<Integer>();
		for(int i = 0; i < block.length(); i++)
		{
			blockArrayList.add(block.charAt(i) - 48);
		}
		ArrayList<Integer> keyArray = new ArrayList<Integer>();
//		System.out.println(Conversions.arrayToString(blockArrayList));
		for(int i = 0; i < key.length(); i++)
		{
			keyArray.add(key.charAt(i) - 48);
		}
		
		ArrayList<ArrayList<Integer>> keys = Conversions.keyScheduleTransform(keyArray);
		
		if(keys.size() != 10) System.out.println("SOMETHING BAD");
		
		//populate the first left and right values
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		for(int i = 0; i < BLOCK_SIZE/2; i++)
		{
			left.add(blockArrayList.get(i));
			right.add(blockArrayList.get(i + BLOCK_SIZE/2));
		}
		
		for(int i = 0; i < 10; i++)
		{
			ArrayList<Integer> tempRight = right;
			right = left;
			left = Conversions.xorIt(Conversions.functionF(left, keys.get(9-i)), tempRight);
		}
		
		
		//combine both halves
		left.addAll(right);
		
		return Conversions.arrayToString(left);
	}
	
	public static String encryption(String longBinaryInput, String inputKey)
	{
		
		String encrypted = "";
		String temp = "";

		int i;
		for(i = 0 ; i < longBinaryInput.length() / BLOCK_SIZE; i++)
		{
			temp = longBinaryInput.substring(BLOCK_SIZE * i, (BLOCK_SIZE * i) + BLOCK_SIZE);
			encrypted += (Conversions.encryptBlock(temp, inputKey));
		}
		
		temp = longBinaryInput.substring(i * BLOCK_SIZE);
		for(int j = 0; j < BLOCK_SIZE - (longBinaryInput.length() - (i * BLOCK_SIZE)); j++)
		{
			temp = "0" + temp;
		}
		encrypted += (Conversions.encryptBlock(temp, inputKey));

		return encrypted;
	}

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
	public static ArrayList<ArrayList<Integer>> keyScheduleTransform(ArrayList<Integer> inputkey)
	{
		//validate that the input is of size 56
		
		if(inputkey.size() != KEY_SIZE)
		{
			System.out.println("INPUT OF INCORRECT SIZE");
			return null;
		}
		
		
		//an arraylist of arraylists so that we can have an array of length 10
		//with each index holding an arraylist of length 32 which are the keys
		ArrayList<ArrayList<Integer>> subkeys = new ArrayList<ArrayList<Integer>>();
		
		
		//creating original left and right subkeys
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		for(int j = 0; j < 28; j++)
		{
			left.add(inputkey.get(j)); //first 28 elements
			right.add(inputkey.get(j+28)); //last 28 elements
		}
		
		for(int i = 0; i < 10; i++)
		{
			//left shift both halves
			left = Conversions.shiftIt(left);
			right = Conversions.shiftIt(right);

			
			//creating the ith subkey from the first 32 elements of the left and right halves
			ArrayList<Integer> iSubKey = new ArrayList<Integer>();
			for(int j = 0; j < 28; j++)
			{
				iSubKey.add(left.get(j));
			}
			for(int j = 0; j < 4; j++)
			{
				iSubKey.add(right.get(j));
			}
			
			if(iSubKey.size() != 32 || right.size() != 28 || left.size() != 28)
			{
				System.out.println("Incorrect input size: " + iSubKey.size());
			}
			
			subkeys.add(iSubKey);
		}
		
		return subkeys;
	}
	
	
	
	
	//MY HELPER FUNCTIONS
	private static String binaryToHexa(ArrayList<Integer> binary)
	{
		int len = binary.size();
		
		String hexa = "";
		if(len % 4 != 0)
		{
			System.out.println("Incomplete octet passed");
			return null;
		}

		for(int i = 0; i < len/4; i++)
		{
			int binval = 0;
			for(int j = 0; j < 4; j++)
			{
				binval += Math.pow(2, 3 - j) * binary.get(4*i + j);
			}
			hexa = hexa + (String.valueOf(hexchars[binval]));
			
		}
		
		return hexa;
	}
	
	private static ArrayList<Integer> hexaToBinary(String hexa)
	{
		int dec = 0;
		for(int i = 0; i < hexchars.length; i++)
		{
			if(hexchars[i] == hexa.charAt(0))
			{
				dec += 16*i;
			}
			if(hexchars[i] == hexa.charAt(1))
			{
				dec += i;
			}
		}
		
		return Conversions.decimalToBinary(dec);
	}
	
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
	
	public static ArrayList<Integer> stringToArray(String binary)
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0 ; i < binary.length(); i++)
		{
			 array.add((Integer.valueOf(binary.charAt(i) - 48)));
		}
		return array;
	}
}
	