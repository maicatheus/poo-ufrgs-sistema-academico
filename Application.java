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
        menu.menuInicial();
        System.out.print("Escolha uma opcao: ");
        opc = sc.nextInt();
        sc.nextLine();

        String nome;
        String codigoDisciplina;
        Integer numeroCreditos;
        switch (opc){
            case 1:
                System.out.print("Nome do Curso: ");
                nome = sc.nextLine();
                cursos.add(new CursoModel(nome));
                break;
            case 2:
                System.out.print("Codigo da Disciplina: ");
                codigoDisciplina = sc.nextLine();
                System.out.print("Nome da disciplina: ");
                nome = sc.nextLine();
                System.out.print("Numero decreditos da disciplina: ");
                numeroCreditos = sc.nextInt();
                disciplinas.add(new DisciplinaModel(codigoDisciplina, nome, numeroCreditos));
                break;

        }




        sc.close();
    }
}
