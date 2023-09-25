package com.example.congthucnauan.Repostories;

import com.example.congthucnauan.Models.NguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguyenLieuRepos extends JpaRepository<NguyenLieu,Integer> {
}
