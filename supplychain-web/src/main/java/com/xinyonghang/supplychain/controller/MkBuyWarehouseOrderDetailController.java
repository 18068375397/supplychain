package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkBuyWarehouseOrderDetailDto;
import com.xinyonghang.supplychain.model.MkBuyWarehouseOrderDetail;
import com.xinyonghang.supplychain.service.MkBuyWarehouseOrderDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/buy/warehouse/order/detail")
public class MkBuyWarehouseOrderDetailController {
    @Resource
    private MkBuyWarehouseOrderDetailService mkBuyWarehouseOrderDetailService;

    @PostMapping("/add")
    public Result add(MkBuyWarehouseOrderDetail mkBuyWarehouseOrderDetail) {
        mkBuyWarehouseOrderDetailService.save(mkBuyWarehouseOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkBuyWarehouseOrderDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkBuyWarehouseOrderDetail mkBuyWarehouseOrderDetail) {
        mkBuyWarehouseOrderDetailService.update(mkBuyWarehouseOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkBuyWarehouseOrderDetail mkBuyWarehouseOrderDetail = mkBuyWarehouseOrderDetailService.findById(id);
        return ResultGenerator.genSuccessResult(mkBuyWarehouseOrderDetail);
    }

    @PostMapping("/list")
    public Result list(MkBuyWarehouseOrderDetailDto mkBuyWarehouseOrderDetailDto) {
        PageInfo pageInfo = mkBuyWarehouseOrderDetailService.findList(mkBuyWarehouseOrderDetailDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
