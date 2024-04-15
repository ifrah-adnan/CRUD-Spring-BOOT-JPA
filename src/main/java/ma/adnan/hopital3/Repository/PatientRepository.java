package ma.adnan.hopital3.Repository;

import jakarta.transaction.Transactional;
import ma.adnan.hopital3.entite.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.dateNaissance = :dateNaissance, p.malade = :malade, p.score = :score WHERE p.nom = :nom")
    void updateByNom(String nom, Date dateNaissance, boolean malade, int score);}
