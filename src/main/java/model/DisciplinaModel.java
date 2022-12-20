package src.main.java.model;

import src.main.java.enums.CaraterEnum;

import java.util.List;

public class DisciplinaModel implements Comparable<DisciplinaModel>{
    private String codigo;
    private String nome;
    private Integer creditos;
    private Integer cargaHoraria;
    private CaraterEnum carater;
    private Integer oferecida;

    private List<CursoModel> cursos;

    public DisciplinaModel(){
    };

    public DisciplinaModel(String codigo, String nome, Integer creditos, CursoModel curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.creditos = creditos;
        setCargaHoraria(creditos);
        setCursos(curso);
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

    public Integer getOferecida() {
        return oferecida;
    }

    public List<CursoModel> getCursos() {
        return cursos;
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

    public void setCargaHoraria(Integer creditos) {
        this.cargaHoraria = creditos*4*6;
    }

    public void setCarater(CaraterEnum carater) {
        this.carater = carater;
    }

    public void setOferecida(Integer oferecida) {
        this.oferecida = oferecida;
    }

    public void setCursos(CursoModel curso) {
        this.cursos.add(curso);
    }
    public void removerCurso(CursoModel curso){
        this.cursos.remove(curso);
    }
    public List<CursoModel> listarOfertas(){
        return this.cursos;
    }
    @Override
    public int compareTo(DisciplinaModel outraDisciplina){
        if(this.oferecida < outraDisciplina.oferecida){
            return -1;
        } if (this.oferecida > outraDisciplina.oferecida){
            return 1;
        }
        return 0;
    }
}
