package com.twilio.helperv8;

import com.twilio.http.HttpClient;
import com.twilio.http.NetworkHttpClient;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;

import static com.twilio.helperv8.Secrets.*;

public class RestClientProxy {

    // These are the defaults for tinyproxy: http://tinyproxy.github.io/
    // Configure these for your environment
    private static final String PROXY_HOST = "localhost";
    private static final int PROXY_PORT = 8888;

    public static void main(String[] args) {

        HttpClient proxiedHttpClient = createProxiedHttpClient(PROXY_HOST, PROXY_PORT);

        TwilioRestClient proxiedTwilioClient = new TwilioRestClient.Builder(
            PROJECT_CAKE_ACCOUNT_SID,
            PROJECT_CAKE_AUTH_TOKEN)
            .httpClient(proxiedHttpClient)
            .build();

        Message.creator(
            TO_PHONE_NUMBER,
            PROJECT_CAKE_PHONE_NUMBER,
            "Cake, or Pie?")
            .create(proxiedTwilioClient);
    }

    private static HttpClient createProxiedHttpClient(String proxyHost, int proxyPort) {

        // you can also configure things like caching, custom HTTPS certs,
        // timeouts and connection pool sizes here.
        // See: https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/HttpClientBuilder.html
        HttpClientBuilder apacheClientBuilder = HttpClientBuilder.create()
            .setProxy(new HttpHost(proxyHost, proxyPort));

        return new NetworkHttpClient(apacheClientBuilder);
    }

}
