package com.color.function.colorbean;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.color.function.fragment.Coordinates;

import java.util.ArrayList;

/**
 * Created by epai on 17/3/3.
 */

public class BaseColor {

	protected ArrayList<Coordinates> listl;//左边点集合
	protected ArrayList<Coordinates> listr;//右边点集合

	protected int mRmax = 0;
	protected int mRmin = 255;
	protected int mGmax = 0;
	protected int mGmin = 255;
	protected int mBmax = 0;
	protected int mBmin = 255;   //RGB的值范围
	protected SharedPreferences mSharedPreferences;
	protected SharedPreferences.Editor editor;
	protected Context mContext;
	private String mColor;


	public BaseColor(Context context) {
		listl = new ArrayList<Coordinates>();
		listr = new ArrayList<Coordinates>();
		mContext = context;
		mSharedPreferences = context.getSharedPreferences("RGBconfig", Activity.MODE_PRIVATE);
		//实例化SharedPreferences.Editor对象
		editor = mSharedPreferences.edit();
	}


	public BaseColor(Context context, String color) {
		mColor = color;
		mContext = context;
		listl = new ArrayList<Coordinates>();
		listr = new ArrayList<Coordinates>();
		mSharedPreferences = context.getSharedPreferences("RGBconfig", Activity.MODE_PRIVATE);
		//实例化SharedPreferences.Editor对象
		editor = mSharedPreferences.edit();
	}

	public String getmColor() {
		return mColor;
	}

	public void setmColor(String mColor) {
		this.mColor = mColor;
	}

	public SharedPreferences getmSharedPreferences() {
		return mSharedPreferences;
	}

	public SharedPreferences.Editor getEditor() {
		return editor;
	}

	public ArrayList<Coordinates> getListl() {
		return listl;
	}

	public void setListl(ArrayList<Coordinates> listl) {
		this.listl = listl;
	}

	public ArrayList<Coordinates> getListr() {
		return listr;
	}

	public void setListr(ArrayList<Coordinates> listr) {
		this.listr = listr;
	}

	public int getmRmax() {
		return mRmax;
	}

	public void setmRmax(int mRmax) {
		this.mRmax = mRmax;
	}

	public int getmRmin() {
		return mRmin;
	}

	public void setmRmin(int mRmin) {
		this.mRmin = mRmin;
	}

	public int getmGmax() {
		return mGmax;
	}

	public void setmGmax(int mGmax) {
		this.mGmax = mGmax;
	}

	public int getmGmin() {
		return mGmin;
	}

	public void setmGmin(int mGmin) {
		this.mGmin = mGmin;
	}

	public int getmBmax() {
		return mBmax;
	}

	public void setmBmax(int mBmax) {
		this.mBmax = mBmax;
	}

	public int getmBmin() {
		return mBmin;
	}

	public void setmBmin(int mBmin) {
		this.mBmin = mBmin;
	}


	public int getSharePreference_Rmax(int colornum) {

		return getmSharedPreferences().getInt(StringColor.getRmax(colornum), -1);

	}

	public int getSharePreference_Rin(int colornum) {

		return getmSharedPreferences().getInt(StringColor.getRmin(colornum), -1);

	}

	public int getSharePreference_Gmax(int colornum) {

		return getmSharedPreferences().getInt(StringColor.getGmax(colornum), -1);

	}

	public int getSharePreference_Gmin(int colornum) {

		return getmSharedPreferences().getInt(StringColor.getGmin(colornum), -1);

	}

	public int getSharePreference_Bmax(int colornum) {

		return getmSharedPreferences().getInt(StringColor.getBmax(colornum), -1);

	}

	public int getSharePreference_Bmin(int colornum) {

		return getmSharedPreferences().getInt(StringColor.getBmin(colornum), -1);

	}

	public void update(int r, int g, int b) {
		if (r > mRmax) {
			mRmax = r;
		} else if (r < mRmin) {
			mRmin = r;
		}
		if (g > mGmax) {
			mGmax = g;
		} else if (g < mGmin) {
			mGmin = g;
		}
		if (b > mBmax) {
			mBmax = b;
		} else if (b < mBmin) {
			mBmin = b;
		}
	}

	public void reset() {
		mRmax = 0;
		mRmin = 255;
		mGmax = 0;
		mGmin = 255;
		mBmax = 0;
		mBmin = 255;
	}
}
