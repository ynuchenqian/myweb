package com.travelsky.pssguimonitor.util;

import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;

/**
 * HttpClientUtil.java
 *
 * @author chenqian
 * @date 2017/4/12
 */

public class HttpClientUtil {

    public static void enableSSL(DefaultHttpClient httpclient) {

        // 调用ssl

        try {

            SSLContext sslcontext = SSLContext.getInstance("TLS");


            sslcontext.init(null, new TrustManager[]{truseAllManager}, null);

            @SuppressWarnings("deprecation")

            SSLSocketFactory sf = new SSLSocketFactory(sslcontext);

            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            Scheme https = new Scheme("https", sf, 443);

            httpclient.getConnectionManager().getSchemeRegistry()

                    .register(https);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    /**
     * 重写验证方法，取消检测ssl
     */
    private static TrustManager truseAllManager = new X509TrustManager(){

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] arg0, String arg1)
                throws CertificateException {
            // TODO Auto-generated method stub

        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] arg0, String arg1)
                throws CertificateException {
            // TODO Auto-generated method stub

        }

        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }

    };
}


