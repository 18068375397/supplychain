package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkSailWarehouseOrderDto;
import com.xinyonghang.supplychain.model.MkSailWarehouseOrder;
import com.xinyonghang.supplychain.service.MkSailWarehouseOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/sail/warehouse/order")
public class MkSailWarehouseOrderController {
    @Resource
    private MkSailWarehouseOrderService mkSailWarehouseOrderService;

    @PostMapping("/add")
    public Result add(MkSailWarehouseOrder mkSailWarehouseOrder) {
        mkSailWarehouseOrderService.save(mkSailWarehouseOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkSailWarehouseOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkSailWarehouseOrder mkSailWarehouseOrder) {
        mkSailWarehouseOrderService.update(mkSailWarehouseOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkSailWarehouseOrder mkSailWarehouseOrder = mkSailWarehouseOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mkSailWarehouseOrder);
    }

    @PostMapping("/list")
    public Result list(MkSailWarehouseOrderDto mkSailWarehouseOrderDto) {
        PageInfo pageInfo = mkSailWarehouseOrderService.findList(mkSailWarehouseOrderDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
