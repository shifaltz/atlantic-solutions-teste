package br.pedro.almeida.testepratico.repository;

import br.pedro.almeida.testepratico.model.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {

    @Query("SELECT r FROM Responsible r WHERE r.email = ?1 AND r.password = ?2")
    public Responsible findResponsibleLogin(String email, String password);

}
