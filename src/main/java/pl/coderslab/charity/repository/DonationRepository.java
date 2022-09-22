package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;

public interface DonationRepository extends JpaRepository <Donation, Integer>{


//Integer sumQuantityFromDonations();
@Query("SELECT SUM(d.quantity) FROM Donation d")
Integer sumDonationsBags();

@Query("select count(d.id) from Donation d")
Integer donationsSum();
}
