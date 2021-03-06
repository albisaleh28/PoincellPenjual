package com.example.poincellpenjual.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Konsumen implements Parcelable {

    private String id;
    private String nama_konsumen;
    private String no_telepon_konsumen;
    private String alamat_konsumen;
    private String email_konsumen;
    private String poin_konsumen;


    public String getId() {
        return id;
    }

    public String getNama_konsumen() {
        return nama_konsumen;
    }

    public String getNo_telepon_konsumen() {
        return no_telepon_konsumen;
    }

    public String getAlamat_konsumen() {
        return alamat_konsumen;
    }

    public String getEmail_konsumen() {
        return email_konsumen;
    }

    public String getPoin_konsumen() {
        return poin_konsumen;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama_konsumen(String nama_konsumen) {
        this.nama_konsumen = nama_konsumen;
    }

    public void setNo_telepon_konsumen(String no_telepon_konsumen) {
        this.no_telepon_konsumen = no_telepon_konsumen;
    }

    public void setAlamat_konsumen(String alamat_konsumen) {
        this.alamat_konsumen = alamat_konsumen;
    }

    public void setEmail_konsumen(String email_konsumen) {
        this.email_konsumen = email_konsumen;
    }

    public void setPoin_konsumen(String poin_konsumen) {
        this.poin_konsumen = poin_konsumen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Konsumen() {
    }

    private Konsumen(Parcel in) {
        this.nama_konsumen = in.readString();
        this.alamat_konsumen = in.readString();
        this.id = in.readString();
        this.email_konsumen = in.readString();
        this.no_telepon_konsumen = in.readString();
        this.poin_konsumen = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.id);
        dest.writeString(this.nama_konsumen);
        dest.writeString(this.email_konsumen);
        dest.writeString(this.no_telepon_konsumen);
        dest.writeString(this.alamat_konsumen);
        dest.writeString(this.poin_konsumen);

    }

    public static final Parcelable.Creator<Konsumen> CREATOR = new Parcelable.Creator<Konsumen>() {
        @Override
        public Konsumen createFromParcel(Parcel source) {
            return new Konsumen(source);
        }

        @Override
        public Konsumen[] newArray(int size) {
            return new Konsumen[size];
        }
    };
}
