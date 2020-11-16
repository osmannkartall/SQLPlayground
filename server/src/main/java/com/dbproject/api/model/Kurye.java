package com.dbproject.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kurye", schema = "getir_app")
public class Kurye {
    @Id
    private int ID;
    private int bayilik_id;
    private String isim;
    private String soyisim;
    private String telefon;

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

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
