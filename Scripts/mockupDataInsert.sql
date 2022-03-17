-- Insert Mockup Data

-- bank
insert into bank (id, name, code) values (1, 'D''Amore and Sons', 'CYBR');
insert into bank (id, name, code) values (2, 'Leuschke, Harvey and Schulist', 'PTIE');
insert into bank (id, name, code) values (3, 'Bechtelar-Kuphal', 'SYNA');
insert into bank (id, name, code) values (4, 'Macejkovic Inc', 'DYN.WS');
insert into bank (id, name, code) values (5, 'Block, Mosciski and Streich', 'NEE');
insert into bank (id, name, code) values (6, 'Sporer-Christiansen', 'WHLRD');
insert into bank (id, name, code) values (7, 'Mraz Inc', 'FRTA');
insert into bank (id, name, code) values (8, 'Anderson, Hoppe and Klocko', 'VZ');
insert into bank (id, name, code) values (9, 'Cremin-O''Hara', 'DMB');
insert into bank (id, name, code) values (10, 'Botsford LLC', 'PCSB');
insert into bank (id, name, code) values (11, 'Dare, Nitzsche and Greenholt', 'ENB');
insert into bank (id, name, code) values (12, 'Lemke, Bashirian and Conn', 'GSL^B');
insert into bank (id, name, code) values (13, 'Sanford Inc', 'OMAM');
insert into bank (id, name, code) values (14, 'Waters-Hermann', 'AVAV');
insert into bank (id, name, code) values (15, 'Beahan-Koelpin', 'WHFBL');
insert into bank (id, name, code) values (16, 'Jast, McKenzie and Boyer', 'TJX');
insert into bank (id, name, code) values (17, 'Pfannerstill Inc', 'BPL');
insert into bank (id, name, code) values (18, 'Marvin, Thompson and Koch', 'GIL');
insert into bank (id, name, code) values (19, 'Fisher Inc', 'GBX');
insert into bank (id, name, code) values (20, 'Erdman-Doyle', 'AVD');
insert into bank (id, name, code) values (21, 'TECBANK', 'TCBK');

-- location

insert into location (id, coordinates, name, schedule) values (1, '36.1899557, 117.1168644', 'Hucheng', '10:49 AM');
insert into location (id, coordinates, name, schedule) values (2, '34.145966, 105.757408', 'Xiongbei', '2:06 AM');
insert into location (id, coordinates, name, schedule) values (3, '27.5277132, 57.8651371', 'Qal‘eh Ganj', '1:54 PM');
insert into location (id, coordinates, name, schedule) values (4, '7.9500846, -75.3594016', 'Montelíbano', '1:25 PM');
insert into location (id, coordinates, name, schedule) values (5, '38.052038, 114.466022', 'Shuiyuan', '11:39 AM');
insert into location (id, coordinates, name, schedule) values (6, '9.834832, -75.120521', 'San Jacinto', '6:12 PM');
insert into location (id, coordinates, name, schedule) values (7, '-7.4104934, 110.3279026', 'Ketawang', '8:55 AM');

-- tecbank
-- (id: 1, bank_id: 21 - TECBANK, location_id: 1 - Hucheng)
insert into tec_bank (id, bank_id, location_id) values (1, 21, 1);

-- user

