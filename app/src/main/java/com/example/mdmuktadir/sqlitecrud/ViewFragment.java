package com.example.mdmuktadir.sqlitecrud;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mdmuktadir.sqlitecrud.com.services.ContactDbHelper;
import com.example.mdmuktadir.sqlitecrud.com.services.ContactDetails;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    private TextView viewer_txt;


    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_view, container, false);
        makeObj(view);
        readDbContact();

        return view;
    }

    private void makeObj(View view){
        viewer_txt=(TextView)view.findViewById(R.id.viewer_txt);
    }

    private void readDbContact(){
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase sqLiteDatabase = contactDbHelper.getReadableDatabase();
        Log.d("Database Operation","View One row successfully::::::::::::::::");

        Cursor cursor=contactDbHelper.readContact(sqLiteDatabase);
        Log.d("Database Operation","View Two row successfully::::::::::::::::");

        String info ="";
        while (cursor.moveToNext()){
            info =info+ "\n\nID : "+cursor.getInt(cursor.getColumnIndex(ContactDetails.ContactEntry.CONTACT_ID))+"" +
                    "\nName : "+cursor.getString(cursor.getColumnIndex(ContactDetails.ContactEntry.CONTACT_NAME))+"" +
                    "\nEmail : "+cursor.getString(cursor.getColumnIndex(ContactDetails.ContactEntry.CONTACT_EMAIL));
        }
        viewer_txt.setText(info);
        sqLiteDatabase.close();
    }

}
