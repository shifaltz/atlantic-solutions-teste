package br.pedro.almeida.testepratico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "responsible")
public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsible;
    private String name;
    private String email;
    private String cpf;
    private String password;

    public Long getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(Long idResponsible) {
        this.idResponsible = idResponsible;
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
}
