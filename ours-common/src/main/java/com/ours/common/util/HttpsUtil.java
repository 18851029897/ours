package com.ours.common.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by fish on 2018/7/26.
 */
public class HttpsUtil {

    /**
     * 发送post请求
     *
     * @param url
     * @return
     */
    public static String post(String url) {
        //增加下面两行代码
        Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
        Protocol.registerProtocol("https", myhttps);

        HttpClient client = new HttpClient();
        HttpMethod post = new PostMethod(url);
        try {
            client.executeMethod(post);
            byte[] responseBody = post.getResponseBody();
            String result = new String(responseBody, "UTF-8");
            return result;
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
        }
        return null;
    }


    /**
     * 发送get请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
        Protocol.registerProtocol("https", myhttps);

        HttpClient client = new HttpClient();
        HttpMethod get = new GetMethod(url);
        try {
            client.executeMethod(get);
            byte[] responseBody = get.getResponseBody();
            String result = new String(responseBody, "UTF-8");
            return result;
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            get.releaseConnection();
        }
        return null;
    }

}
