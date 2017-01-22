package integration.wcc.dao;
import integration.wcc.model.Chamado;

import java.util.HashMap;
import java.util.Map;

public class ChamadoDAO extends GenericDAO<Chamado> {

    private static final long serialVersionUID = 1L;

    public ChamadoDAO() {
        super(Chamado.class);
    }

    public Chamado findTicketByNumber(long numeroChamado) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ticketNumber", numeroChamado);

        return super.findOneResult(Chamado.FIND_TICKET_BY_NUMBER, parameters);
    }



    public void delete(Chamado chamado) {
        super.delete(chamado.getNumeroChamado(), Chamado.class);
    }


}
