package ua.org.bolshakov.dao.impl;

public class SQLs {
    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String FIND_BY = "Select * from %s where %s = ?";
    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";

    public static  final String INSERT_MOVIE = "Insert into movie (title, description, duration, rent_start, rent_end, genre, rating, poster, video) values (?,?,?,?,?,?,?,?,?)";
    public static  final String UPDATE_MOVIE = "UPDATE movie SET title = ?, description = ?, duration = ?, rent_start = ?, rent_end = ?, genre = ?, rating = ?,poster = ?, video = ? WHERE id = ?";

    public static  final String UPDATE_USER = "UPDATE user SET login = ?, password = ?, first_name = ?, last_name = ?, email = ?, sex = ?, birthday = ?, role_id = ?, WHERE id = ?";
    public static  final String INSERT_USER = "Insert into user (login, password, first_name, last_name, email, sex, birthday, role_id) values (?,?,?,?,?,?,?,?)";

    public static  final String INSERT_TICKET= "Insert into ticket (id_place = ? ) values (?)";
    public static  final String UPDATE_TICKET = "UPDATE ticket SET id_place = ?, WHERE id = ?";

    public static  final String INSERT_SESSION= "Insert into session (movie_id, hall_id , date_session) values (?,?,?)";
    public static  final String UPDATE_SESSION = "UPDATE session SET movie_id = ? , hall_id = ? , date_session = ?, WHERE id = ?";

    public static  final String INSERT_PLACE= "Insert into place (seat = ? , row= ? , status = ? , session_id = ? ) values (?,?,?,?)";
    public static  final String UPDATE_PLACE = "UPDATE place SET seat = ? , row= ? , status = ? , session_id = ?";

    public static  final String INSERT_HALL= "Insert into hall (name = ? , price=? ) values (?,?)";
    public static  final String UPDATE_HALL = "UPDATE hall SET name = ?, price = ?, WHERE id = ?";

    public static  final String INSERT_ORDER= "Insert into order (id_ticket =? , Id_user=? ) values (?,?)";
    public static  final String UPDATE_ORDER = "UPDATE order SET id_ticket = ?, Id_user = ?, WHERE id = ?";



}
