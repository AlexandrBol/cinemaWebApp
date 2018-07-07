package ua.org.bolshakov.service.impl;

import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.dto.HallDTO;
import ua.org.bolshakov.mapper.BeanMapper;
import ua.org.bolshakov.model.Hall;
import ua.org.bolshakov.service.api.Service;

import java.util.List;

public class HallServiceImpl implements Service<Integer, HallDTO> {
    private static HallServiceImpl service;
    private Dao<Integer, Hall> hallDAO;
    private BeanMapper beanMapper;

    private HallServiceImpl() {
        hallDAO = DaoFactory.getInstance().getHallDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized HallServiceImpl getInstance() {
        if (service == null) {
            service = new HallServiceImpl();
        }
        return service;
    }


    @Override
    public List<HallDTO> getAll() {
        List<Hall> halls = hallDAO.getAll();
        List<HallDTO> hallDTOs = beanMapper.listMapToList(halls, HallDTO.class);
        return hallDTOs;
    }

    @Override
    public HallDTO getById(Integer id) {
        Hall hall = hallDAO.getById(id);
        HallDTO hallDTO = beanMapper.singleMapper(hall, HallDTO.class);
        return hallDTO;
    }

    @Override
    public void save(HallDTO HallDTO) {
        Hall hall = beanMapper.singleMapper(HallDTO, Hall.class);
        hallDAO.save(hall);
    }

    public HallDTO getByName(String value){
        Hall hall = hallDAO.getBy("name", value);
        HallDTO hallDTO = beanMapper.singleMapper(hall, HallDTO.class);
        return hallDTO;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(HallDTO HallDTO) {
        Hall hall = beanMapper.singleMapper(HallDTO, Hall.class);
        hallDAO.save(hall);
    }
}
