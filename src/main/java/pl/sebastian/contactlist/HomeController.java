package pl.sebastian.contactlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class HomeController {



    @RequestMapping("/")
    public String test() {

        return "index";
    }
    @Autowired
    private ContactService service;



    //@PreAuthorize("hasRole('USER')")
    @RequestMapping("/list_contact")//== ("/")

    public String listContact(Model model) {
        List<Contact> listContact=service.listAll();

        model.addAttribute("listContact",listContact);

        return "contact";
    }

    @RequestMapping("/new")//== ("/")

    public String showNewContactForm(Model model) {

        Contact contact=new Contact();

        model.addAttribute("contact",contact);

        return "new_contact";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        service.save(contact);

        return "redirect:/list_contact";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView showEditContactForm(@PathVariable(name = "id") Long id) {

        ModelAndView mav=new ModelAndView("edit_contact");

        Contact contact=service.get(id);
        mav.addObject("contact",contact);
        return mav;
    }

    @RequestMapping(value = "/delete/{id}")

    public String deleteContact(@PathVariable(name="id") Long id) {
        service.delete(id);

        return "redirect:/list_contact";
    }
   // @PreAuthorize("hasRole('ADMIN')")
//    @RequestMapping("/list_admin")
//
//    public String listContactAdmin(Model model) {
//        List<Contact> listContact=service.listAll();
//
//        model.addAttribute("listContact",listContact);
//
//        return "admin_view";
//    }



}
