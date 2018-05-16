package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkSupplierDto;
import com.xinyonghang.supplychain.model.MkSupplier;
import com.xinyonghang.supplychain.service.MkSupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/supplier")
public class MkSupplierController {
    @Resource
    private MkSupplierService mkSupplierService;

    @PostMapping("/add")
    public Result add(MkSupplier mkSupplier) {
        mkSupplierService.save(mkSupplier);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkSupplierService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkSupplier mkSupplier) {
        mkSupplierService.update(mkSupplier);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkSupplier mkSupplier = mkSupplierService.findById(id);
        return ResultGenerator.genSuccessResult(mkSupplier);
    }

    @PostMapping("/list")
    public Result list(MkSupplierDto mkSupplierDto) {
        PageInfo pageInfo = mkSupplierService.findList(mkSupplierDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
