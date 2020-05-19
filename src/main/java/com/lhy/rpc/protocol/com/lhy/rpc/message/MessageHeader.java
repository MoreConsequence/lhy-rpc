package com.lhy.rpc.protocol.com.lhy.rpc.message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lhy
 **/
public class MessageHeader implements Header {

    /**
     * 总长度 length of (header+body), not include MEGICCODE
     */
    protected Integer length;
    /**
     * 消息头长度 length of (PROTOCOLTYPE+...+header tail), not include FULLLENGTH and HEADERLENGTH
     */
    protected Short headerLength;
    /**
     * 协议类别
     */
    protected byte protocolType;
    /**
     * 消息类别
     */
    protected byte msgType;
    /**
     * 序列化类别
     */
    protected byte serialization;
    /**
     * 消息标识ID
     */
    protected int msgId;
    /**
     * 扩展属性
     */
    protected Map<Byte, Object> attributes;

    public MessageHeader() {
    }

    public MessageHeader(byte msgType) {
        this.msgType = msgType;
    }

    public MessageHeader(byte msgType, int msgId) {
        this.msgType = msgType;
        this.msgId = msgId;
    }

    public MessageHeader(byte msgType, byte serialization) {
        this.msgType = msgType;
        this.serialization = serialization;
    }

    public MessageHeader(byte protocolType, byte msgType, byte serialization) {
        this.protocolType = protocolType;
        this.msgType = msgType;
        this.serialization = serialization;
    }

    @Override
    public Integer getLength() {
        return length;
    }

    @Override
    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public Short getHeaderLength() {
        return headerLength;
    }

    @Override
    public void setHeaderLength(Short headerLength) {
        this.headerLength = headerLength;
    }

    @Override
    public int getMsgType() {
        return msgType;
    }

    @Override
    public void setMsgType(int type) {
        this.msgType = msgType;
    }

    @Override
    public byte getSerialization() {
        return serialization;
    }

    @Override
    public void setSerialization(byte serialization) {
        this.serialization = serialization;
    }

    @Override
    public int getMsgId() {
        return msgId;
    }

    @Override
    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public Map<Byte, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<Byte, Object> attributes) {
        this.attributes = attributes;
    }

    /**
     * 获取或创建扩展属性
     *
     * @return
     */
    protected Map<Byte, Object> getOrCreateAttributes() {
        if (attributes == null) {
            //TODO 是否是单线程操作
            synchronized (this) {
                if (attributes == null) {
                    attributes = new ConcurrentHashMap<>(5);
                }
            }
        }
        return attributes;
    }

    @Override
    public String toString() {
        return "MessageHeader{" +
                "length=" + length +
                ", headerLength=" + headerLength +
                ", protocolType=" + protocolType +
                ", msgType=" + msgType +
                ", serialization=" + serialization +
                ", msgId=" + msgId +
                ", attributes=" + attributes +
                '}';
    }

    @Override
    public Header clone() {
        MessageHeader result = new MessageHeader();
        result.msgId = msgId;
        result.serialization = serialization;
        result.msgType = msgType;
        result.protocolType = protocolType;
        result.length = length;
        result.headerLength = headerLength;
        result.attributes = attributes;
        return result;
    }
}
