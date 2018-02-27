package integration.wcc.test;

import integration.wcc.controller.ChamadoCard;
import integration.wcc.facade.TrelloUserFacade;
import integration.wcc.model.TrelloUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class TestNamedQuery {
    public static void main(String[] args) {

        TrelloUser trelloU;
        TrelloUserFacade facade2 = new TrelloUserFacade();
        List<TrelloUser> trelloUsers1 = new ArrayList<>();
        trelloUsers1 = facade2.listAll();
        trelloU = facade2.findInfoByUserNameAndInfo("matheusmaciel77", "pessoal");
        /*{
            if (trelloUser.getUserToken() != null) {
                System.out.println("Selectss do usuario: " + trelloUser.getUserName());
                ChamadoCard cards = new ChamadoCard();
                cards.InsereChamado(trelloUser,"produtos");
            }
        }*/
        System.out.println("Usuario: " + trelloU.getUserName());
        //ChamadoCard cards = new ChamadoCard();
        //cards.InsereChamado(trelloU,"pessoal");


    }
}
