package com.example.congthucnauan.Repostories;

import com.example.congthucnauan.Models.MonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonAnRepos extends JpaRepository<MonAn,Integer> {
}
