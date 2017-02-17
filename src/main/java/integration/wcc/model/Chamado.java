package integration.wcc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ATIVIDADES",schema = "CALLCENTER_RO")
@NamedQueries({
        @NamedQuery(name = "Chamado.findTicketByNumber", query = "SELECT c FROM Chamado c where c.numeroChamado = :ticketNumber"),
        @NamedQuery(name = "Chamado.findTicketbyNumberWithFila", query = "SELECT c FROM Chamado c JOIN c.filaChamados f where c.numeroChamado =:chamadoNum")
})

public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_TICKET_BY_NUMBER = "Chamado.findTicketByNumber";
    public static final String FIND_TICKET_BY_NUMBER_WITH_FILA = "Chamado.findTicketbyNumberWithFila";

    @Id
    @Column(name = "cod_atividade")
    private int numeroChamado;

    @Column(name = "atividade")
    private String tituloChamado;
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

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "chamado")
    @Fetch(FetchMode.JOIN)
    private List<FilaChamado> filaChamados = new ArrayList<FilaChamado>();

    public List<FilaChamado> getFilaChamados() {
        return filaChamados;
    }

    public void setFilaChamados(List<FilaChamado> filaChamados) {
        this.filaChamados = filaChamados;
    }

    public List<FilaChamado> getFilaChamado() {
        return filaChamados;
    }

    public void setFilaChamado(ArrayList<FilaChamado> adicao) {
        this.filaChamados = filaChamados;
    }

    public void addFilaChamado(FilaChamado filaChamado) {
        addFilaChamado(filaChamado, true);
    }

    void addFilaChamado(FilaChamado filaChamado, boolean set) {
        if (filaChamado != null) {
            if (getFilaChamado().contains(filaChamado)) {
                getFilaChamado().set(getFilaChamado().indexOf(filaChamado), filaChamado);
            } else {
                getFilaChamado().add(filaChamado);
            }
            if (set) {
                filaChamado.setChamado(this, false);
            }
        }
    }


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

    @Override
    public int hashCode() {
        return numeroChamado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Chamado) {
            Chamado ch = (Chamado) obj;
            return ch.getNumeroChamado() == numeroChamado;
        }

        return false;
    }
}
