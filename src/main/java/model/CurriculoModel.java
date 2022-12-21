package src.main.java.model;

import src.main.java.enums.CaraterEnum;

import java.util.Collections;
import java.util.List;

public class CurriculoModel {

    private List<DisciplinaModel> disciplinas;

    public CurriculoModel() {
    }

    public List<DisciplinaModel> getDisciplinas() {
        return disciplinas;
    }

    public Integer etapaDisciplinaOferecida(DisciplinaModel outraDisciplina){
        for(DisciplinaModel disciplina: this.disciplinas){
            if(disciplina.getCodigo().equals(outraDisciplina.getCodigo())){
                return disciplina.getOferecida();
            }
        }
        return 0;
    }
    public void setDisciplinas(DisciplinaModel disciplina, CaraterEnum caraterEnum, Integer oferecida, CursoModel curso) {
        disciplina.setCarater(caraterEnum);
        disciplina.setOferecida(oferecida);
        disciplina.setCursos(curso);
        this.disciplinas.add(disciplina);
    }

    public void removerDisciplinas(DisciplinaModel disciplina, CursoModel curso) {
        disciplina.removerCurso(curso);
        this.disciplinas.remove(disciplina);
    }
    public void setDisciplinas(DisciplinaModel disciplina) {
        this.disciplinas.add(disciplina);
    }

    public List<DisciplinaModel> listarDisciplinasPorEtapa() {
        Collections.sort(disciplinas);
        return disciplinas;
    }

}
