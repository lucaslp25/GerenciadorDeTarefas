package model;

import enums.Prioridade;
import enums.Status;

import java.time.LocalDate;

public class Tarefa {
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    private Prioridade prioridade;
    private Status status;


    public Tarefa(){

    }

    public Tarefa(String nome, LocalDate dataInicio, LocalDate dataFim, Prioridade prioridade, Status status) {


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
    




}
