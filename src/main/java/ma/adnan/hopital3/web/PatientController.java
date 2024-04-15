package ma.adnan.hopital3.web;

import ma.adnan.hopital3.Repository.PatientRepository;
import ma.adnan.hopital3.entite.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@RestController
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")

    public List<Patient> displayPatient(){
        return patientRepository.findAll();

    };
}
