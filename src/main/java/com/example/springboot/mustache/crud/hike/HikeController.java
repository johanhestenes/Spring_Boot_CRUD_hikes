package com.example.springboot.mustache.crud.hike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HikeController {

    private final HikeService hikeService;

    @Autowired
    public HikeController(HikeService hikeService) {
        this.hikeService = hikeService;
    }

    @GetMapping
    public String getHikes(Model model) {
        model.addAttribute("hikes", hikeService.getHikes());
        return "hike";
    }

    @GetMapping(path = "/delete/{hikeId}")
    public String deleteHike(@PathVariable("hikeId") Long hikeId) {
        hikeService.deleteHike(hikeId);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createHikePage(Model model) {
        model.addAttribute("isUpdate", false);
        return "create-update";
    }

    @GetMapping("/update/{id}")
    public String updateHikePage(Model model, @PathVariable("id") Long id) {
        Hike hike = hikeService.findHikeById(id);
        model.addAttribute("hike", hike);
        model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/update/{id}")
    public String updateHike(@ModelAttribute("hike") Hike hike, @PathVariable("id") Long id) {
        hikeService.updateHike(id, hike.getName(), hike.getDistance(), hike.getElevationGain());
        return "redirect:/";
    }

    @PostMapping("/create")
    public String createHike(@ModelAttribute("hike") Hike hike) {
        hikeService.addNewHike(hike);
        return "redirect:/";
    }
}
