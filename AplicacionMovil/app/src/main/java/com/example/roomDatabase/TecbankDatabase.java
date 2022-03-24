package com.example.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomDatabase.Daos.AccountDao;
import com.example.roomDatabase.Daos.BankDao;
import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.Bank;

// entities = tables, version = the rollback prevision
// if migration error, erase app from phone, and run again
@Database(entities = {Bank.class, Account.class} , version = 1)
public abstract class TecbankDatabase extends RoomDatabase {

    public abstract BankDao bankDao();
    public abstract AccountDao accountDao();

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
                            .build();
                }
            }
        }
        return INSTANCE;
    }


};
