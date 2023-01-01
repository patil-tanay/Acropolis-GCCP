package com.example.acropolisgccp.ui.dashboard;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.acropolisgccp.AdapterPack.NoticeAdapter;
import com.example.acropolisgccp.ModelPack.NoticeModel;
import com.example.acropolisgccp.databinding.FragmentDashboardBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    NoticeAdapter adapter;
    ProgressDialog progressDialog;
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait loading");
        progressDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        },2000);

        try {
            binding.noticeRV.setLayoutManager(new LinearLayoutManager(getContext()));
            getNotice();
        }catch (Exception e){
            Toast.makeText(getContext() , e.getMessage() , Toast.LENGTH_LONG).show();
        }

        return root;
    }

//     GET NOTICE FROM FIREBASE ! ! !
    private void getNotice() {
        FirebaseRecyclerOptions<NoticeModel> options =
                new FirebaseRecyclerOptions.Builder<NoticeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("NoticeNode"), NoticeModel.class)
                        .build();
        adapter = new NoticeAdapter(options);
        binding.noticeRV.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}