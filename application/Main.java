package application;

import enums.Prioridade;
import enums.Status;
import model.Tarefa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Tarefa> tarefas = new ArrayList<>();


        tarefas = carregarTarefas();


        while(true){

        System.out.println();
        System.out.println("|--GERENCIADOR DE TAREFAS--|");
        System.out.println();
        System.out.println("(1) - ADICIONAR TAREFA: ");
        System.out.println("(2) - VER SUAS TAREFAS: ");
        System.out.println("(3) - REMOVER TAREFA: ");
        System.out.println("(4) - MARCAR COMO CONCLUIDO:");
        System.out.println("(5) - SALVAR TAREFAS: ");
        System.out.println("(6) - SAIR:");
        System.out.println();
        System.out.println("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        if (opcao == 1) {

            System.out.println("Você escolheu adicionar uma tarefa! \n");
            System.out.println("Qual será o nome da tarefa? ");
            String nomeTarefa = sc.nextLine();

            System.out.println("Deseja adicionar uma descrição a essa tarefa?\n(1) - SIM\n(2) - NÃO ");
            int escolha3 = sc.nextInt();
            sc.nextLine();
            if (escolha3 == 1) {
                System.out.println("Digite a sua descrição à tarefa...");
                String descricaoTarefa = sc.nextLine();


                System.out.println("Essa tarefa tem prazo para terminar?\n(1) - SIM\n(2) - NÃO ");
                int opcao2 = sc.nextInt();
                sc.nextLine();
                if (opcao2 == 1) {
                    System.out.println("Digite a data prazo  (dd/MM/yyyy): ");
                    String dataFinal = sc.nextLine();
                    LocalDate dataFinal2 = LocalDate.parse(dataFinal, dtf);

                    System.out.println("Qual é a prioridade da tarefa?\nBAIXA, MEDIA, ALTA, URGENTE:");
                    String prioridade = sc.nextLine();
                    prioridade = prioridade.toUpperCase();


                    tarefas.add(new Tarefa(nomeTarefa, descricaoTarefa, dataFinal2, Prioridade.valueOf(prioridade)));


                } else {

                    System.out.println("Qual é a prioridade da tarefa?\nBAIXA, MEDIA, ALTA, URGENTE:");
                    String prioridade = sc.nextLine();
                    prioridade = prioridade.toUpperCase();
                    System.out.println();

                    tarefas.add(new Tarefa(nomeTarefa, descricaoTarefa, Prioridade.valueOf(prioridade)));

                }

            } else {

                System.out.println("Essa tarefa tem prazo para terminar?\n(1) - SIM\n(2) - NÃO ");
                int opcao2 = sc.nextInt();
                sc.nextLine();
                if (opcao2 == 1) {
                    System.out.println("Digite a data prazo  (dd/MM/yyyy): ");
                    String dataFinal = sc.nextLine();
                    LocalDate dataFinal2 = LocalDate.parse(dataFinal, dtf);

                    System.out.println("Qual é a prioridade da tarefa?\nBAIXA, MEDIA, ALTA, URGENTE:");
                    String prioridade = sc.nextLine();
                    prioridade = prioridade.toUpperCase();


                    tarefas.add(new Tarefa(nomeTarefa, dataFinal2, Prioridade.valueOf(prioridade)));


                } else {

                    System.out.println("Qual é a prioridade da tarefa?\nBAIXA, MEDIA, ALTA, URGENTE:");
                    String prioridade = sc.nextLine();
                    prioridade = prioridade.toUpperCase();
                    System.out.println();

                    tarefas.add(new Tarefa(nomeTarefa, Prioridade.valueOf(prioridade)));

                }
            }

        }else if(opcao == 2){

            if(tarefas.isEmpty()){

                System.out.println("Você não tem tarefas aqui!");

                try {
                    Thread.sleep(800);
                }catch (InterruptedException e){        //Pequena pausa para voltar para o menu

                    System.out.println("Houve interrupção da pausa...");
                    Thread.currentThread().interrupt();
                }

            }else{

                System.out.println("SUA LISTA DE TAREFAS: ");
                System.out.println("\n");

                for (Tarefa tarefa : tarefas) {


                    try {
                        Thread.sleep(750);
                    }catch (InterruptedException e){        //Pequena pausa para mostrar as tarefas

                        System.out.println("Houve interrupção da pausa...");
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("TAREFA º"+tarefas.indexOf(tarefa));   //mostra pro usuário o indice da tarefa!
                    System.out.println(tarefa);
                }
            }

        } else if (opcao == 3) {

            if(tarefas.isEmpty()) {
                System.out.println("Você não tem tarefas aqui!");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){        //Pequena pausa para voltar para o menu

                    System.out.println("Houve interrupção da pausa...");
                    Thread.currentThread().interrupt();
                }
            }else{

                System.out.println("Digite o número da tarefa que deseja remover: ");
                int numeroTarefa = sc.nextInt();
                System.out.println(tarefas.get(numeroTarefa).getNome());
                System.out.println("Tem certeza que deseja remover essa tarefa?\n(1) - SIM\n(2) - NÃO ");
                opcao = sc.nextInt();
                if (opcao == 1) {
                    tarefas.remove(numeroTarefa);
                    System.out.println("Tarefa removida com sucesso!");
                }
            }

        } else if (opcao == 4) {

            if(tarefas.isEmpty()) {

                System.out.println("Você não tem tarefas aqui!");

                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){        //Pequena pausa para voltar para o menu

                    System.out.println("Houve interrupção da pausa...");
                    Thread.currentThread().interrupt();
                }
            }else{

                System.out.println("Digite o número da tarefa que deseja marcar como concluida: ");
                int numeroTarefa = sc.nextInt();
                System.out.println(tarefas.get(numeroTarefa).getNome());
                System.out.println("Tem certeza que deseja marcar essa tarefa como concluida?\n(1) - SIM\n(2) - NÃO ");
                opcao = sc.nextInt();
                if (opcao == 1) {
                    tarefas.get(numeroTarefa).marcarConcluido();
                    System.out.println("Tarefa marcada como concluida!");

                }

            }

        }else if (opcao == 5) {


                System.out.println("Deseja salvar todas suas tarefas/alterações?\n(1) - SIM\n(2) - NÃO ");
                opcao = sc.nextInt();
                if (opcao == 1) {

                    salvarTarefas(tarefas);
                    System.out.println("Tarefas salva com sucesso!");
                }

        }

            if (opcao > 6 || opcao < 1) {
            System.out.println("Opção inválida!");
        }
        if (opcao == 6) {
            System.out.println("Saindo...");
            break;
        }
        }
        sc.close();
    }

    //Criação do método para deixa os dados persistentes!

    public static void salvarTarefas(List<Tarefa> tarefas){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (FileWriter writer = new FileWriter("tarefas.txt")){
            for(Tarefa t : tarefas){
                String dataCriacao = t.getDataInicio().format(dtf);
                String dataConclusao = (t.getDataFim() != null) ? t.getDataFim().format(dtf) : "";  //operação ternária para treinar
                writer.write(t.getNome() + ";" + t.getDataInicio().format(dtf) + ";"
                        + (t.getDataFim() != null ? t.getDataFim().format(dtf) : "") + ";"  //outra operação ternária
                        + t.getPrioridade() + ";" + t.getStatus() + ";"
                        + (t.getDescricao() != null ? t.getDescricao() : ""));
                writer.write("\n");
            }                                                                                         //alteração no formato novamente aqui
            System.out.println("Tarefas salvas com sucesso!");
        }catch (IOException e) {
            System.out.println("Erro ao salvar tarefas! " + e.getMessage());
        }
    }

    /*Todas as operações que o usuário pode escolher em deixa nulo ou não eu tive que optar por fazer uma operação ternária para poder colocar esses dados de forma correta no arquivo, para quando for puxar de volta ao programa não dar erro!*/



    public static List <Tarefa> carregarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader reader = new BufferedReader(new FileReader("tarefas.txt"))) {

            String linha;
            while ((linha = reader.readLine()) != null) {

                String[] dados = linha.split(";");
                if (dados.length >= 5) {
                    String nome = dados[0];
                    LocalDate dataInicio = (dados.length > 1 && !dados[1].isEmpty()) ? LocalDate.parse(dados[1], dtf) : null;
                    ;
                    LocalDate dataFim = (dados.length > 2 && !dados[2].isEmpty()) ? LocalDate.parse(dados[2], dtf) : null;
                    Prioridade prioridade = Prioridade.valueOf(dados[3]);
                    Status status = Status.valueOf(dados[4]);
                    String descricao = (dados.length > 5) ? dados[5] : null;


                    Tarefa t = new Tarefa(nome, dataInicio, dataFim, prioridade, status, descricao);
                    tarefas.add(t);
                }

            }
            System.out.println("Tarefas carregadas com sucesso!");

        }catch (IOException e){
            System.out.println("Erro ao carregar tarefas! " + e.getMessage());
        }
        return tarefas;
        }

    }