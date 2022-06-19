package bod.abhijit.dbtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import bod.abhijit.dbtest.db.DBHelper;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    // data source
    ArrayList<Contact> contacts = new ArrayList<>();
    ContactAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button addData =findViewById(R.id.addDataBtn);

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }});

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new ContactAdapter(this, contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));



    }


    @Override
    protected void onResume() {
        super.onResume();

        // get the contacts from db and refresh the recylcer view automatically
        Log.d("aka","0");
        getContacts();
    }

    private void getContacts() {
        contacts.clear();
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT id, personName, address, phone, email, age FROM Contacts", null);

        Log.d("aka","1");
        if(!cursor.isAfterLast()){

            Log.d("aka","2");
            cursor.moveToFirst();

            while(!cursor.isAfterLast()){

                Log.d("aka","loop");

                int id =cursor.getInt(0);
                String personName =cursor.getString(1);
                String address = cursor.getString(2);
                String phone = cursor.getString(3);
                String email = cursor.getString(4);
                int age = cursor.getInt(5);

                Contact contact = new Contact();
                contact.setId(id);
                contact.setName(personName);
                contact.setAddress(address);
                contact.setEmail(email);
                contact.setPhone(phone);
                contact.setAge(age);

                Log.d("aka","loop:"+contact.toString());

                contacts.add(contact);

                cursor.moveToNext();

            }

            cursor.close();

            db.close();

            dbHelper.close();



            adapter.notifyDataSetChanged();

        }else{

        }

    }
}


