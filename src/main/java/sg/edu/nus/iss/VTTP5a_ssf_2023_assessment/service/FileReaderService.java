package sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.component.FileReaderComponent;

@Service
public class FileReaderService {
    @Autowired
    FileReaderComponent fileReaderComponent;

    public String readFile(String fileName){
        return fileReaderComponent.readFile(fileName);
    }
}
