package com.lhy.rpc.protocol.com.lhy.rpc.message;

public interface Message<H extends Header, T> {

    H getHeader();

    void setHeader(H header);

    T getPayLoad();

    void setPayLoad(T data);

    default int getMsgId() {
        H header = getHeader();
        return header == null ? -1 : header.getMsgId();
    }

    default int getMsgType() {
        H header = getHeader();
        return header == null ? -1 : header.getMsgType();
    }

    boolean isRequest();


}
