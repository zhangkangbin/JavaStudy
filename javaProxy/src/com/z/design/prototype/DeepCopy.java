package com.z.design.prototype;

/**
 * User: zhangkb
 * Date: 2019/5/13 0013
 * Time: 上午 10:47
 * 深度复制(deep copy)
 */
public class DeepCopy implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    private UserInfo userInfo;

    @Override
    protected Object clone() {

        try {
            //深拷贝
            DeepCopy deepCopy = (DeepCopy) super.clone();
            //再拷贝UserInfo 对象
            deepCopy.userInfo = (UserInfo) userInfo.clone();
            //个人理解深拷贝就是把对象都复制一遍。
            return deepCopy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;

    }
}
