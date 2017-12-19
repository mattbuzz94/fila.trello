package integration.wcc.facade;

import integration.wcc.dao.FilaChamadoDAO;
import integration.wcc.model.FilaChamado;
import org.hibernate.HibernateException;

import java.util.List;

public class FilaChamadoFacade {

    private FilaChamadoDAO FilaChamadoDAO = new FilaChamadoDAO();

    public List<FilaChamado> listAll() {
        FilaChamadoDAO.beginTransaction();
        List<FilaChamado> result = FilaChamadoDAO.findAll();
        FilaChamadoDAO.closeTransaction();
        return result;
    }

    public FilaChamado findTicketByNumber(int filaChamadoNumero, int idFila) {
        FilaChamadoDAO.beginTransaction();
        FilaChamado FilaChamado = FilaChamadoDAO.findTicketFilaByNumber(filaChamadoNumero, idFila);
        FilaChamadoDAO.closeTransaction();
        return FilaChamado;
    }

    public List<FilaChamado> findTicketsByFila(int idFila, String listaDestino) {
        List<FilaChamado> result = null;
        try {
            FilaChamadoDAO.beginTransaction();
            result = FilaChamadoDAO.findTicketsByFila(idFila, listaDestino);
            FilaChamadoDAO.flush();
        } catch (HibernateException e) {
            if (FilaChamadoDAO != null) {
                FilaChamadoDAO.rollback();
            }
            e.printStackTrace();
        } finally {
            FilaChamadoDAO.closeTransaction();
            System.out.print("Fechou no Facade");
        }
        return result;
    }

    public void createFilaChamado(FilaChamado FilaChamado) {
        FilaChamadoDAO.beginTransaction();
        FilaChamadoDAO.save(FilaChamado);
        FilaChamadoDAO.commitAndCloseTransaction();
    }

    public void updateFilaChamado(FilaChamado FilaChamado) {
        FilaChamadoDAO.beginTransaction();
        FilaChamado persistedFilaChamado = FilaChamadoDAO.findTicketFilaByNumber(FilaChamado.getChamado().getNumeroChamado(), FilaChamado.getId_fila());
        //persistedFilaChamado.setChamado(FilaChamado.getChamado());
        persistedFilaChamado.setObservacao(FilaChamado.getObservacao());
        FilaChamadoDAO.update(persistedFilaChamado);
        FilaChamadoDAO.commitAndCloseTransaction();
    }
}
