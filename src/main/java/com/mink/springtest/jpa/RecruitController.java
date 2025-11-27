package com.mink.springtest.jpa;

import com.mink.springtest.jpa.domain.Recruit;
import com.mink.springtest.jpa.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/jpa/recruit")
@Controller
public class RecruitController {

    @Autowired
    private RecruitRepository recruitRepository;

    @ResponseBody
    @GetMapping("/find")
    public List<Recruit> findRecruit(){
        List<Recruit> recruitList = null;
//        recruitList = recruitRepository.findById(8);
//        recruitList= recruitRepository.findByPositionAndType("웹 back-end 개발자","정규직");
//        recruitList =recruitRepository.findByTypeOrSalaryGreaterThan("정규직",9000);
//        recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
//        recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
        recruitList = recruitRepository.selectByRecruit("2026-04-10","정규직",8100);


        return recruitList;
    }
    @ResponseBody
    @GetMapping("/findParm")
    public List<Recruit> findRecruitParm(@RequestParam("companyId") int companyId) {
        List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
        return recruitList;
    }
}
