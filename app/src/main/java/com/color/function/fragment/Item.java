package com.color.function.fragment;


public class Item {
    /**
     * 用来封装视图数据的对象,分别对应image,text;
     */
    public String mTv_ColorName,mTv_Rmin,mTv_Rmax,mTv_Gmin,mTv_Gmax,mTv_Bmin,mTv_Bmax;

    public Item(String tv_ColorName, String tv_Rmin, String tv_Rmax, String tv_Gmin, String tv_Gmax, String tv_Bmin, String tv_Bmax) {
        mTv_ColorName = tv_ColorName;
        mTv_Rmin = tv_Rmin;
        mTv_Rmax = tv_Rmax;
        mTv_Gmin = tv_Gmin;
        mTv_Gmax = tv_Gmax;
        mTv_Bmin = tv_Bmin;
        mTv_Bmax = tv_Bmax;
    }
}
