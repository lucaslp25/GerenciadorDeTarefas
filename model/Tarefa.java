package model;

import enums.Prioridade;
import enums.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    private Prioridade prioridade;              //Associação com as enumerações...
    private Status status;

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Tarefa(){

    }

    //Construtor sem a data de término caso a pessoa não queira colocar prazo!

    public Tarefa(String nome,Prioridade prioridade) {
        this.nome = nome;
        this.dataInicio = LocalDate.now();
        this.status = Status.PENDENTE;
        this.prioridade = prioridade;
        System.out.println();
        System.out.println("Tarefa adicionada com sucesso!");


    }

    public Tarefa(String nome, String descricao,Prioridade prioridade) {
        this.nome = nome;
        this.dataInicio = LocalDate.now();
        this.status = Status.PENDENTE;
        this.prioridade = prioridade;
        this.descricao = descricao;
        System.out.println();
        System.out.println("Tarefa adicionada com sucesso!");
    }


    public Tarefa(String nome, String descricao,LocalDate dataFim, Prioridade prioridade) {
        this.nome = nome;
        this.dataInicio = LocalDate.now();
        this.status = Status.PENDENTE;
        this.prioridade = prioridade;           //Fiz uma sobrecarga de construtores para poder dar um opção maior de
        this.descricao = descricao;             //escolhas ao usuario na hora de adicionar alguma tarefa!
        this.dataFim = dataFim;         //E a sobrecarga me permite fazer isso de forma fácil
        System.out.println();
        System.out.println("Tarefa adicionada com sucesso!");
    }


    public Tarefa(String nome, LocalDate dataFim, Prioridade prioridade) {
        this.nome = nome;
        this.dataInicio = LocalDate.now();     //Data da tarefa vai ser definido no dia que a pessoa adicionar a tarefa
        this.dataFim = dataFim;
        this.prioridade = prioridade;
        this.status = Status.PENDENTE;
        System.out.println();
        System.out.println("Tarefa adicionada com sucesso!");

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Descrições da tarefa:\n");

        sb.append("Nome da Tarefa: " + nome + "\n");
        sb.append("Data de inicio: " + dataInicio.format(formatter) + "\n");

        if (dataFim != null) {
            sb.append("Data de fim: " + dataFim.format(formatter) + "\n");
        }
        sb.append("Prioridade: " + prioridade + "\n");
        sb.append("Status: " + status + "\n");

        if (descricao != null) {
            sb.append("Descricao: " + descricao + "\n");
        }

        return sb.toString();
    }
}
