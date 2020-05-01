package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.*;
import casestudy.javaweb.persistence.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private AccompanyService accompanyService;
    @ModelAttribute("customers")
    public Page<Customer> listCustomer(Pageable pageable) {
        return customerService.findAll(pageable);
    }
    @ModelAttribute("employees")
    public Page<Employee> listEmployee(Pageable pageable) {
        return employeeService.findAll(pageable);
    }
    @ModelAttribute("services")
    public Page<Service> listService(Pageable pageable) {
        return serviceService.findAll(pageable);
    }
    @ModelAttribute("accompanys")
    public List<Accompany> listAccompany(Pageable pageable) {
        return accompanyService.findAll();
    }

    @GetMapping("contracts")
    public ModelAndView listContract(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Contract> contracts;
        if (s.isPresent()) {
            contracts = contractService.findByContractNumberContaining(s.get(), pageable);
        } else {
            contracts = contractService.findAll(pageable);
        }
        return new ModelAndView("contract/listContract", "contracts", contracts);
    }

    @GetMapping("createContract")
    public ModelAndView showFormCreate() {
        return new ModelAndView("contract/createContract", "contract", new Contract());
    }

    @PostMapping("createContract")
    public ModelAndView saveContract(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult,
                                     @CookieValue(value="setHistory", defaultValue = "") String setHistory,
                                     HttpServletResponse response, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/contract/createContract");
            modelAndView.addObject("message", "New Contract created not successfully");
        } else {
            Customer customer=contract.getCustomer();
            customer.setStatus("Registered");
            customerService.save(customer);
            Service service = contract.getService();
            service.setStatus("Registered");
            serviceService.save(service);
            contract.setTotalPay(0);

            setHistory = contract.getContractNumber()+contract.getService().getName();
            Cookie cookie = new Cookie("setHistory", setHistory);
            cookie.setMaxAge(24 * 60 * 60);
            cookie.setPath("/viewHistory");
            response.addCookie(cookie);


            contractService.save(contract);
            Page<Contract> contracts = contractService.findAll(pageable);
            modelAndView = new ModelAndView("contract/listContract");
            modelAndView.addObject("message", "New Contract created successfully");
            modelAndView.addObject("contracts", contracts);
        }

        return modelAndView;
    }

    @GetMapping("editContract/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Contract contract = contractService.findById(id);
        if (contract != null) {
            return new ModelAndView("contract/editContract", "contract", contract);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editContract")
    public ModelAndView updateCustomer(@Validated @ModelAttribute("contract") Contract contract,BindingResult bindingResult, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/contract/editContract");
            modelAndView.addObject("message", "Contract updated not successfully");
        } else {
            Customer customer=contract.getCustomer();
            customer.setStatus("Registered");
            customerService.save(customer);
            Service service = contract.getService();
            service.setStatus("Registered");
            serviceService.save(service);

            if (contract.getContractDetail() != null) {
                contract.setTotalPay(contract.getService().getRentType().getPrice()*
                        (contract.getEndDate().getTime()-contract.getBeginDate().getTime())/(1000*60*60*24) +
                        contract.getContractDetail().getQuantity()*
                                contract.getContractDetail().getAccompany().getPrice());
            } else {
                contract.setTotalPay(0);
            }
            contractService.save(contract);
            Page<Contract> contracts = contractService.findAll(pageable);
            modelAndView = new ModelAndView("contract/listContract");
            modelAndView.addObject("message", "Contract updated successfully");
            modelAndView.addObject("contracts", contracts);
        }
        return modelAndView;
    }

    @GetMapping("deleteContract/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Contract contract = contractService.findById(id);
        if (contract != null) {
            return new ModelAndView("contract/deleteContract", "contract", contract);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("deleteContract")
    public String deleteContract(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        contractService.remove(contract.getId());
        redirectAttributes.addFlashAttribute("message","Contract deleted successfully");
        return "redirect:contracts";
    }
    @GetMapping("deleteAllContracts")
    public String deleteAllContracts(RedirectAttributes redirectAttributes,Pageable pageable) {
        for (Contract contract : contractService.findAll(pageable)) {
            contractService.remove(contract.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All contracts deleted successfully");
        return "redirect:contracts";
    }

    @GetMapping("viewContract/{id}")
    public ModelAndView viewContract(@PathVariable("id")Long id) {
        Contract contract=contractService.findById(id);
        if (contract != null) {
            return new ModelAndView("contract/viewContract", "contract", contract);
        }
        return new ModelAndView("error.404");
    }

    @GetMapping("viewHistory")
    public ModelAndView viewHistoryContract(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return new ModelAndView("viewHistory", "cookies", cookies);
    }
}
