package lab7;

public class HashMap 
{

    public static int hashA(String key)
    {
        int hash = 0;
        String newkey = key.toUpperCase();
        for(int i = 0; i < newkey.length(); i++)
        {
            hash += newkey.charAt(i) - 65;
        }
        return hash;
    }

    public static int hashB(String key)
    {
        String newkey = key.toUpperCase();
        return newkey.charAt(0) + newkey.charAt(newkey.length() - 1) - 130;

    }

    public static void main(String[] args)
    {
        System.out.println("hash value: " + hashA("lizard"));
        System.out.println("hash value: " + hashB("lizard"));
    }    
}
