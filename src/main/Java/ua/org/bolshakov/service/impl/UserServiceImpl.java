package ua.org.bolshakov.service.impl;

import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.dto.MovieDTO;
import ua.org.bolshakov.dto.UserDTO;
import ua.org.bolshakov.mapper.BeanMapper;
import ua.org.bolshakov.model.User;
import ua.org.bolshakov.service.api.Service;

import java.util.List;

public class UserServiceImpl implements Service<Integer, UserDTO> {

    private static UserServiceImpl service;
    private Dao<Integer, User> userDao;
    private BeanMapper beanMapper;

    private UserServiceImpl() {
        userDao = DaoFactory.getInstance().getUserDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized UserServiceImpl getInstance() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userDao.getAll();
        List<UserDTO> userDTOs = beanMapper.listMapToList(users, UserDTO.class);
        return userDTOs;
    }

    @Override
    public UserDTO getById(Integer id) {
        User user = userDao.getById(id);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void save(UserDTO UserDTO) {
        User user = beanMapper.singleMapper(UserDTO, User.class);
        userDao.save(user);
    }

    public UserDTO getByLogin(String value){
        User user = userDao.getBy("login", value);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(UserDTO entity) {

    }

}