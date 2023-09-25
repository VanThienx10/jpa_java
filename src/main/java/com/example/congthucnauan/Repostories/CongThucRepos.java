package com.example.congthucnauan.Repostories;

import com.example.congthucnauan.Models.CongThuc;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongThucRepos extends JpaRepository<CongThuc,Integer> {
}
