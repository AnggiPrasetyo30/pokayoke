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
import java.util.Collection;
import java.util.Date;
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
        super(context, DB_name, null, 3);
        this.mContext = context;
        this.DB_PATH = "/data/data/" + mContext.getPackageName() + "/databases/";

    }

    public void createDatabase() throws IOException {
        boolean mDatabaseExist = checkDataBase();
        if (!mDatabaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDataBase();

            } catch (IOException mIOException) {
                mIOException.printStackTrace();
                throw new Error("Error copying database");
            } finally {
                this.close();
            }
        }
    }

    private void copyDataBase() throws IOException {
        try {
            InputStream inputStream = mContext.getAssets().open(DB_name);
            String OutfileName = DB_PATH + DB_name;
            OutputStream outputStream = new FileOutputStream(OutfileName);

            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, lenght);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Check database already exist or not
    private boolean checkDataBase() {
        try {
            final String mPath = DB_PATH + DB_name;
            final File file = new File(mPath);
            return file.exists();
        } catch (SQLiteException e) {
            e.printStackTrace();
            return false;
        }
    }


    public synchronized void close() {
        if (myDatabase != null) {
            myDatabase.close();
            SQLiteDatabase.releaseMemory();
            super.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
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

        try {
            createDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,// Selecting Table
                new String[]{name, npk, username, password, usergroup, trial857, status_akun},    //Selecting columns want to query
                npk + "=?",
                new String[]{user.npk},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
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

    public String CekKanbanAPI(String hasilScan) {
        String pn_api = "pn_api";
        String pn_cust = "pn_cust";

        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor2 = db2.query(TABLE_PRODUCT,
                new String[]{pn_cust},
                pn_api + "=?",
                new String[]{hasilScan}, null, null, null);
        if (cursor2 != null && cursor2.moveToFirst() && cursor2.getCount() > 0) {
            return cursor2.getString(0);
        }
        cursor2.close();
        db2.close();
        return null;
    }


    public String CekCustomer(String hasilScan) {
        String pn_api = "pn_api";
        String customer = "customer";

        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor2 = db2.query(TABLE_PRODUCT,
                new String[]{customer},
                pn_api + "=?",
                new String[]{hasilScan}, null, null, null);
        if (cursor2 != null && cursor2.moveToFirst() && cursor2.getCount() > 0) {
            return cursor2.getString(0);
        }
        cursor2.close();
        db2.close();
        return null;
    }

    public User insertValue (User user) {
        String npk = "npk";
        String username = "username";
        String password = "password";
        String rfid_tag = "rfid_tag" ;
        String name = "name";
        String usergroup = "usergroup";
        String department = "department";
        String op_skill = "op_skill";
        String last_login = "last_login";
        String status = "status";
        String created_at = "created_at" ;
        String updated_at = "updated_at";
        String status_akun = "status_akun";
        String trial857 = "trial857";

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(npk, user.getNpk());
        values.put(username, user.getUsername());
        values.put(password, user.getPassword());
        values.put(rfid_tag, user.getRfid_tag());
        values.put(name, user.getName());
        values.put(usergroup, user.getUsergroup());
        values.put(department, user.getDepartment());
        values.put(op_skill, user.getOp_skill());
        values.put(last_login, user.getLast_login().toString());
        values.put(status, user.getStatus());
        values.put(created_at, user.getCreated_at().toString());
        values.put(updated_at, user.getUpdated_at().toString());
        values.put(status_akun, user.getStatus_akun().toString());
        values.put(trial857, user.getTrial857());

        long newRowId = db.insert(TABLE_USER, null, values);

        return user;
    }

    public shopping InsertResult(shopping shop) {
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

    public Boolean cekOnResult(String pn) {
        String cek_data_api = "data_api";

        SQLiteDatabase dbc = this.getReadableDatabase();
        Cursor cursor = dbc.query(TABLE_SHOPPING,// Selecting Table
                new String[]{cek_data_api},//Selecting columns want to query
                cek_data_api + "=?",
                new String[]{pn},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            return false;
        }
        cursor.close();
        dbc.close();
        return true;

    }

    public Boolean cekOnResultC(String pn2) {
        String cek_data_cust = "data_cust";

        SQLiteDatabase dbc = this.getReadableDatabase();
        Cursor cursor = dbc.query(TABLE_SHOPPING,// Selecting Table
                new String[]{cek_data_cust},//Selecting columns want to query
                cek_data_cust + "=?",
                new String[]{pn2},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            return false;
        }
        cursor.close();
        dbc.close();
        return true;

    }

    public List<Product> retrieve_produk() {
        String part_name = "part_name";
        String sku = "sku";
        final List<Product> list_product = new ArrayList<>();

        SQLiteDatabase dbr = this.getReadableDatabase();
        Cursor cursor = dbr.query(TABLE_PRODUCT,
                new String[]{part_name, sku},
                null,
                null,
                null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Product produk = new Product(
                        null,
                        cursor.getString(1),
                        cursor.getString(0),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);

                list_product.add(produk);
            }while(cursor.moveToNext());

        }

        cursor.close();
        dbr.close();
        return list_product;
    }

    public List<User> retrieve_user() {
        String nama = "name";
        String npk = "npk";
        final List<User> list_user = new ArrayList<>();

        SQLiteDatabase dbr = this.getReadableDatabase();
        Cursor cursor = dbr.query(TABLE_USER,
                new String[]{nama, npk},
                null,
                null,
                null, null, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User(
                        cursor.getString(0),
                        cursor.getString(1),
                        null,
                        null,
                        null,
                        null,
                        null);
                list_user.add(user);
            }while(cursor.moveToNext());

        }
        cursor.close();
        dbr.close();
        return list_user;
    }

    public List<shopping> retrieve_riwayat() {
        String kanban_api = "kanban_api";
        String kanban_cust = "kanban_cust";
        String hasil_scan = "hasil";
        String datetime = "datetime";
        final List<shopping> list_riwayat = new ArrayList<>();

        SQLiteDatabase dbr = this.getReadableDatabase();
        Cursor cursor = dbr.query(TABLE_SHOPPING,
                new String[]{kanban_api, kanban_cust, hasil_scan, datetime},
                null,
                null,
                null, null, datetime+" DESC");

        if (cursor.moveToFirst()) {
            do {
                shopping riwayat = new shopping(
                        null,
                        null,
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        null,
                        null,
                        null);

                    list_riwayat.add(riwayat);
            }while(cursor.moveToNext());
        }
        cursor.close();
        dbr.close();
        return list_riwayat;
    }

    public void DeleteProduct(String Psku) {
        SQLiteDatabase dbdeleteP = this.getWritableDatabase();
        dbdeleteP.delete(TABLE_PRODUCT,"sku=?", new String[]{Psku});
    }

}