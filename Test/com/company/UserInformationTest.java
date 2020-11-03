package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInformationTest {

    UserInformation userinformation = new UserInformation();
    
    @Test
    void parsing() {
        String[] tokens = new String[6];
        tokens[0] = "test1";
        tokens[1] = "test2";
        tokens[2] = "test3";
        tokens[3] = "test4";
        tokens[4] = "test5";
        tokens[5] = "test6";
        userinformation.parsing(tokens);
        assertEquals(userinformation.getID(),"test1");
        assertEquals(userinformation.getPassword(),"test2");
        assertEquals(userinformation.getUserName(),"test3");
        assertEquals(userinformation.getPhoneNumber(),"test4");
        assertEquals(userinformation.getUserEmail(),"test5");
        assertEquals(userinformation.getUserState(),"test7");

    }

    @Test
    void getID() {
        userinformation.setID("test1");
        assertEquals(userinformation.getID(),"test1");
    }

    @Test
    void getUserState() {
        userinformation.setUserState();
        assertEquals(userinformation.getUserState(),"no");
    }

    @Test
    void testSetUserState() {
        userinformation.setUserState("test");
        assertEquals(userinformation.getUserState(),"yes");
    }
}