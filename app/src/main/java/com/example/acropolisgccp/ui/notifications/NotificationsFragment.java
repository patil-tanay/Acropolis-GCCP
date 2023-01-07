package com.example.acropolisgccp.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.acropolisgccp.SplashScreen;
import com.example.acropolisgccp.databinding.FragmentNotificationsBinding;
//import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String user = "0827IT211020";
    GoogleSignInAccount account;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        account = GoogleSignIn.getLastSignedInAccount(getContext());
//        binding.txtStudentName.setText(account.getDisplayName());
//        binding.txtEmail.setText(account.getEmail());
//        Glide.with(getContext()).load(account.getPhotoUrl()).into(binding.imgStudent);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Students");

        getDatas();

        // LOGOUT BUTTON ! ! !
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), SplashScreen.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return root;
    }

    // FETCHING DATA FROM FIREBASE ! ! !
    private void getDatas() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String studentName = snapshot.child(user).child("studentName").getValue(String.class);
                String studentEmail = snapshot.child(user).child("studentEmail").getValue(String.class);
                String studentEnrollNo = snapshot.child(user).child("studentEnroll").getValue(String.class);
                String studentDepartment = snapshot.child(user).child("department").getValue(String.class);

                binding.txtStudentName.setText(studentName);
                binding.txtEnrollNo.setText(studentEnrollNo);
                binding.txtEmail.setText(studentEmail);
                binding.txtDepartment.setText(studentDepartment);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}