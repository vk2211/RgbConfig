package com.color.function.colorbean;

import android.content.Context;
import android.content.SharedPreferences;

import com.color.function.fragment.ColorAdapter;

/**
 * Created by epai on 17/3/3.
 */

public class Charge_Color {


	private Context mContext;
	private BaseColor mBase_Color;

	private int Rmax=0,Gmax=0,Bmax=0,Rmin=255,Gmin=255,Bmin=255;

	public Charge_Color(Context context){
		mContext=context;
		mBase_Color=new BaseColor(context);

	}

	public BaseColor getmBase_Color() {
		return mBase_Color;
	}

	/**
	 * 初始化
	 */
	public boolean init_Color(int num){


		boolean init_state=false;

		mBase_Color.setmRmax(mBase_Color.getmSharedPreferences().getInt(StringColor.getRmax(num),-1));
		mBase_Color.setmRmin(mBase_Color.getmSharedPreferences().getInt(StringColor.getRmin(num),-1));

		mBase_Color.setmGmax(mBase_Color.getmSharedPreferences().getInt(StringColor.getGmax(num),-1));
		mBase_Color.setmGmin(mBase_Color.getmSharedPreferences().getInt(StringColor.getGmin(num),-1));

		mBase_Color.setmBmax(mBase_Color.getmSharedPreferences().getInt(StringColor.getBmax(num),-1));
		mBase_Color.setmBmin(mBase_Color.getmSharedPreferences().getInt(StringColor.getBmin(num),-1));

		if(mBase_Color.getmSharedPreferences().getInt(StringColor.getRmax(num),-1)==-1){
			init_state=false;
		}
		else {
			init_state=true;
		}

		return init_state;
	}


	public void putRGB(int r,int g,int b,int colornum){

		if (r > Rmax) {
			Rmax = r;
			mBase_Color.getEditor().putInt(StringColor.getRmax(colornum),Rmax);

		}
		else if (r < Rmin)
		{
			Rmin = r;
			mBase_Color.getEditor().putInt(StringColor.getRmin(colornum),Rmin);
		}
		if (g > Gmax) {
			Gmax = g;
			mBase_Color.getEditor().putInt(StringColor.getGmax(colornum),Gmax);

		}
		else if (g < Gmin)
		{
			Gmin = g;
			mBase_Color.getEditor().putInt(StringColor.getGmin(colornum),Gmin);
		}
		if (b > Bmax) {
			Bmax = b;
			mBase_Color.getEditor().putInt(StringColor.getBmax(colornum),Bmax);

		}
		else if (b < Bmin)
		{
			Bmin = b;
			mBase_Color.getEditor().putInt(StringColor.getBmin(colornum),Bmin);
		}

		mBase_Color.getEditor().apply();   //提交数据


	}


	public boolean isNullsharepreference(String key){

		if(mBase_Color.getmSharedPreferences().getInt(key,-1)==-1){
			return false;

		}
		else {
			return true;
		}

	}


	/**
	 *   判断颜色
	 * @param r
	 * @param g
	 * @param b
	 * @return
	 */

	public boolean isIdentyColor(int r,int g,int b){

		if((mBase_Color.getmRmax()>=r&&r>=mBase_Color.getmRmin())&&(mBase_Color.getmGmax()>=g&&g>=mBase_Color.getmGmin())&&(mBase_Color.getmBmax()>=b&&b>=mBase_Color.getmBmin())){
			return true;
		}
		else {
			return false;
		}

	}
}
