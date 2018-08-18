package com.example.mdmuktadir.sqlitecrud;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    Button add_contact_btn, update_contact_btn, delete_contact_btn, view_contact_btn;
    OnDbOpListener onDbOpListener;

    public interface OnDbOpListener{
        public void onDbPerform(int method);
    }


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        makeObj(view);

        add_contact_btn.setOnClickListener(this);
        update_contact_btn.setOnClickListener(this);
        delete_contact_btn.setOnClickListener(this);
        view_contact_btn.setOnClickListener(this);

        return view;
    }

    private void makeObj(View view) {
        add_contact_btn = (Button) view.findViewById(R.id.add_contact_btn);
        update_contact_btn = (Button) view.findViewById(R.id.update_contact_btn);
        delete_contact_btn = (Button) view.findViewById(R.id.delete_contact_btn);
        view_contact_btn = (Button) view.findViewById(R.id.view_contact_btn);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity= (Activity) context;
        try{
            onDbOpListener= (OnDbOpListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must be implemented!!!");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_contact_btn:
                onDbOpListener.onDbPerform(0);
                break;
            case R.id.view_contact_btn:
                onDbOpListener.onDbPerform(1);
                break;

            case R.id.delete_contact_btn:
                onDbOpListener.onDbPerform(2);
                break;

            case R.id.update_contact_btn:
                onDbOpListener.onDbPerform(3);
                break;

        }
    }
}