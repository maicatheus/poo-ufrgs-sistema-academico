package src.main.java.model;

import src.main.java.enums.CaraterEnum;

import java.util.List;

public class CursoModel {

    private String nome;
    private CurriculoModel curriculo;
    private HabilitacaoModel habilitacao;

    public CursoModel() {
    }

    public CursoModel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public CurriculoModel getCurriculo() {
        return curriculo;
    }

    public HabilitacaoModel getHabilitacao() {
        return habilitacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurriculo(CurriculoModel curriculo) {
        this.curriculo = curriculo;
    }

    public void setHabilitacao(HabilitacaoModel habilitacao) {
        this.habilitacao = habilitacao;
    }

    public void oferecerDisciplina(DisciplinaModel disciplina, CaraterEnum carater, Integer oferecida){
        curriculo.setDisciplinas(disciplina,carater,oferecida, this );
    }

    public void excluirDisciplina(DisciplinaModel disciplina){
        curriculo.removerDisciplinas(disciplina, this);
    }

    public List<DisciplinaModel> listarDisciplinaPorEtapa(){
        return this.curriculo.listarDisciplinasPorEtapa();
    }







}
