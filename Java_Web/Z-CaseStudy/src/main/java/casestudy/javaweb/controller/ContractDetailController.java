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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView saveContractDetail(@Validated @ModelAttribute("contractDetail") ContractDetail contractDetail, BindingResult bindingResult, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/contractDetail/createContractDetail");
            modelAndView.addObject("message", "New ContractDetail created not successfully");
        } else {
            //Khi thay đổi 3 giá trị thời gian bắt đầu/kết thúc,số lượng và giá dịch vụ đi kèm sẽ làm thay đổi
            //đến tổng tiền.Riêng giá kiểu thuê dịch vụ thì chưa xử lý @@
            contractDetail.getContract().setTotalPay(contractDetail.getContract().getService().getRentType().getPrice()*
                    (contractDetail.getContract().getEndDate().getTime()-
                            contractDetail.getContract().getBeginDate().getTime())/(1000*60*60*24) +
                    contractDetail.getQuantity()*contractDetail.getAccompany().getPrice());
            contractDetail.getContract().setContractDetail(contractDetail);
            contractDetailService.save(contractDetail);
            Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
            modelAndView = new ModelAndView("contractDetail/listContractDetail");
            modelAndView.addObject("message", "New ContractDetail created successfully");
            modelAndView.addObject("contractDetails", contractDetails);
        }

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
    public ModelAndView updateCustomer(@Validated @ModelAttribute("contractDetail") ContractDetail contractDetail,BindingResult bindingResult, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/contractDetail/editContractDetail");
            modelAndView.addObject("message", "ContractDetail updated not successfully");
        } else {
            contractDetail.getContract().setTotalPay(contractDetail.getContract().getService().getRentType().getPrice()*
                    (contractDetail.getContract().getEndDate().getTime()-
                            contractDetail.getContract().getBeginDate().getTime())/(1000*60*60*24) +
                    contractDetail.getQuantity()*contractDetail.getAccompany().getPrice());
            contractDetail.getContract().setContractDetail(contractDetail);
            contractDetailService.save(contractDetail);
            Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
            modelAndView = new ModelAndView("contractDetail/listContractDetail");
            modelAndView.addObject("message", "ContractDetail updated successfully");
            modelAndView.addObject("contractDetails", contractDetails);
        }
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
    public String deleteContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractDetailService.remove(contractDetail.getId());
        redirectAttributes.addFlashAttribute("message","ContractDetail deleted successfully");
        return "redirect:contractDetails";
    }
    @GetMapping("deleteAllContractDetails")
    public String deleteAllContractDetails(RedirectAttributes redirectAttributes,Pageable pageable) {
        for (ContractDetail contractDetail : contractDetailService.findAll(pageable)) {
            contractDetailService.remove(contractDetail.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All contractDetails deleted successfully");
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
