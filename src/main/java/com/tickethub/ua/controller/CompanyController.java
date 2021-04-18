package com.tickethub.ua.controller;

import com.tickethub.ua.models.Company;
import com.tickethub.ua.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("company")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getAll(){
        return companyService.findAll();
    }

    @GetMapping("{id}")
    public Company getOne(@PathVariable("id") Company company){
        return company;
    }

    @PostMapping("/add")
    public Company create(@RequestBody Company company){
        return companyService.create(company);
    }

    @PutMapping("{id}")
    public Company update(@PathVariable("id") Company companyFromDB, @RequestBody Company company){
        BeanUtils.copyProperties(company, companyFromDB, "id");
        return companyService.update(companyFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Company company){
        companyService.deleteById(company.getCompanyId());
    }
}
