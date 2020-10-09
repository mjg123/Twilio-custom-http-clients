package com.twilio.helperv8;

import com.twilio.type.PhoneNumber;

public class Secrets {

    public static final String PROJECT_CAKE_ACCOUNT_SID = System.getenv("PROJECT_CAKE_ACCOUNT_SID");
    public static final String PROJECT_CAKE_AUTH_TOKEN = System.getenv("PROJECT_CAKE_AUTH_TOKEN");
    public static final PhoneNumber PROJECT_CAKE_PHONE_NUMBER = new PhoneNumber(System.getenv("PROJECT_CAKE_PHONE_NUMBER"));

    public static final String PROJECT_PIE_ACCOUNT_SID = System.getenv("PROJECT_PIE_ACCOUNT_SID");
    public static final String PROJECT_PIE_AUTH_TOKEN = System.getenv("PROJECT_PIE_AUTH_TOKEN");
    public static final PhoneNumber PROJECT_PIE_PHONE_NUMBER = new PhoneNumber(System.getenv("PROJECT_PIE_PHONE_NUMBER"));

    public static final PhoneNumber TO_PHONE_NUMBER = new PhoneNumber(System.getenv("MY_REAL_PHONE_NUMBER"));

}
