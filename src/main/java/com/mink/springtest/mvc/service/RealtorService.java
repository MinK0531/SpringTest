package com.mink.springtest.mvc.service;

import com.mink.springtest.mvc.domain.Realtor;
import com.mink.springtest.mvc.repository.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorService {
    @Autowired
    private RealtorRepository realtorRepository;
    public int createUser(Realtor realtor){

        int count = realtorRepository.insertRealtor(realtor);
        return count;

    }
}
