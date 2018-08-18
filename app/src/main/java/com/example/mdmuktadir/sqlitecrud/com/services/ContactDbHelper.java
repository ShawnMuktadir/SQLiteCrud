package com.example.mdmuktadir.sqlitecrud.com.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ContactDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contact_db";
    private static final int VERSION_NO = 1;

    //Create table (tableName)(contact_id number, contact_name text, contact_email text);
    private static final String CREATE_STATEMENT="CREATE TABLE "+ContactDetails.ContactEntry.TABLE_NAME+"("+ ContactDetails.ContactEntry.CONTACT_ID+" number"
            +","+ ContactDetails.ContactEntry.CONTACT_NAME+" text,"+ ContactDetails.ContactEntry.CONTACT_EMAIL+" text);";

    //drop table if exists tableName;
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ ContactDetails.ContactEntry.TABLE_NAME;


    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NO);
        Log.d("Database Operation","Database Created Succcessfully!!!!!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Database Operation","CREATE STATEMENT:: "+CREATE_STATEMENT);
        db.execSQL(CREATE_STATEMENT);
        Log.d("Database Operation","Table created successfully::::::::::::::::");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void createContact(int id,String name,String email,SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactDetails.ContactEntry.CONTACT_ID,id);
        contentValues.put(ContactDetails.ContactEntry.CONTACT_NAME,name);
        contentValues.put(ContactDetails.ContactEntry.CONTACT_EMAIL,email);

        database.insert(ContactDetails.ContactEntry.TABLE_NAME,null,contentValues);
        database.close();
        Log.d("Database Operation","One row inserted successfully::::::::::::::::");

    }

    public Cursor readContact(SQLiteDatabase sqLiteDatabase){

        String[] projection={ContactDetails.ContactEntry.CONTACT_ID,ContactDetails.ContactEntry.CONTACT_NAME,ContactDetails.ContactEntry.CONTACT_EMAIL};
        Cursor cursor=sqLiteDatabase.query(ContactDetails.ContactEntry.TABLE_NAME,projection,null,null,null,null,null);

        return cursor;
    }

    public void deleteContact(int id, SQLiteDatabase database){

        String selection = ContactDetails.ContactEntry.CONTACT_ID +" = "+id;
        database.delete(ContactDetails.ContactEntry.TABLE_NAME, selection, null);
        Log.d("Database Operation","One row deleted successfully::::::::::::::::");

    }

    public void updateContact(int id, String name, String email, SQLiteDatabase database){

        String selection = ContactDetails.ContactEntry.CONTACT_ID +" = "+id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactDetails.ContactEntry.CONTACT_NAME, name);
        contentValues.put(ContactDetails.ContactEntry.CONTACT_EMAIL, email);

        database.update(ContactDetails.ContactEntry.TABLE_NAME, contentValues, selection,null);

        Log.d("Database Operation","One row updated successfully::::::::::::::::");

    }

}