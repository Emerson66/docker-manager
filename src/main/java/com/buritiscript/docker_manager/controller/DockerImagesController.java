package com.buritiscript.docker_manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buritiscript.docker_manager.services.DockerService;
import com.github.dockerjava.api.model.Image;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/images")
public class DockerImagesController {
    
    private final DockerService dockerService;

    public DockerImagesController(DockerService dockerService){
        this.dockerService = dockerService;
    }

    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    @GetMapping("") 
    public List<Image> listImages(){
        return dockerService.listImages();
    }
    public List<Image> listImages(@RequestParam(required = false, defaultValue = "image-") String filterName){
        return dockerService.listImagesFilter(filterName);
    }
}
