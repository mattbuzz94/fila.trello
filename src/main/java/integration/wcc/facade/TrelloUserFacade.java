package integration.wcc.facade;

import integration.wcc.dao.TrelloUserDAO;
import integration.wcc.model.TrelloUser;

import java.util.List;

public class TrelloUserFacade {
    private TrelloUserDAO trelloUserDAO = new TrelloUserDAO();


    public List<TrelloUser> listAll() {
        trelloUserDAO.beginTransaction();
        List<TrelloUser> result = trelloUserDAO.findAll();
        trelloUserDAO.closeTransaction();
        return result;
    }

    public TrelloUser findInfoByUserName(String userName) {
        trelloUserDAO.beginTransaction();
        TrelloUser trelloUser = trelloUserDAO.findInfoByUserName(userName);
        trelloUserDAO.closeTransaction();
        return trelloUser;
    }

    public void createTrelloUser(TrelloUser TrelloUser) {
        trelloUserDAO.beginTransaction();
        trelloUserDAO.save(TrelloUser);
        trelloUserDAO.commitAndCloseTransaction();
    }
/*
    public void updateTrelloUser(TrelloUser TrelloUser) {
        TrelloUserDAO.beginTransaction();
        TrelloUser persistedTrelloUser = TrelloUserDAO.find(TrelloUser.getId());
        persistedTrelloUser.setEmail(TrelloUser.getEmail());
        persistedTrelloUser.setName(TrelloUser.getName());
        persistedTrelloUser.setPassword(TrelloUser.getPassword());
        persistedTrelloUser.setRole(TrelloUser.getRole());
        TrelloUserDAO.update(persistedTrelloUser);
        TrelloUserDAO.commitAndCloseTransaction();
    }
    */

}
