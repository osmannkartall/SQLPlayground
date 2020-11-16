/*
 *	Stok tablosundaki sayı alanı güncellenirken negatif sayi veya null
 *	girilmişse sayi alanı olduğu gibi kalır.
 */
drop trigger if exists stok_sayi_guncelleme;

DELIMITER $$
create trigger stok_sayi_guncelleme before update on stok
for each row
	begin
		if (new.sayi is null or new.sayi < 0) then
			set new.sayi = old.sayi;
		end if;
	end$$
DELIMITER ;
# test
update stok set sayi=-5 where id=1;
update stok set sayi=null where id=1;

/*
 *  Sepet tablosuna bir kayıt eklenmeden önce ilgili ürünün Stok tablosundaki
 *	sayısı sepet tablosundaki ürün adetinden fazla veya aynı sayıda olmalıdır.
 *	bayilik_kullanici tablosundan kullanici hangi bayilik ile iliskilisi ise
 *	ona ulasilip o bayiligin stogunda bu urunden kac tane olduguna bakilir.
 *	Ayrica, yeni kayittaki adet sayisi pozitif degilse ekleme yapilmamali.
 */
drop trigger if exists sepete_ekle_once;

DELIMITER $$
create trigger sepete_ekle_once before insert on sepet
for each row
	begin
		# urune ait stoklardaki toplam sayi
		set @toplam_stok = (select stok.sayi from stok 
							where stok.bayilik_id in (
								select bayilik_kullanici.bayilik_id 
								from bayilik_kullanici
								where bayilik_kullanici.kullanici_id in (
									select siparis.kullanici_id 
									from siparis 
									where siparis.id = new.siparis_id
								)
							) and stok.urun_id = new.urun_id);
		if new.adet <= 0 or @toplam_stok < new.adet then
			set new.siparis_id = null;
		end if;
	end$$
DELIMITER ;
# test
insert into sepet values(75, 3, 44);
insert into sepet values(75, 3, -12);
# Bu out of range hatası verir cunku adet field'ını 2 basamaklı tanımladık.
insert into sepet values(75, 3, 441);

/*
 * Sepete bir sipariste bulunan urun eklendigi zaman siparis tablosundaki bu
 * siparisin sepet_tutarı alanina yeni urunun fiyatı adet sayisi ile carpilarak
 * eklenir.
 * Urun, sepete eklendikten sonra ilgili bayiligin stogunda azaltması yapılır.
 */
drop trigger if exists sepete_ekle_sonra;
DELIMITER $$
create trigger sepete_ekle_sonra after insert on sepet
for each row
	begin
		declare urun_fiyati int;
		declare toplam_stok int;

		select fiyat into @urun_fiyati from urun 
		where id in (select urun_id from sepet where urun_id = new.urun_id);
		
		update siparis set sepet_tutari = sepet_tutari + @urun_fiyati * new.adet
		where id = new.siparis_id;
		
		select stok.sayi into @toplam_stok from stok 
		where stok.bayilik_id in (
			select bayilik_kullanici.bayilik_id 
			from bayilik_kullanici
			where bayilik_kullanici.kullanici_id in (
				select siparis.kullanici_id 
				from siparis 
				where siparis.id = new.siparis_id
			)
		) and stok.urun_id = new.urun_id;

		update stok set sayi = @toplam_stok - new.adet
		where stok.bayilik_id in (
			select bayilik_kullanici.bayilik_id 
			from bayilik_kullanici
			where bayilik_kullanici.kullanici_id in (
				select siparis.kullanici_id 
				from siparis 
				where siparis.id = new.siparis_id
			)
		) and stok.urun_id = new.urun_id;
		
	end$$
DELIMITER $$
# test
insert into sepet values(75, 3, 2);

/*
 * Bir siparise ait urun sepetten silinirse bu durumda siparis_tutari da
 * guncellenir, sepet_tutari azaltilir.
 * Urun sepetten silindikten sonra da ilgili bayiligin stogunda attırmasi olur.
 */
drop trigger if exists sepetten_sil_sonra;
DELIMITER $$
create trigger sepetten_sil_sonra after delete on sepet
for each row
	begin
		declare urun_fiyati int;
		declare toplam_stok int;

		select fiyat into @urun_fiyati from urun where id in (select urun_id from sepet where urun_id = old.urun_id);
		update siparis set sepet_tutari = sepet_tutari - @urun_fiyati * old.adet where id = old.siparis_id;
		
		select stok.sayi into @toplam_stok from stok 
		where stok.bayilik_id in (
			select bayilik_kullanici.bayilik_id 
			from bayilik_kullanici
			where bayilik_kullanici.kullanici_id in (
				select siparis.kullanici_id 
				from siparis 
				where siparis.id = old.siparis_id
			)
		) and stok.urun_id = old.urun_id;

		update stok set sayi = @toplam_stok + old.adet
		where stok.bayilik_id in (
			select bayilik_kullanici.bayilik_id 
			from bayilik_kullanici
			where bayilik_kullanici.kullanici_id in (
				select siparis.kullanici_id 
				from siparis 
				where siparis.id = old.siparis_id
			)
		) and stok.urun_id = old.urun_id;
		
	end$$
DELIMITER $$
# test
# TODO: bunu sadece id yi silerek yapman icin degistirmen lazim.
delete from sepet where siparis_id=75 and urun_id=3 and adet=2;

/*
 *	Bir kullanıcı tablosundaki kayıt silinmeden önce Kart, Siparis,
 *	Adres_Kullanici ve Adres tablosunda bu kullanıcıya ait olan
 *	kayıtlar da silinir.
 */
drop trigger if exists kullanici_silme;

DELIMITER $$
create trigger kullanici_silme before delete on kullanici
for each row
	begin
		# adres kullanicidan kullanici_id ye ait adresi al sonra da o adres_id ye ait adresi sil.
		set @adresler = (select adres_id from adres_kullanici where OLD.id = adres_kullanici.kullanici_id);
		
		delete from adres_kullanici where OLD.id=adres_kullanici.kullanici_id;
		delete from bayilik_kullanici where OLD.id=bayilik_kullanici.kullanici_id;
		
		delete adr.* from adres adr
		where adr.id in (@adresler);
		
		delete from siparis where OLD.id=siparis.kullanici_id;    
		delete from kart where OLD.id=kart.kullanici_id;
	end$$
DELIMITER ;
# test
delete from kullanici where kullanici.id = 1003;
# Bu data'ları trigger testinden sonra tekrar ekle cunku kullanacagiz.
insert into getir_app.kullanici values(1003, "ali", "kartal", "000 555 55 55", "ali@gmail.com", "ali1234");
insert into getir_app.adres values(2, "istanbul", "kucukyalı", "su", "uzun", 120, 15, "is");
insert into getir_app.adres_kullanici values(1003, 2);
insert into getir_app.bayilik_kullanici values(1003, 999);
insert into getir_app.kart values(66, 1003, "ali kartal", "0000 1111 1111 1111", "2020-12-01");