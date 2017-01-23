package integration.wcc.facade;

import integration.wcc.model.Chamado;
import integration.wcc.dao.ChamadoDAO;
import java.util.List;

public class ChamadoFacade {

    private ChamadoDAO ChamadoDAO = new ChamadoDAO();


    public List<Chamado> listAll() {
        ChamadoDAO.beginTransaction();
        List<Chamado> result = ChamadoDAO.findAll();
        ChamadoDAO.closeTransaction();
        return result;

    }

    public Chamado findTicketByNumber(int chamadoNumero) {
        ChamadoDAO.beginTransaction();
        Chamado Chamado = ChamadoDAO.findTicketByNumber(chamadoNumero);
        ChamadoDAO.closeTransaction();
        return Chamado;
    }

    public void createChamado(Chamado Chamado) {
        ChamadoDAO.beginTransaction();
        ChamadoDAO.save(Chamado);
        ChamadoDAO.commitAndCloseTransaction();
    }
/*
    public void updateChamado(Chamado Chamado) {
        ChamadoDAO.beginTransaction();
        Chamado persistedChamado = ChamadoDAO.find(Chamado.getId());
        persistedChamado.setEmail(Chamado.getEmail());
        persistedChamado.setName(Chamado.getName());
        persistedChamado.setPassword(Chamado.getPassword());
        persistedChamado.setRole(Chamado.getRole());
        ChamadoDAO.update(persistedChamado);
        ChamadoDAO.commitAndCloseTransaction();
    }
    */

}
