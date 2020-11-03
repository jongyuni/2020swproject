package com.company;

import java.io.IOException;
import java.util.Scanner;

public class SearchUser {

    UserList showuser = new UserList();
    Scanner sc = new Scanner(System.in);

    public SearchUser(){}

    public void SearchUser(String AdminID) throws IOException {

        for (int i = 1 ; i < showuser.records.size() ; i++){

            System.out.printf(i + ": ");
            System.out.printf(showuser.records.get(i).getUserName() + ", ");
            System.out.printf(showuser.records.get(i).getID() + ", ");
            System.out.printf(showuser.records.get(i).getPassword() + ", ");
            System.out.printf(showuser.records.get(i).getUserEmail() + ", ");
            System.out.printf(showuser.records.get(i).getPhoneNumber() + ", ");
            System.out.println(showuser.records.get(i).getUserState());
        }//모든 회원 출력

        System.out.println("무엇을 하시겠습니까?");
        System.out.println("1. 계정 상태 변경 / 2. 계정 삭제 / 3. 이전화면 돌아가기 / 4. 프로그램 종료");
        int num = sc.nextInt();

        switch (num){
            case 1: this.changestate(); break;//계정 상태 변경 모드

            case 2: this.deluser(AdminID); break;//계정 삭제 모드

            case 3: RunProgram rp = new RunProgram(); rp.adminMenu(AdminID); break;//이전 화면 돌아가기

            case 4: System.exit(0);//프로그램 종료

            default: this.SearchUser(AdminID);
        }//관리자 모드로 무엇을 할지 결정

        RunProgram rp = new RunProgram();
        rp.adminMenu(AdminID);//관리자 메뉴 화면으로 돌아가기
    }//관리자 모드로 무엇을 할지 결정

    public void changestate() throws IOException {
        System.out.println("몇번 계정의 상태를 바꾸시겠습니까?");
        int j = sc.nextInt();

        if(showuser.records.get(j).getUserState().equals("yes")){
            showuser.records.get(j).setUserState("no");//계정 활성화 -> 비활성화
        }
        else showuser.records.get(j).setUserState("yes");//계정 비활성화 -> 활성화

        UserList userlist = new UserList();
        userlist.writeFile();//파일 저장

    }//특정 계정의 상태 바꾸기

    public void deluser(String AdminID) throws IOException{

        System.out.println("몇번 계정을 삭제하시겠습니까?");
        int j = sc.nextInt();

        if(showuser.records.get(j).getUserState().equals("no")){
            SearchBook sb = new SearchBook();
            sb.DelBook(AdminID, showuser.records.get(j).getID());//해당 계정으로 판매 중인 책 삭제
            
            showuser.records.remove(j);//해당 유저 삭제
            showuser.writeFile();
            System.out.println("삭제가 완료되었습니다.");
        }
        else {//유저가 비활성화가 아닐시 계정 삭제 불가 
            System.out.println("계정을 삭제할 수 없습니다.");
        }

        RunProgram runprogram = new RunProgram();
        runprogram.adminMenu(AdminID);//관리자 메뉴 화면으로 돌아가기

    }//관리자 모드로 삭제할 계정 입력받기


}
