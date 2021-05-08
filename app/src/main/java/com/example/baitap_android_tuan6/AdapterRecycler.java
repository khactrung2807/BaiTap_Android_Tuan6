package com.example.baitap_android_tuan6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.PoularViewHolder> {
    private ArrayList<Poular> mArrayList;
    private onClickListener mClickListener;

    public AdapterRecycler(ArrayList<Poular> mArrayList) {
        this.mArrayList = mArrayList;
    }

    public interface onClickListener {
        void onItemClick(int position);
    }

    public void setOnClick(onClickListener listener){
        this.mClickListener = listener;
    }

    @NonNull
    @Override
    public PoularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        PoularViewHolder pvh = new PoularViewHolder(v,mClickListener);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PoularViewHolder holder, int position) {
        Poular p = mArrayList.get(position);

        holder.imageView.setImageResource(p.getImagesPoular());
        holder.tvPrice.setText("$"+p.getPricePoular());
        holder.tvName.setText(p.getNamePoular());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class PoularViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvName;
        private TextView tvPrice;

        public PoularViewHolder(@NonNull View itemView,onClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagesA);
            tvPrice = itemView.findViewById(R.id.tvPriceA);
            tvName = itemView.findViewById(R.id.tvNameA);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mClickListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
