package ca.macewan.cmpt496.mobileappdemo_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telephony.mbms.MbmsErrors;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Contacts";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_DATE = "date";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, " + KEY_PHONE_NO + " TEXT, " + KEY_EMAIL+ " TEXT, " + KEY_DATE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void addContact(String name,  String phone_no, String email, String date){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NO, phone_no);
        values.put(KEY_EMAIL, email);
        values.put(KEY_DATE, date);

        db.insert(TABLE_NAME, null, values);
    }
}
