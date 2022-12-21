import src.main.java.enums.CaraterEnum;
import src.main.java.menu.Menu;
import src.main.java.model.CurriculoModel;
import src.main.java.model.CursoModel;
import src.main.java.model.DisciplinaModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<CursoModel> cursos = new ArrayList<>();
        List<DisciplinaModel> disciplinas = new ArrayList<>();



        Integer opc;

        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();

        String nome;
        String codigoDisciplina;
        Integer numeroCreditos;

        Integer opcDisciplina;
        Integer opcCurso;
        Integer opcCarater;
        Integer etapaOferecida;
        CaraterEnum carater = null;

        menu.menuInicial();
        System.out.print("Escolha uma opcao: ");
        opc = sc.nextInt();
        sc.nextLine();
        switch (opc){
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
                    if (codigoDisciplina == disciplina.getCodigo()) {
                        System.out.println("Disciplina ja cadastrada!");
                        return;
                    }
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
                for (int i = 0; i <= disciplinas.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + " - " + disciplinas.get(i).getCodigo());
                }
                System.out.print("Qual disciplina deseja ofertar: ");
                opcDisciplina = sc.nextInt();

                System.out.print("CURSOS: ");
                for (int i = 0; i <= cursos.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + " - " + cursos.get(i).getNome());
                }

                System.out.print("Para qual curso deseja ofertar: ");
                opcCurso = sc.nextInt();

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
            case 4:{
                System.out.println("DISCIPLINAS: ");
                for (int i = 0; i <= disciplinas.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + " - " + disciplinas.get(i).getCodigo());
                }
                System.out.print("Qual disciplina deseja excluir a oferta: ");
                opcDisciplina = sc.nextInt();

                for(int i = 0; i <= disciplinas.get(opcDisciplina-1).getCursos().size(); i++){
                    System.out.println("[" + (i + 1) + "]" + " - " + disciplinas.get(opcDisciplina-1).getCursos().get(i).getNome());
                }
                System.out.print("Qual curso deseja excluir a oferta da disciplina: ");
                opcCurso = sc.nextInt();
                disciplinas.get(opcDisciplina-1).getCursos().get(opcCurso-1).excluirDisciplina(disciplinas.get(opcDisciplina-1));
                break;
            }


        }




        sc.close();
    }
}
