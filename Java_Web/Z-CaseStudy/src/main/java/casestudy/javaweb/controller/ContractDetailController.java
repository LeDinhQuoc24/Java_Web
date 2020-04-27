package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.Accompany;
import casestudy.javaweb.persistence.entity.Contract;
import casestudy.javaweb.persistence.entity.ContractDetail;

import casestudy.javaweb.persistence.entity.Image;
import casestudy.javaweb.persistence.service.AccompanyService;
import casestudy.javaweb.persistence.service.ContractDetailService;
import casestudy.javaweb.persistence.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AccompanyService accompanyService;
    @ModelAttribute("accompanys")
    public List<Accompany> accompanys() {
        return accompanyService.findAll();
    }
    @ModelAttribute("contracts")
    public Page<Contract> contracts(Pageable pageable) {
        return contractService.findAll(pageable);
    }


    @GetMapping("contractDetails")
    public ModelAndView listContractDetail(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<ContractDetail> contractDetails;
        if (s.isPresent()) {
            contractDetails = contractDetailService.findByQuantityContaining(s.get(), pageable);
        } else {
            contractDetails = contractDetailService.findAll(pageable);
        }
        return new ModelAndView("contractDetail/listContractDetail", "contractDetails", contractDetails);
    }

    @GetMapping("createContractDetail")
    public ModelAndView showFormCreate() {
        return new ModelAndView("contractDetail/createContractDetail", "contractDetail", new ContractDetail());
    }

    @PostMapping("createContractDetail")
    public ModelAndView saveContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail, Pageable pageable) {
        contractDetailService.save(contractDetail);
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("contractDetail/listContractDetail");
        modelAndView.addObject("message", "New ContractDetail created successfully");
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }

    @GetMapping("editContractDetail/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        ContractDetail contractDetail = contractDetailService.findById(id);
        if (contractDetail != null) {
            return new ModelAndView("contractDetail/editContractDetail", "contractDetail", contractDetail);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editContractDetail")
    public ModelAndView updateCustomer(@ModelAttribute("contractDetail") ContractDetail contractDetail, Pageable pageable) {
        contractDetailService.save(contractDetail);
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("contractDetail/listContractDetail");
        modelAndView.addObject("message", "ContractDetail updated successfully");
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }

    @GetMapping("deleteContractDetail/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        ContractDetail contractDetail = contractDetailService.findById(id);
        if (contractDetail != null) {
            return new ModelAndView("contractDetail/deleteContractDetail", "contractDetail", contractDetail);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("deleteContractDetail")
    public String deleteContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail) {
        contractDetailService.remove(contractDetail.getId());
        return "redirect:contractDetails";
    }

    @GetMapping("viewContractDetail/{id}")
    public ModelAndView viewContractDetail(@PathVariable("id")Long id) {
        ContractDetail contractDetail=contractDetailService.findById(id);
        if (contractDetail != null) {
            return new ModelAndView("contractDetail/viewContractDetail", "contractDetail", contractDetail);
        }
        return new ModelAndView("error.404");
    }
}
