package integration.wcc.facade;

import integration.wcc.dao.FilaChamadoDAO;
import integration.wcc.model.FilaChamado;

import java.util.List;

public class FilaChamadoFacade {

    private FilaChamadoDAO FilaChamadoDAO = new FilaChamadoDAO();

    public List<FilaChamado> listAll() {
        FilaChamadoDAO.beginTransaction();
        List<FilaChamado> result = FilaChamadoDAO.findAll();
        FilaChamadoDAO.closeTransaction();
        return result;

    }

    public FilaChamado findTicketByNumber(int filaChamadoNumero) {
        FilaChamadoDAO.beginTransaction();
        FilaChamado FilaChamado = FilaChamadoDAO.findTicketFilaByNumber(filaChamadoNumero);
        FilaChamadoDAO.closeTransaction();
        return FilaChamado;
    }

    public List<FilaChamado> findTicketsByFila(int idFila) {
        FilaChamadoDAO.beginTransaction();
        List<FilaChamado> result = FilaChamadoDAO.findTicketsByFila(idFila);
        FilaChamadoDAO.closeTransaction();
        return result;

    }

    public void createFilaChamado(FilaChamado FilaChamado) {
        FilaChamadoDAO.beginTransaction();
        FilaChamadoDAO.save(FilaChamado);
        FilaChamadoDAO.commitAndCloseTransaction();
    }
/*
    public void updateFilaChamado(FilaChamado FilaChamado) {
        FilaChamadoDAO.beginTransaction();
        FilaChamado persistedFilaChamado = FilaChamadoDAO.find(FilaChamado.getId());
        persistedFilaChamado.setEmail(FilaChamado.getEmail());
        persistedFilaChamado.setName(FilaChamado.getName());
        persistedFilaChamado.setPassword(FilaChamado.getPassword());
        persistedFilaChamado.setRole(FilaChamado.getRole());
        FilaChamadoDAO.update(persistedFilaChamado);
        FilaChamadoDAO.commitAndCloseTransaction();
    }
    */
}
