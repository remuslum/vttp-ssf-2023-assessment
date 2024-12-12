package sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonArray;

@Component
public class FileReaderComponent {
    public String readFile(String fileName){
        String message = "";
        try {
            InputStream is = new FileInputStream(fileName);
            JsonArray jsonObject = Json.createReader(is).readArray();
            message = jsonObject.toString();

        } catch (FileNotFoundException e) {
            message = "Fle not found!";
        }
        return message;
    }
        
}

