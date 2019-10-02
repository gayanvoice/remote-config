package com.remoteconfig.library;

public class RemoteError extends Exception {
    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    public RemoteError() {
        networkResponse = null;
    }

    public RemoteError(NetworkResponse response) {
        networkResponse = response;
    }

    public RemoteError(String exceptionMessage) {
        super(exceptionMessage);
        networkResponse = null;
    }

    public RemoteError(String exceptionMessage, Throwable reason) {
        super(exceptionMessage, reason);
        networkResponse = null;
    }

    public RemoteError(Throwable cause) {
        super(cause);
        networkResponse = null;
    }

    /* package */ void setNetworkTimeMs(long networkTimeMs) {
        this.networkTimeMs = networkTimeMs;
    }
}
