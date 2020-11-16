package com.dbproject.api.model;

import java.io.Serializable;
import java.util.Objects;

public class SepetId implements Serializable {
    private int siparis_id;
    private int urun_id;

    public SepetId() {
    }

    public SepetId(int siparis_id, int urun_id) {
        this.siparis_id = siparis_id;
        this.urun_id = urun_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SepetId sepetId = (SepetId) o;
        return siparis_id == sepetId.siparis_id &&
                urun_id == sepetId.urun_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(siparis_id, urun_id);
    }
}
