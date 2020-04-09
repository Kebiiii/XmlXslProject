package com.apecircle.easytranslib.trans;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;

/**
 * Ceate By llb on 2019/7/25
 */
public class Browser {

    public Proxy proxy;
    public String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(String ip, Integer port) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port.intValue()));
    }

    public String executeGet()
            throws Exception {
        String result;
        if (this.proxy != null)
            result = HttpClientUtil.doGetWithProxy(this.url, this.proxy);
        else {
            result = HttpClientUtil.doGet(this.url);
        }

        return result;
    }

    public String executePost(Map<String,String> params)
            throws Exception {
        String result;
        if (this.proxy != null)
            result = HttpClientUtil.doPost(this.url, params, this.proxy);
        else {
            result = HttpClientUtil.doPost(this.url,params);
        }
        return result;
    }
}
