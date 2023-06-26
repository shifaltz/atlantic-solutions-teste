package br.pedro.almeida.testepratico.repository;

import br.pedro.almeida.testepratico.model.Responsible;
import br.pedro.almeida.testepratico.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    public User findUserLogin(String email, String password);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findUserByEmail(String email);

    @Query(value = "SELECT * FROM User WHERE id_responsible = :idResponsible", nativeQuery = true)
    public List<User> findAllByResponsible(@Param("idResponsible") Long idResponsible);

}
