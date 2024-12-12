package sg.edu.nus.iss.VTTP5a_ssf_2023_assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.service.FileReaderService;

@SpringBootApplication
public class Vttp5aSsf2023AssessmentApplication implements CommandLineRunner{
	@Autowired
	FileReaderService fileReaderService;

	public static void main(String[] args){
		SpringApplication.run(Vttp5aSsf2023AssessmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(String arg:args){
			if(arg.startsWith("fileName")){
				String fileName = arg.substring("fileName=".length());
				System.out.println(fileReaderService.readFile(fileName));
			}
		}
	}

}
