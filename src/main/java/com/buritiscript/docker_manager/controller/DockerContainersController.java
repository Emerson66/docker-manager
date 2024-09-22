package com.buritiscript.docker_manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buritiscript.docker_manager.services.DockerService;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/containers")
public class DockerContainersController {
    
    private final DockerService dockerService;

    public DockerContainersController(DockerService dockerService){
        this.dockerService = dockerService;
    }

    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("") 
    public List<Container> listContainers(@RequestParam(required = false) boolean showAll){
        return dockerService.listContainers(showAll);
    }

    @GetMapping("/{filterName}")
    public List<Image> listContainers(@RequestParam(required = false, defaultValue = "true") String filterName){
        return dockerService.listImagesFilter(filterName);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@RequestParam String id) {
        dockerService.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@RequestParam String id) {
        dockerService.stopContainer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@RequestParam String id) {
        dockerService.deleteContainer(id);
    }

    @PostMapping("")
    public void createContainer(@RequestParam String imageName) {
        dockerService.createContainer(imageName);
    }
}
