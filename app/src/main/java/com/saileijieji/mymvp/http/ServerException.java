
package com.saileijieji.mymvp.http;

/**
 * Created by lqy on 2016/4/18.
 */
public class ServerException extends RuntimeException {
    private int code ;
    public ServerException(String detailMessage) {
        super(detailMessage);
    }
    public ServerException(int code, String detailMessage){
        super(detailMessage);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
