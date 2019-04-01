package com.wildan.aha.smartmarket.Model;

public class Pelanggan {
    String nama, alamat, notelp, email, password;

    public Pelanggan(String nama, String alamat, String notelp, String email, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.notelp = notelp;
        this.email = email;
        this.password = password;
    }

    public Pelanggan() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
