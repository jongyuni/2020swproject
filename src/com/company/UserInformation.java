package com.company;

public class UserInformation {

    private String ID;
    private String Password;
    private String UserName;
    private String PhoneNumber;
    private String UserEmail;
    private String UserState;


    public UserInformation(){}

    public UserInformation(String line){
        String[] tokens = line.split(":");
        this.parsing(tokens);
    }//UserList에서 유저 정보 받아오기

    public void parsing(String[] tokens){

        this.ID = tokens[0].trim();
        this.Password = tokens[1].trim();
        this.UserName = tokens[2].trim();
        this.PhoneNumber = tokens[3].trim();
        this.UserEmail = tokens[4].trim();
        this.UserState = tokens[5].trim();

    }//UserList에서 받아온 유저 정보 파트별로 나누기

    //사용자에 대한 정보 저장 및 return
    public String getID(){
        return ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getPassword(){
        return Password;
    }

    public void setPassword(String Password){
        this.Password = Password;
    }

    public String getUserName(){
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPhoneNumber(){
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getUserEmail(){
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        this.UserEmail = userEmail;
    }

    public String getUserState(){
        return UserState;
    }

    public void setUserState() {
        this.UserState = "yes";
    }

    public void setUserState(String state){
        this.UserState = state;
    }
}
