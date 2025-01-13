package com.sistema.trackbug.colaborador;

// INTERFACE ONDE CONTÉM OS METODOS DO COLABORADOR
public interface Servicos {
    void cadastrarColaborador(Colaborador colaborador);
    void deslogarColaborador();
    static boolean loginColaborador(String email, String senha) {
        return false;
    }
}