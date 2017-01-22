package integration.wcc.test;

import integration.wcc.facade.ChamadoFacade;
import integration.wcc.model.Chamado;

/**
 * Created by U6030486 on 22/01/2017.
 */
public class TestNamedQuery {
    public static void main(String[] args) {

        ChamadoFacade facade = new ChamadoFacade();
        //List<Chamado> chamados = new ArrayList<Chamado>();
        //chamados = facade.listAll();
        Chamado chamado = new Chamado();
        chamado = facade.findTicketByNumber(503875);

        System.out.println(chamado.getDescricaoChamado());
    }
}
