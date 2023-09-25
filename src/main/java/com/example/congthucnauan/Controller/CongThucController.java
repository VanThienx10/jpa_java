package com.example.congthucnauan.Controller;

import com.example.congthucnauan.Models.CongThuc;
import com.example.congthucnauan.Models.MonAn;
import com.example.congthucnauan.Repostories.CongThucRepos;
import com.example.congthucnauan.Repostories.LoaiMonAnRepos;
import com.example.congthucnauan.Repostories.MonAnRepos;
import com.example.congthucnauan.Repostories.NguyenLieuRepos;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class CongThucController {
    @Autowired
    private CongThucRepos congThucRepo;
    @Autowired
    private MonAnRepos monAnRepo;
    @Autowired
    private LoaiMonAnRepos loaiMonAnRepo;
    @Autowired
    private NguyenLieuRepos nguyenLieuRepo;


    @GetMapping(value = "congthuc/getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public String HienThiCongThucNauAn(){
        String kq ="";

        for(MonAn ma : monAnRepo.findAll()){
            kq += ma.getTenmon() + "\n";
            for (CongThuc ct : ma.getCongThucs()){
                kq += ct.getNguyenLieu().getTennguyenlieu() +" : "+ct.getSoluong() + " "+ ct.getDonvitinh() +"\n";
            }
            kq += "\n";
        }

        return kq;

    }

    @GetMapping(value = "monan/timkiem",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonAn> TimKiemMonAn(@RequestParam String nl_1,String nl_2){
        List<MonAn> lst = new ArrayList<>();

        for (MonAn x: monAnRepo.findAll()){
            x.getCongThucs().forEach(y->{
                if(y.getNguyenLieu().getTennguyenlieu().toLowerCase().contains(nl_1.toLowerCase()) ||y.getNguyenLieu().getTennguyenlieu().toLowerCase().contains(nl_2.toLowerCase())){
                    lst.add(x);
                }
            });
        }

        return lst;

    }


    @PostMapping(value = "monan/them",produces = MediaType.APPLICATION_JSON_VALUE)
    public void ThemMonAn(@RequestBody MonAn monAnNew){

        ValidatorFactory valfac  = Validation.buildDefaultValidatorFactory();
        Validator validator = valfac.getValidator();
        Set<ConstraintViolation<MonAn>> violations = validator.validate(monAnNew);

        violations.forEach(x->{
            System.out.println(x.getMessage());
        });

        if(violations.size()==0){
            monAnRepo.save(monAnNew);
            monAnNew.getCongThucs().forEach(x->{
                x.setMonAn(monAnNew);
                
            });


            congThucRepo.saveAll(monAnNew.getCongThucs());
        }

    }
}
