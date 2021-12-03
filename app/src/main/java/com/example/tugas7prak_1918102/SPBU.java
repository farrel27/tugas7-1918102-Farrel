package com.example.tugas7prak_1918102;

public class SPBU {
    private String _id, _namabb, _jenisbb;
    public SPBU (String id, String namabb, String jenisbb) {
        this._id = id;
        this._namabb = namabb;
        this._jenisbb = jenisbb;
    }
    public SPBU() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_namabb() {
        return _namabb;
    }
    public void set_namabb(String _namabb) {
        this._namabb = _namabb;
    }
    public String get_jenisbb() {
        return _jenisbb;
    }
    public void set_jenisbb(String _jenisbb) {
        this._jenisbb = _jenisbb;
    }
}
