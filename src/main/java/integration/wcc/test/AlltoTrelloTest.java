package integration.wcc.test;

import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Card;
import org.trello4j.model.Member;

import java.util.ArrayList;
import java.util.List;


public class AlltoTrelloTest {


    public static void main(String[] args) throws Exception {
        String devKey = "99b40dc68a7ca6f8083b36a62db6d2ea";
        String userToken = "10d93ac2e123dfcaed183f514ef73f249fa54ca9936f5b3827e65b4b92db187e";
        Trello trello = new TrelloImpl(devKey, userToken);
        Member analista = trello.getMember("matheusmaciel77");
        Member backupCoordenador = trello.getMember("vanessasousa9");
        Member backupEspecialista = trello.getMember("renatosantana4");
        Member coordenador = trello.getMember("marcelbatista3");
        Member especialista = trello.getMember("sandragemin");


        Card card = new Card();

        List<String> cardMember = new ArrayList<String>();
        cardMember.add(analista.getId());
        cardMember.add(backupCoordenador.getId());
        cardMember.add(backupEspecialista.getId());
        cardMember.add(coordenador.getId());
        cardMember.add(especialista.getId());
        card.setIdMembers(cardMember);


        String meb = retornaMembros(cardMember);

        System.out.println(meb);

    }


    public static String retornaMembros(List<String> cardMembros) {


        String idMember;
        String members = "";
        for (String element : cardMembros) {
            idMember = element;
            members += "," + idMember;

        }
        return members.substring(1);
    }
}
