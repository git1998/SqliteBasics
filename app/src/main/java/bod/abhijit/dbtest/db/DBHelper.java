package bod.abhijit.dbtest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    // constants
    private static final String DB_NAME = "contactsdb.sqlite";
    private static final int DB_VERSION = 1;

    // param1 (context): context used to create the database
    // param2: data file name
    // param3: factory => null
    // param4: database version
    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // will get called only once when an empty database gets created
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // initialize the db schema
        // - create required tables / functions / views
        sqLiteDatabase.execSQL("CREATE TABLE Contacts (" +
                "id integer primary key autoincrement, " +
                "personName text, " +
                "address text, " +
                "email text, " +
                "phone text, " +
                "age integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }
}
