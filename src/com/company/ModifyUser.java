package com.company;

import java.io.IOException;
import java.util.Scanner;

public class ModifyUser {

    UserList listformod = new UserList();
    RunProgram rp = new RunProgram();
    Scanner sc = new Scanner(System.in);
    String modpassword;
    String modusername;
    String modphonenumber;


    public ModifyUser(){}

    public void ModifyUser(String UserID, String UserEmail) throws IOException {

        System.out.println("무슨 정보를 수정하시겠습니까?");
        System.out.println("1. 비밀번호 수정 / 2. 회원 이름 수정 / 3. 전화번호 수정 / 4. 이전 메뉴 돌아가기");
        String num = sc.nextLine();

        switch (num){

            case "1": this.ModifyPassword(UserID, UserEmail); break;

            case "2": this.ModifyUserName(UserID, UserEmail); break;

            case "3": this.ModifyPhoneNumber(UserID, UserEmail); break;

            case "4": rp.generalUserMenu(UserID, UserEmail); break;

            default: this.ModifyUser(UserID, UserEmail);
        }

        listformod.writeFile();//파일 저장
        rp.generalUserMenu(UserID, UserEmail);//메뉴 선택으로 돌아가기

    }

    public void ModifyPassword(String UserID, String UserEmail) throws IOException {
        int num = 0;
        num = this.findUserNum(UserID, UserEmail);

        if(num == 0){
            System.out.println("정보를 수정할 수 없습니다.");
            rp.generalUserMenu(UserID, UserEmail);
        }
        else{
            System.out.print("수정할 비밀번호를 입력해주세요: " + listformod.records.get(num).getPassword() + "->");
            modpassword = sc.nextLine();
            this.checkPassword(modpassword);
            listformod.records.get(num).setPassword(modpassword);
        }

    }//비밀번호 수정

    public void checkPassword(String CheckPW){

        if((CheckPW == null)||CheckPW.trim().length()==0){
            System.out.println("비밀번호를 제대로 입력하세요.");
            System.out.print("Password: ");
            modpassword = sc.nextLine();
            this.checkPassword(modpassword);
        }

    }//비밀번호 제대로 입력했는지 확인

    public void ModifyUserName(String UserID, String UserEmail) throws IOException {
        int num = 0;
        num = this.findUserNum(UserID, UserEmail);

        if(num == 0){
            System.out.println("정보를 수정할 수 없습니다.");
            rp.generalUserMenu(UserID, UserEmail);
        }
        else{
            System.out.print("수정할 이름를 입력해주세요: " + listformod.records.get(num).getUserName() + "->");
            modusername = sc.nextLine();
            this.checkUserName(modusername);
            listformod.records.get(num).setUserName(modusername);
        }
    }//이름 수정

    public void checkUserName(String CheckName){

        if((CheckName == null)||CheckName.trim().length()==0){
            System.out.println("이름 제대로 입력하세요.");
            System.out.print("Name: ");
            modusername = sc.nextLine();
            this.checkUserName(modusername);
        }


    }//이름 제대로 입력했는지 확인

    public void ModifyPhoneNumber(String UserID, String UserEmail) throws IOException {
        int num = 0;
        num = this.findUserNum(UserID, UserEmail);

        if(num == 0){
            System.out.println("정보를 수정할 수 없습니다.");
            rp.generalUserMenu(UserID, UserEmail);
        }
        else{
            System.out.print("수정할 핸드폰 번호를 입력해주세요: " + listformod.records.get(num).getPhoneNumber() + "->");
            modphonenumber = sc.nextLine();
            this.checkPhoneNumber(modphonenumber);
            listformod.records.get(num).setPhoneNumber(modphonenumber);
        }
    }//핸드폰 번호 수정

    public void checkPhoneNumber(String CheckPW){

        if(!(CheckPW.trim().length()==11)||!(CheckPW.startsWith("010"))){
            System.out.println("핸드폰 번호를 제대로 입력하세요.");
            System.out.print("PhoneNumber(형식 01012345678): ");
            modphonenumber = sc.nextLine();
            this.checkPhoneNumber(modphonenumber);
        }
        
    }//핸드폰 번호 제대로 입력했는지 확인

    public int findUserNum(String FindID, String FindEmail){

        for(int i = 0 ; i < listformod.records.size() ; i++){
            if(listformod.records.get(i).getID().equals(FindID)){
                if(listformod.records.get(i).getUserEmail().equals(FindEmail)){
                    return i;
                }
            }
        }
        return 0;
    }//유저 정보가 userlist 몇번에 속해있는지 찾기
}
