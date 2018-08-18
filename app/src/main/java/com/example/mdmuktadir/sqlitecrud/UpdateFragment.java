package com.example.mdmuktadir.sqlitecrud;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class UpdateFragment extends Fragment {
    private Button update_save_btn;
    private EditText contact_id_edit,contact_name_edit,contact_email_edit;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
        makeObj(view);

        update_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(contact_id_edit.getText().toString());
                String name = contact_name_edit.getText().toString();
                String email = contact_email_edit.getText().toString();

                updateDbContact(id,name,email);



            }
        });


        return view;
    }

    private void makeObj(View view){
        update_save_btn=(Button)view.findViewById(R.id.update_save_btn);
        contact_id_edit=(EditText)view.findViewById(R.id.contact_id_edit);
        contact_name_edit=(EditText)view.findViewById(R.id.contact_name_edit);
        contact_email_edit=(EditText)view.findViewById(R.id.contact_email_edit);

    }
    private void updateDbContact(int id,String name,String email){
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase sqLiteDatabase = contactDbHelper.getWritableDatabase();

        Log.d("Database Operation","Update Test1 successfully::::::::::::::::");
        contactDbHelper.updateContact(id,name, email,sqLiteDatabase);
        Log.d("Database Operation","Update Test2 successfully::::::::::::::::");
        sqLiteDatabase.close();
        Toast.makeText(getActivity(),"Updated Successfully", Toast.LENGTH_SHORT).show();

    }

}