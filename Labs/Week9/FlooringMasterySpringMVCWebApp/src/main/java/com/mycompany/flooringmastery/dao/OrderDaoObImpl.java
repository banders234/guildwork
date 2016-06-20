/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class OrderDaoObImpl  implements OrderDao {
private static final String SQL_INSERT_DVD = "INSERT INTO dvd (title, release_date, director, studio, user_rating, mpaa) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_DVD = "UPDATE dvd SET title = ?, release_date = ?, mpaa = ?, director = ?, studio = ?, user_rating = ? WHERE id = ?";
    private static final String SQL_DELETE_DVD = "DELETE FROM dvd where id = ?";
    private static final String SQL_GET_DVD = "SELECT * FROM dvd where id = ?";
    private static final String SQL_GET_DVD_LIST  = "SELECT * FROM dvd";
    private static final String SQL_GET_DVD_COUNT = "SELECT COUNT(*) FROM dvd";
    private static final String SQL_GET_DVD_LIST_ON_DATE = "SELECT * FROM dvd WHERE release_date = ?";
    private static final String SQL_GET_DVD_DATE_LIST = "SELECT release_date FROM dvd GROUP BY release_date";
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private JdbcTemplate jdbcTemplate;
    
    public OrderDaoObImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order create(Order order) {
        jdbcTemplate.update(SQL_INSERT_DVD, 
                order.getCustomerName(),
                order.getArea(),
                order.getProductId(),
                order.getTaxId());
        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        order.setOrderNumber(id);
        return order;
    }

    @Override
    public void update(Order order) {
        jdbcTemplate.update(SQL_UPDATE_DVD, 
                order.getCustomerName(),
                order.getArea(),
                order.getProductId(),
                order.getTaxId());
    }

    @Override
    public void delete(Order order) {
        jdbcTemplate.update(SQL_DELETE_DVD, order.getOrderNumber());
    }

    @Override
    public Order findOrderByNo(Integer id) {
        return jdbcTemplate.queryForObject(SQL_GET_DVD, new OrderMapper(), id);
    }

    @Override
    public List<Order> getAll() {
        return jdbcTemplate.query(SQL_GET_DVD_LIST, new OrderMapper());
    }


    @Override
    public int getCount() {
        return jdbcTemplate.queryForObject(SQL_GET_DVD_COUNT, Integer.class);
    }

    @Override
    public List<Date> getAllDates() {
        return jdbcTemplate.queryForList(SQL_GET_DVD_DATE_LIST, Date.class);
    }

    @Override
    public List<Order> getOrdersOnDate(Date date) {
        return jdbcTemplate.query(SQL_GET_DVD_LIST_ON_DATE, new OrderMapper());
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTest(boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private static final class OrderMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int i) throws SQLException {
            
            Order order = new Order();
            order.setOrderNumber(rs.getInt("id"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setDate(rs.getDate("order_date"));
            order.setProductType(rs.getString("product.name"));
            order.setState(rs.getString("tax.state"));
            order.setArea(rs.getDouble("area"));
            order.setTaxRate(rs.getDouble("tax.tax_rate"));
            
            return order;
        }
    }
    
}
