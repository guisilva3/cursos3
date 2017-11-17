/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "cursos")
@NamedQueries({
    @NamedQuery(name = "Curso.findByNome", query = "select p from Curso p where p.nome = :nome")
})
@XmlRootElement
public class Curso extends AbstractEntity {
    
    @Column(length = 255, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)    
    private Date dataLancamento;
    
    @Column(length = 255, nullable = false)
    private String enredo;
    
    @Column(length = 255, nullable = false)
    private String slogan;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Coordenador coordenador;  
    
    @OneToOne(cascade = CascadeType.ALL)
    private Instituicao instituicao;
    
    @OneToMany()
    private List<Aluno> alunos;
    
    @OneToMany
    private List<Area> areas;

    public Curso() {
    }    

    @Override
    public void updateParameters(Object entity) {
        final Curso curso = (Curso) entity;
        
        this.dataLancamento = curso.getDataLancamento();
        this.coordenador = curso.getCoordenador();
        this.enredo = curso.getEnredo();
        this.nome = curso.getNome();
        this.slogan = curso.getSlogan();
        this.instituicao = curso.getInstituicao();
        this.areas = curso.getAreas();
        this.alunos = curso.getAlunos();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getEnredo() {
        return enredo;
    }

    public void setEnredo(String enredo) {
        this.enredo = enredo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public String toString() {
        return "curso{" + "nome=" + nome + ", dataLancamento=" + dataLancamento + ", enredo=" + enredo + ", slogan=" + slogan + ", coordenador=" + coordenador + '}';
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
    
}
