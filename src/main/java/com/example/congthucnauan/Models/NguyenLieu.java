package com.example.congthucnauan.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "nguyenlieu")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nl")
    private int id_nl;
    @Column(name = "tennguyenlieu")
    private String tennguyenlieu;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "nguyenLieu")
    @JsonIgnoreProperties(value = "nguyenLieu")
    private Set<CongThuc> congThucs;


    public int getId_nl() {
        return id_nl;
    }

    public void setId_nl(int id_nl) {
        this.id_nl = id_nl;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public Set<CongThuc> getCongThucs() {
        return congThucs;
    }

    public void setCongThucs(Set<CongThuc> congThucs) {
        this.congThucs = congThucs;
    }
}
