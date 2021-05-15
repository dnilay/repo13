package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.example.demo.model.ApplianceEntity;
import com.example.demo.model.ApplianceEntityDTO;
import com.example.demo.repository.ApplianceRepository;

@Service
public class ApplicanceService {

    @Autowired
    private ApplianceRepository applianceRepository;

    @Transactional
    public ApplianceEntityDTO save(ApplianceEntityDTO applianceEntityDTO) {

        try {
            ApplianceEntity applianceEntity = new ApplianceEntity();
            applianceEntity.setBrand(applianceEntityDTO.getBrand());
            applianceEntity.setModel(applianceEntityDTO.getModel());
            applianceEntity.setStatus(applianceEntityDTO.getStatus());
            return getDetails(applianceRepository.save(applianceEntity));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ApplianceEntityDTO getById(Integer serialId) {
        return getDetails(applianceRepository.getOne(serialId));
    }

    public List<ApplianceEntityDTO> getByApplianceName(String applianceName) {

        List<ApplianceEntity> applianceEntityList = applianceRepository.findByApplianceName(applianceName);
        if (CollectionUtils.isEmpty(applianceEntityList)) {
            return null;
        }
        return applianceEntityList.stream().map(this::getDetails).collect(Collectors.toList());
    }

    public ApplianceEntityDTO getDetails(ApplianceEntity applianceEntity) {
        return new ApplianceEntityDTO(
                applianceEntity.getSerialnumber(),
                applianceEntity.getBrand(),
                applianceEntity.getModel(),
                applianceEntity.getStatus()
        );
    }

    
}