insert into user (id, email, password, name, last_name, bank_id, user_name) values (1, 'lwarhurst0@dailymotion.com', 'Xmj9QM74', 'Loren', 'Warhurst', '21', 'lwarhurst0');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (2, 'eflorentine1@disqus.com', 'Mmp7jjbdJLM', 'Eudora', 'Florentine', '21', 'eflorentine1');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (3, 'meastgate2@bandcamp.com', '4KTm1GjBgNR', 'Margit', 'Eastgate', '21', 'meastgate2');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (4, 'gguitton3@techcrunch.com', 'llbvlaFnvF', 'Grace', 'Guitton', '21', 'gguitton3');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (5, 'mtommei4@youtu.be', 'UGLZJo', 'Myra', 'Tommei', '21', 'mtommei4');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (6, 'cdils5@infoseek.co.jp', '8nXYbz', 'Celka', 'Dils', '21', 'cdils5');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (7, 'bismirnioglou6@google.pl', 'D61Wsa', 'Berkley', 'Ismirnioglou', '21', 'bismirnioglou6');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (8, 'pthresher7@fotki.com', '00B5qKE7f7X', 'Papageno', 'Thresher', '21', 'pthresher7');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (9, 'carmfirld8@prlog.org', '8jRT4LTqgxah', 'Carine', 'Armfirld', '21', 'carmfirld8');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (10, 'shallagan9@mapy.cz', 'UIeRmioCBV', 'Sophie', 'Hallagan', '21', 'shallagan9');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (11, 'sflorioa@springer.com', 'p5HQXKvwjh', 'Sherman', 'Florio', '21', 'sflorioa');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (12, 'ejakobssenb@shinystat.com', '25NbGY', 'Eartha', 'Jakobssen', '21', 'ejakobssenb');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (13, 'fworpolec@sbwire.com', '59VHrBn', 'Fifi', 'Worpole', '21', 'fworpolec');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (14, 'tmontezd@nymag.com', 'HgJBHrkiO4j', 'Thorin', 'Montez', '21', 'tmontezd');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (15, 'vfarfulle@yahoo.com', 'hqaFqwM', 'Valerye', 'Farfull', '21', 'vfarfulle');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (16, 'dhedditchf@wsj.com', '8h7FuqUaqOL', 'Dill', 'Hedditch', '21', 'dhedditchf');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (17, 'dollisg@state.tx.us', 'taJLhmczY', 'Derby', 'Ollis', '21', 'dollisg');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (18, 'oraddinh@sbwire.com', 'EY5vuykOWWn', 'Otes', 'Raddin', '21', 'oraddinh');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (19, 'mvalleryi@ibm.com', 'jrK27oTJSX', 'Malcolm', 'Vallery', '21', 'mvalleryi');
insert into user (id, email, password, name, last_name, bank_id, user_name) values (20, 'htitchmarshj@sakura.ne.jp', '4XeCB8', 'Herman', 'Titchmarsh', '21', 'htitchmarshj');

-- account

