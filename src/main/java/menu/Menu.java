package src.main.java.menu;

import src.main.java.enums.CaraterEnum;
import src.main.java.model.CursoModel;
import src.main.java.model.DisciplinaModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public Menu() {
    }
    public void menuInicial(){

        List<CursoModel> cursos = new ArrayList<>();
        List<DisciplinaModel> disciplinas = new ArrayList<>();

        Integer opc;

        Scanner sc = new Scanner(System.in);

        String nome;
        String codigoDisciplina;
        Integer numeroCreditos;

        Integer opcDisciplina;
        Integer opcCurso;
        Integer opcCarater;
        Integer etapaOferecida;
        CaraterEnum carater = null;

        Boolean cadastrada = false;

        Boolean continuar = true;
        Boolean foiOferecida = false;

        while (continuar) {

            System.out.println("=-=-=-=-=-=-=-= Menu Inicial =-=-=-=-=-=-=-=");
            System.out.println("[1] - Cadastrar um curso");
            System.out.println("[2] - Cadastrar uma disciplina");
            System.out.println("[3] - Cadastrar uma oferta");
            System.out.println("[4] - Excluir uma oferta");
            System.out.println("[5] - Listar os cursos");
            System.out.println("[6] - Listar o curriculo de um curso, agrupando as disciplinas de cada etapa");
            System.out.println("[7] - Listar todas as ofertas de uma disciplina");
            System.out.println("[0] - Sair");

            System.out.print("Escolha uma opcao: ");
            opc = sc.nextInt();
            sc.nextLine();

            foiOferecida = false;
            cadastrada = false;

            switch (opc) {
                case 1: {
                    System.out.print("Nome do Curso: ");
                    nome = sc.nextLine();
                    cursos.add(new CursoModel(nome));
                    break;
                }
                case 2: {
                    System.out.print("Codigo da Disciplina: ");
                    codigoDisciplina = sc.nextLine();
                    for (DisciplinaModel disciplina : disciplinas) {
                        if (codigoDisciplina.equals(disciplina.getCodigo())) {
                            System.out.println("Disciplina ja cadastrada!");
                            cadastrada = true;
                        }
                    }
                    if(cadastrada){
                        break;
                    }
                    System.out.print("Nome da disciplina: ");
                    nome = sc.nextLine();
                    System.out.print("Numero decreditos da disciplina: ");
                    numeroCreditos = sc.nextInt();
                    disciplinas.add(new DisciplinaModel(codigoDisciplina, nome, numeroCreditos));
                    break;
                }
                case 3: {
                    System.out.println("DISCIPLINAS: ");
                    for (int i = 0; i < disciplinas.size(); i++) {
                        System.out.println("[" + (i + 1) + "]" + " - " + disciplinas.get(i).getCodigo() + " - " + disciplinas.get(i).getNome());
                    }
                    System.out.print("Qual disciplina deseja ofertar: ");
                    opcDisciplina = sc.nextInt();

                    System.out.println("CURSOS: ");
                    for (int i = 0; i < cursos.size(); i++) {
                        System.out.println("[" + (i + 1) + "]" + " - " + cursos.get(i).getNome());
                    }

                    System.out.print("Para qual curso deseja ofertar: ");
                    opcCurso = sc.nextInt();

                    for(DisciplinaModel disciplina: cursos.get(opcCurso-1).getCurriculo().getDisciplinas()){
                        if(disciplina.getCodigo().equals(disciplinas.get(opcDisciplina-1).getCodigo())){
                            System.out.println("Esta disciplina j?? foi oferecida!");
                            foiOferecida = true;
                            break;
                        }
                    }

                    if(foiOferecida){
                        break;
                    }

                    System.out.println("Carater da disciplina: ");
                    System.out.println("[1] - Obrigatorio ");
                    System.out.println("[2] - Eletivo");
                    System.out.println("[3] - Adicional");

                    System.out.print("opcao de carater: ");
                    opcCarater = sc.nextInt();

                    switch (opcCarater) {
                        case 1:
                            carater = CaraterEnum.OBRIGATORIO;
                            break;
                        case 2:
                            carater = CaraterEnum.ELETIVO;
                            break;
                        case 3:
                            carater = CaraterEnum.ADICIONAL;

                    }

                    System.out.print("Etapa oferecida: ");
                    etapaOferecida = sc.nextInt();

                    cursos.get(opcCurso - 1).oferecerDisciplina(
                            disciplinas.get(opcDisciplina - 1),
                            carater,
                            etapaOferecida
                    );

                    break;
                }
                case 4: {
                    System.out.println("DISCIPLINAS: ");
                    for (int i = 0; i < disciplinas.size(); i++) {
                        System.out.println("[" + (i + 1) + "]" + " - " + disciplinas.get(i).getCodigo() + " - " + disciplinas.get(i).getNome());
                    }
                    System.out.print("Qual disciplina deseja excluir a oferta: ");
                    opcDisciplina = sc.nextInt();

                    for (int i = 0; i < disciplinas.get(opcDisciplina - 1).getCursos().size(); i++) {
                        System.out.println("[" + (i + 1) + "]" + " - " + disciplinas.get(opcDisciplina - 1).getCursos().get(i).getNome());
                    }
                    System.out.print("Qual curso deseja excluir a oferta da disciplina: ");
                    opcCurso = sc.nextInt();
                    disciplinas.get(opcDisciplina - 1).getCursos().get(opcCurso - 1).excluirDisciplina(disciplinas.get(opcDisciplina - 1));
                    break;
                }
                case 5: {
                    System.out.println("Cursos oferecidos: ");
                    for (CursoModel curso : cursos) {
                        System.out.println(curso.getNome());
                    }
                    break;
                }
                case 6: {
                    System.out.println("CURSOS: ");
                    for (int i = 0; i < cursos.size(); i++) {
                        System.out.println("[" + (i + 1) + "]" + " - " + cursos.get(i).getNome());
                    }

                    System.out.print("Qual curso deseja listar o curr??culo: ");
                    opcCurso = sc.nextInt();
                    for (DisciplinaModel disciplina : cursos.get(opcCurso - 1).getCurriculo().listarDisciplinasPorEtapa()) {
                        System.out.println("Etapa: " + cursos.get(opcCurso - 1).getCurriculo().etapaDisciplinaOferecida(disciplina) + " - nome: " + disciplina.getNome() + " - carater: " + cursos.get(opcCurso - 1).getCurriculo().getCaraterDisciplina(disciplina));
                    }
                    break;
                }
                case 7: {
                    System.out.println("DISCIPLINAS: ");
                    for (int i = 0; i < disciplinas.size(); i++) {
                        System.out.println("[" + (i + 1) + "]" + " - " + disciplinas.get(i).getCodigo() + " - " + disciplinas.get(i).getNome());
                    }
                    System.out.print("Qual disciplina deseja listar as ofertas: ");
                    opcDisciplina = sc.nextInt();

                    for (CursoModel curso : disciplinas.get(opcDisciplina - 1).getCursos()) {
                        System.out.println("Curso: " + curso.getNome() + " - Oferecida: semestre " + curso.getCurriculo().etapaDisciplinaOferecida(disciplinas.get(opcDisciplina - 1)));
                    }
                    break;
                }
                case 0: {
                    continuar = false;
                    break;
                }
                default: {
                    System.out.println("Digite um valor v??lido!");
                    break;
                }
            }
        }

        sc.close();

    }


}
