package com.example.sidemenusakura.FoodDeliveryManagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 10;
    private static final String DB_NAME = "Sakura_Restaurant";
    private static final String TABLE_NAME = "delivery_management";

    // Column names
    private static final String ID = "id";
    private static final String CUSTOMERNAME = "customername";
    private static final String ADDRESS = "address";
    private static final String CONTACTNUMBER = "contactnumber";
    private static final String TOTALPRICE = "totalprice";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

    public DbHandler(@Nullable Context context) {

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +CUSTOMERNAME + " TEXT,"
                +ADDRESS + " TEXT,"
                +CONTACTNUMBER + " TEXT,"
                +TOTALPRICE + " TEXT,"
                +STARTED+ " TEXT,"
                +FINISHED+" TEXT" +
                ");";

        /*
            CREATE TABLE Delivery_Management (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT,
            started TEXT,finished TEXT); */

        db.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        // Create tables again
        onCreate(db);


    }

    /*
            +-------+-------+-------+-------+
            | Col 1 | col 2 | Col 3 | Col 4 |
            +-------+-------+-------+-------+
            |   1   |   2   |  red  |  dog  |
            +-------+-------+-------+-------+
            |   2   |   4   |  blue |  cat  |
            +-------+-------+-------+-------+
            |   3   |   9   |  red  | bird  |
            +-------+-------+-------+-------+
     */


    // Add a single delivery_management
    public void addToDo(Delivery_Management deliveryManagement){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CUSTOMERNAME, deliveryManagement.getCustomername());
        contentValues.put(ADDRESS, deliveryManagement.getAddress());
        contentValues.put(CONTACTNUMBER, deliveryManagement.getContactnumber());
        contentValues.put(TOTALPRICE, deliveryManagement.getTotalprice());
        contentValues.put(STARTED, deliveryManagement.getStarted());
        contentValues.put(FINISHED, deliveryManagement.getFinished());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        // close database
        sqLiteDatabase.close();
    }

    // Count delivery_management table records
    public int countToDo(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }

    // Get all delivery_managements into a list
    public List<Delivery_Management> getAllToDos(){

        List<Delivery_Management> deliveryManagements = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                // Create new ToDo object
                Delivery_Management deliveryManagement = new Delivery_Management();
                // mmgby6hh
                deliveryManagement.setId(cursor.getInt(0));
                deliveryManagement.setCustomername(cursor.getString(1));
                deliveryManagement.setAddress(cursor.getString(2));
                deliveryManagement.setContactnumber(cursor.getString(3));
                deliveryManagement.setTotalprice(cursor.getString(4));
                deliveryManagement.setStarted(cursor.getLong(5));
                deliveryManagement.setFinished(cursor.getLong(6));

                //toDos [obj,objs,asas,asa]
                deliveryManagements.add(deliveryManagement);
            }while (cursor.moveToNext());
        }
        return deliveryManagements;
    }

    // Delete item
    public void deleteToDo(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }


    // Get a single delivery_management
    public Delivery_Management getSingleToDo(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,CUSTOMERNAME,ADDRESS,CONTACTNUMBER,TOTALPRICE,STARTED, FINISHED},
                ID + "= ?",new String[]{String.valueOf(id)}
                ,null,null,null);

        Delivery_Management deliveryManagement;
        if(cursor != null){
            cursor.moveToFirst();
            deliveryManagement = new Delivery_Management(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getLong(5),
                    cursor.getLong(6)
            );
            return deliveryManagement;
        }
        return null;
    }

    // Update a single delivery_management
    public int updateSingleToDo(Delivery_Management deliveryManagement){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CUSTOMERNAME, deliveryManagement.getCustomername());
        contentValues.put(ADDRESS, deliveryManagement.getAddress());
        contentValues.put(CONTACTNUMBER, deliveryManagement.getContactnumber());
        contentValues.put(TOTALPRICE, deliveryManagement.getTotalprice());
        contentValues.put(STARTED, deliveryManagement.getStarted());
        contentValues.put(FINISHED, deliveryManagement.getFinished());

        int status = db.update(TABLE_NAME,contentValues,ID +" =?",
                new String[]{String.valueOf(deliveryManagement.getId())});

        db.close();
        return status;
    }




}
