package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModifyBook {

    BookList ListforMod = new BookList();
    ArrayList<BookInformation> TempforMod = new ArrayList<BookInformation>();
    RunProgram runprogram = new RunProgram();
    Scanner sc = new Scanner(System.in);
    String input;

    public ModifyBook(){}

    public void ModifyBook(String UserID, String UserEmail) throws IOException {

        for(int i = 0 ; i < ListforMod.bookrecords.size() ; i++){
            if(ListforMod.bookrecords.get(i).getSellerEmail().equals(UserEmail)){
                TempforMod.add(ListforMod.bookrecords.get(i));
            }
        }//등록된 판매자 email로 판매자가 올린 모든 책 찾기
        
        System.out.println("1. 수정 / 2. 삭제 / 3. 이전 화면으로 돌아가기");
        input = sc.nextLine();

        switch (input){

            case "1": this.practiceMod(UserID, UserEmail); break;//책 수정

            case "2": this.delbook(UserID, UserEmail); break;//책 삭제

            case "3": runprogram.generalUserMenu(UserID, UserEmail);//메뉴 화면으로 돌아가기

            default: this.ModifyBook(UserID, UserEmail);

        }

    }//일반 사용자가 자신이 올린 책 중 무슨 행동을 할지 결정

    public void practiceMod(String UserID, String UserEmail) throws IOException {

        if(TempforMod.size()==0){
            System.out.println("등록된 책이 없습니다.");
            this.ModifyBook(UserID,UserEmail);
        }
        System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
        for (int i = 0 ; i < TempforMod.size() ; i++){
            System.out.printf((i+1) + ": ");
            System.out.printf(TempforMod.get(i).getTitle() + ", ");
            System.out.printf(TempforMod.get(i).getPublisher() + ", ");
            System.out.printf(TempforMod.get(i).getWriter() + ", ");
            System.out.printf(TempforMod.get(i).getPublishedYear() + "년, ");
            System.out.printf(TempforMod.get(i).getPrice() + "원, ");
            System.out.println(TempforMod.get(i).getISBNNumber());
        }//검색한 책 모두 띄우기

        System.out.println("몇번 책을 수정하시겠습니까?");
        String num = sc.nextLine();
        int j = Integer.parseInt(num);
        j--;//수정할 책 선택

        System.out.println("책 수정");
        System.out.print("책 이름: " + TempforMod.get(j).getTitle() + " -> ");
        String InputTitle = sc.nextLine();
        System.out.print("출판사: " + TempforMod.get(j).getPublisher() + " -> ");
        String InputPublisher = sc.nextLine();
        System.out.print("저자 정보: " + TempforMod.get(j).getWriter() + " -> ");
        String InputWriter = sc.nextLine();
        System.out.print("출판년도: " + TempforMod.get(j).getPublishedYear() + " -> ");
        String InputPublishedYear = sc.nextLine();
        System.out.print("가격: " + TempforMod.get(j).getPrice() + " -> ");
        String InputPrice = sc.nextLine();
        System.out.print("책 상태(Excellent / Good / Fair): " + TempforMod.get(j).getBookState() + " -> ");
        String InputBookState = sc.nextLine();
        System.out.print("책의 ISBN Number: " + TempforMod.get(j).getISBNNumber() + " -> ");
        String InputISBNNumber = sc.nextLine();//책 정보 수정하기

        ListforMod.bookrecords.remove(TempforMod.get(j));//원래 책 정보 삭제

        TempforMod.get(j).setTitle(InputTitle);
        TempforMod.get(j).setPublisher(InputPublisher);
        TempforMod.get(j).setWriter(InputWriter);
        TempforMod.get(j).setPublishedYear(InputPublishedYear);
        TempforMod.get(j).setPrice(InputPrice);
        TempforMod.get(j).setBookState(InputBookState);
        TempforMod.get(j).setISBNNumber(InputISBNNumber);//책 정보 수정

        ListforMod.bookrecords.add(TempforMod.get(j));//수정된 책을 BookList에 추가
        ListforMod.writeFile();//파일 저장

        runprogram.generalUserMenu(UserID, UserEmail);

    }//일반 사용자가 자신의 책 수정을 선택 했을시 실행

    public void delbook(String UserID, String UserEmail) throws IOException {

        if(TempforMod.size()==0){
            System.out.println("등록된 책이 없습니다.");
            this.ModifyBook(UserID,UserEmail);
        }
        System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
        for (int i = 0 ; i < TempforMod.size() ; i++){
            System.out.printf((i+1) + ": ");
            System.out.printf(TempforMod.get(i).getTitle() + ", ");
            System.out.printf(TempforMod.get(i).getPublisher() + ", ");
            System.out.printf(TempforMod.get(i).getWriter() + ", ");
            System.out.printf(TempforMod.get(i).getPublishedYear() + "년, ");
            System.out.printf(TempforMod.get(i).getPrice() + "원, ");
            System.out.println(TempforMod.get(i).getISBNNumber());
        }//검색한 책 모두 띄우기

        System.out.println("몇번 책을 삭제하시겠습니까?");
        int j = 0;
        j = sc.nextInt();

        ListforMod.bookrecords.remove(TempforMod.get(j-1));//책 삭제
        ListforMod.writeFile();//파일 저장

        System.out.println("삭제가 완료되었습니다.");

        runprogram.generalUserMenu(UserID, UserEmail);

    }//일반 사용자가 삭제하고 싶은 자신의 책 삭제
}
