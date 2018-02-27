package integration.wcc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRELLO_USER", schema = "SFW_SUPORTE")
@NamedQueries({
        @NamedQuery(name = "TrelloUser.findInfoByUserName", query = "SELECT u FROM TrelloUser u where u.userName = :login"),
        @NamedQuery(name = "TrelloUser.FindInfoByUserNameAndTipo", query = "SELECT u FROM TrelloUser u where u.userName = :login and u.tipoInfo = :tipo ")
})

public class TrelloUser implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_INFO_BY_USERNAME = "TrelloUser.findInfoByUserName";
    public static final String FIND_INFO_BY_USERNAME_AND_TIPO = "TrelloUser.FindInfoByUserNameAndTipo";
    @Id
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "username")
    private String userName;
    @Column(name = "board_id")
    private String boardID;
    @Column(name = "usertoken")
    private String userToken;
    @Column(name = "list_id")
    private String listID;
    @Column(name = "fila_id")
    private int filaID;
    @Column(name = "equipe")
    private String equipe;
    @Column(name = "tipo_info")
    private String tipoInfo;



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public int getFilaID() {
        return filaID;
    }

    public void setFilaID(int filaID) {
        this.filaID = filaID;
    }

    public String getTipoInfo() {
        return tipoInfo;
    }

    public void setTipoInfo(String tipoInfo) {
        this.tipoInfo = tipoInfo;
    }

    public TrelloUser() {
    }

    public TrelloUser(String userName, String boardID, String userToken, String listID, int filaID) {
        this.userName = userName;
        this.boardID = boardID;
        this.userToken = userToken;
        this.listID = listID;
        this.filaID = filaID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBoardID() {
        return boardID;
    }

    public void setBoardID(String boardID) {
        this.boardID = boardID;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getListID() {
        return listID;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }
}
