package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkBuyWarehouseOrderDto;
import com.xinyonghang.supplychain.model.MkBuyWarehouseOrder;
import com.xinyonghang.supplychain.service.MkBuyWarehouseOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/buy/warehouse/order")
public class MkBuyWarehouseOrderController {
    @Resource
    private MkBuyWarehouseOrderService mkBuyWarehouseOrderService;

    @PostMapping("/add")
    public Result add(MkBuyWarehouseOrder mkBuyWarehouseOrder) {
        mkBuyWarehouseOrderService.save(mkBuyWarehouseOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkBuyWarehouseOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkBuyWarehouseOrder mkBuyWarehouseOrder) {
        mkBuyWarehouseOrderService.update(mkBuyWarehouseOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkBuyWarehouseOrder mkBuyWarehouseOrder = mkBuyWarehouseOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mkBuyWarehouseOrder);
    }

    @PostMapping("/list")
    public Result list(MkBuyWarehouseOrderDto mkBuyWarehouseOrderDto) {
        PageInfo pageInfo = mkBuyWarehouseOrderService.findList(mkBuyWarehouseOrderDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
