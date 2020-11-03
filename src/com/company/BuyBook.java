package com.company;

import java.io.IOException;
import java.util.Scanner;

public class BuyBook {
    BookList SellingList = new BookList();
    Scanner sc = new Scanner(System.in);
    String input;
    String UserID;
    String UserEmail;

    public BuyBook(){}

    public void BuyBook() throws IOException {
        System.out.println("몇번 책을 사시겠습니까?");
        int i = 0;
        i = sc.nextInt();
        i--;

        System.out.println("구매가 완료되었습니다.");
        System.out.println("구매자: " + UserID);
        System.out.println("판매자: " + SellingList.bookrecords.get(i).getSellerID());
        System.out.println(UserEmail + "에서 " + SellingList.bookrecords.get(i).getSellerEmail() + "로 이메일 발송되었습니다.");
        
        SellingList.bookrecords.remove(i);
        SellingList.writeFile();

    }//장터에 등록된 책 구매

    public void BuyBook(BookInformation bookforbuy) throws IOException{

        System.out.println("구매가 완료되었습니다.");
        System.out.println("구매자: " + UserID);
        System.out.println("판매자: " + bookforbuy.getSellerID());
        System.out.println(UserEmail + "에서 " + bookforbuy.getSellerEmail() + "로 이메일 발송되었습니다.");

        SellingList.bookrecords.remove(bookforbuy);
        SellingList.writeFile();

    }//책 구매시 구매 완료 메세지 출력

    public void AdminDelBook(BookInformation bookforbuy) throws IOException{

        System.out.println("책 삭제가 완료되었습니다.");

        SellingList.bookrecords.remove(bookforbuy);
        SellingList.writeFile();

    }//관리자가 특정 책 삭제

    public void ShowList(String UserID, String UserEmail) throws IOException {

        this.UserID = UserID;
        this.UserEmail = UserEmail;

        System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");

        for(int i = 0; i < SellingList.bookrecords.size(); i++){
            System.out.printf((i+1) + ": ");
            System.out.printf(SellingList.bookrecords.get(i).getTitle() + ", ");
            System.out.printf(SellingList.bookrecords.get(i).getPublisher() + ", ");
            System.out.printf(SellingList.bookrecords.get(i).getWriter() + ", ");
            System.out.printf(SellingList.bookrecords.get(i).getPublishedYear() + ", ");
            System.out.printf(SellingList.bookrecords.get(i).getPrice() + ", ");
            System.out.println(SellingList.bookrecords.get(i).getISBNNumber());
        }//장터에 있는 책 리스트 업

        System.out.println("무엇을 하시겠습니까?");
        System.out.println("1. 책 구매 / 2. 책 검색 / 3. 이전 화면으로 넘어가기");
        input = sc.nextLine();//리스트에서 책 구매할지 또는 책 검색할지 

        switch (input){

            case ("1") : this.BuyBook(); break; //리스트에서 책 구매

            case ("2") : SearchBook searchbook = new SearchBook(); searchbook.SearchBook(UserID, UserEmail); break; //책 검색

            case ("3") : RunProgram runprogram = new RunProgram(); runprogram.generalUserMenu(UserID, UserEmail); break; //이전 화면으로 넘어가기

            default: this.ShowList(UserID, UserEmail);
        }//구매할지 더 검색할지, 이전 화면으로 돌아갈지 결정

        RunProgram runprogram = new RunProgram();
        runprogram.generalUserMenu(UserID, UserEmail);
    }//장터에 있는 책 리스트 출력 및 책 검색 선택
}
