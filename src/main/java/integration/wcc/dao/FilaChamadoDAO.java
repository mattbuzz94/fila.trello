package integration.wcc.dao;


import integration.wcc.model.FilaChamado;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class FilaChamadoDAO extends GenericDAO<FilaChamado> {

    private static final long serialVersionUID = 1L;

    public FilaChamadoDAO() {
        super(FilaChamado.class);
    }

    public FilaChamado findTicketFilaByNumber(int numeroChamado) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ticketNumber", numeroChamado);

        return super.findOneResult(FilaChamado.FIND_TICKET_FILA_BY_NUMBER, parameters);
    }

    public List<FilaChamado> findTicketsByFila(int idFila) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("filaNumber", idFila);

        return super.findListResult(FilaChamado.FIND_TICKETS_FILA_BY_FILA, parameters);
    }


}
