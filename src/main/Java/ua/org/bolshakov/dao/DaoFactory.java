package ua.org.bolshakov.dao;

import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.dao.impl.MovieDaoImpl;
import ua.org.bolshakov.dao.impl.RoleDAOImpl;
import ua.org.bolshakov.dao.impl.UserDaoImpl;
import ua.org.bolshakov.helper.PropertyHolder;
import ua.org.bolshakov.model.*;


public class DaoFactory {
    private static DaoFactory instance = null;

    private Dao<Integer, Movie> movieDao;
    private Dao<Integer, User> userDao;
    private Dao<Integer, Role> roleDao;

    private DaoFactory(){
        loadDaos();
    }



    public static DaoFactory getInstance(){
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }

    private void loadDaos() {
       if(PropertyHolder.getInstance().isInMemoryDB()){
            //inmemory daos
       }else{
           //jdbc daos
           movieDao = MovieDaoImpl.getInstance();
           userDao = new UserDaoImpl();
           roleDao = new RoleDAOImpl();
       }
    }

    public Dao<Integer, Movie> getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(Dao<Integer, Movie> movieDao) {
        this.movieDao = movieDao;
    }

    public static void setInstance(DaoFactory instance) {
        DaoFactory.instance = instance;
    }

    public Dao<Integer, User> getUserDao() {
        return userDao;
    }

    public void setUserDao(Dao<Integer, User> userDao) {
        this.userDao = userDao;
    }

    public Dao<Integer, Role> getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(Dao<Integer, Role> roleDao) {
        this.roleDao = roleDao;
    }
}
