package ua.org.bolshakov.service.impl;


import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.dto.SessionDTO;
import ua.org.bolshakov.mapper.BeanMapper;
import ua.org.bolshakov.model.Session;
import ua.org.bolshakov.service.api.Service;

import java.util.List;

public class SessionServiceImpl  implements Service<Integer, SessionDTO> {
    private static SessionServiceImpl service;
    private Dao<Integer, Session> sessionDao;
    private BeanMapper beanMapper;

    private SessionServiceImpl() {
        sessionDao = DaoFactory.getInstance().getSessionDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized SessionServiceImpl getInstance() {
        if (service == null) {
            service = new SessionServiceImpl();
        }
        return service;
    }

    @Override
    public List<SessionDTO> getAll() {
        List<Session> session = sessionDao.getAll();
        List<SessionDTO> sessionDTOs = beanMapper.listMapToList(session, SessionDTO.class);
        return sessionDTOs;
    }

    @Override
    public SessionDTO getById(Integer id) {
        Session session = sessionDao.getById(id);
        SessionDTO sessionDTO = beanMapper.singleMapper(session, SessionDTO.class);
        return sessionDTO;
    }

    @Override
    public void save(SessionDTO SessionDTO) {
        Session session = beanMapper.singleMapper(SessionDTO, Session.class);
        sessionDao.save(session);
    }

    public SessionDTO getByName(String value){
        Session session = sessionDao.getBy("name", value);
        SessionDTO sessionDTO = beanMapper.singleMapper(session, SessionDTO.class);
        return sessionDTO;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(SessionDTO SessionDTO) {
        Session session = beanMapper.singleMapper(SessionDTO, Session.class);
        sessionDao.save(session);
    }
}
