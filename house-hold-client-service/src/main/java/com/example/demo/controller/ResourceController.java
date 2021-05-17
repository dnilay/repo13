package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ApplianceUserDto;
import com.example.demo.feignservice.ResourceFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/client")
public class ResourceController {

    @Autowired
    private ResourceFeignService resourceFeignService;
 
private static final org.slf4j.Logger log = LoggerFactory.getLogger(ResourceController.class);

    @GetMapping("/getById/{id}")
    @HystrixCommand(fallbackMethod ="fallback_getDetailsById" )
    public ApplianceUserDto getDetailsById(@PathVariable Integer id) {

        return resourceFeignService.getById(id);
    }

    @GetMapping("/getByName/{applianceName}")
    @HystrixCommand(fallbackMethod = "fallback_getDetailsByName")
    public List<ApplianceUserDto> getDetailsByName(@PathVariable("applianceName") String name) {

        return resourceFeignService.getByApplianceName(name);
    }

    @PostMapping("/saveOrUpdate")
    @HystrixCommand(fallbackMethod = "fallback_saveOrUpdate")
    public ApplianceUserDto saveOrUpdate(@RequestBody ApplianceUserDto applianceEntityDTO) {

        return resourceFeignService.save(applianceEntityDTO);
    }

    public ApplianceUserDto fallback_getDetailsById(@PathVariable Integer id) {

    	log.info("fallback worked");
        return new ApplianceUserDto(null, null, null);
    }
    public List<ApplianceUserDto> fallback_getDetailsByName(@PathVariable("applianceName") String name) {

    	log.info("fallback worked");
        return  new ArrayList<ApplianceUserDto>();
    }

    public ApplianceUserDto fallback_saveOrUpdate(@RequestBody ApplianceUserDto applianceEntityDTO) {

    	log.info("fallback called");
        return new ApplianceUserDto(null, null, null);
    }
}





































