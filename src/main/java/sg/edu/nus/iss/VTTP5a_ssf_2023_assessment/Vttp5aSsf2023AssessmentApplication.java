package sg.edu.nus.iss.VTTP5a_ssf_2023_assessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.model.Event;
import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.service.DatabaseService;
import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.util.MyConstants;

@SpringBootApplication
public class Vttp5aSsf2023AssessmentApplication implements CommandLineRunner{
	@Autowired
	DatabaseService databaseService;

	public static void main(String[] args){
		SpringApplication.run(Vttp5aSsf2023AssessmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(String arg:args){
			if(arg.startsWith("fileName")){
				String fileName = arg.substring("fileName=".length());
				List<Event> eventList = databaseService.getEvents(fileName);
				eventList.forEach(System.out::println);
				eventList.forEach(event -> databaseService.saveRecord(MyConstants.REDISKEY,event));
			}
		}
	}

}
