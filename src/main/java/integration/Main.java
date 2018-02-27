package integration;

import integration.wcc.controller.ChamadoCard;
import integration.wcc.facade.TrelloUserFacade;
import integration.wcc.model.TrelloUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TrelloUser trelloU = new TrelloUser();
        TrelloUserFacade facade2 = new TrelloUserFacade();
        List<TrelloUser> trelloUsers = new ArrayList<TrelloUser>();
        trelloUsers = facade2.listAll();
        final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        final List<TrelloUser> finalTrelloUsers = trelloUsers;
        ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("Chamados enviados em " + new Date());
                for (TrelloUser trelloUser : finalTrelloUsers) {
                    if (trelloUser.getUserToken() != null) {
                        System.out.println("Selects do usuario: " + trelloUser.getUserName());
                        ChamadoCard cards = new ChamadoCard();
                        cards.InsereChamado(trelloUser, "produtos");
                    }
                }
            }
        }, 0, 3, TimeUnit.MINUTES);
    }
}
