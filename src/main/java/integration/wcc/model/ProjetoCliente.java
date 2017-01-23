package integration.wcc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "PROJETOS",schema = "CALLCENTER_RO")
public class ProjetoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_projeto")
    private int codigoProjeto;
    @Column(name = "projeto")
    private String nomeProjeto;

    public ProjetoCliente() {
    }

    public int getCodigoProjeto() {
        return codigoProjeto;
    }

    public void setCodigoProjeto(int codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
}
