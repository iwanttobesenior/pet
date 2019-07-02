package training.patterns.proxy.remote;

import java.io.Serializable;

class Wrapper implements Serializable {

    String msg;

    public Wrapper(String msg) {
        this.msg = "i am a wrapper " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
