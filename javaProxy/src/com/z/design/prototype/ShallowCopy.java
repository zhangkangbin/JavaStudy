package com.z.design.prototype;

/**
 * 浅复制(Shallow Copy)
 * 如果属性是内存地址（引用类型），拷贝的就是内存地址（即复制引用但不复制引用的对象） ，
 * 因此如果其中一个对象改变了这个地址，就会影响到另一个对象。
 * User: zhangkb
 * Date: 2019/5/13 0013
 * Time: 上午 10:45
 */
public class ShallowCopy  implements Cloneable{

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    private UserInfo userInfo;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone()   {
        try {
            // 此处使用的是浅拷贝
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return  null;
        }
    }



}
