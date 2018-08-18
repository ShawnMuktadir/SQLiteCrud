package com.example.mdmuktadir.sqlitecrud;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.container)!=null){
            HomeFragment homeFragment=new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container,homeFragment,null).commit();


        }


    }

    @Override
    public void onDbPerform(int method) {
        switch (method){
            case 0:
                CreateFragment createFragment=new CreateFragment();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,createFragment,null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

//              getSupportFragmentManager().beginTransaction().replace(R.id.container,createFragment,null).commit();
            case 1:
                ViewFragment viewFragment=new ViewFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,viewFragment,null).addToBackStack(null).commit();
                break;

            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new DeleteFragment(),null).addToBackStack(null).commit();
                break;

            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new UpdateFragment(),null).addToBackStack(null).commit();
                break;
        }

    }
}