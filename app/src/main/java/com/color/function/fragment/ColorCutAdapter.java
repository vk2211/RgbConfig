package com.color.function.fragment;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.color.function.colorbean.ColorCutBitmap;
import com.jstelcom.colorshape.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;



public class ColorCutAdapter extends RecyclerArrayAdapter<ColorCutBitmap>{

	private Context mContext;

	public ColorCutAdapter(Context context) {
		super(context);
	}
	@Override
	public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {

		return new CutViewHolder(parent);
	}

	class CutViewHolder extends BaseViewHolder<ColorCutBitmap>{

		private ImageView mImagView;

		public CutViewHolder(ViewGroup itemView) {
			super(itemView,R.layout.item_cut);
			mImagView=$(R.id.listImage);
		}

		@Override
		public void setData(ColorCutBitmap data) {
			super.setData(data);
			mImagView.setImageBitmap(data.getmBitmap());
		}
	}


}
