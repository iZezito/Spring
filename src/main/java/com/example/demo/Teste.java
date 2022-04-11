package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Teste {
    @RequestMapping(value = "/cadastra", method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var writer = response.getWriter();
        var nome = request.getParameter("nome");
        var email = request.getParameter("email");
        var senha = request.getParameter("senha");
        var prefs = request.getParameterValues("prefs");
        var header = request.getHeader("qualquer header");


        writer.println("<html><body><h1 style=\"color: blue\">Bom dia " + nome + header +"</h1></body></html>");
        /*
        writer.println(numero);
        for(var p: prefs){
            writer.println(p);
        }

         */
    }
    @RequestMapping(value = "/cadastraform", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var writer = response.getWriter();
        var nome = request.getParameter("nome");
        var email = request.getParameter("email");
        var senha = request.getParameter("senha");
        var repeteSenha = request.getParameter("repeteSenha");


        Boolean[] regex = new Boolean[4];


        if(!(senha.equals("") || nome.equals("") || repeteSenha.equals("") || email.equals(""))){
            regex[0] = true;

        }else{
            writer.println("Algum campo está vazio!");
            regex[0] = false;
        }

        if (senha.equals(repeteSenha)) {
            regex[1] = true;
        } else {
            regex[1] = false;
            writer.println("Senhas diferentes");
        }
        if (senha.length() > 5){
            regex[2] = true;
        } else{
            regex[2] = false;
            writer.println("senha tem que possuir mais de 5 digitos");
        }

        senha = senha.replaceAll("[\\D]", "");

        String regexTeste = "[0-9]+";
        if(senha.matches(regexTeste)){
            regex[3] = true;
        }else {
            regex[3] = false;
            writer.println("Senha não contém números");
        }

        if(regex[0] && regex[1] && regex[2] && regex[3])
            writer.println("Cadastro Realizado");








        //writer.println("<html><body><h1 style=\"color: blue\">Bom dia " + nome +"</h1></body></html>");
        /*
        writer.println(numero);
        for(var p: prefs){
            writer.println(p);
        }

         */
    }
}