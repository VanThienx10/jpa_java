package com.example.congthucnauan.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "loaimonan")
public class LoaiMonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lma")
    private int id_lma;
    @Column(name = "tenloai")
    private String tenloai;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "loaiMonAn")
    @JsonIgnoreProperties(value = "loaiMonAn")
    private Set<MonAn> monAns;

    public int getId_lma() {
        return id_lma;
    }

    public void setId_lma(int id_lma) {
        this.id_lma = id_lma;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public Set<MonAn> getMonAns() {
        return monAns;
    }

    public void setMonAns(Set<MonAn> monAns) {
        this.monAns = monAns;
    }
}
