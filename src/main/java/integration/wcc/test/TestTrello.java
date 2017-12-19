package integration.wcc.test;

import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.List;
import org.trello4j.model.Member;

public class TestTrello {
    public static void main(String[] args) {

        String devKey = "99b40dc68a7ca6f8083b36a62db6d2ea";
        String userToken = "10d93ac2e123dfcaed183f514ef73f249fa54ca9936f5b3827e65b4b92db187e";
        String boardId = "5874e18ea3a71833e0ec02c1";
        String listId = "5874e1cb943824b69db54ad6";
        String boardName;
        String listName;
        String cardName;
        String cardDescription;
        Trello trello = new TrelloImpl(devKey,userToken);
        Member member;
        Board b = trello.getBoard(boardId);
        member = trello.getMember("matheusmaciel77");
        trello.getBoardsByMember("matheusmaciel77");

        boardName = b.getName();

        List l = trello.getList(listId);
        listName = l.getName();

        System.out.println("Nome do Quadro: "+ boardName);
        System.out.println("Nome da Lista: "+ listName);
        System.out.println("Nome do Membro: " + member.getId());
        java.util.List<Card> listCards = trello.getCardsByList("5874e1cb943824b69db54ad6");

        for (Card cartao: listCards) {
            System.out.println(cartao.getName());

        }

    }
}
