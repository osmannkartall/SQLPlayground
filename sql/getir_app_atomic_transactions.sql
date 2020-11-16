# start transaction atomic olarak gerçekleşir.

/*
 * Ayni anda hem marka, hem de kategori ekleme.
 */
START TRANSACTION;
insert into getir_app.marka values (8, "coca cola");
insert into getir_app.kategori values (6, "su ve icecek");
COMMIT;

# Kontrol et
select * from marka;
select * from kategori;

# Eski haline dondur.
delete from getir_app.marka where id=8;
delete from getir_app.kategori where id=6;

/*
 * Bir bayinin stogundaki urunun yarisini alip baska bayiye goturme.
 */
START TRANSACTION;
set @bayilik1_id = 44;
set @bayilik2_id = 999;
set @urun_sayisi = 50;
set @urun_id = 5;

update stok set stok.sayi = stok.sayi - @urun_sayisi
where stok.urun_id = @urun_id and stok.bayilik_id = @bayilik1_id;
insert into stok values(10, @bayilik2_id, @urun_id, @urun_sayisi);
COMMIT;

# Kontrol et
select * from stok
where stok.urun_id = 5 and (stok.bayilik_id = 44 or stok.bayilik_id = 999);

# Eski haline dondur.
update stok set stok.sayi = stok.sayi + 50
where stok.urun_id = 5 and stok.bayilik_id = 44;
delete from stok where stok.bayilik_id=999 and stok.urun_id=5;

/*
 * siparis_tutari karistirilan iki siparisin switch edilmesi
 */
START TRANSACTION;
set @siparis1_id = 75;
set @siparis2_id = 79;
set @sepet_tutari1 = (select sepet_tutari from siparis where id = @siparis1_id);
set @sepet_tutari2 = (select sepet_tutari from siparis where id = @siparis2_id);

update siparis set sepet_tutari = @sepet_tutari2
where id = @siparis1_id;
update siparis set sepet_tutari = @sepet_tutari1
where id = @siparis2_id;
COMMIT;

# Kontrol et
select * from siparis;

# Eski haline dondur.
# Transaction'ı tekrar calistirinca eski haline doner.