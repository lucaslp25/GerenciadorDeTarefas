package application;

import model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Tarefa> tarefas = new ArrayList<>();



        tarefas.add(new Tarefa());



        sc.close();
    }
}
