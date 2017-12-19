package integration.wcc.dao;

import integration.wcc.model.TrelloUser;

import java.util.HashMap;
import java.util.Map;


public class TrelloUserDAO extends GenericDAO<TrelloUser> {

    private static final long serialVersionUID = 1L;

    public TrelloUserDAO() {
        super(TrelloUser.class);
    }

    public TrelloUser findInfoByUserName(String userName) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("login", userName);

        return super.findOneResult(TrelloUser.FIND_INFO_BY_USERNAME, parameters);
    }
}
