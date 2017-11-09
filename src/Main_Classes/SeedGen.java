package Main_Classes;

import java.util.Scanner;

public class SeedGen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("(E)ncode or (D)ecode?");
        String ed = sc.nextLine();

        if(ed.equals("e")) System.out.println(encode(input));
        if(ed.equals("d")) System.out.println(decode(input));
    }

    private static String encode(String input) {
        String temp = input;
        temp = toHex(temp);
        for(int i = 0; i<temp.length()-2; i += 2)System.out.println(temp.substring(i,i+2));
        return temp;
    }

    private static String decode(String input) {
        String temp = input;
        return input;
    }

    private static String toHex(String str){

        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }

        return hex.toString();
    }
}

/*
Standard ascii runs from the values 20 to 7E
2 3 4 5 6 7
6 categories, each with 4 subcategories
 */