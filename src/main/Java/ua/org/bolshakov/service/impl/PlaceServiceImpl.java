package ua.org.bolshakov.service.impl;

import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.dto.PlaceDTO;
import ua.org.bolshakov.mapper.BeanMapper;
import ua.org.bolshakov.model.Place;
import ua.org.bolshakov.service.api.Service;

import java.util.List;

public class PlaceServiceImpl implements Service<Integer, PlaceDTO> {
    private static PlaceServiceImpl service;
    private Dao<Integer, Place> placeDao;
    private BeanMapper beanMapper;

    private PlaceServiceImpl() {
        placeDao = DaoFactory.getInstance().getPlaceDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized PlaceServiceImpl getInstance() {
        if (service == null) {
            service = new PlaceServiceImpl();
        }
        return service;
    }


    @Override
    public List<PlaceDTO> getAll() {
        List<Place> place = placeDao.getAll();
        List<PlaceDTO> placeDTOs = beanMapper.listMapToList(place, PlaceDTO.class);
        return placeDTOs;
    }

    @Override
    public PlaceDTO getById(Integer id) {
        Place place = placeDao.getById(id);
        PlaceDTO placeDTO = beanMapper.singleMapper(place, PlaceDTO.class);
        return placeDTO;
    }

    @Override
    public void save(PlaceDTO PlaceDTO) {
        Place place = beanMapper.singleMapper(PlaceDTO, Place.class);
        placeDao.save(place);
    }

    public PlaceDTO getByName(String value){
        Place place = placeDao.getBy("name", value);
        PlaceDTO placeDTO = beanMapper.singleMapper(place, PlaceDTO.class);
        return placeDTO;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(PlaceDTO PlaceDTO) {
        Place place = beanMapper.singleMapper(PlaceDTO, Place.class);
        placeDao.save(place);
    }
}
