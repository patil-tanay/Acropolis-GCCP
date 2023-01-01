package com.example.acropolisgccp.AdapterPack;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acropolisgccp.ModelPack.CommunityModel;
import com.example.acropolisgccp.R;

import java.util.List;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.viewHolder>{

    Context context;
    List<CommunityModel> list;

    public CommunityAdapter(Context context, List<CommunityModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_community , null , false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CommunityModel model = list.get(position);
        holder.image.setImageResource(model.getCommunityImage());
        holder.textView.setText(model.getCommunityName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgCommunity);
            textView = itemView.findViewById(R.id.txtName);
        }
    }
}
