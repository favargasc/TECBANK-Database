package com.example.roomDatabase;

import com.example.roomDatabase.Daos.BankDao;
import com.example.roomDatabase.models.Bank;

public class Populate {

    public static void populateBank(TecbankDatabase database) {
        database.bankDao().insert( new Bank("TECBANK", "TCBK"));
        database.bankDao().insert( new Bank("D'Amore and Sons", "CYBR"));
        database.bankDao().insert( new Bank("Leuschke, Harvey and Schulist", "PTIE"));
        database.bankDao().insert( new Bank("Bechtelar-Kuphal", "SYNA"));
        database.bankDao().insert( new Bank("Macejkovic Inc", "DYN.WS"));
        database.bankDao().insert( new Bank("Block, Mosciski and Streich", "NEE"));
        database.bankDao().insert( new Bank("Sporer-Christiansen", "WHLRD"));
        database.bankDao().insert( new Bank("Mraz Inc", "FRTA"));
        database.bankDao().insert( new Bank("Anderson, Hoppe and Klocko", "VZ"));
        database.bankDao().insert( new Bank("Cremin-O''Hara", "DMB"));
        database.bankDao().insert( new Bank("Botsford LLC", "PCSB"));
        database.bankDao().insert( new Bank("Dare, Nitzsche and Greenholt", "ENB"));
        database.bankDao().insert( new Bank("Lemke, Bashirian and Conn", "GSL^B"));
        database.bankDao().insert( new Bank("Sanford Inc", "OMAM"));
        database.bankDao().insert( new Bank("Waters-Hermann", "AVAV"));
        database.bankDao().insert( new Bank("Beahan-Koelpin", "WHFBL"));
        database.bankDao().insert( new Bank("Jast, McKenzie and Boyer", "TJX"));
        database.bankDao().insert( new Bank("Pfannerstill Inc", "BPL"));
        database.bankDao().insert( new Bank("Marvin, Thompson and Koch", "GIL"));
        database.bankDao().insert( new Bank("Fisher Inc", "GBX"));
        database.bankDao().insert( new Bank("Erdman-Doyle", "AVD"));
    }
}
