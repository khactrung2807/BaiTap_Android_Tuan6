package com.example.baitap_android_tuan6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterList extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Poular> listPoular;

    public AdapterList(Context context, int layout, ArrayList<Poular> listPoular) {
        this.context = context;
        this.layout = layout;
        this.listPoular = listPoular;
    }

    @Override
    public int getCount() {
        return listPoular.size();
    }

    @Override
    public Object getItem(int position) {
        return listPoular.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layout,null);

        ImageView imageView = convertView.findViewById(R.id.imagesB);
        TextView tvName = convertView.findViewById(R.id.tvNameB);
        TextView tvPrice = convertView.findViewById(R.id.tvPriceB);

        Poular p = listPoular.get(position);

        imageView.setImageResource(p.getImagesPoular());
        tvName.setText(p.getNamePoular());
        tvPrice.setText("$"+p.getPricePoular());

        return convertView;
    }
}
