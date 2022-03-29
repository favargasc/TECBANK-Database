package com.example.adapters;

import android.content.Intent;
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
import com.example.roomDatabase.models.Proofpayment;
import com.example.tecbankmovil.R;
import com.example.tecbankmovil.RegistrarUsuario;
import com.example.tecbankmovil.Transferencia;

import java.util.ArrayList;
import java.util.List;

public class transferAccountAdapter extends RecyclerView.Adapter{
    private List<Proofpayment> transferList;
    private String accountId;

    // public constructor for this class
    public transferAccountAdapter()
    {
        this.transferList = new ArrayList<Proofpayment>() {};
    }

    public void updateAdapter(List<Proofpayment> accounts){
        this.transferList = accounts;
        notifyDataSetChanged();
    }


    // Create classes for each layout ViewHolder.

    public class LayoutTransferViewHolder extends RecyclerView.ViewHolder {

        private TextView text_transferNumber, text_amount, text_description;
        private ConstraintLayout transferLayout;

        public LayoutTransferViewHolder(@NonNull View itemView)
        {
            super(itemView);
            text_transferNumber = itemView.findViewById(R.id.transferNumber);
            text_amount = itemView.findViewById(R.id.transferAmmount);
            text_description = itemView.findViewById(R.id.transferDescription);
            transferLayout = itemView.findViewById(R.id.transferenciaItem);
        }

        private void setViews(String transferNumber, String amount, String description)
        {
            this.text_transferNumber.setText(transferNumber);
            this.text_amount.setText(amount);
            this.text_description.setText(description);
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
                .inflate(R.layout.recycler_view_transferencia, parent, false);
        return new LayoutTransferViewHolder(layoutTwo);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //int image = itemClassList.get(position).geticon();
        String Transfer = transferList.get(position).getId().toString();
        String Amount = String.valueOf(transferList.get(position).getAmount());
        String description = String.valueOf(transferList.get(position).getDetail());

        ((LayoutTransferViewHolder)holder).setViews(Transfer,Amount,description);
        ((LayoutTransferViewHolder)holder).transferLayout.setOnClickListener(null);
        ((LayoutTransferViewHolder)holder).transferLayout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(),
                                "Hello from Account " + transferList.get(holder.getAdapterPosition()).getReqAccount(), Toast.LENGTH_SHORT).show();
                        //accountId = transferList.get(holder.getAdapterPosition()).getReqAccount();
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return transferList.size();
    }
}