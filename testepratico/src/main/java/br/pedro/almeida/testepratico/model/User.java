package br.pedro.almeida.testepratico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String cpf;

    @JsonIgnore
    private String password;
    private Boolean status = true;

    @ManyToOne
    @JoinColumn(name = "idResponsible")
    private Responsible idResponsible;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Responsible getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(Responsible idResponsible) {
        this.idResponsible = idResponsible;
    }

    @Override
    public String toString() {
        return "name='" + name + "| email='" + email;
    }
}
