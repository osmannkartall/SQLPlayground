package com.dbproject.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stok", schema = "getir_app")
public class Stok {
    @Id
    private int ID;
    private int bayilik_id;
    private int urun_id;
    private int sayi;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBayilik_id() {
        return bayilik_id;
    }

    public void setBayilik_id(int bayilik_id) {
        this.bayilik_id = bayilik_id;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public int getSayi() {
        return sayi;
    }

    public void setSayi(int sayi) {
        this.sayi = sayi;
    }
}
