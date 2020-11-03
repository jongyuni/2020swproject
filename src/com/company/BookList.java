package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookList {

    static ArrayList<BookInformation> bookrecords = new ArrayList<BookInformation>();

    public BookList(){}

    public void openFile(String filename) throws IOException {

        Scanner input;
        String line;
        try
        {
            input = new Scanner(new File(filename));
        }//유저 정보 들어있는 파일 열기

        catch(Exception e)
        {
            System.out.println("Unknown File");
            return;
        }//에러 메세지 출력 및 return

        while (input.hasNext())
        {
            line = input.nextLine();

            if(!(line.startsWith(" ")))
            {
                this.bookrecords.add(new BookInformation(line));
            }
        }//유저 정보 분리 작업

    }

    public void writeFile() throws IOException{

        BufferedWriter register = new BufferedWriter(new FileWriter("booklist.data"));

        for(int i = 0 ; i < bookrecords.size() ; i++){

            register.write(bookrecords.get(i).getTitle());
            register.write(", ");
            register.write(bookrecords.get(i).getPublisher());
            register.write(", ");
            register.write(bookrecords.get(i).getWriter());
            register.write(", ");
            register.write(bookrecords.get(i).getPublishedYear());
            register.write(", ");
            register.write(bookrecords.get(i).getPrice());
            register.write(", ");
            register.write(bookrecords.get(i).getBookState());
            register.write(", ");
            register.write(bookrecords.get(i).getISBNNumber());
            register.write(", ");
            register.write(bookrecords.get(i).getSellerID());
            register.write(", ");
            register.write(bookrecords.get(i).getSellerEmail());
            register.newLine();
        }
        register.close();

    }//유저 정보 저장

}
