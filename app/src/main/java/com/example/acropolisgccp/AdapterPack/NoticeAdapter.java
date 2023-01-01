package com.example.acropolisgccp.AdapterPack;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.acropolisgccp.ModelPack.NoticeModel;
import com.example.acropolisgccp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class NoticeAdapter extends FirebaseRecyclerAdapter<NoticeModel, NoticeAdapter.noticeViewHolder> {


    public NoticeAdapter(@NonNull FirebaseRecyclerOptions<NoticeModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull noticeViewHolder holder, int position, @NonNull NoticeModel model) {

        holder.txtNoticeDate.setText(model.getDate());
        holder.txtNotice.setText(model.getNotice());
        Glide.with(holder.imgNotice.getContext()).load(model.getImage()).into(holder.imgNotice);

    }

    @NonNull
    @Override
    public noticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View views = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_notice, parent, false);
        return new noticeViewHolder(views);
    }

    public class noticeViewHolder extends RecyclerView.ViewHolder {
        TextView txtNoticeDate , txtNotice ;
        ImageView imgNotice ;
        CardView imageCardView;
        public noticeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNoticeDate = itemView.findViewById(R.id.txtNoticeDate);
            txtNotice = itemView.findViewById(R.id.txtNotice);
            imgNotice = itemView.findViewById(R.id.imgNotice);
            imageCardView = itemView.findViewById(R.id.imageCardView);
        }
    }

}
