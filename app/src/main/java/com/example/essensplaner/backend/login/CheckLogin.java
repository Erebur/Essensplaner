package com.example.essensplaner.backend.login;

import com.example.essensplaner.data.Result;
import com.example.essensplaner.data.model.LoggedInUser;

import java.io.IOException;
import java.util.Locale;

public class CheckLogin {

    public static void check(LoggedInUser fakeUser, String password) throws Exception {
        //TODO: implement login with DB
        if (fakeUser.getDisplayName().toLowerCase(Locale.ROOT).equals("admin") && password.hashCode() == "42069".hashCode()  ){
            return ;
        }
         throw new Exception("Passwords does not match to user");
    }
}
