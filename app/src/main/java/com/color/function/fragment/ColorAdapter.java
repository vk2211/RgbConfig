package com.color.function.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.jstelcom.colorshape.R;

import java.util.List;


public class ColorAdapter extends BaseAdapter {

    private List<Item> mList;
    private LayoutInflater layoutInflater;
    private Context mContext;
    public static boolean config_flag=false;
    public static int posn=100;/**. 0--红色,1--绿色,2--蓝色,3--黄色,4--品色,5--青色,6--黑色,7--白色 */




    public ColorAdapter( Context context) {
        mContext=context;
        layoutInflater = LayoutInflater.from(context);//context :要使用当前的Adapter的界面对象 layoutInflater: 布局装载器对象
    }

    public List<Item> getmList() {
        return mList;
    }

    public void setmList(List<Item> mList) {
        this.mList = mList;
    }

    /**
     * 以上是数据源与数据适配器进行关联
     *
     * @return
     */
    @Override
    public int getCount() {
        //返回ListView需要显示的数据量,也就是集合的长度

        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        //的到索引对应的数据项
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //返回指定索引对应的数据项
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //2.创建ViewHlder
        final ViewHolder viewHolder;
        //3.判断concerView是否为空
        if (convertView == null) {
            //实例化ViewHolder

            viewHolder = new ViewHolder();
            //View对象还没有被实例化过,缓存池中没有缓存,那么就创建一个convertView对象
            convertView = layoutInflater.inflate(R.layout.item_rgbconfig, null);
            //把findviewbyid找的的保存到 viewHolder 中
            viewHolder.mTv_ColorName = (TextView) convertView.findViewById(R.id.tv_colorName);

            viewHolder.mTv_Rmax = (TextView) convertView.findViewById(R.id.tv_r_max);
            viewHolder.mTv_Rmin = (TextView) convertView.findViewById(R.id.tv_r_min);

            viewHolder.mTv_Gmax = (TextView) convertView.findViewById(R.id.tv_g_max);
            viewHolder.mTv_Gmin = (TextView) convertView.findViewById(R.id.tv_g_min);

            viewHolder.mTv_Bmax = (TextView) convertView.findViewById(R.id.tv_b_max);
            viewHolder.mTv_Bmin = (TextView) convertView.findViewById(R.id.tv_b_min);

            viewHolder.bt_config=(Button)convertView.findViewById(R.id.bt_config);

            /**
			 * 设置监听器
             */
            viewHolder.bt_config.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    posn=position;

                    if(!config_flag){
                        viewHolder.bt_config.setText("配置中");
                        config_flag=true;

                    }

                    else {
                        viewHolder.bt_config.setText("配置");
                        config_flag=false;

                    }


                }
            });

            //通过setTag将 viewHolder 和 convertview 进行绑定
            convertView.setTag(viewHolder);

        } else {
            //可以直接通过 viewHolder 来找到对象所对应的控件
            viewHolder = (ViewHolder) convertView.getTag();

        }

        Item bean = mList.get(position);

        viewHolder.mTv_ColorName.setText(bean.mTv_ColorName);

        viewHolder.mTv_Rmax.setText(bean.mTv_Rmax);
        viewHolder.mTv_Rmin.setText(bean.mTv_Rmin);

        viewHolder.mTv_Gmax.setText(bean.mTv_Gmax);
        viewHolder.mTv_Gmin.setText(bean.mTv_Gmin);

        viewHolder.mTv_Bmax.setText(bean.mTv_Bmax);
        viewHolder.mTv_Bmin.setText(bean.mTv_Bmin);

        return convertView;

    }
    //1.创建内部类ViewHlder

    class ViewHolder {
        /**
         * 避免重复的findviewbyId
         */
        public TextView mTv_ColorName, mTv_Rmin, mTv_Rmax, mTv_Gmin, mTv_Gmax, mTv_Bmin, mTv_Bmax;
        public Button bt_config;
    }
}
