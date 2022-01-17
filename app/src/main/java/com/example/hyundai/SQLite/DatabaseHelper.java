package com.example.hyundai.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import static android.accounts.AccountManager.KEY_PASSWORD;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "HyundaiPokayoke.db";

    private static final String TABLE_USER = "user";

    //User Table
    private static final String ID = "id";
    private static final String npk = "npk";
    private static final String username = "username";
    private static final String password = "password";
    private static final String rfid_tag = "rfid_tag";
    private static final String name = "name";
    private static final String usergroup = "usergorup";
    private static final String department_id = "department_id";
    private static final String op_skill = "op_skill";
    private static final String last_login = "last_login";
    private static final String status = "status";
    private static final String created_at = "created_at";
    private static final String updated_at = "updated_at";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + npk + " TEXT,"
            + username + " TEXT," + password + " TEXT," + rfid_tag + " TEXT," + name + " TEXT, " + usergroup + " TEXT,"
        + department_id + " INTEGER," + op_skill + " INTEGER," + last_login + " DATE," + status + " TEXT," +
            created_at + " DATE," + updated_at + " DATE" +")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        ArrayList<User> list = new ArrayList<>();
        add_users(list);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CREATE_USER_TABLE);
        onCreate(db);
    }

    public void add_users(ArrayList<User> list) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO " + TABLE_USER +
        " VALUES('0268', '0268', 'leader', '2579541961', 'Ropik Nur Faizal', " +
                "'Leader', 'PPIC', 0, '2021-12-24 13:46:44', 'Active', " +
                "'2021-02-28 06:11:51', '0000-00-00 00:00:00')";
        SQLiteStatement statement = database.compileStatement(sql);
        database.beginTransaction();
        try {
            for (User c : list) {
                statement.clearBindings();
                statement.bindString(1, c.getNpk());
                statement.bindString(2, c.getUsername());
                statement.bindString(3, c.getPassword());
                statement.bindString(4, c.getRfid_tag());
                statement.bindString(5, c.getName());
                statement.bindString(6, c.getUsergroup());
                statement.bindLong(7, c.getDepartment_id());
                statement.bindLong(8, c.getOp_skill());
                statement.bindString(10, c.getStatus());
                statement.execute();
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public void addUser(User user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(npk, user.getNpk());
        values.put(username, user.getUsername());
        values.put(password, user.getPassword());
        values.put(rfid_tag, user.getRfid_tag());
        values.put(name, user.getName());
        values.put(usergroup, user.getUsergroup());
        values.put(department_id, user.getDepartment_id());
        values.put(op_skill, user.getOp_skill());
        values.put(last_login, user.getLast_login().getTimezoneOffset());
        values.put(status, user.getStatus());
        values.put(created_at, user.getCreated_at().getTimezoneOffset());
        values.put(updated_at, user.getUpdated_at().getTimezoneOffset());
    }

    public boolean checkUser(String npk, String password) {
        // array of columns to fetch
        String[] columns = {
                ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = npk + " = ?" + " AND " + password + " = ?";
        // selection arguments
        String[] selectionArgs = {npk, password};
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,// Selecting Table
                new String[]{ID, npk, username, password},//Selecting columns want to query
                npk + "=?",
                new String[]{user.npk},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            User user1 = new User();
                return user1;
        }
        return null;
    }

//    public List<User> getAllUser() {
//        // array of columns to fetch
//        String[] columns = {
//                ID, npk, username, password, rfid_tag, name, usergroup, department_id,
//                op_skill, last_login, status, created_at, updated_at
//        };
//        // sorting orders
//        String sortOrder =
//                ID + " ASC";
//        List<User> userList = new ArrayList<User>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_USER, //Table to query
//                columns,    //columns to return
//                null,        //columns for the WHERE clause
//                null,        //The values for the WHERE clause
//                null,       //group the rows
//                null,       //filter by row groups
//                sortOrder); //The sort order
//        // Traversing through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                User user = new User();
//                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))));
//                user.setNpk(cursor.getString(cursor.getColumnIndex(npk)));
//                user.setName(cursor.getString(cursor.getColumnIndex(name)));
//                user.setPassword(cursor.getString(cursor.getColumnIndex(password)));
//                // Adding user record to list
//                userList.add(user);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        // return user list
//        return userList;
//    }
}
