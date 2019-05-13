package com.z.design.prototype;

/**
 * User: zhangkb
 * Date: 2019/5/13 0013
 * Time: 上午 10:56
 */
public class UserInfo  implements Cloneable {
    public UserInfo(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
