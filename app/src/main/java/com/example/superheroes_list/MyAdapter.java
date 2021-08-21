package com.example.superheroes_list;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<itemlist> itemlists;
    private Context context;
    private OnRecyclerviewClickListener listener;

    public interface OnRecyclerviewClickListener{
        void OnItemClick(int position,ImageView imageView);
    }
    public void setOnRecyclerViewClickListener(OnRecyclerviewClickListener listener){
        this.listener = listener;
    }

    public MyAdapter(List<itemlist> itemlists,Context context) {
        this.itemlists=itemlists;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        itemlist itemlist = itemlists.get(position);

        holder.name.setText(itemlist.getName());
        Picasso.with(context)
                .load(itemlist.getImageurl())
                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return itemlists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.superheroname);
            imageView = (ImageView) itemView.findViewById(R.id.imageurl);
            linearLayout=itemView.findViewById(R.id.linearlayout);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.OnItemClick(position,imageView);
                        }

                    }
                }
            });


        }
    }
}
