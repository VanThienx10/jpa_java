package com.example.congthucnauan.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "monan")
public class MonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ma")
    private int id_ma;
    @Column(name = "tenmon")
    private String tenmon;

    @Column(name = "ghichu")
    private String ghichu;

    @ManyToOne
    @JoinColumn(name = "id_lma",foreignKey = @ForeignKey(name = "fk_monan_loaimonan"))
    @JsonIgnoreProperties(value = "monAns")
    private LoaiMonAn loaiMonAn;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "monAn")
    @JsonIgnoreProperties(value = "monAns")
    private Set<CongThuc> congThucs;

    public int getId_ma() {
        return id_ma;
    }

    public void setId_ma(int id_ma) {
        this.id_ma = id_ma;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public LoaiMonAn getLoaiMonAn() {
        return loaiMonAn;
    }

    public void setLoaiMonAn(LoaiMonAn loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
    }

    public Set<CongThuc> getCongThucs() {
        return congThucs;
    }

    public void setCongThucs(Set<CongThuc> congThucs) {
        this.congThucs = congThucs;
    }
}
