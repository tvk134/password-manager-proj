package pass;

import java.util.*;
public class crypt
{
    
    public static String keyGen(String input)                           //encryption method.
    {
        char[] key = new char[93];                                      //array storing corresponding key character.
        ArrayList<Character> used = new ArrayList<Character>();         //arraylist to ensure same character does not correspond to 2 entries in the array.

        for(int i = 0;i<93;i++)                                         //generates random and new character for each array index.
        {
            int j = (int) (33+(Math.random()*93));                      //generator does not include spaces since they are not allowed in passwords.
            if(!used.contains((char)j))
            {
                used.add((char)j);
                key[i] = (char)j;
            }
            else i--;                                                   //resets for loop counter till new character is found. 
        }

        String output="";
        char[] in = input.toCharArray();
        for(char b:key)
        {
            output+=b;                                                  //inserts entire key to the beginning of the output string.
        }
        for(char a:in)
        {   
            output+=key[((int)a)-33];                                   //inserts encrypted string AFTER the key in the same string.
        }

        return output;
    }

    public static String decrypt(String input)
    {
        String answer="";
        String key = input.substring(0, 93);
        char[] coded = (input.substring(93, 94+(input.length()-94))).toCharArray();

        char[] correspond = new char[key.length()];
        for(int i = 0;i<key.length();i++)                               //loop iterates over all characters after the key to individually decrypt the string.
        {
            char a = key.charAt(i);
            char b = (char) (i+33);
            correspond[((int)a)-33] = b;                                //individually decrypted characters added to char array in order.
        }

        for(char c:coded)
        {
            answer+=correspond[((int)c)-33];                            //contents of char array concatenated to the output string in order.
        }

        return answer;
    }
}
