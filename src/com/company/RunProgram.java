package com.company;

import java.io.IOException;
import java.util.Scanner;

public class RunProgram {

    Scanner sc = new Scanner(System.in);
    String input;

    public RunProgram(){}

    public void selloginreg() throws IOException {

        System.out.println("1. 로그인 / 2. 회원 가입 / 3. 프로그램 종료");
        input = sc.nextLine();

        switch (input){

            case "1": ProgramLogin runlogin = new ProgramLogin();//시스템 로그인
            runlogin.login();
            break;

            case "2": RegisterUser runregi = new RegisterUser();//회원 가입
            runregi.register();
            break;

            case "3": System.exit(0); break; //프로그램 종료

            default: this.selloginreg();
        }

    }//프로그램 초기 화면

    public void generalUserMenu(String UserID, String UserEmail) throws IOException {

        System.out.println("1. 책 판매하기 / 2. 책 구매하기 / 3. 책 관리하기 / 4. 회원 정보 수정 / 5. 로그아웃 / 6. 프로그램 종료");
        input = sc.nextLine();

        switch (input){

            case "1" : BookRegister bkreg = new BookRegister(); bkreg.InputSellerInform(UserID, UserEmail);
            bkreg.register(); break;//책 장터에 등록하기

            case "2" : BuyBook buybook = new BuyBook(); buybook.ShowList(UserID, UserEmail); break;//책 구매하기

            case "3" : ModifyBook modifybook = new ModifyBook(); modifybook.ModifyBook(UserID, UserEmail); break;//판매중인 책 관리하기

            case "4" : ModifyUser modifyuser = new ModifyUser(); modifyuser.ModifyUser(UserID, UserEmail); break;

            case "5" : this.selloginreg(); break;//로그아웃

            case "6" : System.exit(0);//프로그램 종료

            default: this.generalUserMenu(UserID, UserEmail); break;
        }//메뉴 선택

    }//일반 유저 모드

    public void adminMenu(String ID) throws IOException {

        System.out.println("//////관리자 모드//////");
        System.out.println("무엇을 할지 선택해주세요.");
        System.out.println("1. 책 관리 / 2. 회원 관리 / 3. 로그아웃 / 4. 프로그램 종료");
        input = sc.nextLine();

        switch (input){

            case "1" : SearchBook adminSearch = new SearchBook(); adminSearch.SearchBook(ID); break;//책 관리 모드
            
            case "2" : SearchUser adminUserSearch = new SearchUser(); adminUserSearch.SearchUser(ID); break;//회원 관리 모드

            case "3" : this.selloginreg(); break;//관리자 로그아웃

            case "4" : System.exit(0); break;//프로그램 종료

            default: this.adminMenu(ID);
        }//메뉴 선택
    }//관리자 모드

}



