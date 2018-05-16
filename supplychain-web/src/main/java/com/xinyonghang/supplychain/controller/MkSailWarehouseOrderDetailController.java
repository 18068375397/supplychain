package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkSailWarehouseOrderDetailDto;
import com.xinyonghang.supplychain.model.MkSailWarehouseOrderDetail;
import com.xinyonghang.supplychain.service.MkSailWarehouseOrderDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/sail/warehouse/order/detail")
public class MkSailWarehouseOrderDetailController {
    @Resource
    private MkSailWarehouseOrderDetailService mkSailWarehouseOrderDetailService;

    @PostMapping("/add")
    public Result add(MkSailWarehouseOrderDetail mkSailWarehouseOrderDetail) {
        mkSailWarehouseOrderDetailService.save(mkSailWarehouseOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkSailWarehouseOrderDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkSailWarehouseOrderDetail mkSailWarehouseOrderDetail) {
        mkSailWarehouseOrderDetailService.update(mkSailWarehouseOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkSailWarehouseOrderDetail mkSailWarehouseOrderDetail = mkSailWarehouseOrderDetailService.findById(id);
        return ResultGenerator.genSuccessResult(mkSailWarehouseOrderDetail);
    }

    @PostMapping("/list")
    public Result list(MkSailWarehouseOrderDetailDto mkSailWarehouseOrderDetailDto) {
        PageInfo pageInfo = mkSailWarehouseOrderDetailService.findList(mkSailWarehouseOrderDetailDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
