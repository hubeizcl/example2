package com.zcl.httpserver;

import com.sun.net.httpserver.*;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.*;
import java.security.cert.CertificateException;

public class MyHttpServer {
    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8888), 0);
            httpServer.createContext("/hujun", new MyHandler());
            httpServer.setExecutor(null);
            httpServer.start();

            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress(443), 0);
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(""), " ".toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("");

            keyManagerFactory.init(keyStore, "".toCharArray());
            SSLContext sslContext = SSLContext.getInstance("SSLv3");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
            HttpsConfigurator httpsConfigurator = new HttpsConfigurator(sslContext);
            httpsServer.setHttpsConfigurator(httpsConfigurator);
            httpsServer.setExecutor(null);
            httpsServer.createContext("/", new MyHandler());
            httpsServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

}

class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        InputStream requestBody = httpExchange.getRequestBody();
        String response = "<font color='#ff0000'>come on baby</font>";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream responseBody = httpExchange.getResponseBody();
        responseBody.write(response.getBytes());
        responseBody.close();
    }
}
