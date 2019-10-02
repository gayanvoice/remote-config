package com.remoteconfig.library;

public class RemoteSettings {
    public int GET = 0;
    public int POST = 1;

    private int method;
    private String url;

    public RemoteSettings (int method, String url){
        this.method = method;
        this.url = url;
    }

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
