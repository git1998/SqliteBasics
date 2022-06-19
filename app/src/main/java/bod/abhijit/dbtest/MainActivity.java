package bod.abhijit.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import bod.abhijit.dbtest.db.DBHelper;

public class MainActivity extends AppCompatActivity {

    // references
    EditText editName, editAddress, editEmail, editPhone, editAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set reeferemces to the ui elements
        editName = findViewById(R.id.editName);
        editAddress = findViewById(R.id.editAddress);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editAge = findViewById(R.id.editAge);
    }

    public void onSave( View view){
        String name = editName.getText().toString();
        String address = editAddress.getText().toString();
        String email = editEmail.getText().toString();
        String phone = editPhone.getText().toString();
        String age = editAge.getText().toString();

        DBHelper dbHelper =new DBHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("personName", name);
        values.put("address", address);
        values.put("email", email);
        values.put("phone", phone);
        values.put("age", age);


        db.insert("Contacts", null, values);

        db.close();

        dbHelper.close();

        Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();


    }
}