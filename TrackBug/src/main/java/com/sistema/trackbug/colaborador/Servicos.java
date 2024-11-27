package com.sistema.trackbug.colaborador;

public interface Servicos {
    void cadastrarColaborador(Colaborador colaborador);
    void deslogarColaborador();
    static boolean loginColaborador(String email, String senha) {
        return false;
    }
}