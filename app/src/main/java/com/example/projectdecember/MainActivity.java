package com.example.projectdecember;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.projectdecember.Fragment.GoogleMapFragment;
import com.example.projectdecember.Fragment.NetworkConnectionFragment;
import com.example.projectdecember.Fragment.UserListFragment;
import com.example.projectdecember.Store_All.StoreFragment;
import com.example.projectdecember.WebApiJson.EmployeeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    BottomNavigationView bottomNavigationView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // default fragment
        openFragment(new GoogleMapFragment());

    }

    @Override
    protected void onStart() {
        super.onStart();

        bottomNavigationView = findViewById(R.id.nav_view);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.googleMapMenu) {

                    openFragment(new GoogleMapFragment());
                    return true;
                }
                else if (menuItem.getItemId() == R.id.apiMenu) {
                    // open api fragment
                    openFragment(new NetworkConnectionFragment());
                    return true;
                }
                else if (menuItem.getItemId() == R.id.userListMenu) {



                    // open user list fragment
                    openFragment(new UserListFragment());
                    return true;
                }
                else if(menuItem.getItemId()==R.id.navigation_shop){
                         Fragment fragment=new StoreFragment();
                         openFragment(fragment);
                         return true;


                }
                else if(menuItem.getItemId()==R.id.employee){

                    Fragment fragment=new EmployeeFragment();
                    openFragment(fragment);
                    return true;
                }
                return false;
            }

        });


    }

    private void openFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(R.id.mainFrame, fragment);
        transaction.commit();
    }


}