insert into account (id, account_number, current_balance, user_id) values ('6373287268972683', 'GI66 PZCC UJWW T96J ZMNW VJU', 76865750.91, 17);
insert into account (id, account_number, current_balance, user_id) values ('5602235307003536', 'FI16 4979 4957 1008 02', 13545097.99, 3);
insert into account (id, account_number, current_balance, user_id) values ('5363983708611709', 'GT77 OMV6 OQG5 WDBM 1S6Y SSYA UYL2', 66579668.56, 13);
insert into account (id, account_number, current_balance, user_id) values ('3554690371086465', 'FR40 3271 8195 78PA KVGL XQF4 O46', 36050194.13, 12);
insert into account (id, account_number, current_balance, user_id) values ('5610557073770943', 'ES28 3202 9155 0401 8525 9455', 24299518.31, 17);
insert into account (id, account_number, current_balance, user_id) values ('3575046750673719', 'ES33 7657 3652 9965 3106 1744', 17066648.13, 9);
insert into account (id, account_number, current_balance, user_id) values ('3557938444379434', 'GT52 NOWV JSH0 KAJN MM39 B97W 6TKT', 43592631.25, 18);
insert into account (id, account_number, current_balance, user_id) values ('560223538056246047', 'SI18 3470 7257 5198 550', 76816874.01, 16);
insert into account (id, account_number, current_balance, user_id) values ('201991184036611', 'FR50 7167 8015 10O4 GWOU PYWZ C95', 79101147.03, 15);
insert into account (id, account_number, current_balance, user_id) values ('4175009884805716', 'MK43 158L 0ZAX UT0L 761', 88103629.05, 7);
insert into account (id, account_number, current_balance, user_id) values ('3544526425305555', 'FR42 7144 2550 22DH UH9N JPPX 050', 62145221.18, 4);
insert into account (id, account_number, current_balance, user_id) values ('5602218991540141013', 'ME29 2139 5392 9121 2826 49', 40400460.26, 13);
insert into account (id, account_number, current_balance, user_id) values ('36455289661492', 'GL43 3230 1472 6898 07', 94360557.99, 1);
insert into account (id, account_number, current_balance, user_id) values ('4026980823037440', 'FR72 2445 0784 025I IRXU IW3G E70', 86993624.31, 16);
insert into account (id, account_number, current_balance, user_id) values ('3537671150985822', 'FR80 3288 5546 79GQ LAZF A4OJ 224', 79022515.78, 19);
insert into account (id, account_number, current_balance, user_id) values ('3552884325382656', 'DO28 19WN 0980 4683 8782 1282 4946', 25451284.55, 11);
insert into account (id, account_number, current_balance, user_id) values ('4903551927547259', 'VG36 BCWD 3153 0480 9201 3929', 97875559.42, 12);
insert into account (id, account_number, current_balance, user_id) values ('3541579985504094', 'SI98 3744 5820 8338 821', 86678277.88, 6);
insert into account (id, account_number, current_balance, user_id) values ('5407138336518044', 'PS30 YQOP TFPV EVGZ EPQG AFQT TFWV K', 23159379.86, 11);
insert into account (id, account_number, current_balance, user_id) values ('3561483049237012', 'RS81 1807 1182 7958 8052 88', 46001048.66, 3);
insert into account (id, account_number, current_balance, user_id) values ('3573463484454815', 'RS66 8896 8780 6860 0129 80', 73122056.32, 1);
insert into account (id, account_number, current_balance, user_id) values ('3587899848062022', 'GE12 TQ77 7812 4232 1363 72', 26567377.05, 1);
insert into account (id, account_number, current_balance, user_id) values ('3535939865599895', 'VG64 WCQC 9374 1580 9318 4843', 58031887.53, 16);
insert into account (id, account_number, current_balance, user_id) values ('3546713666470524', 'CY21 4005 7284 ATKO CLOO TDYK ZIAQ', 19036548.52, 8);
insert into account (id, account_number, current_balance, user_id) values ('3563996968891012', 'AT57 3714 5334 9016 6560', 65043254.71, 15);
insert into account (id, account_number, current_balance, user_id) values ('5010126639306240', 'SM51 F433 5292 6500 XFCF GOWY QSD', 6646669.0, 7);
insert into account (id, account_number, current_balance, user_id) values ('3566715146372068', 'SK28 4884 2055 6280 1104 3543', 53558357.66, 12);
insert into account (id, account_number, current_balance, user_id) values ('36443549457620', 'DE15 1707 6290 7636 0345 61', 55279775.39, 8);
insert into account (id, account_number, current_balance, user_id) values ('344921542730736', 'SK13 2854 3884 2530 5430 3115', 31528625.57, 15);
insert into account (id, account_number, current_balance, user_id) values ('3560693567091234', 'KW67 MTAW XI8X INN7 UBLZ XGS5 GMRR TO', 201372.28, 8);
insert into account (id, account_number, current_balance, user_id) values ('3561740388720951', 'GL22 1434 4379 6314 12', 98787435.21, 3);
insert into account (id, account_number, current_balance, user_id) values ('5641820936372890', 'EE91 7062 9307 3704 9547', 53638497.2, 17);
insert into account (id, account_number, current_balance, user_id) values ('5593674013412147', 'FI59 8871 7714 6302 81', 16477199.59, 8);
insert into account (id, account_number, current_balance, user_id) values ('67636668178412800', 'LT08 6502 2430 5045 5691', 74137800.67, 14);
insert into account (id, account_number, current_balance, user_id) values ('30520182274820', 'AL29 6299 1736 M0HJ AK6I ZAW0 J38V', 53980651.01, 9);
insert into account (id, account_number, current_balance, user_id) values ('3549205353130963', 'HR67 5964 8951 9134 2131 6', 2.41, 4);
insert into account (id, account_number, current_balance, user_id) values ('3563323346098311', 'GE53 BG11 0684 9521 3600 45', 32.81, 20);
insert into account (id, account_number, current_balance, user_id) values ('67712007100577835', 'ES76 1685 2192 7168 0616 6926', 73.53, 8);
insert into account (id, account_number, current_balance, user_id) values ('3538339348953156', 'SA42 86P8 JGWV HNPJ LP1J YYUX', 22.87, 14);
insert into account (id, account_number, current_balance, user_id) values ('3563896369370972', 'LT73 9598 0727 9727 7800', 49.17, 8);
insert into account (id, account_number, current_balance, user_id) values ('67719180703948068', 'TR13 6120 0PDK XZA2 MHD7 XVNQ T9', 44.1, 10);
insert into account (id, account_number, current_balance, user_id) values ('3566512197097540', 'LB41 1944 PGTM JQA0 V5F6 8VNQ XAW5', 66.17, 8);
insert into account (id, account_number, current_balance, user_id) values ('6304433818849393', 'AL93 7299 5050 PJ5D 9BIF G4DN DGQH', 50.2, 11);
insert into account (id, account_number, current_balance, user_id) values ('6767678022371713', 'SA35 82P2 W7YQ 46UE K1TI PC9D', 15.36, 17);
insert into account (id, account_number, current_balance, user_id) values ('3583894737901889', 'MK88 273V JXAV CIGI F62', 18.71, 3);

