package com.example.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomDatabase.Daos.AccountDao;
import com.example.roomDatabase.Daos.BankDao;
import com.example.roomDatabase.Daos.LocationDao;
import com.example.roomDatabase.Daos.SavingEnvelopeDao;
import com.example.roomDatabase.Daos.UserDao;
import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.Bank;
import com.example.roomDatabase.models.Location;
import com.example.roomDatabase.models.SavingEnvelope;
import com.example.roomDatabase.models.User;

/**
 * The type Tecbank database.
 */
// entities = tables, version = the rollback prevision
// if migration error, erase app from phone, and run again
@Database(entities = {Bank.class, Account.class, Location.class, User.class, SavingEnvelope.class} , version = 1)
public abstract class TecbankDatabase extends RoomDatabase {

    /**
     * Bank dao bank dao.
     *
     * @return the bank dao
     */
    public abstract BankDao bankDao();

    /**
     * Account dao account dao.
     *
     * @return the account dao
     */
    public abstract AccountDao accountDao();

    /**
     * Location dao location dao.
     *
     * @return the location dao
     */
    public abstract LocationDao locationDao();

    /**
     * User dao user dao.
     *
     * @return the user dao
     */
    public abstract UserDao userDao();

    /**
     * Saving envelope dao saving envelope dao.
     *
     * @return the saving envelope dao
     */
    public abstract SavingEnvelopeDao savingEnvelopeDao();

    private static TecbankDatabase INSTANCE;

    /**
     * Gets database.
     *
     * @param context the context
     * @return the database
     */
    public static TecbankDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TecbankDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TecbankDatabase.class, "TecbankDatabase_db")

                            //.createFromAsset("tecbank.sqlite")

                            //every time the app uninstall, theres a database destruction
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


};
