package audioapk.com.example.android.farmertofarmer.Farms;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FarmDatabase extends SQLiteOpenHelper{

    static private String DB_TABLE_FARM = "farm";

    private SQLiteDatabase sqLiteDatabase;

    public FarmDatabase(Context context, String DB_NAME) {
        super(context, DB_NAME, null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DB_TABLE_FARM+" (_id integer primary key autoincrement ,title text, image_resource integer, land text, date text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


    public int insetFarm(String title,int img,String land,String date){

        sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.execSQL("insert into "+DB_TABLE_FARM+" (title,image_resource,land,date) values ('"+title+"',"+img+",'"+land+"','"+date+"')");
        Cursor cursor = getAll();
        cursor.moveToLast();
        int result =  cursor.getInt(0);
        cursor.close();
        return result;

    }

    public Cursor getAll(){
        sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("Select * from "+DB_TABLE_FARM,null);
    }


}
