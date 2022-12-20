package src.main.java.model;

import src.main.java.enums.CaraterEnum;

public class DisciplinaModel {
    private String codigo;
    private String nome;
    private Integer creditos;
    private Integer cargaHoraria;
    private CaraterEnum carater;

    public DisciplinaModel(){
    };

    public DisciplinaModel(String codigo, String nome, Integer creditos, Integer cargaHoraria, CaraterEnum carater) {
        this.codigo = codigo;
        this.nome = nome;
        this.creditos = creditos;
        this.cargaHoraria = cargaHoraria;
        this.carater = carater;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public CaraterEnum getCarater() {
        return carater;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setCarater(CaraterEnum carater) {
        this.carater = carater;
    }
}
