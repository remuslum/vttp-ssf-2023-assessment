package sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.model.Event;

@Component
public class FileReaderComponent {

    public List<Event> getEvents(String fileName){
        List<Event> events = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(fileName);
            JsonArray jsonArray = Json.createReader(is).readArray();
            populateEventList(jsonArray, events);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return events;
    }

    private void populateEventList(JsonArray jsonArray, List<Event> eventList){
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            Event event = new Event(jsonObject.getInt("eventId"), jsonObject.getString("eventName"), jsonObject.getInt("eventSize"), jsonObject.getJsonNumber("eventDate").longValue(), jsonObject.getInt("participants"));

            eventList.add(event);
        }
    }
        
}

