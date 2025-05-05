package br.com.fintech.core;

import br.com.fintech.dao.*;
import br.com.fintech.modules.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========= MENU DE INSERÇÃO =========");
            System.out.println("1. Inserir Banco");
            System.out.println("2. Inserir Conta");
            System.out.println("3. Inserir Resumo Financeiro");
            System.out.println("4. Inserir Meta");
            System.out.println("5. Inserir Gasto");
            System.out.println("6. Inserir Trilha de Investimento");
            System.out.println("7. Inserir Email");
            System.out.println("8. Inserir Renda");
            System.out.println("9. Cadastrar usuário");
            System.out.println("10. Consultar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Código do banco: ");
                    int cdBanco = sc.nextInt();
                    sc.nextLine(); // consumir quebra de linha
                    System.out.print("Nome do banco: ");
                    String nmBanco = sc.nextLine();

                    Banco bancco = new Banco(cdBanco, nmBanco);
                    BancoDao bancoDao = new BancoDao(bancco);
                    try {
                        bancoDao.registrarBanco();
                        System.out.println("Banco registrado com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Número da conta: ");
                    int nmConta = sc.nextInt();
                    System.out.print("Agência: ");
                    int agencia = sc.nextInt();
                    System.out.print("Código do banco: ");
                    cdBanco = sc.nextInt();
                    System.out.print("Código do usuário: ");
                    int cdUsuario = sc.nextInt();
                    System.out.print("Código do resumo financeiro: ");
                    int cdResumo = sc.nextInt();

                    Conta conta = new Conta(nmConta, agencia,cdBanco , cdUsuario, cdResumo);
                    ContaDao contaDao = new ContaDao(conta);

                    try {
                        contaDao.cadastrarConta();
                        System.out.println("Conta cadastrada com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Código do resumo: ");
                    cdResumo = sc.nextInt();
                    System.out.print("Mês/Ano (ex: 04/2025): ");
                    String mesAno = sc.next();
                    System.out.print("Total de renda: ");
                    float totalRenda = sc.nextFloat();
                    System.out.print("Total de gastos: ");
                    float totalGasto = sc.nextFloat();
                    System.out.print("Saldo disponível: ");
                    float saldo = sc.nextFloat();
                    System.out.print("Valor faltante para meta: ");
                    float faltante = sc.nextFloat();

                    ResumoFinanceiro resumo = new ResumoFinanceiro(cdResumo, mesAno, totalRenda, totalGasto, saldo, faltante);
                    ResumoFinanceiroDAO resumoDao = new ResumoFinanceiroDAO(resumo);

                    try {
                        resumoDao.insert();
                        System.out.println("Resumo inserido com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    System.out.print("Código da meta: ");
                    int cdMeta = sc.nextInt();
                    System.out.print("Valor alvo: ");
                    float vlAlvo = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Data alvo (dd-mm-yyyy): ");
                    String dtAlvo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    System.out.print("Valor atual: ");
                    float vlAtual = sc.nextFloat();
                    System.out.print("Número da conta: ");
                    nmConta = sc.nextInt();
                    System.out.print("Código do usuário: ");
                    cdUsuario = sc.nextInt();

                    Metas meta = new Metas(cdMeta, vlAlvo, dtAlvo, descricao, vlAtual, nmConta, cdUsuario);
                    MetasDao metaDao = new MetasDao(meta);

                    try {
                        metaDao.caadastarMeta();
                        System.out.println("Metas cadastrada com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    System.out.print("Código do gasto: ");
                    int cdGasto = sc.nextInt();
                    System.out.print("Valor gasto: ");
                    float vlGasto = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    System.out.print("Data do gasto (dd-mm-yyyy): ");
                    String dtGasto = sc.nextLine();
                    System.out.print("Descrição: ");
                    descricao = sc.nextLine();
                    System.out.print("Número da conta: ");
                    nmConta = sc.nextInt();
                    System.out.print("Código do usuário: ");
                    cdUsuario = sc.nextInt();

                    Gastos gasto = new Gastos(cdGasto, vlGasto, categoria, dtGasto, descricao, nmConta, cdUsuario);
                    GastosDao gastoDao = new GastosDao(gasto);

                    try {
                        gastoDao.cadastrarGastos();
                        System.out.println("Gastos cadastrada com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Código da trilha: ");
                    int cdTrilha = sc.nextInt();
                    System.out.print("Código da meta: ");
                    cdMeta = sc.nextInt();
                    System.out.print("Número da conta: ");
                    nmConta = sc.nextInt();
                    System.out.print("Código do usuário: ");
                    cdUsuario = sc.nextInt();
                    System.out.print("Valor investido: ");
                    float vlInvestido = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Tipo de investimento: ");
                    String tipo = sc.nextLine();
                    System.out.print("Valor aplicado: ");
                    float vlAplicado = sc.nextFloat();
                    System.out.print("Rentabilidade: ");
                    float rentabilidade = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Prazo: ");
                    String prazo = sc.nextLine();
                    System.out.print("Risco: ");
                    String risco = sc.nextLine();
                    System.out.print("Transação: ");
                    String transacao = sc.nextLine();

                    TrilhaInvestimento trilha = new TrilhaInvestimento(cdTrilha, cdMeta, nmConta, cdUsuario, vlInvestido, tipo, vlAplicado, rentabilidade, prazo, risco, transacao);
                    TrilhaInvestimentoDAO trilhaDao = new TrilhaInvestimentoDAO(trilha);

                    try {
                        trilhaDao.insert();
                        System.out.println("Investimento cadastrada com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 7:
                    System.out.print("Código do e-mail: ");
                    int cdEmail = sc.nextInt();
                    System.out.print("E-mail: ");
                    String nmEmail = sc.next();
                    System.out.print("Tipo de e-mail: ");
                    String tipoEmail = sc.next();
                    System.out.print("Código do usuário: ");
                    cdUsuario = sc.nextInt();

                    Email email = new Email(cdEmail, nmEmail, cdUsuario, tipoEmail);
                    EmailDao emailDao = new EmailDao(email);

                    try {
                        emailDao.registrarEmail();
                        System.out.println("E-mail cadastrado com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                case 8:
                    System.out.print("Código da renda: ");
                    int cdRenda = sc.nextInt();
                    System.out.print("Valor da renda: ");
                    float vlRenda = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Frequência: ");
                    String frequencia = sc.nextLine();
                    System.out.print("Tipo da renda: ");
                    String tpRenda = sc.nextLine();
                    System.out.print("Número da conta: ");
                    nmConta = sc.nextInt();
                    System.out.print("Código do usuário: ");
                    cdUsuario = sc.nextInt();

                    Renda renda = new Renda(cdRenda, vlRenda, frequencia, tpRenda, nmConta, cdUsuario);
                    RendaDao rendaDao = new RendaDao(renda);

                    try {
                        rendaDao.cadastrarRenda();
                        System.out.println("Renda cadastrada com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    System.out.println("Código do usuario: ");
                    int cd_usuario = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome do usuario: ");
                    String nm_usuario = sc.nextLine();
                    System.out.println("Senha: ");
                    String senha = sc.nextLine();

                    Usuario usuario = new Usuario(cd_usuario, nm_usuario, senha);
                    UsuarioDao usuarioDao = new UsuarioDao(usuario);
                    try {
                        usuarioDao.logar();
                        System.out.println("Usuario logado com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                break;

                case 10:
                    int escolhaConsulta;
                    do {
                        System.out.println("\n=== CONSULTAR REGISTROS ===");
                        System.out.println("1. Bancos");
                        System.out.println("2. Contas");
                        System.out.println("3. Resumos Financeiros");
                        System.out.println("4. Metas");
                        System.out.println("5. Gastos");
                        System.out.println("6. Trilhas de Investimento");
                        System.out.println("7. Emails");
                        System.out.println("8. Rendas");
                        System.out.println("9. Retornar menu principal");
                        System.out.print("Escolha a tabela: ");
                        escolhaConsulta = sc.nextInt();

                        switch (escolhaConsulta) {
                            case 1:
                                BancoDao bancoDao1 = new BancoDao();
                                try {
                                    List<Banco> bancos = bancoDao1.listarBancos();
                                    for (Banco banco :bancos) {
                                        System.out.println(banco.getCd_banco() + " - " +  banco.getNm_banco());
                                        System.out.println();
                                    }
                                }catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                ContaDao cd = new ContaDao();
                                try {
                                    List<Conta> contas = cd.listarConta();
                                    for (Conta c : contas) {
                                        System.out.println("conta: " +c.getNm_conta());
                                        System.out.println("Agencia: " + c.getAgencia());
                                        System.out.println("cdBanco: " + c.getCd_banco());
                                        System.out.println("cdUsuario: " + c.getCd_usuraio());
                                        System.out.println("cdResumo: " + c.getCd_resumo());
                                        System.out.println("__________________________");
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 3:
                                ResumoFinanceiroDAO ResumoF =new ResumoFinanceiroDAO();
                                try {
                                    List<ResumoFinanceiro> ResumoF1 = ResumoF.getAll();
                                    for (ResumoFinanceiro rf :ResumoF1) {
                                        System.out.println("cdResumo: " + rf.getCdResumo());
                                        System.out.println("data: " + rf.getMesAno());
                                        System.out.println("rendaTotal: " + rf.getTotalRenda());
                                        System.out.println("totalgasto: " + rf.getTotalGasto());
                                        System.out.println("saldo disponivel: " + rf.getSaldoDisponivel());
                                        System.out.println("valor faltando: " + rf.getVlFaltanteMeta());
                                        System.out.println("__________________________");
                                    }
                                }catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                MetasDao md = new MetasDao();
                                try {
                                    List<Metas> metas = md.listarMetas();
                                    for (Metas m : metas) {
                                        System.out.println("cdMeta: " + m.getCd_meta());
                                        System.out.println("valorAlvo: " + m.getVl_alvo());
                                        System.out.println("Descriçao: " + m.getDescricao());
                                        System.out.println("valor atual: " + m.getVl_atual());
                                        System.out.println("nome conta: " + m.getNm_conta());
                                        System.out.println("Usario: " + m.getCd_usuario());
                                        System.out.println("_________________");
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 5:
                                GastosDao gd  = new GastosDao();

                                try {
                                    List<Gastos> gastos = gd.listargastos();
                                    for (Gastos g : gastos) {
                                        System.out.println("cdGasto: " + g.getCd_gastos());
                                        System.out.println("valor gasto: " + g.getVl_gastos());
                                        System.out.println("categoria:  " + g.getCategoria());
                                        System.out.println("datagasto:  " + g.getDt_gasto());
                                        System.out.println("descriçao: " + g.getDescricao());
                                        System.out.println("nome conta: " + g.getNm_conta());
                                        System.out.println("cdUsuario: " + g.getCd_usuario());
                                        System.out.println("_________________");
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 6:
                                TrilhaInvestimentoDAO TI = new TrilhaInvestimentoDAO();
                                try {
                                    List<TrilhaInvestimento> trilhaF = TI.getAll();
                                    for (TrilhaInvestimento trilhas : trilhaF) {
                                        System.out.println("cd trilha: " + trilhas.getCdTrilha());
                                        System.out.println("cdMeta:  " + trilhas.getCdMeta());
                                        System.out.println("valorInvestimento:  " + trilhas.getVlInvestido());
                                        System.out.println("rentabilidade: " + trilhas.getRentabilidade());
                                        System.out.println("prazo: " + trilhas.getPrazo());
                                        System.out.println("Rsico:  " +  trilhas.getRisco());
                                        System.out.println("nomeConta:  " + trilhas.getNmConta());
                                        System.out.println("cdUsuario: " + trilhas.getCdUsuario());
                                        System.out.println("transação: " + trilhas.getTransacao());
                                        System.out.println("_________________");
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 7:
                                EmailDao ed = new EmailDao();
                                try {
                                    List<Email> emails = ed.listarEmail();
                                    for (Email e : emails) {
                                        System.out.println("cdEmail: " + e.getCd_email());
                                        System.out.println("nomEmail: " + e.getNom_email());
                                        System.out.println("tipo: " + e.getTipo_email());
                                        System.out.println("cdusuario: " + e.getCd_usuario());
                                        System.out.println("_________________");
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 8:
                                RendaDao rd = new RendaDao();
                                try {
                                    List<Renda> rendas = rd.listarRenda();
                                    for (Renda r : rendas) {
                                        System.out.println("cdRenda: " + r.getCd_renda());
                                        System.out.println("valorRenda: " + r.getVl_renda());
                                        System.out.println("frequncia: " + r.getFrequencia());
                                        System.out.println("Renda: " + r.getTp_renda());
                                        System.out.println("nmConta: " + r.getNm_conta());
                                        System.out.println("cdUsuario: " + r.getCd_usuario());
                                        System.out.println("_________________");
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 9:
                                System.out.println("Retornando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    } while (escolhaConsulta != 9);
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0) ;

        sc.close();
    }

}