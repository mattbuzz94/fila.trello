package integration;

import integration.wcc.controller.ChamadoCard;
import integration.wcc.facade.TrelloUserFacade;
import integration.wcc.model.TrelloUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TrelloUser trelloU = new TrelloUser();
        // Pega qual para onde será enviado os chamados.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Produtos ou Pessoal?");
        String tipoLista = scanner.nextLine();
        tipoLista = tipoLista.toLowerCase();

        TrelloUserFacade facade2 = new TrelloUserFacade();
        List<TrelloUser> trelloUsers = new ArrayList<>();
        TrelloUser trelloUser = new TrelloUser();

        if (tipoLista.equals("produtos")) {
            trelloUsers = facade2.listAll();
        } else if (tipoLista.equals("pessoal")) {
            trelloUser = facade2.findInfoByUserNameAndInfo("matheusmaciel77", tipoLista);
            System.out.println("Usuario: " + trelloU.getUserName());
        }
        final List<TrelloUser> finalTrelloUsers = trelloUsers;
        final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        final String finalTipoLista = tipoLista;
        final TrelloUser finalTrelloUser = trelloUser;

        ses.scheduleWithFixedDelay(() -> {
            System.out.println("Chamados enviados em " + new Date());
            if (finalTipoLista.equals("produtos")) {
                for (TrelloUser trelloUser1 : finalTrelloUsers) {
                    if (trelloUser1.getUserToken() != null) {
                        System.out.println("Selects do usuario: " + trelloUser1.getUserName());
                        ChamadoCard cards = new ChamadoCard();
                        cards.InsereChamado(trelloUser1, finalTipoLista);
                    }
                }
            } else {
                System.out.println("Selects do usuario: " + finalTrelloUser.getUserName());
                ChamadoCard cards = new ChamadoCard();
                cards.InsereChamado(finalTrelloUser, finalTipoLista);
            }
        }, 0, 3, TimeUnit.MINUTES);
    }
}
