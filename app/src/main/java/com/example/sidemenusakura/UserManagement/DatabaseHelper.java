package com.example.sidemenusakura.UserManagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context ctx;

    public DatabaseHelper(@Nullable Context context) {
        super(context, com.example.sidemenusakura.UserManagement.Constants.DB_NAME, null, com.example.sidemenusakura.UserManagement.Constants.DB_VERSION);
        this.ctx = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_REGISTER_TABLE = "CREATE TABLE " + com.example.sidemenusakura.UserManagement.Constants.TABLE_NAME + "("
                + com.example.sidemenusakura.UserManagement.Constants.KEY_ID + " INTEGER PRIMARY KEY,"
                + com.example.sidemenusakura.UserManagement.Constants.KEY_USERNAME + " TEXT,"
                + com.example.sidemenusakura.UserManagement.Constants.KEY_NAME + " TEXT,"
                + com.example.sidemenusakura.UserManagement.Constants.KEY_CONTACTNUMBER + " TEXT,"
                + com.example.sidemenusakura.UserManagement.Constants.KEY_PASSWORD + " TEXT,"
                + com.example.sidemenusakura.UserManagement.Constants.KEY_EMAIL + " TEXT UNIQUE)";
        Log.d("TableCreated", "done");
        db.execSQL(CREATE_REGISTER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + com.example.sidemenusakura.UserManagement.Constants.TABLE_NAME);

        onCreate(db);
    }

    /*
     * CRUD OPERATIONS : CREATE -->  add user  , DELETE , UPDATE  METHODS .
     *
     */

    public long addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_USERNAME, user.getUserName());
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_NAME, user.getName());
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_CONTACTNUMBER, user.getContactNumber());
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_PASSWORD, user.getPassword());
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_EMAIL, user.getEmail());

        // Error
        long res = db.insert(com.example.sidemenusakura.UserManagement.Constants.TABLE_NAME, null, values);
        Log.d("Saved!", "saved to DB");
        db.close();
        return res;

    }






    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_USERNAME, user.getUserName());
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_NAME, user.getName());
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_CONTACTNUMBER, user.getContactNumber());
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_PASSWORD, user.getPassword());
        values.put(com.example.sidemenusakura.UserManagement.Constants.KEY_EMAIL, user.getEmail());
        return db.update(com.example.sidemenusakura.UserManagement.Constants.TABLE_NAME, values, com.example.sidemenusakura.UserManagement.Constants.KEY_ID + "=?",
                new String[]{String.valueOf(user.getId())});
    }



    public int getUsersCount() {
        String countQuery = "SELECT * FROM " + com.example.sidemenusakura.UserManagement.Constants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();
    }


    public Boolean checkUser(String email, String password) {
        String[] columns = {com.example.sidemenusakura.UserManagement.Constants.KEY_ID};
        SQLiteDatabase db = getReadableDatabase();
        String selection = com.example.sidemenusakura.UserManagement.Constants.KEY_EMAIL + "=?" + " and " + com.example.sidemenusakura.UserManagement.Constants.KEY_PASSWORD + "=?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(com.example.sidemenusakura.UserManagement.Constants.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;
    }


    // not clean code
    public String selectOneUserSendUserName(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + com.example.sidemenusakura.UserManagement.Constants.TABLE_NAME + " WHERE " + com.example.sidemenusakura.UserManagement.Constants.KEY_EMAIL + " = '" + email.trim() + "'" + " and " + com.example.sidemenusakura.UserManagement.Constants.KEY_PASSWORD + " = '" + password.trim() + "'", null);
        c.moveToFirst();

        int x = 0;
        String y = "";
        String a = "";
        String cd = "";
        while (c != null) {
            x = Integer.parseInt(c.getString(c.getColumnIndex(com.example.sidemenusakura.UserManagement.Constants.KEY_ID)));
            y = c.getString(c.getColumnIndex(com.example.sidemenusakura.UserManagement.Constants.KEY_USERNAME));
            a = c.getString(c.getColumnIndex(com.example.sidemenusakura.UserManagement.Constants.KEY_NAME));
            cd = c.getString(c.getColumnIndex(com.example.sidemenusakura.UserManagement.Constants.KEY_CONTACTNUMBER));
            Log.d("tagOneUser", Integer.toString(x));
            Log.d("tagOneUser", y);
            Log.d("tagOneUser", a);
            Log.d("tagOneUser", cd);
            break;
        }
        c.moveToNext();
        return y;
    }
        public String selectOneUserSendName(String email, String password) {
            SQLiteDatabase db = getReadableDatabase();

            Cursor c = db.rawQuery("SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.KEY_EMAIL + " = '"+email.trim()+"'" +" and "+ Constants.KEY_PASSWORD + " = '"+password.trim()+"'" , null);
            c.moveToFirst();

            int x = 0 ;
            String y = "";
            String a = "";
            int cd = 0;
            while (c != null) {
                x = Integer.parseInt(c.getString(c.getColumnIndex(Constants.KEY_ID)));
                y = c.getString(c.getColumnIndex(Constants.KEY_USERNAME));
                a = c.getString(c.getColumnIndex(Constants.KEY_NAME));
                cd = Integer.parseInt(c.getString(c.getColumnIndex(Constants.KEY_CONTACTNUMBER)));
                Log.d("tagOneUser", Integer.toString(x) );
                Log.d("tagOneUser", y );
                Log.d("tagOneUser", a );
                Log.d("tagOneUser", Integer.toString(cd) );
                break;
            }
            c.moveToNext();
            return a;
        }



    public int selectOneUserSendId(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + com.example.sidemenusakura.UserManagement.Constants.TABLE_NAME + " WHERE " + com.example.sidemenusakura.UserManagement.Constants.KEY_EMAIL + " = '"+email.trim()+"'" +" and "+ com.example.sidemenusakura.UserManagement.Constants.KEY_PASSWORD + " = '"+password.trim()+"'" , null);
        c.moveToFirst();

        int x = 0 ;
        String y = "";
        String a = "";
        String cd = "";
        while (c != null) {
            x = Integer.parseInt(c.getString(c.getColumnIndex(com.example.sidemenusakura.UserManagement.Constants.KEY_ID)));
            y = c.getString(c.getColumnIndex(com.example.sidemenusakura.UserManagement.Constants.KEY_USERNAME));
            a = c.getString(c.getColumnIndex(com.example.sidemenusakura.UserManagement.Constants.KEY_NAME));
            cd = c.getString(c.getColumnIndex(com.example.sidemenusakura.UserManagement.Constants.KEY_CONTACTNUMBER));
            Log.d("tagOneUser", Integer.toString(x) );
            Log.d("tagOneUser", y );
            Log.d("tagOneUser", a );
            Log.d("tagOneUser", cd );
            break;
        }
        c.moveToNext();
        return x;
    }

    public int selectOneUserSendContactnumber(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.KEY_EMAIL + " = '"+email.trim()+"'" +" and "+ Constants.KEY_PASSWORD + " = '"+password.trim()+"'" , null);
        c.moveToFirst();

        int x = 0 ;
        String y = "";
        String a = "";
        int cd = 0;
        while (c != null) {
            x = Integer.parseInt(c.getString(c.getColumnIndex(Constants.KEY_ID)));
            y = c.getString(c.getColumnIndex(Constants.KEY_USERNAME));
            a = c.getString(c.getColumnIndex(Constants.KEY_NAME));
            cd = Integer.parseInt(c.getString(c.getColumnIndex(Constants.KEY_CONTACTNUMBER)));
            Log.d("tagOneUser", Integer.toString(x) );
            Log.d("tagOneUser", y );
            Log.d("tagOneUser", a );
            Log.d("tagOneUser", Integer.toString(cd) );
            break;
        }
        c.moveToNext();
        return cd;
    }



}

