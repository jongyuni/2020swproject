package com.company;

import java.io.IOException;
import java.util.Scanner;

public class RegisterUser {

    UserList tempforadd = new UserList();
    Scanner sc = new Scanner(System.in);
    String InputID;
    String InputPassword;
    String InputUserName;
    String InputPhoneNumber;
    String InputUserEmail;

    public  RegisterUser(){}

    public void register () throws IOException {

        System.out.println("회원 등록");
        System.out.print("ID: ");
        InputID = sc.nextLine();
        this.checkID(InputID);//아이디 제대로 입력했는지와 중복 확인
        System.out.print("Password: ");
        InputPassword = sc.nextLine();
        this.checkPassword(InputPassword);//비밀번호 제대로 입력했는지 확인
        System.out.print("UserName: ");
        InputUserName = sc.nextLine();
        this.checkUserName(InputUserName);//이름 제대로 입력했는지 확인
        System.out.print("PhoneNumber(형식 01012345678): ");
        InputPhoneNumber = sc.nextLine();
        this.checkPhoneNumber(InputPhoneNumber);//폰 번호 제대로 입력했는지 확인
        System.out.print("UserEmail: ");
        InputUserEmail = sc.nextLine();
        this.checkEmail(InputUserEmail);//이메일 제대로 입력했는지 확인
        //새로운 유저 정보 입력 받기


        UserInformation tempuser = new UserInformation();

        tempuser.setID(InputID);
        tempuser.setPassword(InputPassword);
        tempuser.setUserName(InputUserName);
        tempuser.setPhoneNumber(InputPhoneNumber);
        tempuser.setUserEmail(InputUserEmail);
        tempuser.setUserState();
        tempforadd.records.add(tempuser);//유저 정보 저장

        UserList saveFile = new UserList();
        saveFile.writeFile();//유저 정보 파일에 저장

        RunProgram rp = new RunProgram();
        rp.selloginreg();//초기 화면으로 돌아가기

    }//새로운 유저 정보 입력 받기

    public void checkID(String CheckID) {

        if((CheckID == null)||CheckID.trim().length()==0){
            System.out.println("아이디를 제대로 입력하세요.");
            System.out.print("ID: ");
            InputID = sc.nextLine();
            this.checkID(InputID);
        }
        for(int i = 0; i < tempforadd.records.size(); i++){

            if (CheckID.equals(tempforadd.records.get(i).getID())){
                System.out.println("이미 같은 아이디가 있습니다.");
                System.out.println("회원 등록");
                System.out.print("ID: ");
                InputID = sc.nextLine();
                this.checkID(InputID);
                break;
            }
        }

    }//아이디 중복 확인

    public void checkPassword(String CheckPW){

            if((CheckPW == null)||CheckPW.trim().length()==0){
                System.out.println("비밀번호를 입력하세요.");
                System.out.print("Password: ");
                InputPassword = sc.nextLine();
                this.checkPassword(InputPassword);
            }


    }//비밀번호 제대로 입력했는지 확인

    public void checkUserName(String CheckName){

        if((CheckName == null)||CheckName.trim().length()==0){
            System.out.println("이름을 제대로 입력하세요.");
            System.out.print("UserName: ");
            InputUserName = sc.nextLine();
            this.checkUserName(InputUserName);
        }


    }//이름 제대로 입력했는지 확인

    public void checkPhoneNumber(String CheckNumber){

        if(!(CheckNumber.trim().length()==11)||!(CheckNumber.startsWith("010"))){
            System.out.println("핸드폰 번호를 제대로 입력하세요.");
            System.out.print("PhoneNumber(형식 01012345678): ");
            InputPhoneNumber = sc.nextLine();
            this.checkPhoneNumber(InputPhoneNumber);
        }
        
    }//핸드폰 번호 제대로 입력했는지 확인

    public void checkEmail(String CheckEmail){

        if((CheckEmail == null)||CheckEmail.trim().length()==0){
            System.out.println("이메일을 제대로 입력하세요.");
            System.out.print("Email: ");
            InputUserEmail = sc.nextLine();
            this.checkEmail(InputUserEmail);
        }

    }//핸드폰 번호 제대로 입력했는지 확인
    
}
