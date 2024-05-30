package com.example.modul8_restapi;

public class User {
    private int id;
    private String name;
    private String email;
    private String agama;
    private String nohp;
    private String alamat;

    public User(String name, String email, String agama, String nohp, String alamat) {
        this.name = name;
        this.email = email;
        this.agama = agama;
        this.nohp = nohp;
        this.alamat = alamat;    }

    public int getId() {  return id;    }

    public String getName() { return name;    }

    public String getEmail() { return email;    }
    public String getAgama() { return agama;    }
    public String getNohp() { return nohp;    }
    public String getAlamat() { return alamat;    }
}
