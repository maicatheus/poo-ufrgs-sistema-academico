package src.main.java.model;

import src.main.java.enums.CaraterEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CurriculoModel implements Comparable<DisciplinaModel> {

    private List<DisciplinaModel> disciplinas;

    private HashMap<DisciplinaModel, Integer> etapaoferecida;

    private HashMap<DisciplinaModel, CaraterEnum> caraterDisciplina;

    public CurriculoModel() {
        caraterDisciplina = new HashMap<>();
        etapaoferecida = new HashMap<>();
        this.disciplinas = new ArrayList<>();
    }

    public List<DisciplinaModel> getDisciplinas() {
        return disciplinas;
    }

    public Integer etapaDisciplinaOferecida(DisciplinaModel outraDisciplina){
        for(DisciplinaModel disciplina: this.disciplinas){
            if(disciplina.getCodigo().equals(outraDisciplina.getCodigo())){
                return etapaoferecida.get(disciplina);
            }
        }
        return 0;
    }

    public CaraterEnum getCaraterDisciplina(DisciplinaModel disciplina){
        return this.caraterDisciplina.get(disciplina);
    }
    public void setDisciplinas(DisciplinaModel disciplina, CaraterEnum caraterEnum, Integer oferecida, CursoModel curso) {
        disciplina.setCarater(caraterEnum);
        disciplina.setOferecida(oferecida);
        disciplina.setCursos(curso);
        this.caraterDisciplina.put(disciplina,caraterEnum);
        this.etapaoferecida.put(disciplina,oferecida);
        this.disciplinas.add(disciplina);
    }

    public void removerDisciplinas(DisciplinaModel disciplina, CursoModel curso) {
        disciplina.removerCurso(curso);
        this.caraterDisciplina.remove(disciplina);
        this.disciplinas.remove(disciplina);
        this.etapaoferecida.remove(disciplina);
    }
    public void setDisciplinas(DisciplinaModel disciplina) {
        this.disciplinas.add(disciplina);
    }

    public List<DisciplinaModel> listarDisciplinasPorEtapa() {
        Collections.sort(disciplinas);
        return disciplinas;
    }

    @Override
    public int compareTo(DisciplinaModel disciplina){
        if(this.etapaoferecida.get(disciplina) < disciplina.getOferecida()){
            return -1;
        } if (this.etapaoferecida.get(disciplina) > disciplina.getOferecida()){
            return 1;
        }
        return 0;
    }

}
