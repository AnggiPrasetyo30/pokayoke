package com.example.hyundai.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

import com.example.hyundai.activity.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.accounts.AccountManager.KEY_PASSWORD;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_name = "mobile_db.db";
    private static String DB_PATH = "";
    SQLiteDatabase myDatabase;
    private final Context mContext;

    public static final String TABLE_USER = "user";
    public static final String TABLE_PRODUCT = "product";
    public static final String TABLE_SHOPPING = "shopping";



    public DatabaseHelper(Context context) {
        super(context, DB_name, null, 2);
        this.mContext = context;
        this.DB_PATH = "/data/data/" + mContext.getPackageName() + "/databases/";

    }


    public void createDatabase() throws IOException {
        boolean mDatabaseExist = checkDataBase();
        if (!mDatabaseExist){
            this.getReadableDatabase();
            this.close();
            try{
                copyDataBase();

            }catch (IOException mIOException){
                mIOException.printStackTrace();
                throw new Error("Error copying database");
            }finally {
                this.close();
            }
        }
    }

    private void copyDataBase() throws IOException {
        try{
            InputStream inputStream = mContext.getAssets().open(DB_name);
            String OutfileName = DB_PATH+DB_name;
            OutputStream outputStream = new FileOutputStream(OutfileName);

            byte [] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) > 0){
                outputStream.write(buffer, 0, lenght);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Check database already exist or not
    private boolean checkDataBase() {
        try{
            final String mPath = DB_PATH + DB_name;
            final File file = new File(mPath);
            return file.exists();
        }catch (SQLiteException e){
            e.printStackTrace();
            return false;
        }
    }


    public synchronized void close() {
        if(myDatabase != null){
            myDatabase.close();
            SQLiteDatabase.releaseMemory();
            super.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion>oldVersion) {
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public Product ProductHyundai(Product product) {
//        String station_num = "station_num";
//        String sku = "sku";
//        String part_name = "part_name";
//        String position = "position";
//        String pn_api = "pn_api";
//        String pn_cust = "pn_cust";
//        BigInteger ptloc = "";
//        BigInteger sfgwh
//        BigInteger fgwh
//        BigInteger nkiwh
//        String type
//        String customer
//        String cust_id
//        String supplier_id
//        String job_num
//        String address
//        Integer time_production
//        Integer qty_packaging
//        Integer qty_child
//        String goods
//        String line_prod
//        BigInteger seq_qr
//        BigInteger seq_data_part
//    }

    public User Authenticate(User user) {
        String name = "name";
        String npk = "npk";
        String username = "username";
        String password = "password";
        String usergroup = "usergroup";
        String trial857 = "TRIAL857";
        String status_akun = "status_akun";

        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,// Selecting Table
                new String[]{name, npk, username, password, usergroup, trial857, status_akun},    //Selecting columns want to query
                npk + "=?",
                new String[]{user.npk},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6));
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }
        cursor.close();
        db.close();
        return null;
    }

    public String CekKanbanAPI(String hasilScan){
        String pn_api = "pn_api";
        String pn_cust = "pn_cust";

        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor2 = db2.query(TABLE_PRODUCT,
                new String[] {pn_cust},
                pn_api +"=?",
                new String[]{hasilScan},null,null,null);
        if (cursor2 != null && cursor2.moveToFirst()&& cursor2.getCount()>0){
           // Toast.makeText(mContext, cursor2.getString(0), Toast.LENGTH_SHORT).show();
            return cursor2.getString(0);
        }
        cursor2.close();
        db2.close();
        return null;
    }

    public String CekCustomer(String hasilScan){
        String pn_api = "pn_api";
        String customer = "customer";

        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor2 = db2.query(TABLE_PRODUCT,
                new String[] {customer},
                pn_api +"=?",
                new String[]{hasilScan},null,null,null);
        if (cursor2 != null && cursor2.moveToFirst()&& cursor2.getCount()>0){
                return cursor2.getString(0);
        }
        cursor2.close();
        db2.close();
        return null;
    }

    public shopping InsertResult(shopping shop){
        String npk = "npk";
        String customer = "customer";
        String kanban_api = "kanban_api";
        String kanban_cust = "kanban_cust";
        String hasil = "hasil";
        String datetime = "datetime";
        String data_api = "data_api";
        String data_cust = "data_cust";
        String TRIAL857 = "TRIAL857";

        SQLiteDatabase dbi = this.getWritableDatabase();

        //put value yang akan di insert
        ContentValues values = new ContentValues();
        values.put(npk, shop.getNpk());
        values.put(customer, shop.getCustomer());
        values.put(kanban_api, shop.getKanban_api());
        values.put(kanban_cust, shop.getKanban_cust());
        values.put(hasil, shop.getHasil());
        values.put(datetime, shop.getDatetime());
        values.put(data_api, shop.getData_api());
        values.put(data_cust, shop.getData_cust());
        values.put(TRIAL857, shop.getTRIAL857());

        long newRowId = dbi.insert(TABLE_SHOPPING, null, values);

        return shop;
    }

    public Boolean cekOnResult(String pn){
        String cek_data_api = "data_api";

        SQLiteDatabase dbc = this.getReadableDatabase();
        Cursor cursor = dbc.query(TABLE_SHOPPING,// Selecting Table
                new String[]{cek_data_api},//Selecting columns want to query
                cek_data_api + "=?",
                new String[]{pn},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
           return false;
        }
        cursor.close();
        dbc.close();
        return true;

    }

    public Boolean cekOnResultC(String pn2){
        String cek_data_cust = "data_cust";

        SQLiteDatabase dbc = this.getReadableDatabase();
        Cursor cursor = dbc.query(TABLE_SHOPPING,// Selecting Table
                new String[]{cek_data_cust},//Selecting columns want to query
                cek_data_cust + "=?",
                new String[]{pn2},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            return false;
        }
        cursor.close();
        dbc.close();
        return true;

    }
}