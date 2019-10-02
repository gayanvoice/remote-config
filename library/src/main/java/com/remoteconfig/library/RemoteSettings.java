package com.remoteconfig.library;

public class RemoteSettings {
    private int method;
    private String url;


    public void setMethod(int method) {
        this.method = method;
    }

    public int getMethod() {
        return method;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
