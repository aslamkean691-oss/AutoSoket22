package com.example.cars;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import fragments.MenuFragment;
import fragments.ProfaileFragment;
import fragments.SettingFragment;

public class StartActivity2 extends AppCompatActivity {


    BottomNavigationView bth;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start2);

        ChangeFargment(new MenuFragment());

        bth=findViewById(R.id.bth);


        bth.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                if(menuItem.getItemId()==R.id.btmenu1)
                {
                    ChangeFargment(new SettingFragment());
                }


                if(menuItem.getItemId()==R.id.btmenu2)
                {
                    ChangeFargment(new MenuFragment());
                }


                if(menuItem.getItemId()==R.id.btmenu3)
                {
                    ChangeFargment(new ProfaileFragment());
                }

                return true;
            }
        });


    }

    private void ChangeFargment(Fragment menuFragment) {
        FragmentManager frm =getSupportFragmentManager();
        FragmentTransaction ftm =frm.beginTransaction();
        ftm.replace(R.id.btflag,menuFragment);
        ftm.commit();
    }


}