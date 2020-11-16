select kullanici.id, kullanici.isim, kart.kart_no from kullanici
inner join kart
on kullanici.id = kart.kullanici_id;

select urun.isim from urun
where urun.id in 
(select stok.urun_id from stok where stok.sayi >= 100 and stok.bayilik_id = 44);

update urun set urun.isim = "ulker suuuuutlu" where urun.id = 1;

insert into duyuru values(111, "baslik2", "aciklama2");
delete from duyuru where id=111;

# views
select * from kullanici_bilgisi;
select * from siparis_kartsiz;
select * from siparis_kullanici;
select * from stok_urun_sayisi;
select * from urun_isim_fiyat;