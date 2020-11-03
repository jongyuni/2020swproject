package com.company;

import java.io.IOException;
import java.util.Scanner;

public class ProgramLogin {

        Scanner sc = new Scanner(System.in);
        String InputID;
        String InputPassword;
        String InputEmail;

    public void login() throws IOException {

        System.out.print("ID: ");
        InputID = sc.nextLine();
        System.out.print("Password: ");
        InputPassword = sc.nextLine();

        this.checkID(InputID,InputPassword);


    }//유저로부터 아이디와 비밀번호 입력 받음

    public void checkID(String InputID, String InputPassword) throws IOException {

        UserList CheckforLogin = new UserList();

        if((InputID.equals("admin")&&(InputPassword.equals("nayana")))){
            RunProgram runprogram = new RunProgram();
            runprogram.adminMenu(InputID);
        }//관리자면 관리자 모드로 들어감

        for(int i = 1; i < CheckforLogin.records.size(); i++) {//i=0에는 admin 계정 정보가 들어가 있기 때문에 i=1부터 시작한다

            if ((InputID.equals(CheckforLogin.records.get(i).getID()))&&InputPassword.equals(CheckforLogin.records.get(i).getPassword()))
            {//아이디와 비밀번호확인
                    if(CheckforLogin.records.get(i).getUserState().equals("yes")) {//활성화 여부 확인
                        InputEmail =  CheckforLogin.records.get(i).getUserEmail();//로그인 성공시 회원 email return
                        this.UserMenu(InputID,InputEmail);//로그인 후 화면으로 넘어감
                        break;
                    }
                    else {
                        System.out.println("아이디가 비활성화 되었습니다.");//비활성화시 로그인 불가
                        System.exit(0);                           //및 프로그램 종료
                    }
            }

        }
        System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");//아이디나 비밀번호 틀렸을시 다시 로그인
        System.out.print("ID: ");
        InputID = sc.nextLine();
        System.out.print("Password: ");
        InputPassword = sc.nextLine();
        this.checkID(InputID, InputPassword);

    }//유저가 입력한 아이디와 비밀번호로 로그인

    public void UserMenu(String UserID, String UserEmail) throws IOException {

        RunProgram runprogram = new RunProgram();
        runprogram.generalUserMenu(UserID, UserEmail);

    }//로그인 이후 일반 유저 메뉴로 넘어가기
}
