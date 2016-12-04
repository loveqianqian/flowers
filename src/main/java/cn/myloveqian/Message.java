package cn.myloveqian;

/**
 * cn.myloveqian
 *
 * @author zhiwei
 * @create 2016-12-03 19:01.
 */
public class Message<T> {

    /**
     * use this sign to help machine understand how to transfer message
     */
    private String sign;

    /**
     * the message
     */
    private T message;

    /**
     * whatever the type of message is ,you need to tell machine to know
     */
    private String messageType;

    public Message() {

    }

    public Message(String sign, T message, String messageType) {
        this.sign = sign;
        this.message = message;
        this.messageType = messageType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

}
