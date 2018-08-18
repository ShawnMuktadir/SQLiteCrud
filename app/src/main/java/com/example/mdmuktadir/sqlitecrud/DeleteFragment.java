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
import com.example.mdmuktadir.sqlitecrud.com.services.ContactDetails;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {

    private EditText id_delete_contact;
    private Button contact_delete_btn;
    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete, container, false);

        makeObj(view);
        contact_delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDbContact();
            }
        });



        return view;
    }

    private void makeObj(View view) {
        id_delete_contact=(EditText)view.findViewById(R.id.id_delete_contact);
        contact_delete_btn=(Button)view.findViewById(R.id.contact_delete_btn);

    }

    private void deleteDbContact(){

        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase sqLiteDatabase = contactDbHelper.getWritableDatabase();

        contactDbHelper.deleteContact(Integer.parseInt(id_delete_contact.getText().toString()), sqLiteDatabase);
        Toast.makeText(getActivity(),"Deleted Successfully", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
    }



}