package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomDatabase.TecbankDatabase;

/**
 * The type Menu sobres.
 */
public class menuSobres extends AppCompatActivity {

    private int cuenta;
    private int savingEnv; //Identificador del sobre seleccionado en el recliclerview
    private EditText dinero;
    /**
     * The Database.
     */
    TecbankDatabase database;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sobres);

        cuenta = getIntent().getIntExtra("NombreCuenta",0);
        savingEnv = getIntent().getIntExtra("SavingEnv",-1);
        database = TecbankDatabase.getDatabase(this);

        dinero = (EditText) findViewById(R.id.txtMontoMenuSobre);
    }

    /**
     * Depositar.
     *
     * @param view the view
     */
    public void depositar(View view){
        double monto = Double.parseDouble(dinero.getEditableText().toString());
        if(monto != 0) {
            int updateReduceAccount = database.savingEnvelopeDao().reduceAccountCB(savingEnv, monto);
            if (updateReduceAccount > 0){
                int updateReceiveMoney = database.savingEnvelopeDao().receiveMoney(savingEnv, monto);
                if(updateReceiveMoney <= 0){ //verifica si se realizo el update
                    Toast.makeText(getApplicationContext(),
                            "No fue posible depositar " + savingEnv, Toast.LENGTH_LONG).show();
                    //Descomentar la siguiente linea por si se quiere devolver el dinero ya que no se realizo el update
                    //database.savingEnvelopeDao().increaseAccountCB(savingEnv, monto);
                }
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "No fue posible depositar " + savingEnv, Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(menuSobres.this,"No ingreso el monto", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Devolver.
     *
     * @param view the view
     */
    public void devolver(View view){
        double monto = Double.parseDouble(dinero.getEditableText().toString());
        if(monto != 0) {
            int updateReturnMoney = database.savingEnvelopeDao().returnMoney(savingEnv, monto);
            if (updateReturnMoney > 0){
                int updateIncreaseAccount = database.savingEnvelopeDao().increaseAccountCB(savingEnv, monto);
                if(updateIncreaseAccount <= 0){ //verifica si se realizo el update
                    Toast.makeText(getApplicationContext(),
                            "No fue posible devolver " + savingEnv, Toast.LENGTH_LONG).show();
                    //Descomentar la siguiente linea por si se quiere devolver el dinero ya que no se realizo el update
                    //database.savingEnvelopeDao().receiveMoney(savingEnv, monto);
                }
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "No fue posible devolver " + savingEnv, Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(menuSobres.this,"No ingreso el monto", Toast.LENGTH_SHORT).show();
        }
    }

}