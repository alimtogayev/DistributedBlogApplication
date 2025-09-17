package alim.togayev.blogapplication.identityservice.repository;

import alim.togayev.blogapplication.identityservice.entities.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepo extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByUsername(String username);

}
