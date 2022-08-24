package com.example.springboot.mustache.crud.hike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HikeService {

    private final HikeRepository hikeRepository;

    @Autowired
    public HikeService(HikeRepository hikeRepository) {
        this.hikeRepository = hikeRepository;
    }

    public List<Hike> getHikes(){
        return hikeRepository.findAll();
    }

    public Hike findById(Long id) {
        return hikeRepository.findById(id).orElse(null);
    }

    public void deleteHike(Long hikeId){
        hikeRepository.deleteById(hikeId);
    }

    public void addNewHike(Hike hike) {
        if (hike.getName().isEmpty()) {
            throw new IllegalStateException("Name cannot be null.");
        }
        hikeRepository.save(hike);
    }

    @Transactional
    public void updateStudent(Long hikeId, String name, String distance, String elevationGain) {
        Hike hike = hikeRepository.findById(hikeId)
                .orElseThrow(() -> new IllegalStateException(
                        "hike with id " + hikeId + " does not exist"
                ));

        if (name != null && name.length() > 0) {
            hike.setName(name);
        }
        hike.setDistance(distance);
        hike.setElevationGain(elevationGain);
    }
}
