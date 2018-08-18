package com.example.mdmuktadir.sqlitecrud;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mdmuktadir.sqlitecrud.com.services.ContactDbHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment {

    private Button add_save_btn;
    private EditText contact_id_add,contact_name_add,contact_email_add;
    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_create, container, false);
        makeObj(view);
        add_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= Integer.parseInt(contact_id_add.getText().toString());
                String name=contact_name_add.getText().toString();
                String email=contact_email_add.getText().toString();

                insertContact(id,name,email);


            }
        });



        return view;
    }

    public void makeObj(View view){
        add_save_btn=(Button)view.findViewById(R.id.add_save_btn);
        contact_id_add=(EditText)view.findViewById(R.id.contact_id_add);
        contact_name_add=(EditText)view.findViewById(R.id.contact_name_add);
        contact_email_add=(EditText)view.findViewById(R.id.contact_email_add);

    }

    public void insertContact(int id, String name, String email){

        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase sqLiteDatabase=contactDbHelper.getWritableDatabase();

        contactDbHelper.createContact(id,name,email,sqLiteDatabase);
        Toast.makeText(getActivity(),"Inserted Successfully", Toast.LENGTH_SHORT).show();
        contactDbHelper.close();


    }

}
