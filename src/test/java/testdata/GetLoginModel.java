package testdata;

import models.LoginModel;

public class GetLoginModel {
    public static LoginModel getLoginFirst(){
        LoginModel loginModel = LoginModel
                .builder()
                .login("standard_user")
                .password("secret_sauce")
                .build();
        return loginModel;
    }
    public static LoginModel getLoginSecond(){
        LoginModel loginModel = LoginModel
                .builder()
                .login("locked_out_user")
                .password("secret_sauce")
                .build();
        return loginModel;
    }
    public static LoginModel getLoginThird(){
        LoginModel loginModel = LoginModel
                .builder()
                .login("problem_user")
                .password("secret_sauce")
                .build();
        return loginModel;
    }
    public static LoginModel getLoginFourth(){
        LoginModel loginModel = LoginModel
                .builder()
                .login("performance_glitch_user")
                .password("secret_sauce")
                .build();
        return loginModel;
    }
}
