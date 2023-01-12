import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String green = "\033[32;1;4m";
        String red = "\033[31;1;4m";
        String clear = "\033[m";

        List<Holyday> holydays = App.createList();
        Scanner sc = new Scanner(System.in);
        int prompt = 0;

        System.out.println("%sFeriado específico:%s digite 1 %n%sTodos os feriados:%s digite 2 %n%sCancelar:%s digite 3"
                .formatted(green, clear, green, clear, green, clear));

        while (!Arrays.asList(1, 2, 3).contains(prompt)) {
            System.out.print("%sSua escolha:%s ".formatted(red, clear));
            prompt = sc.nextInt();
        }

        if (prompt == 1) {
            System.out.print("%sData do feriado (dd/mm/2023):%s ".formatted(red, clear));
            String date = sc.next();

            Holyday holyday = App.returnHolyday(holydays, date);

            if (holyday.getName() == null) {
                System.out.println("%sEsse feriado não está no banco de dados.%s".formatted(green, clear));
            } else {
                System.out.println("%sFeriado:%s ".formatted(green, clear) + holyday.getName());
            }
        } else if (prompt == 2) {
            System.out.println("%sTodos os feriados:%s".formatted(green, clear));

            for (int i = 0; i < holydays.size(); i++) {
                System.out.println(" %s->%s ".formatted(green, clear) + holydays.get(i).getDate() + " - "
                        + holydays.get(i).getName());
            }
        }
    }

    public static List<Holyday> createList() {
        List<Holyday> holydays = new ArrayList<>();

        Holyday anoNovo = new Holyday("01/01/2023", "Confraternização mundial");
        Holyday carnaval = new Holyday("21/02/2023", "Carnaval");
        Holyday pascoa = new Holyday("17/04/2023", "Páscoa");
        Holyday tiradentes = new Holyday("21/04/2023", "Tiradentes");
        Holyday diaDoTrabalho = new Holyday("01/05/2023", "Dia do Trabalho");
        Holyday corpusChristi = new Holyday("08/06/2023", "Corpus Christi");
        Holyday independencia = new Holyday("07/09/2023", "Independência do Brasil");
        Holyday nossaSenhoraAparecida = new Holyday("12/10/2023", "Nossa Senhora Aparecida");
        Holyday finados = new Holyday("02/11/2023", "Finados");
        Holyday proclamacaoDaRepublica = new Holyday("15/11/2023", "Proclamação da República");
        Holyday natal = new Holyday("25/12/2023", "Natal");

        holydays.addAll(Arrays.asList(anoNovo, carnaval, pascoa, tiradentes, diaDoTrabalho, corpusChristi,
                independencia, nossaSenhoraAparecida, finados, proclamacaoDaRepublica, natal));

        return holydays;
    }

    public static Holyday returnHolyday(List<Holyday> holydays, String date) {
        int index = -1;
        for (int i = 0; i < holydays.size(); i++) {
            if (holydays.get(i).getDate().equals(date)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return new Holyday();
        } else {
            return holydays.get(index);
        }
    }
}
