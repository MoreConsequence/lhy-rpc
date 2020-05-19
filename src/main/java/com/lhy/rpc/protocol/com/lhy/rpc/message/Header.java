package com.lhy.rpc.protocol.com.lhy.rpc.message;

/**
 * @author lhy
 **/
public interface Header extends Cloneable {

    default Integer getLength() {
        return null;
    }

    default void setLength(Integer length) {
    }

    default Short getHeaderLength() {
        return null;
    }

    default void setHeaderLength(Short headerLength) {
    }

    default int getMsgType() {
        return 0;
    }

    default void setMsgType(int type) {
    }

    default byte getSerialization() {
        return 0;
    }

    default void setSerialization(byte serialization) {
    }

    default int getMsgId() {
        return 0;
    }

    default void setMsgId(int msgId) {
    }

    Header clone();
}
