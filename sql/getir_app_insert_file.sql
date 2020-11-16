insert into getir_app.kategori values (1, "atistirmalik");
insert into getir_app.kategori values (2, "sut & kahvalti");
insert into getir_app.kategori values (3, "temel gida");
insert into getir_app.kategori values (4, "kisisel bakim");
insert into getir_app.kategori values (5, "ev bakim");

insert into getir_app.alt_kategori values (10, 1, "cikolata");
insert into getir_app.alt_kategori values (20, 1, "cips");
insert into getir_app.alt_kategori values (30, 2, "süt");
insert into getir_app.alt_kategori values (40, 3, "makarna");
insert into getir_app.alt_kategori values (50, 4, "agiz bakim");
insert into getir_app.alt_kategori values (60, 5, "bulasik");

insert into getir_app.marka values (1, "ulker");
insert into getir_app.marka values (2, "ruffles");
insert into getir_app.marka values (3, "sek");
insert into getir_app.marka values (4, "sutas");
insert into getir_app.marka values (5, "filiz");
insert into getir_app.marka values (6, "colgate");
insert into getir_app.marka values (7, "pril");

insert into getir_app.urun values (1, 1, 10, "ulker sutlu", "ulker sutlu kare cikolata", 4.70, "60 g");
insert into getir_app.urun values (2, 2, 20, "ruffles ketcapli", "ruffles ketcapli patates cipsi super boy", 5.75, "107 g");
insert into getir_app.urun values (3, 3, 30, "sek tam yagli sut", "", 6.95, "1 L");
insert into getir_app.urun values (4, 4, 30, "sutas yagli sut", "", 6.25, "1 L");
insert into getir_app.urun values (5, 5, 40, "filiz burgu", "filiz burgu makarna", 3.45, "500 g");
insert into getir_app.urun values (6, 6, 50, "colgate ekstra guc", 
	"colgate optic white extra guc, duzenli kullanim ile yuzey lekelerini yok eder.", 4.70, "60 g");
insert into getir_app.urun values (7, 7, 60, "pril limon", "", 12.95, "1350 g");

insert into getir_app.kampanya values (
	101, "GetirSu dan damacana",
	"Getir siparisinizi teslim aldiktan sonra GetirSu sekmesine giderek damacana kampanyanizi kullanabilirsiniz.",
	"Kampanya 1 kullanim icin gecerlidir.",
	null
);

insert into getir_app.kampanya values (
	102, "Vespa kazanma sansi",
	"Kampanyadan yararlanmak icin en az 15 tl degerinde Cornetto urununu sepetinize eklemelisiniz.",
	"Kampanya 1 kullanim icin gecerlidir.",
	null
);

insert into getir_app.duyuru values (
	11, "20 tl indirim sansi",
	"Getir HUAWEI App galery..."
);

insert into getir_app.kullanici values(1001, "osman", "kartal", "555 555 55 55", "mail@mail.com", "passworddd");
insert into getir_app.kullanici values(1003, "ali", "kartal", "000 555 55 55", "ali@gmail.com", "ali1234");

insert into getir_app.kart values(45, 1001, "osman kartal", "1111 1111 1111 1111", "2025-12-01");
insert into getir_app.kart values(66, 1003, "ali kartal", "0000 1111 1111 1111", "2020-12-01");

insert into getir_app.siparis values(75, 1001, 45, 15.15, "2020-07-01");
insert into getir_app.siparis values(79, 1001, 45, 20.85, "2020-07-01");

insert into getir_app.sepet values(75, 1, 2);
insert into getir_app.sepet values(75, 2, 1);
insert into getir_app.sepet values(79, 1, 1);
insert into getir_app.sepet values(79, 2, 1);
insert into getir_app.sepet values(79, 3, 1);
insert into getir_app.sepet values(79, 5, 1);

insert into getir_app.bayilik values(999, "Dudullu");
insert into getir_app.bayilik values(44, "Sekerpinar");

insert into getir_app.stok values(1, 44, 1, 150);
insert into getir_app.stok values(2, 44, 2, 200);
insert into getir_app.stok values(3, 44, 3, 20);
insert into getir_app.stok values(4, 44, 5, 100);
insert into getir_app.stok values(5, 44, 7, 0);
insert into getir_app.stok values(6, 999, 1, 550);
insert into getir_app.stok values(7, 999, 2, 340);

insert into getir_app.adres values(1, "kocaeli", "sekerpinar", "cadde1", "sokak1", 5, 2, "ev");
insert into getir_app.adres values(2, "istanbul", "kucukyalı", "su", "uzun", 120, 15, "is");
insert into getir_app.adres values(3, "kocaeli", "sekerpinar", "pamuk", "seker", 15, null, "diger");
insert into getir_app.adres values(4, "istanbul", "dudullu", "ses", "sarı", 23, null, "diger");

insert into getir_app.adres_bayilik values(44, 3);
insert into getir_app.adres_bayilik values(999, 4);

insert into getir_app.adres_kullanici values(1001, 1);
insert into getir_app.adres_kullanici values(1003, 2);

insert into getir_app.bayilik_kullanici values(1001, 44);
insert into getir_app.bayilik_kullanici values(1003, 999);

# VIEWS
# -----
create view kullanici_bilgisi as select id, isim, soyisim, telefon, mail from kullanici;
create view urun_isim_fiyat as select id, isim, fiyat from urun;
create view siparis_kartsiz as select id, kullanici_id, sepet_tutari, siparis_tarihi from siparis;
create view stok_urun_sayisi as select id, urun_id, sayi from stok;
# Burada baska bir view kullanip ondan da view olusturabilecegimizi test ettik.
create view siparis_kullanici as select id, kullanici_id from siparis_kartsiz;

# TRIGGERS
# --------
