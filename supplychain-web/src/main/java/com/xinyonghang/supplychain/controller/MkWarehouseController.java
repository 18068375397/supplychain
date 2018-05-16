package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkWarehouseDto;
import com.xinyonghang.supplychain.model.MkWarehouse;
import com.xinyonghang.supplychain.service.MkWarehouseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/05/07.
 */
@RestController
@RequestMapping("/mk/warehouse")
public class MkWarehouseController {
    @Resource
    private MkWarehouseService mkWarehouseService;

    @RequestMapping("/toWarehouseList")
    public ModelAndView toWarehouseList() {
        return new ModelAndView("sub/stock/warehouseList");
    }

    @RequestMapping("/toAddWarehouse")
    public ModelAndView toAddWarehouse() {
        return new ModelAndView("sub/stock/addWarehouse");
    }

    @RequestMapping("/toEditWarehouse")
    public ModelAndView toEditWarehouse() {
        return new ModelAndView("sub/stock/editWarehouse");
    }

    @PostMapping("/add")
    public Result add(MkWarehouse mkWarehouse) {
        mkWarehouseService.save(mkWarehouse);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkWarehouseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkWarehouse mkWarehouse) {
        mkWarehouseService.update(mkWarehouse);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkWarehouse mkWarehouse = mkWarehouseService.findById(id);
        return ResultGenerator.genSuccessResult(mkWarehouse);
    }

    @PostMapping("/list")
    public Result list(MkWarehouseDto mkWarehouseDto) {
        PageInfo pageInfo = mkWarehouseService.findList(mkWarehouseDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
