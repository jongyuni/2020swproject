package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName = "userlist.data"; // 대상 파일
        UserList userinform = new UserList();
        userinform.openFile(fileName); //유저 정보 정리


        String BookfileName = "booklist.data"; // 대상 파일
        BookList bookarray = new BookList();
        bookarray.openFile(BookfileName); //책 정보 정리

        RunProgram program = new RunProgram();
        program.selloginreg();//프로그램 실행

    }
}
