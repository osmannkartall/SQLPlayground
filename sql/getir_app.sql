# SCHEMA(or DATABASE)
# -------------------
create schema if not exists getir_app;

# TABLES
# ------
create table getir_app.kullanici (
	id      int,
	isim    varchar(20) not null,
	soyisim varchar(20) not null,
	telefon varchar(20),
	mail    varchar(255),
	parola  varchar(255),
	
	primary key (id)
);

create table getir_app.kart (
	id           int,
	kullanici_id int,
	kart_isim    varchar(45),
	kart_no      varchar(20),
	son_kullanma date,
	
	primary key (id),
	foreign key (kullanici_id) references kullanici(id)
		on delete set null
);

create table getir_app.siparis (
	id             int,
	kullanici_id   int,
	kart_id        int,
	sepet_tutari   decimal(8,2) not null,
	siparis_tarihi datetime,
	
	primary key (id),
	foreign key (kullanici_id) references kullanici(id)
		on delete set null,
	foreign key (kart_id) references kart(id)
		on delete set null
);

create table getir_app.kategori (
	id   int,
	isim varchar(20) not null,
	
	primary key (id)
);

create table getir_app.alt_kategori (
	id          int,
	kategori_id int,
	isim        varchar(20) not null,
	
	primary key (id),
	foreign key (kategori_id) references kategori(id)
		on delete set null
);

create table getir_app.marka (
	id   int,
	isim varchar(20) not null,
	
	primary key (id)
);

create table getir_app.urun (
	id              int,
	marka_id        int,
	alt_kategori_id int,
	isim            varchar(20) not null,
	aciklama        varchar(255),
	fiyat           decimal(8,2) not null,
	birim           varchar(20),
	
	primary key (id),
	foreign key (marka_id) references marka(id)
		on delete set null,
	foreign key (alt_kategori_id) references alt_kategori(id)
		on delete set null
);

create table getir_app.bayilik (
	id   int,
	isim varchar(20) not null,
	
	primary key (id)
);

create table getir_app.stok (
	id         int,
	bayilik_id int,
	urun_id    int,
	sayi       decimal(4),
	
	primary key (id),
	foreign key (bayilik_id) references bayilik(id)
		on delete set null,
	foreign key (urun_id) references urun(id)
		on delete set null
);

create table getir_app.kurye (
	id         int,
	bayilik_id int,
	isim       varchar(20) not null,
	soyisim    varchar(20) not null,
	telefon    varchar(20),

	primary key (id),
	foreign key (bayilik_id) references bayilik(id)
		on delete set null
);

create table getir_app.adres (
	id    int,
	il    varchar(20) not null,
	ilce  varchar(20) not null,
	cadde varchar(20) not null,
	sokak varchar(20) not null,
	no    numeric(3) not null,
	daire numeric(3),
	tip   enum('ev', 'is', 'diger') default NULL,

	primary key (id)
);

create table getir_app.adres_kullanici (
	kullanici_id int not null,
	adres_id     int not null,
	
	primary key (kullanici_id, adres_id),
	foreign key (kullanici_id) references kullanici(id),
	foreign key (adres_id) references adres(id)
);

create table getir_app.adres_bayilik (
	bayilik_id int not null,
	adres_id   int not null,
	
	primary key (bayilik_id, adres_id),
	foreign key (adres_id) references adres(id)
);

create table getir_app.bayilik_kullanici (
	kullanici_id int not null,
	bayilik_id   int not null,
	
	primary key (kullanici_id, bayilik_id),
	foreign key (kullanici_id) references kullanici(id),
	foreign key (bayilik_id) references bayilik(id)
);

create table getir_app.kampanya (
	id           int,
	baslik       varchar(20) not null,
	aciklama     varchar(255),
	kosul        varchar(255),
	gecerli_sure datetime,

	primary key (id)
);

create table getir_app.duyuru (
	id           int,
	baslik       varchar(20) not null,
	aciklama     varchar(255),

	primary key (id)
);

create table getir_app.sepet (
	siparis_id int not null,
	urun_id    int not null,
	adet       decimal(2),
	
	primary key (siparis_id, urun_id),
	foreign key (siparis_id) references siparis(id),
	foreign key (urun_id) references urun(id)
);