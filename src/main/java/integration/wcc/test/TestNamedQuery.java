package integration.wcc.test;

import integration.wcc.facade.ChamadoFacade;
import integration.wcc.model.Chamado;


public class TestNamedQuery {
    public static void main(String[] args) {

        ChamadoFacade facade = new ChamadoFacade();
        //List<Chamado> chamados = new ArrayList<Chamado>();
        //chamados = facade.listAll();
        Chamado chamado = new Chamado();
        chamado = facade.findTicketByNumberWithFila(504355);

        /*
        FilaChamadoFacade facade1 = new FilaChamadoFacade();
        List<FilaChamado> chamadosFila = new ArrayList<FilaChamado>();
        chamadosFila = facade1.findTicketsByFila(4140);

        System.out.println(chamadosFila.get(0).getChamado().getTituloChamado());
*/
        System.out.println(chamado.getDescricaoChamado());
        System.out.println(chamado.getProjeto().getNomeProjeto());
        System.out.println(chamado.getFilaChamado().get(1).getObservacao());
        System.out.println(chamado.getFilaChamado().get(1).getId_fila());

        System.out.println(chamado.getFilaChamado().get(1).getFila_detail().getNomeFila());
    }
}
