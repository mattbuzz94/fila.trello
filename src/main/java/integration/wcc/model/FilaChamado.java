package integration.wcc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FILA_CHAMADO", schema = "SFW_SUPORTE")
@NamedQueries({
        @NamedQuery(name = "FilaChamado.findTicketFilaByNumber", query = "SELECT c FROM FilaChamado c JOIN c.chamado ch where ch.numeroChamado = :ticketNumber")
        //@NamedQuery(name = "FilaChamado.findTicketsByFila", query = "SELECT c FROM FilaChamado c JOIN c.fila f where f.idFila = :filaNumber")
        //@NamedQuery(name = "FilaChamado.findTicketsByFila", query = "SELECT c FROM FilaChamado c where c.stack.id_fila = :filaNumber")
})

public class FilaChamado implements Serializable {
    private static final long serialVersionUID = 1L;
// 4140 = Matheus

    public static final String FIND_TICKET_FILA_BY_NUMBER = "FilaChamado.findTicketFilaByNumber";
    public static final String FIND_TICKETS_FILA_BY_FILA = "FilaChamado.findTicketsByFila";


    //@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    //@PrimaryKeyJoinColumn
    @Id
    private int id_fila;

    @Id
    @ManyToOne
    @JoinColumn(name = "chamado", referencedColumnName = "cod_atividade")
    private Chamado chamado;

    @Column(name = "descricao")
    private String observacao;


    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado1) {
        setChamado(chamado1, true);
    }

    void setChamado(Chamado chamado1, boolean add) {
        this.chamado = chamado1;
        if (chamado1 != null && add) {
            chamado1.addFilaChamado(this, false);
        }
    }

    public int getId_fila() {
        return id_fila;
    }

    public void setId_fila(int id_fila) {
        this.id_fila = id_fila;
    }
/*
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if ((object == null) || !(object instanceof FilaChamado))
            return false;

        final FilaChamado filaChamado = (FilaChamado) object;

        if (filaChamado != null && filaChamado.getFila() != null) {
            return filaChamado.getFila().getNomeFila().equals(fila.getNomeFila());
        }
        return false;
    }
    */
}
