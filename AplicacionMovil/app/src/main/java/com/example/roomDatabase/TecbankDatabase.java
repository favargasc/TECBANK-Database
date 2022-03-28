package com.example.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomDatabase.Daos.AccountDao;
import com.example.roomDatabase.Daos.BankDao;
import com.example.roomDatabase.Daos.LocationDao;
import com.example.roomDatabase.Daos.SavingEnvelopeDao;
import com.example.roomDatabase.Daos.UserDao;
import com.example.roomDatabase.Daos.proofOfPaymentDao;
import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.Bank;
import com.example.roomDatabase.models.Location;
import com.example.roomDatabase.models.Proofpayment;
import com.example.roomDatabase.models.SavingEnvelope;
import com.example.roomDatabase.models.TransactionType;
import com.example.roomDatabase.models.User;

// entities = tables, version = the rollback prevision
// if migration error, erase app from phone, and run again
@Database(entities = {Bank.class, Account.class, Location.class, User.class, SavingEnvelope.class, Proofpayment.class, TransactionType.class} , version = 1)
public abstract class TecbankDatabase extends RoomDatabase {

    public abstract BankDao bankDao();
    public abstract AccountDao accountDao();
    public abstract LocationDao locationDao();
    public abstract UserDao userDao();
    public abstract SavingEnvelopeDao savingEnvelopeDao();
    public abstract proofOfPaymentDao proofpaymentDao();

    private static TecbankDatabase INSTANCE;

    public static TecbankDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TecbankDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TecbankDatabase.class, "TecbankDatabase_db")

                            //.createFromAsset("tecbank.sqlite")

                            //every time the app uninstall, theres a database destruction
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


};
