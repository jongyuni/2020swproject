package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchBook {

    BookList ListforSearch = new BookList();
    BuyBook tempBuyBook = new BuyBook();
    ArrayList<BookInformation> tempList = new ArrayList<BookInformation>();
    Scanner sc = new Scanner(System.in);
    String input;

    public SearchBook(){}

    public void SearchBook(String UserID, String UserEmail) throws IOException {
        System.out.println("무엇으로 검색하겠습니까?");
        System.out.println("1: 책 이름 / 2: ISBN 번호 / 3: 저자 / 4: 출판사 / 5: 출판년도 / 6: 판매자 id / 7.메뉴 선택으로 돌아가기");
        input = sc.nextLine();

        switch (input){

            case "1" : this.SearchTitle(); break;//책 이름으로 검색
            case "2" : this.SearchISBN(); break;//ISBN으로 검색
            case "3" : this.SearchWriter(); break;//저자로 검색
            case "4" : this.SearchPublisher(); break;//출판사로 검색
            case "5" : this.SearchPublishedYear(); break;//츨판년도로 검색
            case "6" : this.SearchSellerID(); break;//판매자 id로 검색
            case "7" : break;
            default: this.SearchBook(UserID, UserEmail);

        }

        RunProgram runprogram = new RunProgram();
        runprogram.generalUserMenu(UserID, UserEmail);

    }//일반 사용자로 책 검색

    public void SearchBook(String AdminID) throws IOException {
        System.out.println("무엇으로 검색하겠습니까?");
        System.out.println("1: 책 이름 / 2: ISBN 번호 / 3: 저자 / 4: 출판사 / 5: 출판년도 / 6: 판매자 id / 7: 메뉴로 돌아가기");
        input = sc.nextLine();

        switch (input){

            case "1" : this.SearchTitle(AdminID); break;
            case "2" : this.SearchISBN(AdminID); break;
            case "3" : this.SearchWriter(AdminID); break;
            case "4" : this.SearchPublisher(AdminID); break;
            case "5" : this.SearchPublishedYear(AdminID); break;
            case "6" : this.SearchSellerID(AdminID); break;
            case "7" : RunProgram RP = new RunProgram(); RP.adminMenu(AdminID); break;
            default: this.SearchBook(AdminID);

        }

        RunProgram RP = new RunProgram();
        RP.adminMenu(AdminID);
    }//관리자 ID로 로그인시 책 검색

    public void SearchTitle() throws IOException {

        System.out.println("검색하려는 책의 이름은?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size(); i++){

            if(ListforSearch.bookrecords.get(i).getTitle().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//책 이름으로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook();
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우

    }//일반 사용자가 책 이름으로 책 검색

    public void SearchTitle(String AdminID) throws IOException {

        System.out.println("검색하려는 책의 이름은?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size(); i++){

            if(ListforSearch.bookrecords.get(i).getTitle().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//책 이름으로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook(AdminID);
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우

    }//관리자가 책 이름으로 책 검색

    public void SearchISBN() throws IOException {

        System.out.println("검색하려는 책의 ISBN 번호는?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getISBNNumber().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//책 ISBN 번호로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook();
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우

    }//일반 사용자가 책 ISBN 번호로 책 검색

    public void SearchISBN(String AdminID) throws IOException {

        System.out.println("검색하려는 책의 ISBN 번호는?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getISBNNumber().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//책 ISBN 번호로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook(AdminID);
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우

    }//관리자가 책 ISBN 번호로 책 검색

    public void SearchWriter() throws IOException {

        System.out.println("검색하려는 작가의 이름은?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getWriter().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//저자 이름으로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook();
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우
    }//일반 사용자가 저자 이름으로 책 검색

    public void SearchWriter(String AdminID) throws IOException {

        System.out.println("검색하려는 작가의 이름은?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getWriter().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//저자 이름으로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook(AdminID);
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우

    }//관리자가 저자 이름으로 책 검색

    public void SearchPublisher() throws IOException {

        System.out.println("검색하려는 출판사는?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size(); i++){

            if(ListforSearch.bookrecords.get(i).getPublisher().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//출판사명으로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook();
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우
    }//일반 사용자가 출판사로 책 검색

    public void SearchPublisher(String AdminID) throws IOException {

        System.out.println("검색하려는 출판사는?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getPublisher().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//출판사명으로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook(AdminID);
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우

    }//관리자가 출판사로 책 검색

    public void SearchPublishedYear() throws IOException {

        System.out.println("검색하려는 출판연도는?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size(); i++){

            if(ListforSearch.bookrecords.get(i).getPublishedYear().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//출판연도로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook();
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우
    }//일반 사용자가 출판연도로 책 검색

    public void SearchPublishedYear(String AdminID) throws IOException {

        System.out.println("검색하려는 출판연도는?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getPublishedYear().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//출판연도로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook(AdminID);
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우

    }//관리자가 출판연도로 책 검색

    public void SearchSellerID() throws IOException {

        System.out.println("검색하려는 판매자 ID는?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getSellerID().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//책 판매자 ID로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook();
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우
    }//일반 사용자가 판매자 ID로 책 검색

    public void SearchSellerID(String AdminID) throws IOException {

        System.out.println("검색하려는 판매자 ID는?");
        input = sc.nextLine();

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getSellerID().equals(input)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//책 ISBN 번호로 검색하기

        if(this.CheckisBook(tempList)){
            System.out.println("책 이름, 출판사, 저자, 출판년도, 가격, ISBN ");
            for (int i = 0 ; i < tempList.size() ; i++){
                System.out.printf((i+1) + ": ");
                System.out.printf(tempList.get(i).getTitle() + ", ");
                System.out.printf(tempList.get(i).getPublisher() + ", ");
                System.out.printf(tempList.get(i).getWriter() + ", ");
                System.out.printf(tempList.get(i).getPublishedYear() + "년, ");
                System.out.printf(tempList.get(i).getPrice() + "원, ");
                System.out.println(tempList.get(i).getISBNNumber());
            }//검색한 책 모두 띄우기
            this.DetermineBook(AdminID);
        }//검색하려는 책 있을 경우
        else {
            System.out.println("검색하려는 책을 찾을 수 없습니다.");
        }//검색하는 책 없을 경우

    }//관리자가 판매자 ID로 책 검색

    public void DetermineBook() throws IOException {

        int j = 0;
        System.out.println("몇번 책을 사시겠습니까?");
        j = sc.nextInt();

        tempBuyBook.BuyBook(tempList.get(j-1));

    }//일반 사용자가 검색된 목록에서 책 구매 결정

    public void DetermineBook(String AdminID) throws IOException {

        int j = 0;

        System.out.println("몇번 책을 삭제하시겠습니까?");
        j = sc.nextInt();

        tempBuyBook.AdminDelBook(tempList.get(j-1));

    }//관리자가 검색 목록에서 어떤 책 삭제할지 결정

    public void DelBook(String AdminID, String UserID) throws IOException {

        for (int i = 0 ; i < ListforSearch.bookrecords.size() ; i++){

            if(ListforSearch.bookrecords.get(i).getSellerID().equals(UserID)){
                tempList.add(ListforSearch.bookrecords.get(i));
            }
        }//특정 ID가 판매하는 모든 책 찾기

        ListforSearch.bookrecords.remove(tempList);//책 삭제
        ListforSearch.writeFile();//파일 저장

    }//관리자가 회원 삭제하면서 동시에 회원이 등록한 책 삭제

    public boolean CheckisBook(ArrayList<BookInformation> checklist){

        if(checklist.size()==0){
            return false;
        }
        else return true;

    }//찾을려는 책이 있는지 검사

}
