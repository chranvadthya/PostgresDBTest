package com.sfdc.file;

import java.io.FileReader;
public class LocalAccessTesting {
    public static void main(String args[])throws Exception{
        FileReader fr=new FileReader("C:\\\\Users\\\\cvadthya\\\\Hello.class");
        int i;
        while((i=fr.read())!=-1)
            System.out.print((char)i);
        fr.close();
    }
}
