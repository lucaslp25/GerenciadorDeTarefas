package application;

import enums.Prioridade;
import model.Tarefa;

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

        int contador = 0;


        while(true){

        System.out.println();
        System.out.println("|--GERENCIADOR DE TAREFAS--|");
        System.out.println();
        System.out.println("(1) - ADICIONAR TAREFA: ");
        System.out.println("(2) - VER SUAS TAREFAS: ");
        System.out.println("(3) - REMOVER TAREFA: ");
        System.out.println("(4) - MARCAR COMO CONCLUIDO:");
        System.out.println("(5) - SAIR:");
        System.out.println();
        System.out.println("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        if (opcao == 1) {

            contador = tarefas.size();

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
                    Thread.sleep(1000);
                }catch (InterruptedException e){        //Pequena pausa para voltar para o menu

                    System.out.println("Houve interrupção da pausa...");
                    Thread.currentThread().interrupt();
                }

            }else{

                System.out.println("SUA LISTA DE TAREFAS: ");
                System.out.println("\n");

                for (Tarefa tarefa : tarefas) {


                    try {
                        Thread.sleep(600);
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

        }


            if (opcao > 5 || opcao < 1) {
            System.out.println("Opção inválida!");
        }
        if (opcao == 5) {
            System.out.println("Saindo...");
            break;
        }
        }
        sc.close();
    }




}