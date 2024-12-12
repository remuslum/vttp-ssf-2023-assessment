package sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.component.FileReaderComponent;
import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.model.Event;
import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.repo.RedisRepo;

@Service
public class DatabaseService {
    @Autowired
    FileReaderComponent fileReaderComponent;

    @Autowired
    RedisRepo redisRepo;

    public List<Event> getEvents(String fileName){
        return fileReaderComponent.getEvents(fileName);
    }

    public void saveRecord(String redisKey, Event event){
        redisRepo.saveRecord(redisKey,event);
    }
}
