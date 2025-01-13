package com.sistema.trackbug.servicos;

import com.sistema.trackbug.colaborador.Colaborador;
import com.sistema.trackbug.usuario.Funcionario;

import java.util.List;
import java.util.Scanner;

// ESSA CLASSE CONTÉM O MENU ANTERIOR(CMD), NÃO ESTÁ MAIS FUNCIONAL
public class Menu {
    Scanner inserir = new Scanner(System.in);

    private Colaborador dadosColaborador;
    private Colaborador dadosLogado;
    private boolean logado;

    private Funcionario funcionario;
    private Equipamento equipamento;
    private Manutencao manutencao;
    private Emprestimo emprestimo;
    private List<Equipamento> listaEquipamentosIndisponiveis;


    private List<Funcionario> listaFuncionarios;
    private List<Equipamento> listaEquipamentos;
    private List<Manutencao> listaManutencao;
    private List<Emprestimo> listaEmprestimos;

    /*public Menu() {
        this.dadosColaborador = new Colaborador("", "", "", "");
        this.funcionario = new Funcionario(0, null, "", "");
        this.equipamento = new Equipamento(0, 0, LocalDate.now(), "", "Conservado", new ArrayList<>(), 0, 0);
        this.manutencao = new Manutencao(0, null, null, "", null);
        this.emprestimo = new Emprestimo(null, null, null, null, "");
        this.listaEquipamentos = new ArrayList<>();
        this.listaFuncionarios = new ArrayList<>();
        this.listaManutencao = new ArrayList<>();
        this.listaEmprestimos = new ArrayList<>();
        this.listaEquipamentosIndisponiveis = new ArrayList<>();
        Colaborador.Admin();
    }

    public void menuColaborador() {
        int op;

        do {
            //Colaborador.Admin();
            System.out.println("\t\tMENU COLABORADOR\n");
            System.out.println("[1] - Cadastro");
            System.out.println("[2] - Login");
            System.out.println("[3] - Deslogar");
            System.out.println("[4] - Sair");
            System.out.print("Opção: ");
            op = inserir.nextInt();
            inserir.nextLine();

            switch(op) {
                case 0: // USAR PARA TESTES
                    for (int i = 0; i <= 100; i += 20) {  // Atualiza de 20 em 20
                        System.out.print(".");
                        try {
                            Thread.sleep(500);  // Pausa de 500ms a cada iteração
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    dadosColaborador.cadastrarColaborador(Colaborador colaborador);
                    break;
                case 2:
                    if(logado) {
                        menuPrincipal();
                    } else {
                        dadosColaborador.loginColaborador();
                        logado = true;
                        menuPrincipal();
                    }
                    break;
                case 3:
                    if(!logado) {
                        System.out.println("Nenhum colaborador está logado!\n");
                    } else {
                        dadosColaborador.deslogarColaborador();
                        logado = false;
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while(op != 4);
    }

    public void menuPrincipal() {
        int op;

        do {
            Colaborador colaboradorLogado = Colaborador.getColaboradorLogado(); // Obtém o colaborador atualmente logado
            System.out.print("\t\tTRACK BUG LTDA - CONTROLE DE EMPRESTIMOS\t\t");
            System.out.println("[Login - " + colaboradorLogado.getNome() + "]");
            System.out.println("\n[1] - Cadastrar Funcionário");
            System.out.println("[2] - Remover Funcionário");
            System.out.println("[3] - Lista Funcionários");
            System.out.println("[4] - Cadastrar Equipamento");
            System.out.println("[5] - Remover Equipamento");
            System.out.println("[6] - Listar Equipamentos");
            System.out.println("[7] - Realizar Empréstimo");
            System.out.println("[8] - Realizar Devolução");
            System.out.println("[9] - Listar Emprestimos ativos");
            System.out.println("[10] - Enviar para Manutenção");
            System.out.println("[11] - Remover da Manutenção");
            System.out.println("[12] - Histórico de emprestimos");
            System.out.println("[13] - Histórico de Manutenção");
            System.out.println("[14] - Sair");
            System.out.print("Opção: ");
            op = inserir.nextInt();

            switch(op) {
                case 1:
                    funcionario.cadastrarFuncionario(listaFuncionarios);
                    break;
                case 2:
                    funcionario.removerFuncionario(listaFuncionarios);
                    break;
                case 3:
                    funcionario.listarFuncionarios(listaFuncionarios);
                    break;
                case 4:
                    equipamento.cadastrarEquipamento(listaEquipamentos);
                    break;
                case 5:
                    equipamento.removerEquipamento(listaEquipamentos, listaEquipamentosIndisponiveis);
                    break;
                case 6:
                    equipamento.listarEquipamentos(listaEquipamentos);
                    break;
                case 7:
                    emprestimo.registrarEmprestimo(listaEquipamentos, listaEquipamentosIndisponiveis, listaFuncionarios);
                    break;
                case 8:
                    emprestimo.registrarDevolucao(listaEquipamentos, listaEquipamentosIndisponiveis);
                    break;
                case 9:
                    emprestimo.listarEmprestimosAtivos();
                    break;
                case 10:
                    manutencao.registrarManutencao(listaEquipamentos, listaEquipamentosIndisponiveis);
                    break;
                case 11:
                    manutencao.removerManutencao(listaEquipamentos, listaEquipamentosIndisponiveis);
                    break;
                case 12:
                    emprestimo.historicoEmprestimos();
                    break;
                case 13:
                    manutencao.historicoManutencao();
                    break;
                case 14:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while(op != 14);
    }
     */
}