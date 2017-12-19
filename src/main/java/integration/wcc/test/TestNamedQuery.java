package integration.wcc.test;

import integration.wcc.controller.ChamadoCard;
import integration.wcc.facade.TrelloUserFacade;
import integration.wcc.model.TrelloUser;

import java.util.ArrayList;
import java.util.List;


public class TestNamedQuery {
    public static void main(String[] args) {

        TrelloUser trelloU = new TrelloUser();
        TrelloUserFacade facade2 = new TrelloUserFacade();
        List<TrelloUser> trelloUsers1 = new ArrayList<TrelloUser>();
        trelloUsers1 = facade2.listAll();

        for (TrelloUser trelloUser : trelloUsers1) {
            if (trelloUser.getUserToken() != null) {
                System.out.println("Selectss do usuario: " + trelloUser.getUserName());
                ChamadoCard cards = new ChamadoCard();
                cards.InsereChamado(trelloUser);
            }
        }


    }
}
