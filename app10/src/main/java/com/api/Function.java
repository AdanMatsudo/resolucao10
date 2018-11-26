package com.api;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */

public class Function {

    List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> fakelist() {

        funcionarios.add(new Funcionario(new Long(1), "gardheam", 44, 332142151));
        funcionarios.add(new Funcionario(new Long(2), "guifaydsbfiyuasardheam", 44, 332142151));
        funcionarios.add(new Funcionario(new Long(3), "agsjgnoasdam", 44, 332142151));
        funcionarios.add(new Funcionario(new Long(4), "gaasdgasdg", 44, 332142151));
        funcionarios.add(new Funcionario(new Long(5), "asdgasgsaardheam", 44, 332142151));

        return funcionarios;
    }

    @FunctionName("create-funcionario")
    public Funcionario createFuncionario(@HttpTrigger(name = "createFuncionario", methods = {
            HttpMethod.POST }, authLevel = AuthorizationLevel.FUNCTION, route = "funcionario") Funcionario funcionario) {

        // operações de add na lista
        Funcionario func = new Funcionario();
        func.setID(funcionario.getID());
        func.setNome(funcionario.getNome());
        func.setIdade(funcionario.getIdade());
        func.setSalário(funcionario.getSalário());

        return func;
    }

    @FunctionName("read-funcionario")
    public List<Funcionario> readFuncionario(@HttpTrigger(name = "readFuncinario", methods = {
            HttpMethod.GET }, authLevel = AuthorizationLevel.FUNCTION, route = "funcionario") String funcionario) {
        //retorna a lista completa

        return funcionarios;
    }

    @FunctionName("edit-funcionario")
    public Funcionario editFuncionario(@HttpTrigger(name = "editFuncionario", methods = {
            HttpMethod.PUT }, authLevel = AuthorizationLevel.FUNCTION, route = "funcionario") Funcionario funcionario) {

        // operações de modificar a lista

        return funcionario;
    }

    @FunctionName("delete-funcionario")
    public String deleteFuncionario(@HttpTrigger(name = "deleteFuncionario", methods = {
            HttpMethod.DELETE }, authLevel = AuthorizationLevel.FUNCTION, route = "funcionario") int id) {

        //operação de deletar da lista        

        return "ok";
    }

}

class Funcionario {

    Long ID;
    String nome;
    int idade;
    double salário;

    Funcionario(){

    }

    Funcionario(Long ID, String nome, int idade, double salario) {
        this.ID = ID;
        this.nome = nome;
        this.idade = idade;
        this.salário = salario;
    }

    /**
     * @return the iD
     */
    public Long getID() {
        return ID;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the salário
     */
    public double getSalário() {
        return salário;
    }

    /**
     * @param iD the iD to set
     */
    public void setID(Long iD) {
        ID = iD;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param salário the salário to set
     */
    public void setSalário(double salário) {
        this.salário = salário;
    }
}
