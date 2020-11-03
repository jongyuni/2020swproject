package com.company;

import java.io.IOException;
import java.util.Scanner;

public class BookRegister {

    private String SellerID;
    private String SellerEmail;
    String InputTitle;
    Scanner sc = new Scanner(System.in);
    BookList tempforadd = new BookList();

    public BookRegister(){}

    public void register() throws IOException {

        System.out.println("책 등록");
        System.out.print("책 이름: ");
        InputTitle = sc.nextLine();
        this.checkBookName(InputTitle);//책 제목 입력 했는지 확인
        System.out.print("출판사: ");
        String InputPublisher = sc.nextLine();
        System.out.print("저자 정보: ");
        String InputWriter = sc.nextLine();
        System.out.print("출판년도: ");
        String InputPublishedYear = sc.nextLine();
        System.out.print("가격: ");
        String InputPrice = sc.nextLine();
        System.out.print("책 상태: (Excellent / Good / Fair)");
        String InputBookState = sc.nextLine();
        System.out.print("책의 ISBN Number: ");
        String InputISBNNumber = sc.nextLine();//새로운 책 정보 입력 받기

        BookInformation addbook = new BookInformation();
        addbook.setTitle(InputTitle);
        addbook.setPublisher(InputPublisher);
        addbook.setWriter(InputWriter);
        addbook.setPublishedYear(InputPublishedYear);
        addbook.setPrice(InputPrice);
        addbook.setBookState(InputBookState);
        addbook.setISBNNumber(InputISBNNumber);
        addbook.setSellerID(this.SellerID);
        addbook.setSellerEmail(this.SellerEmail);
        tempforadd.bookrecords.add(addbook);//새 책 정보 리스트에 저장

        BookList savefile = new BookList();
        savefile.writeFile();//새 책 정보 파일에 저장

        RunProgram runprogram = new RunProgram();
        runprogram.generalUserMenu(SellerID, SellerEmail);//초기 화면 돌아가기
    }//새로운 책 입력 받기

    public void InputSellerInform(String SellerID, String SellerEmail){
        this.SellerID = SellerID;
        this.SellerEmail = SellerEmail;
    }

    public void checkBookName(String Input){

        if((Input==null)||(Input.trim().length()==0)){
            System.out.println("책 이름을 입력해주세요");
            System.out.print("책 이름: ");
            InputTitle = sc.nextLine();
            this.checkBookName(InputTitle);
        }
    }//책 제목 입력했는지 확인
}
