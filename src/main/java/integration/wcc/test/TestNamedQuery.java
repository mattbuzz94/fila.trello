package integration.wcc.test;

import integration.wcc.facade.FilaChamadoFacade;
import integration.wcc.model.FilaChamado;

import java.util.ArrayList;
import java.util.List;


public class TestNamedQuery {
    public static void main(String[] args) {

        //ChamadoFacade facade = new ChamadoFacade();
        //List<Chamado> chamados = new ArrayList<Chamado>();
        //chamados = facade.listAll();
        //Chamado chamado = new Chamado();
        //chamado = facade.findTicketByNumberWithFila(504355);


        FilaChamadoFacade facade1 = new FilaChamadoFacade();
        List<FilaChamado> chamadosFila = new ArrayList<FilaChamado>();
        chamadosFila = facade1.findTicketsByFila(4140);
        int count = 0;
        for (FilaChamado chamado : chamadosFila) {
            System.out.println(chamado.getChamado().getNumeroChamado());
            System.out.println(chamado.getChamado().getProjeto().getNomeProjeto());
            System.out.println(chamado.getChamado().getTituloChamado());
            System.out.println(chamado.getChamado().getDescricaoChamado());
            System.out.println(chamado.getChamado().getAnalistaNome());
            System.out.println(chamado.getObservacao());
            count++;
            System.out.println("Chamado " + count);
        }

//        System.out.println(chamado.getDescricaoChamado());
        //      System.out.println(chamado.getProjeto().getNomeProjeto());
        //    System.out.println(chamado.getFilaChamado().get(1).getObservacao());
        //  System.out.println(chamado.getFilaChamado().get(1).getId_fila());


    }
}
