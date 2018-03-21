package rucr;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Arithmetic {
    public static ArrayList<String> ss = new ArrayList<String>();

    public static void main(String[] args) throws Exception {

            System.out.println("Input a number:");
            int count = new Scanner(System.in).nextInt();
            File file =new File("./result.txt");
            FileOutputStream fops=null ;

            try {
                fops = new FileOutputStream(file);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            PrintStream ps= new PrintStream(fops);
            ps.println("201571030125");
            boolean f = true;
            for (int i=0;i<count;i++) {
                String data = Data();
                String input = data;
                ss.add(input);
                if (input.equals("q"))
                    break;
                else {
                    Expression express = new Expression(input);
                    f = express.getResult();
                    if(!f) i--;
                    else ps.println(data + "=" + express.getExpresult());
                }
            }
    }


    //随机产生算式
    public static String Data()
    {
        Random rand =new Random();
        ArrayList<Integer> numlist = new ArrayList<Integer>();
        ArrayList<String> express = new ArrayList<String>();
      //产生随机数
        for(int i=0;i<5;i++)
        {
            numlist.add(rand.nextInt(100)+1);
        }
        //System.out.print(numlist);
        String[] operator=new String[]{"+","-","*","/"};
        int size=numlist.size();
        String[] num=new String[size];
        for(int i=0;i<numlist.size();i++){
            num[i]=String.valueOf(numlist.get(i));
        }
        String exp="";
        for(int j=0;j<num.length;j++)
        {
            express.add(num[j]);
            express.add(operator[rand.nextInt(4)]);
        }
        //System.out.print(express);

        for(int i=0;i<express.size()-1;i++)
            exp+=express.get(i);
        return exp;
    }
}
