package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class UserList {

    static ArrayList<UserInformation> records = new ArrayList<UserInformation>();

    public UserList(){}

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
                this.records.add(new UserInformation(line));
            }
        }//유저 정보 분리 작업

    }//파일 열기

    public void writeFile() throws IOException{

        BufferedWriter register = new BufferedWriter(new FileWriter("userlist.data"));

        for(int i = 0 ; i < records.size() ; i++){
            register.write(records.get(i).getID());
            register.write(":");
            register.write(records.get(i).getPassword());
            register.write(":");
            register.write(records.get(i).getUserName());
            register.write(":");
            register.write(records.get(i).getPhoneNumber());
            register.write(":");
            register.write(records.get(i).getUserEmail());
            register.write(":");
            register.write(records.get(i).getUserState());
            register.newLine();
        }
        register.close();

    }//유저 정보 저장


}
