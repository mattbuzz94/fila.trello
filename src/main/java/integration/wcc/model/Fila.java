package integration.wcc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "FILA", schema = "SFW_SUPORTE")
public class Fila implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id_fila;

    public int getId_fila() {
        return id_fila;
    }

    public void setId_fila(int id_fila) {
        this.id_fila = id_fila;
    }

    @Column(name = "descricao")
    private String nomeFila;

    public Fila() {
    }
/*
    public FilaChamado getInventory() {
        if (filachamado == null) {
            filachamado = new FilaChamado();
        }
        return filachamado;
    }

    public void setFilaChamado(FilaChamado filachamado) {
        this.filachamado = filachamado;
    }
*/


    public String getNomeFila() {
        return nomeFila;
    }

    public void setNomeFila(String nomeFila) {
        this.nomeFila = nomeFila;
    }
}