-- saving_envelopes

insert into saving_envelope (id, name, current_balance, account_id) values (1, 'Health Care', 85.7, 15);
insert into saving_envelope (id, name, current_balance, account_id) values (2, 'n/a', 95.81, 14);
insert into saving_envelope (id, name, current_balance, account_id) values (3, 'Consumer Durables', 38.07, 11);
insert into saving_envelope (id, name, current_balance, account_id) values (4, 'Energy', 63.26, 9);
insert into saving_envelope (id, name, current_balance, account_id) values (5, 'Consumer Services', 54.37, 20);
insert into saving_envelope (id, name, current_balance, account_id) values (6, 'Consumer Non-Durables', 97.53, 14);
insert into saving_envelope (id, name, current_balance, account_id) values (7, 'Consumer Services', 27.37, 14);
insert into saving_envelope (id, name, current_balance, account_id) values (8, 'Health Care', 13.65, 6);
insert into saving_envelope (id, name, current_balance, account_id) values (9, 'Consumer Services', 6.59, 11);
insert into saving_envelope (id, name, current_balance, account_id) values (10, 'n/a', 96.0, 2);
insert into saving_envelope (id, name, current_balance, account_id) values (11, 'Health Care', 46398569.94, 3);
insert into saving_envelope (id, name, current_balance, account_id) values (12, 'Finance', 48851966.28, 17);
insert into saving_envelope (id, name, current_balance, account_id) values (13, 'Consumer Non-Durables', 16353900.16, 3);
insert into saving_envelope (id, name, current_balance, account_id) values (14, 'Health Care', 45694236.39, 18);
insert into saving_envelope (id, name, current_balance, account_id) values (15, 'Basic Industries', 52783769.44, 7);
insert into saving_envelope (id, name, current_balance, account_id) values (16, 'Consumer Non-Durables', 77634520.76, 15);
insert into saving_envelope (id, name, current_balance, account_id) values (17, 'n/a', 17275536.75, 9);
insert into saving_envelope (id, name, current_balance, account_id) values (18, 'Consumer Services', 11299984.15, 6);
insert into saving_envelope (id, name, current_balance, account_id) values (19, 'n/a', 47590794.56, 13);
insert into saving_envelope (id, name, current_balance, account_id) values (20, 'Capital Goods', 11499006.08, 12);
insert into saving_envelope (id, name, current_balance, account_id) values (21, 'Public Utilities', 59901953.54, 1);
insert into saving_envelope (id, name, current_balance, account_id) values (22, 'Consumer Services', 58258233.43, 11);
insert into saving_envelope (id, name, current_balance, account_id) values (23, 'Technology', 38690254.55, 12);
insert into saving_envelope (id, name, current_balance, account_id) values (24, 'Health Care', 42585375.4, 4);
insert into saving_envelope (id, name, current_balance, account_id) values (25, 'Capital Goods', 1146943.02, 14);
insert into saving_envelope (id, name, current_balance, account_id) values (26, 'n/a', 84267180.7, 16);
insert into saving_envelope (id, name, current_balance, account_id) values (27, 'Miscellaneous', 14236368.88, 1);
insert into saving_envelope (id, name, current_balance, account_id) values (28, 'Consumer Services', 74048539.02, 8);
insert into saving_envelope (id, name, current_balance, account_id) values (29, 'Technology', 7129308.25, 10);
insert into saving_envelope (id, name, current_balance, account_id) values (30, 'Finance', 68134781.25, 1);


