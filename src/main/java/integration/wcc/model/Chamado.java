package integration.wcc.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "ATIVIDADES",schema = "CALLCENTER_RO")
@NamedQueries({
        @NamedQuery(name = "Chamado.findTicketByNumber", query = "SELECT c FROM Chamado c where c.numeroChamado = :ticketNumber")
})

public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_TICKET_BY_NUMBER = "Chamado.findTicketByNumber";

    @Id
    @Column(name = "cod_atividade")
    private int numeroChamado;

    @Column(name = "atividade")
    private String tituloChamado;
    //@Column (name= "cod_projeto")
    //private int codigoProjeto;
    @Column (name = "descricao_necessidade")
    private String descricaoChamado;
    @Column (name = "status_call_center")
    private String statusChamado;
    @Column (name = "severidade_cliente")
    private int severidadeCliente;
    @Column (name = "func_solucao")
    private String analistaNome;
    @Column (name = "descricao_solucao")
    private String solucaoProposta;

    @OneToOne
    @JoinColumn(name="cod_projeto")
    private ProjetoCliente projeto;

    public String getAnalistaNome() {
        return analistaNome;
    }

    public void setAnalistaNome(String analistaNome) {
        this.analistaNome = analistaNome;
    }

    public String getSolucaoProposta() {
        return solucaoProposta;
    }

    public void setSolucaoProposta(String solucaoProposta) {
        this.solucaoProposta = solucaoProposta;
    }

    public ProjetoCliente getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoCliente projeto) {
        this.projeto = projeto;
    }

    public String getTituloChamado() {
        return tituloChamado;
    }

    public void setTituloChamado(String tituloChamado) {
        this.tituloChamado = tituloChamado;
    }

    /*public int getCodigoProjeto() {
        return codigoProjeto;
    }*/

    /*public void setCodigoProjeto(int codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }*/

    public String getDescricaoChamado() {
        return descricaoChamado;
    }

    public void setDescricaoChamado(String descricaoChamado) {
        this.descricaoChamado = descricaoChamado;
    }

    public String getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(String statusChamado) {
        this.statusChamado = statusChamado;
    }

    public int getSeveridadeCliente() {
        return severidadeCliente;
    }

    public void setSeveridadeCliente(int severidadeCliente) {
        this.severidadeCliente = severidadeCliente;
    }

    public int getNumeroChamado() {
        return numeroChamado;
    }

    public void setNumeroChamado(int numeroChamado) {
        this.numeroChamado = numeroChamado;
    }

    public Chamado(/*int numeroChamado*/) {
        //this.numeroChamado = numeroChamado;
    }
}
