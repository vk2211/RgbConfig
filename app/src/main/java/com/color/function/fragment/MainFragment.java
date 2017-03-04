package com.color.function.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.color.function.colorbean.BaseColor;
import com.jstelcom.colorshape.R;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {

	private TouchImageView mConfigImageView;
	private TextView mRgbText;
	private Bitmap bitmap;
	private ColorSettingAdapter mColorSettingAdapter;
	private EasyRecyclerView mColorSettingList;
	private Bitmap mShotBitmap;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_main, container, false);
		mConfigImageView = (TouchImageView) view.findViewById(R.id.configImage);
		mColorSettingList = (EasyRecyclerView) view.findViewById(R.id.colorSettingList);
		mRgbText = (TextView) view.findViewById(R.id.rgbText);

		//拿到原始图像的长宽
//		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic1);
//		mConfigImageView.setImageBitmap(bitmap);

		mConfigImageView.setOnTouchListener(onTouchListener);
		LinearLayoutManager m = new LinearLayoutManager(getActivity());
		m.setOrientation(LinearLayoutManager.VERTICAL);
		mColorSettingList.setLayoutManager(m);
		mColorSettingAdapter = new ColorSettingAdapter(getActivity());
		mColorSettingAdapter.setOnSettingColorListener(new ColorSettingAdapter.OnSettingColorListener() {
			@Override
			public void onSettingColor(boolean isSetting) {
				mConfigImageView.enableDrag(!isSetting);
			}
		});
		mColorSettingAdapter.addAll(initListdata());
		mColorSettingList.setAdapter(mColorSettingAdapter);

		return view;

	}

	/**
	 * 触屏获取RGB的值
	 */
	private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View view, MotionEvent event) {

			// TODO Auto-generated method stub
			int x = (int) event.getX();
			int y = (int) event.getY();
			int pixel;

			if (mShotBitmap != null) {
				mShotBitmap.recycle();
				mShotBitmap = null;
			}
			mShotBitmap = shot(mConfigImageView);
			if (x <= mShotBitmap.getWidth() && y <= mShotBitmap.getHeight()) {
				pixel = mShotBitmap.getPixel(x, y);
				int r = (pixel & 0xff0000) >> 16;
				int g = (pixel & 0xff00) >> 8;
				int b = (pixel & 0xff);
				mRgbText.setText("R:" + r + ",G:" + g + ",B:" + b);
				int pos = mColorSettingAdapter.getCurrentPos();
				if (pos > -1) {
					BaseColor color = mColorSettingAdapter.getItem(pos);
					color.update(r, g, b);
					mColorSettingAdapter.update(color, pos);
					mColorSettingAdapter.notifyItemChanged(pos);
				}
			}
			return false;
		}
	};


	/**
	 * 初始化ListView 的数据
	 *
	 * @return
	 */
	public List<BaseColor> initListdata() {

		List<BaseColor> list = new ArrayList<BaseColor>();
		String[] data = {"红色", "绿色", "蓝色", "黄色", "品色", "青色", "黑色", "白色", "底色"};
		for (int i = 0; i < data.length; i++) {

			BaseColor baseColor = new BaseColor(getContext(), data[i]);
			list.add(baseColor);
		}
		return list;
	}

	private Bitmap shot(Activity activity) {
		View view = activity.getWindow().getDecorView();
		view.buildDrawingCache();
		view.setDrawingCacheEnabled(true);
		int x = (int) view.getX();
		int y = (int) view.getY();
		int w = view.getWidth();
		int h = view.getHeight();
		Bitmap bmp = Bitmap.createBitmap(view.getDrawingCache(), x, y, w, h);
		view.destroyDrawingCache();
		return bmp;
	}

	private Bitmap shot(View view) {
		view.buildDrawingCache();
		view.setDrawingCacheEnabled(true);
		int x = (int) view.getX();
		int y = (int) view.getY();
		int w = view.getWidth();
		int h = view.getHeight();
		Bitmap bmp = Bitmap.createBitmap(view.getDrawingCache(), x, y, w, h);
		view.destroyDrawingCache();
		return bmp;
	}
}
