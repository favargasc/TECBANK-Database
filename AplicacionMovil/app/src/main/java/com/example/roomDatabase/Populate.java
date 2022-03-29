package com.example.roomDatabase;

import com.example.roomDatabase.Daos.BankDao;
import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.Bank;
import com.example.roomDatabase.models.Location;
import com.example.roomDatabase.models.Proofpayment;
import com.example.roomDatabase.models.SavingEnvelope;
import com.example.roomDatabase.models.User;

/**
 * The type Populate.
 */
public class Populate {

    /**
     * Populate bank.
     *
     * @param database the database
     */
    public static void populateBank(TecbankDatabase database) {
        database.bankDao().insert( new Bank("TECBANK", "TCBK"));
        database.bankDao().insert( new Bank("DAmore and Sons", "CYBR"));
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

    /**
     * Populate location.
     *
     * @param database the database
     */
    public static void populateLocation(TecbankDatabase database){
        database.locationDao().insert( new Location("36.1899557, 117.1168644", "Hucheng", "10:49 AM"));
        database.locationDao().insert( new Location("34.145966, 105.757408", "Xiongbei", "2:06 AM"));
        database.locationDao().insert( new Location("27.5277132, 57.8651371", "Qal‘eh Ganj", "1:54 PM"));
        database.locationDao().insert( new Location("7.9500846, -75.3594016", "Montelíbano", "1:25 PM"));
        database.locationDao().insert( new Location("38.052038, 114.466022", "Shuiyuan", "11:39 AM"));
        database.locationDao().insert( new Location("9.834832, -75.120521", "San Jacinto", "6:12 PM"));
        database.locationDao().insert( new Location("-7.4104934, 110.3279026", "Ketawang", "8:55 AM"));
    }

    /**
     * Populate user.
     *
     * @param database the database
     */
    public static void populateUser(TecbankDatabase database){
        database.userDao().insert(new User("lwarhurst0@dailymotion.com","Xmj9QM74","Loren","Warhurst","lwarhurst0"));      
        database.userDao().insert(new User("eflorentine1@disqus.com","Mmp7jjbdJLM","Eudora","Florentine","eflorentine1")); 
        database.userDao().insert(new User("meastgate2@bandcamp.com","4KTm1GjBgNR","Margit","Eastgate","meastgate2"));     ;
        database.userDao().insert(new User("gguitton3@techcrunch.com","llbvlaFnvF","Grace","Guitton","gguitton3"));        
        database.userDao().insert(new User("mtommei4@youtu.be","UGLZJo","Myra","Tommei","mtommei4"));                      
        database.userDao().insert(new User("cdils5@infoseek.co.jp","8nXYbz","Celka","Dils","cdils5"));                     
        database.userDao().insert(new User("bismirnioglou6@google.pl","D61Wsa","Berkley","Ismirnioglou","bismirnioglou6"));;
        database.userDao().insert(new User("pthresher7@fotki.com","00B5qKE7f7X","Papageno","Thresher","pthresher7"));      
        database.userDao().insert(new User("carmfirld8@prlog.org","8jRT4LTqgxah","Carine","Armfirld","carmfirld8"));       
        database.userDao().insert(new User("shallagan9@mapy.cz","UIeRmioCBV","Sophie","Hallagan","shallagan9"));          
        database.userDao().insert(new User("sflorioa@springer.com","p5HQXKvwjh","Sherman","Florio","sflorioa"));          
        database.userDao().insert(new User("ejakobssenb@shinystat.com","25NbGY","Eartha","Jakobssen","ejakobssenb"));     
        database.userDao().insert(new User("fworpolec@sbwire.com","59VHrBn","Fifi","Worpole","fworpolec"));               
        database.userDao().insert(new User("tmontezd@nymag.com","HgJBHrkiO4j","Thorin","Montez","tmontezd"));             
        database.userDao().insert(new User("vfarfulle@yahoo.com","hqaFqwM","Valerye","Farfull","vfarfulle"));             
        database.userDao().insert(new User("dhedditchf@wsj.com","8h7FuqUaqOL","Dill","Hedditch","dhedditchf"));
        database.userDao().insert(new User("dollisg@state.tx.us","taJLhmczY","Derby","Ollis","dollisg"));                 
        database.userDao().insert(new User("oraddinh@sbwire.com","EY5vuykOWWn","Otes","Raddin","oraddinh"));              
        database.userDao().insert(new User("mvalleryi@ibm.com","jrK27oTJSX","Malcolm","Vallery","mvalleryi"));
        database.userDao().insert(new User("htitchmarshj@sakura.ne.jp","4XeCB8","Herman","Titchmarsh","htitchmarshj"));   
    }

    /**
     * Populate account.
     *
     * @param database the database
     */
    public static void populateAccount(TecbankDatabase database){
        database.accountDao().insert(new Account("GI66 PZCC UJWW T96J ZMNW VJU", 76865750.91, 17));
        database.accountDao().insert(new Account("FI16 4979 4957 1008 02", 13545097.99, 3));
        database.accountDao().insert(new Account("GT77 OMV6 OQG5 WDBM 1S6Y SSYA UYL2", 66579668.56, 13));
        database.accountDao().insert(new Account("FR40 3271 8195 78PA KVGL XQF4 O46", 36050194.13, 12));
        database.accountDao().insert(new Account("ES28 3202 9155 0401 8525 9455", 24299518.31, 17));
        database.accountDao().insert(new Account("ES33 7657 3652 9965 3106 1744", 17066648.13, 9));
        database.accountDao().insert(new Account("GT52 NOWV JSH0 KAJN MM39 B97W 6TKT", 43592631.25, 18));
        database.accountDao().insert(new Account("SI18 3470 7257 5198 550", 76816874.01, 16));
        database.accountDao().insert(new Account("FR50 7167 8015 10O4 GWOU PYWZ C95", 79101147.03, 15));
        database.accountDao().insert(new Account("MK43 158L 0ZAX UT0L 761", 88103629.05, 7));
        database.accountDao().insert(new Account("FR42 7144 2550 22DH UH9N JPPX 050", 62145221.18, 4));
        database.accountDao().insert(new Account("ME29 2139 5392 9121 2826 49", 40400460.26, 13));
        database.accountDao().insert(new Account("GL43 3230 1472 6898 07", 94360557.99, 1));
        database.accountDao().insert(new Account("FR72 2445 0784 025I IRXU IW3G E70", 86993624.31, 16));
        database.accountDao().insert(new Account("FR80 3288 5546 79GQ LAZF A4OJ 224", 79022515.78, 19));
        database.accountDao().insert(new Account("DO28 19WN 0980 4683 8782 1282 4946", 25451284.55, 11));
        database.accountDao().insert(new Account("VG36 BCWD 3153 0480 9201 3929", 97875559.42, 12));
        database.accountDao().insert(new Account("SI98 3744 5820 8338 821", 86678277.88, 6));
        database.accountDao().insert(new Account("PS30 YQOP TFPV EVGZ EPQG AFQT TFWV K", 23159379.86, 11));
        database.accountDao().insert(new Account("RS81 1807 1182 7958 8052 88", 46001048.66, 3));
        database.accountDao().insert(new Account("RS66 8896 8780 6860 0129 80", 73122056.32, 1));
        database.accountDao().insert(new Account("GE12 TQ77 7812 4232 1363 72", 26567377.05, 1));
        database.accountDao().insert(new Account("VG64 WCQC 9374 1580 9318 4843", 58031887.53, 16));
        database.accountDao().insert(new Account("CY21 4005 7284 ATKO CLOO TDYK ZIAQ", 19036548.52, 8));
        database.accountDao().insert(new Account("AT57 3714 5334 9016 6560", 65043254.71, 15));
        database.accountDao().insert(new Account("SM51 F433 5292 6500 XFCF GOWY QSD", 6646669.0, 7));
        database.accountDao().insert(new Account("SK28 4884 2055 6280 1104 3543", 53558357.66, 12));
        database.accountDao().insert(new Account("DE15 1707 6290 7636 0345 61", 55279775.39, 8));
        database.accountDao().insert(new Account("SK13 2854 3884 2530 5430 3115", 31528625.57, 15));
        database.accountDao().insert(new Account("KW67 MTAW XI8X INN7 UBLZ XGS5 GMRR TO", 201372.28, 8));
        database.accountDao().insert(new Account("GL22 1434 4379 6314 12", 98787435.21, 3));
        database.accountDao().insert(new Account("EE91 7062 9307 3704 9547", 53638497.2, 17));
        database.accountDao().insert(new Account("FI59 8871 7714 6302 81", 16477199.59, 8));
        database.accountDao().insert(new Account("LT08 6502 2430 5045 5691", 74137800.67, 14));
        database.accountDao().insert(new Account("AL29 6299 1736 M0HJ AK6I ZAW0 J38V", 53980651.01, 9));
        database.accountDao().insert(new Account("HR67 5964 8951 9134 2131 6", 2.41, 4));
        database.accountDao().insert(new Account("GE53 BG11 0684 9521 3600 45", 32.81, 20));
    }


    /**
     * Populate envelopes.
     *
     * @param database the database
     */
    public static void populateEnvelopes(TecbankDatabase database) {
        database.savingEnvelopeDao().insert(new SavingEnvelope("Health Care", 85.7, 15));
        database.savingEnvelopeDao().insert(new SavingEnvelope("n/a", 95.81, 14));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Durables", 38.07, 11));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Energy", 63.26, 9));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Services", 54.37, 20));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Non-Durables", 97.53, 14));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Services", 27.37, 14));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Health Care", 13.65, 6));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Services", 6.59, 11));
        database.savingEnvelopeDao().insert(new SavingEnvelope("n/a", 96.0, 2));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Health Care", 46398569.94, 3));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Finance", 48851966.28, 17));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Non-Durables", 16353900.16, 3));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Health Care", 45694236.39, 18));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Basic Industries", 52783769.44, 7));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Non-Durables", 77634520.76, 15));
        database.savingEnvelopeDao().insert(new SavingEnvelope("n/a", 17275536.75, 9));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Services", 11299984.15, 6));
        database.savingEnvelopeDao().insert(new SavingEnvelope("n/a", 47590794.56, 13));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Capital Goods", 11499006.08, 12));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Public Utilities", 59901953.54, 1));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Services", 58258233.43, 11));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Technology", 38690254.55, 12));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Health Care", 42585375.4, 4));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Capital Goods", 1146943.02, 14));
        database.savingEnvelopeDao().insert(new SavingEnvelope("n/a", 84267180.7, 16));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Miscellaneous", 14236368.88, 1));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Consumer Services", 74048539.02, 8));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Technology", 7129308.25, 10));
        database.savingEnvelopeDao().insert(new SavingEnvelope("Finance", 68134781.25, 1));
    }

        public static void populateTranfers(TecbankDatabase database) {
            database.proofpaymentDao().insert(new Proofpayment("GL43 3230 1472 6898 07", "GL22 1434 4379 6314 12", 11111111, 95.81, "may many details", 1, 0.0, 1));
        }

}
