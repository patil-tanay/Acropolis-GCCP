package com.example.acropolisgccp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.acropolisgccp.AdapterPack.CommunityAdapter;
import com.example.acropolisgccp.AdapterPack.DepartmentAdapter;
import com.example.acropolisgccp.ModelPack.CommunityModel;
import com.example.acropolisgccp.ModelPack.DepartmentModel;
import com.example.acropolisgccp.R;
import com.example.acropolisgccp.databinding.FragmentHomeBinding;

import java.util.Arrays;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CommunityModel[] models = new CommunityModel[]{
                new CommunityModel(R.drawable.gdsc_png , "GDSC-AITR"),
                new CommunityModel(R.drawable.salesforcelogo , "Salesforce"),
                new CommunityModel(R.drawable.acmlogo , "AITR ACM"),
                new CommunityModel(R.drawable.cdc_logo , "CDC"),
                new CommunityModel(R.drawable.rotaract_logo , "Rotaract AITR"),
                new CommunityModel(R.drawable.gfglogo , "GFG AITR")
        };

        CommunityAdapter adapter = new CommunityAdapter(getContext() , Arrays.asList(models));
        binding.communityRV.setHasFixedSize(true);
        binding.communityRV.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        binding.communityRV.setAdapter(adapter);

        DepartmentModel[] model2 = new DepartmentModel[]{
                new DepartmentModel(R.drawable.acro_eng , "Acropolis Institute of Technology and Research" , "BTech, MTech, Diploma, MCA, MBA" ),
                new DepartmentModel(R.drawable.acro_managment , "Acropolis Institute of Management Studies & Research" , "BCA, BBA, BCom, BSc, BA, MCom, MSc"),
                new DepartmentModel(R.drawable.acro_pharma , "Acropolis Institute of Pharmaceutical Education & Research" , "D Pharm , B Pharm and M Pharm"),
                new DepartmentModel(R.drawable.acro_mba , "Acropolis Faculty of Managment and Research" , "MBA")
        };

        DepartmentAdapter adapter1 = new DepartmentAdapter(getContext() , Arrays.asList(model2));
        binding.departmentRV.setHasFixedSize(true);
        binding.departmentRV.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.departmentRV.setAdapter(adapter1);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}