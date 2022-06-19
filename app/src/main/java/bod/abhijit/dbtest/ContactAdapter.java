package bod.abhijit.dbtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    Context context;
    ArrayList<Contact> contacts;


    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.item_contact,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {

        Contact contact = contacts.get(position);
        holder.textId.setText("Id = " + contact.getId());
        holder.textName.setText("Name = " + contact.getName());
        holder.textAddress.setText("Address = " + contact.getAddress());
        holder.textPhone.setText("Phone = " + contact.getPhone());
        holder.textEmail.setText("Email = " + contact.getEmail());
        holder.textAge.setText("Age = " + contact.getAge());


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textId, textName, textAddress, textPhone, textEmail, textAge;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textId = itemView.findViewById(R.id.textId);
            textName = itemView.findViewById(R.id.textName);
            textAddress = itemView.findViewById(R.id.textAddress);
            textPhone = itemView.findViewById(R.id.textPhone);
            textEmail = itemView.findViewById(R.id.textEmail);
            textAge = itemView.findViewById(R.id.textAge);


        }
    }

}
