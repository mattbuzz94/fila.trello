package integration.wcc.controller;

import integration.wcc.facade.FilaChamadoFacade;
import integration.wcc.model.Chamado;
import integration.wcc.model.FilaChamado;
import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Board;
import org.trello4j.model.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChamadoCard {

    private int numeroChamado;
    private String observacaoChamado;
    String devKey = "99b40dc68a7ca6f8083b36a62db6d2ea";
    String userToken = "10d93ac2e123dfcaed183f514ef73f249fa54ca9936f5b3827e65b4b92db187e";
    String boardId = "5874e18ea3a71833e0ec02c1";
    String listId = "5874e1cb943824b69db54ad6";
    String boardName;
    String listName;
    String cardName;
    String cardDescription;
    Trello trello = new TrelloImpl(devKey, userToken);


    public List<FilaChamado> BuscaChamados(int id_fila) {
        FilaChamadoFacade facade1 = new FilaChamadoFacade();
        List<FilaChamado> chamadoFila = new ArrayList<FilaChamado>();
        chamadoFila = facade1.findTicketsByFila(id_fila);
        return chamadoFila;
    }

    public List<Integer> ChamadosNoTrello() {

        String nameCard;
        int numChamado;

        List<Integer> numChamados = new ArrayList<Integer>();


        Board b = trello.getBoard(boardId);

        boardName = b.getName();

        org.trello4j.model.List l = trello.getList(listId);
        listName = l.getName();

        System.out.println("Nome do Quadro: " + boardName);
        System.out.println("Nome da Lista: " + listName);

        java.util.List<Card> listCards = trello.getCardsByList("5874e1cb943824b69db54ad6");

        for (Card cartao : listCards) {
            nameCard = cartao.getName().substring(0, 6);
            numChamado = Integer.parseInt(nameCard);
            numChamados.add(numChamado);
        }
        return numChamados;

    }

    public List<Chamado> ValidaNotificacaoTrello() {
        //Alterar posteriormente pois está passando o parametro de fila via harcode
        List<FilaChamado> chamadosFila = BuscaChamados(4140);
        List<Chamado> chamados = new ArrayList<Chamado>();


        //Preenche o lista de chamados com todos os chamados que estão na fila passada por parametro
        for (FilaChamado filaChamado : chamadosFila) {
            numeroChamado = filaChamado.getChamado().getNumeroChamado();
            observacaoChamado = filaChamado.getObservacao();
            if (observacaoChamado != null) {
                if (observacaoChamado.equals("Enviar Trello")) {
                    chamados.add(filaChamado.getChamado());
                }
            }
        }
        return chamados;
    }

    public void InsereChamado() {
        List<Chamado> chamados = ValidaNotificacaoTrello();
        String cliente;
        String numeroChamado;
        String tituloChamado;
        String descricaoChamado;
        for (Chamado chamado : chamados) {
            numeroChamado = String.valueOf(chamado.getNumeroChamado());
            cliente = chamado.getProjeto().getNomeProjeto();
            tituloChamado = chamado.getTituloChamado();
            descricaoChamado = chamado.getDescricaoChamado();

            StringBuilder title = new StringBuilder();
            title.append(numeroChamado);
            title.append(" - ");
            title.append(cliente);
            title.append(" - ");
            title.append(tituloChamado);

            cardName = title.toString();
            cardDescription = descricaoChamado;

            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", cardDescription);

            Card card = trello.createCard(listId, cardName, map);
            List<String> cardMember = new ArrayList<String>();
            cardMember.add("573f6210f01944062044c9e7");
            card.setIdMembers(cardMember);
            //card.setPos(99);
        }
    }
}
