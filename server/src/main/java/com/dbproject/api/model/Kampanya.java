package com.dbproject.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kampanya", schema = "getir_app")
public class Kampanya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String baslik;
    private String aciklama;
    private String kosul;
    private Date gecerli_sure;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getKosul() {
        return kosul;
    }

    public void setKosul(String kosul) {
        this.kosul = kosul;
    }

    public Date getGecerli_sure() {
        return gecerli_sure;
    }

    public void setGecerli_sure(Date gecerli_sure) {
        this.gecerli_sure = gecerli_sure;
    }
}
