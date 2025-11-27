package com.mink.springtest.jpa.repository;


import com.mink.springtest.jpa.domain.Recruit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit ,Integer> {


    public List<Recruit> findById(int id);
    public List<Recruit> findByCompanyId(int companyId);
    public List<Recruit> findByPositionAndType(String position, String type);
    public List<Recruit> findByTypeOrSalaryGreaterThan(String type, int salary);
    public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
    public List<Recruit> findByRegionAndSalaryBetween(String region, int salary1,int salary2);

    @Query(value = "SELECT * FROM `recruit` WHERE `deadline` > :deadline AND `type` = :type AND `salary` >= :salary ORDER BY `salary` DESC", nativeQuery = true)
    public List<Recruit> selectByRecruit(String deadline, String type, int salary);

}

