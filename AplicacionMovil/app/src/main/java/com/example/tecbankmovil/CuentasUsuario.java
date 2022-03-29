package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.adapters.UserAccountsAdapter;
import com.example.roomDatabase.TecbankDatabase;
import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.Bank;
import com.example.tecbankmovil.databinding.RecyclerViewAccountBinding;
import com.example.utilities.globalUserData;

import java.util.List;

/**
 * The type Cuentas usuario.
 */
public class CuentasUsuario extends AppCompatActivity implements cuentasUsuarioRecyclerViewInterface {
    private int accountId;
    private int userId;
    /**
     * The Accounts.
     */
    public List<Account> accounts;
    /**
     * The Database.
     */
    TecbankDatabase database;
    /**
     * The Account adapter.
     */
    UserAccountsAdapter accountAdapter = new UserAccountsAdapter();

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas_usuario);

        accountAdapter.userInterface = this;

        accountId = getIntent().getIntExtra("accountId",-1);
        userId = getIntent().getIntExtra("accountId",-1);
        Toast.makeText(getApplicationContext(), "accountId " + accountId , Toast.LENGTH_LONG).show();



        database = TecbankDatabase.getDatabase(this);
        //database.bankDao().insert(new Bank(1,"TECBANK", "TBNK"));

        RecyclerView recyclerView = findViewById(R.id.rcvCuentas);
        recyclerView.setAdapter(accountAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database.accountDao().getAccountByUserId(globalUserData.getInstance().getUserId()).observe(this,new Observer<List<Account>>(){

            @Override
            public void onChanged(List<Account> userAccounts) {
                if (userAccounts == null ||userAccounts.size() == 0) {
                    Toast.makeText(getApplicationContext(), "El usuario no tiene cuentas Activas " , Toast.LENGTH_LONG).show();
                    //informar de que se ingreso mal el texto
                } else {
                    accounts = userAccounts;
                    accountAdapter.updateAdapter(userAccounts);
                }
            }
        });
    }

    @Override
    public void sendToHistorialOnClick(String accountNumber) {
        Intent infCuenta = new Intent(this, informacionCuenta.class);
        infCuenta.putExtra("accountNumber", accountNumber); // Pasar dato por paramatro de una activity a otra, se tiene que pasar el user id
        startActivity(infCuenta);


    }
    // utilizacion del reciclerveiw
    // Unir a informacionCuenta cuando selecione una cuenta en el reciclerveiw
}

