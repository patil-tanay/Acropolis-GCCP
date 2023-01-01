package com.example.acropolisgccp.AdapterPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acropolisgccp.ModelPack.DepartmentModel;
import com.example.acropolisgccp.R;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.departmentViewHolder> {

    Context departmentContext;
    List<DepartmentModel> modelList;

    public DepartmentAdapter(Context departmentContext, List<DepartmentModel> modelList) {
        this.departmentContext = departmentContext;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public departmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(departmentContext).inflate(R.layout.sample_departments, null, false);
        return new departmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull departmentViewHolder holder, int position) {
        DepartmentModel model = modelList.get(position);
        holder.imageView.setImageResource(model.getDepartmentImage());
        holder.name.setText(model.getDepartmentName());
        holder.desc.setText(model.getDepartmentDes());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class departmentViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView name, desc;

        public departmentViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.departmentCard);
            imageView = itemView.findViewById(R.id.departmentImage);
            name = itemView.findViewById(R.id.departmentName);
            desc = itemView.findViewById(R.id.departmentDec);
        }
    }
}
