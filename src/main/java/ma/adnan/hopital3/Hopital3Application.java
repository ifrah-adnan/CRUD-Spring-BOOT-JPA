package ma.adnan.hopital3;

import ma.adnan.hopital3.Repository.PatientRepository;
import ma.adnan.hopital3.entite.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Hopital3Application {

	public static void main(String[] args) {
		SpringApplication.run(Hopital3Application.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
	return args -> {
		Patient p1 =
				new Patient(null, "Adnan", new Date(), false, 10);
		Patient p2 =
				new Patient(null, "nabil", new Date(2001 - 1900, Calendar.NOVEMBER, 22), true, 20);
		Patient p3 =
				new Patient(null, "Ahmed", new Date(), false, 12);
		Patient p4 =
				new Patient(null, "issam", new Date(), true, 15);

		List<Patient> patientList = List.of(p1, p2, p3, p4);
		patientRepository.saveAll(patientList);

		List<Patient> patients = patientRepository.findAll();
		for (Patient p : patients
		) {
			System.out.println(p.getNom());
			System.out.println(p.getDateNaissance());
			System.out.println(p.getScore());
			System.out.println(p.isMalade());


		}
		Optional<Patient> p = patientRepository.findById(5L);
		System.out.println("***************************");
		if (p.isPresent()) {
			Patient patient = p.get();
			System.out.println("Patient trouvé :");
			System.out.println("ID : " + patient.getId());
			System.out.println("Nom : " + patient.getNom());
			System.out.println("Date de naissance : " + patient.getDateNaissance());
			System.out.println("Malade : " + patient.isMalade());
			System.out.println("Score : " + patient.getScore());
		} else {
			System.out.println("Aucun patient trouvé avec l'ID spécifié.");
		}
		patientRepository.deleteById(2L);
		patientRepository.updateByNom("Adnan",new Date(2001-1900,11-1,24),true,40);
		List<Patient>patientList1=patientRepository.findAll();
		patientList1.forEach(patient ->
				System.out.println(patient));



	};


}

}
