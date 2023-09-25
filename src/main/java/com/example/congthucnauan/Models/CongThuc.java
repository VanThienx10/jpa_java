package com.example.congthucnauan.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "congthuc")
public class CongThuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ct")
    private int id_ct;
    @Column(name = "soluong")

    private int soluong;
    @Column(name = "donvitinh")

    private String donvitinh;


    @ManyToOne
    @JoinColumn(name = "id_ma",foreignKey = @ForeignKey(name = "fk_congthuc_monan"))
    @JsonIgnoreProperties(value = "congThucs")
    private MonAn monAn;


    @ManyToOne
    @JoinColumn(name = "id_nl",foreignKey = @ForeignKey(name = "fk_congthuc_nguyenlieu"))
    @JsonIgnoreProperties(value = "congThucs")
    private NguyenLieu nguyenLieu;


    public int getId_ct() {
        return id_ct;
    }

    public void setId_ct(int id_ct) {
        this.id_ct = id_ct;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
}
