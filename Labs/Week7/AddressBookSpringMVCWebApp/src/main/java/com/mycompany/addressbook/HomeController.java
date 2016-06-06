package com.mycompany.addressbook;

import com.mycompany.addressbook.dao.AddressDao;
import com.mycompany.addressbook.dto.Address;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/"})
public class HomeController {
    private AddressDao addressDao;
    
    @Inject
    public HomeController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Address> addresses = addressDao.list();
        model.put("address", new Address());
        model.put("addresses", addresses);
        return "home";
    }
}
