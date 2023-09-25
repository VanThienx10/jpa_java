package com.example.congthucnauan.Repostories;

import com.example.congthucnauan.Models.LoaiMonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiMonAnRepos extends JpaRepository<LoaiMonAn,Integer> {
}
