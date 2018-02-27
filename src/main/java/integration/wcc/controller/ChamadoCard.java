package integration.wcc.controller;

import integration.wcc.facade.FilaChamadoFacade;
import integration.wcc.model.Chamado;
import integration.wcc.model.FilaChamado;
import integration.wcc.model.TrelloUser;
import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Card;
import org.trello4j.model.Member;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChamadoCard {
    private int numeroChamado;
    private String observacaoChamado;
    private String devKey = "99b40dc68a7ca6f8083b36a62db6d2ea";
    private String userToken; //= "10d93ac2e123dfcaed183f514ef73f249fa54ca9936f5b3827e65b4b92db187e";
    private String boardId;//"5874e18ea3a71833e0ec02c1";
    private String listId;//= "5874e1cb943824b69db54ad6";
    private String boardName;
    private String listName;
    private String cardName;
    private String cardDescription;
    private LocalDateTime now = LocalDateTime.now();

    //Esse Label ID é do quadro pessoal de Matheus Maciel
    private String idLabels = "5874e18eced82109ffad35ce";

    public String getIdLabels() {
        return idLabels;
    }

    public void setIdLabels(String idLabels) {
        this.idLabels = idLabels;
    }

    private List<FilaChamado> BuscaChamados(int id_fila, String listDestino) {
        FilaChamadoFacade facade1 = new FilaChamadoFacade();
        List<FilaChamado> chamadoFila;
        chamadoFila = facade1.findTicketsByFila(id_fila, listDestino);
        return chamadoFila;
    }

    private void AtualizaChamado(FilaChamado filaChamado) {
        FilaChamadoFacade filaChamadoFacade = new FilaChamadoFacade();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        filaChamado.setObservacao("Enviado Trello " + formattedDateTime);
        filaChamadoFacade.updateFilaChamado(filaChamado);
    }

    private List<Chamado> ValidaNotificacaoTrello(int idFila, String listName) {
        List<FilaChamado> chamadosFila = BuscaChamados(idFila, listName); // 4140 Matheus Maciel
        List<Chamado> chamados = new ArrayList<>();

        //Preenche o lista de chamados com todos os chamados que estão na fila passada por parametro
        for (FilaChamado filaChamado : chamadosFila) {
            numeroChamado = filaChamado.getChamado().getNumeroChamado();
            observacaoChamado = filaChamado.getObservacao();
            if (observacaoChamado != null) {
                if (observacaoChamado.equals("produtos") || observacaoChamado.equals("pessoal")) {
                    chamados.add(filaChamado.getChamado());
                    AtualizaChamado(filaChamado);
                }
            }
        }
        return chamados;
    }

    public void InsereChamado(TrelloUser trelloUser, String listDestino) {
        Trello trello = new TrelloImpl(devKey, trelloUser.getUserToken());
        List<Chamado> chamados = ValidaNotificacaoTrello(trelloUser.getFilaID(), listDestino);
        String cliente;
        String numeroChamado;
        String tituloChamado;
        String descricaoChamado;
        String member;
        Member analista = trello.getMember(trelloUser.getUserName());
        Member backupCoordenador = trello.getMember("vanessasousa9");
        Member backupEspecialista = trello.getMember("renatosantana4");
        Member coordenador = trello.getMember("marcelbatista3");
        Member especialista = trello.getMember("sandragemin");

        Card card = new Card();
        now = now.plusDays(1).minusHours(1);

        List<String> cardMember = new ArrayList<>();
        cardMember.add(analista.getId());
        if (listDestino.equals("produtos")) {
            cardMember.add(backupCoordenador.getId());
            cardMember.add(backupEspecialista.getId());
            cardMember.add(coordenador.getId());
            cardMember.add(especialista.getId());
        }

        card.setIdMembers(cardMember);
        member = retornaMembros(cardMember);

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
            System.out.println(cardName + " - " + trelloUser.getUserName());

            // Aqui são passados os parametros que criam o card no Trello --Notar que cada um vai em um put --
            Map<String, String> map = new HashMap<>();
            map.put("desc", cardDescription);
            map.put("idMembers", member);
            //map.put("idMembers", cardMember.get(1).toString());

            map.put("due", now.toString());

            //map.put("idLabels",idLabels);
            // Checklists não está dando certo
            //map.put("idChecklists",idChecklists);

            card = trello.createCard(trelloUser.getListID(), cardName, map);
        }

    }

    private String retornaMembros(List<String> cardMembros) {
        String idMember;
        StringBuilder members = new StringBuilder();
        for (String element : cardMembros) {
            idMember = element;
            members.append(",").append(idMember);
        }
        return members.substring(1);
    }
}
/*    public void apagaObsChamado(List<Chamado> tickets){
        FilaChamadoFacade facade1 = new FilaChamadoFacade();
        for (Chamado ticket: tickets) {
            facade1.updateFilaChamado();
        }
    }
    public List<Integer> ChamadosNoTrello(TrelloUser trelloUser) {
        Trello trello = new TrelloImpl(devKey, trelloUser.getUserToken());
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
*/