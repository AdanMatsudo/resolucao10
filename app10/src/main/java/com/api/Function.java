package com.api;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

import Lombok.Data;

/**
 * Azure Functions with HTTP Trigger.
 */

public class Function {

    List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> fakelist() {

        funcionarios.add(new Funcionario(new Long(1), "Matsudo", 18, 1800));

        return funcionarios;
    }

    @FunctionName("create-funcionario")
    public Funcionario create(@HttpTrigger(name = "createFuncionario", methods = {
            HttpMethod.POST }, route = "funcionario") Funcionario funcionario) {

        // operações de add na lista
        Funcionario func = new Funcionario();
        func.setID(funcionario.getID());
        func.setNome(funcionario.getNome());
        func.setIdade(funcionario.getIdade());
        func.setSalário(funcionario.getSalario());

        return func;
    }

    @FunctionName("read-funcionario")
    public List<Funcionario> readFuncionario(@HttpTrigger(name = "readFuncinario", methods = {
            HttpMethod.GET }, route = "funcionario") String funcionario) {
        //retorna a lista completa

        return funcionarios;
    }

    @FunctionName("edit-funcionario")
    public Funcionario editFuncionario(@HttpTrigger(name = "editFuncionario", methods = {
            HttpMethod.PUT }, route = "funcionario") Funcionario funcionario) {

        // operações de modificar a lista

        for (Funcionario funcionario : funcionarios) {
                if(funcionario.ID == funcionario.ID){
                    funcionario.setNome(funcionario.getNome());
                    funcionario.setIdade(funcionario.getIdade());
                    funcionario.setSalário(funcionario.getSalário());
        	
        }

        return funcionarios;
    }

    @FunctionName("delete-funcionario")
    public String deleteFuncionario(@HttpTrigger(name = "deleteFuncionario", methods = {
            HttpMethod.DELETE }, route = "funcionario") int id) {

        //operação de deletar da lista   
        for (Funcionario funcionario : funcionarios) {
             	if(funcionario.getID == id){

             		funcionarios.delete(id);
             	}
             }     

        return "ok";
    }

}
@Data
class Funcionario {

    Long ID;
    String nome;
    int idade;
    double salario;

    Funcionario(){

    }

    Funcionario(Long ID, String nome, int idade, double salario) {
        this.ID = ID;
        this.nome = nome;
        this.idade = idade;
        this.salário = salario;
    }

}

