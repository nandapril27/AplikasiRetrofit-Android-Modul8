package com.example.modul8_restapi;
import com.google.gson.annotations.SerializedName;
public class User {
    private int id;
    private String name;
    private String email;
    private String agama;
    private String nohp;
    private String alamat;
    public User(int id, String name, String email, String agama, String nohp, String alamat) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.agama = agama;
        this.nohp = nohp;
        this.alamat = alamat;    }
    public User(String name, String email, String agama, String nohp, String alamat) {
        this.name = name;
        this.email = email;
        this.agama = agama;
        this.nohp = nohp;
        this.alamat = alamat;    }


    //getter
    public int getId() {  return id;    }
    public String getName() { return name;    }
    public String getEmail() { return email;    }
    public String getAgama() { return agama;    }
    public String getNohp() { return nohp;    }
    public String getAlamat() { return alamat;    }

    //setter
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) { this.email = email;}
    public void setAgama(String agama) {
        this.agama = agama;
    }
    public void setNohp(String nohp) { this.nohp = nohp;}
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
