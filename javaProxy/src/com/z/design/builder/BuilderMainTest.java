package com.z.design.builder;

/**
 *
 * 构建者模式
 * builder mode
 * 适用于数据接收和填充。
 * 构建者模式是一个非常实用而常见的创建类型的模式（creational design pattern)，
 * 例如图片处理框架Glide，网络请求框架Retrofit等都使用了此模式。
 */
public class BuilderMainTest {

    public static void main(String[] args) {

        ImageLoad imageLoad= new ImageLoad.Builder().setUrl("i am url").setHigh(88).load();
    }
}

class ImageLoad{

    private String mUrl;
    private int mHigh;
    public ImageLoad(String url){
        this.mUrl=url;
    }
    public ImageLoad(String url,int high){
        this.mUrl=url;
        this.mHigh = high;    }
    public static final class Builder{
        private String mUrl;
        private int mHigh;
        public Builder setUrl(String url){
            this.mUrl=url;
            return  this;
        }

        public Builder setHigh(int high) {
            this.mHigh = high;

            return this;
        }

        public ImageLoad load(){
            System.out.println("url:"+mUrl);

            return new ImageLoad(mUrl);
        }

    }

}