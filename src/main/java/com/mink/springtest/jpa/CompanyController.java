package com.mink.springtest.jpa;

import com.mink.springtest.jpa.domain.Company;
import com.mink.springtest.jpa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jpa/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ResponseBody
    @GetMapping("/add")
    public List<Company> addCompany(){
        List<Company> company = new ArrayList<>();

        company.add(companyService.createCompany(
                "넥슨"
                ,"컨텐츠 게임"
                ,"대기업"
                ,3585));
        company.add(companyService.createCompany(
                "버블팡"
                ,"여신 금융업"
                ,"대기업"
                ,6834));
        return company;

    }
    @ResponseBody
    @GetMapping("/modify")
    public Company modifyCompany(){
        Company company = companyService.updateCompany(10,"중소기업",34);
        return company;
    }
    @ResponseBody
    @GetMapping("/delete")
    public String removeCompany(){
        // id가 3인 학생의 장래희망을 강사로 변경
        companyService.deleteCompany(8);

        return "수행 완료";
    }

}
