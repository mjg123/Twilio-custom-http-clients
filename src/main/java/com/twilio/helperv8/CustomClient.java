package com.twilio.helperv8;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;

import static com.twilio.helperv8.Secrets.*;

public class CustomClient {

    public static void main(String[] args) {

        TwilioRestClient cakeClient = new TwilioRestClient.Builder(
            Secrets.PROJECT_CAKE_ACCOUNT_SID,
            Secrets.PROJECT_CAKE_AUTH_TOKEN)
            .build();

        TwilioRestClient pieClient = new TwilioRestClient.Builder(
            Secrets.PROJECT_PIE_ACCOUNT_SID,
            Secrets.PROJECT_PIE_AUTH_TOKEN)
            .build();

        Message.creator(
            TO_PHONE_NUMBER,
            PROJECT_CAKE_PHONE_NUMBER,
            "Cake is best! 🎂")
            .create(cakeClient);

        Message.creator(
            TO_PHONE_NUMBER,
            PROJECT_PIE_PHONE_NUMBER,
            "No, Pie is better! 🥧")
            .create(pieClient);

    }

}
