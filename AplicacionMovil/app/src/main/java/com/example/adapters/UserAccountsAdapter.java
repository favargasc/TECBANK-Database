package com.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomDatabase.models.Account;
import com.example.tecbankmovil.R;

import java.util.ArrayList;
import java.util.List;

public class UserAccountsAdapter extends RecyclerView.Adapter{
    private List<Account> accountsList;
    
    // public constructor for this class
    public UserAccountsAdapter()
    {
        this.accountsList = new ArrayList<Account>() {};
    }

    public void updateAdapter(List<Account> accounts){
        this.accountsList = accounts;
        notifyDataSetChanged();
    }


    // Create classes for each layout ViewHolder.

    public class LayoutAccountViewHolder extends RecyclerView.ViewHolder {

        private TextView text_AccountNumber, text_Balance;
        private ConstraintLayout accountLayout;

        public LayoutAccountViewHolder(@NonNull View itemView)
        {
            super(itemView);
            text_AccountNumber = itemView.findViewById(R.id.accountNumber);
            text_Balance = itemView.findViewById(R.id.accountBalance);
            accountLayout = itemView.findViewById(R.id.accountItem);
        }

        private void setViews(String AccountNumber, String Balance)
        {
            this.text_AccountNumber.setText(AccountNumber);
            this.text_Balance.setText(Balance);
        }
    }

    // In the onCreateViewHolder, inflate the
    // xml layout as per the viewType.
    // This method returns either of the
    // ViewHolder classes defined above,
    // depending upon the layout passed as a parameter.

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutTwo = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_account, parent, false);
        return new LayoutAccountViewHolder(layoutTwo);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //int image = itemClassList.get(position).geticon();
        String AccountNumber = accountsList.get(position).getAccount_number();
        String Balance = String.valueOf(accountsList.get(position).getCurrent_balance());
        ((LayoutAccountViewHolder)holder).setViews(AccountNumber,Balance);
        ((LayoutAccountViewHolder)holder).accountLayout.setOnClickListener(null);
        ((LayoutAccountViewHolder)holder).accountLayout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(),
                                "Hello from Account " + accountsList.get(holder.getAdapterPosition()).getAccount_number(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return accountsList.size();
    }
}
