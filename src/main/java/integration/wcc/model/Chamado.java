package integration.wcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "ATIVIDADES")

public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_atividade")
    private int numeroChamado;

    @Column(name = "atividade")
    private String tituloChamado;
    @Column (name= "cod_projeto")
    private int codigoProjeto;
    @Column (name = "descricao_atividade")
    private String descricaoChamado;
    @Column (name = "status_call_center")
    private String statusChamado;
    @Column (name = "severidade_cliente")
    private int severidadeCliente;

    public String getTituloChamado() {
        return tituloChamado;
    }

    public void setTituloChamado(String tituloChamado) {
        this.tituloChamado = tituloChamado;
    }

    public int getCodigoProjeto() {
        return codigoProjeto;
    }

    public void setCodigoProjeto(int codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }

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

    public Chamado(int numeroChamado) {
        this.numeroChamado = numeroChamado;
    }
}
