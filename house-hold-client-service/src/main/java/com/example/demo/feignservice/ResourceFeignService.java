package com.example.demo.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.ApplianceUserDto;

@FeignClient(name = "house-hold-service")
public interface ResourceFeignService {

    @PostMapping("/appliance/saveOrUpdate")
    ApplianceUserDto save(@RequestBody ApplianceUserDto applianceUserDto);

    @GetMapping("/appliance/getById/{id}")
    ApplianceUserDto getById(@PathVariable Integer id);

    @GetMapping("/appliance/getByName/{applianceName}")
    List<ApplianceUserDto> getByApplianceName(@PathVariable("applianceName") String name);

   
}
