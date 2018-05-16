package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkBuyOrderDetailDto;
import com.xinyonghang.supplychain.model.MkBuyOrderDetail;
import com.xinyonghang.supplychain.service.MkBuyOrderDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/buy/order/detail")
public class MkBuyOrderDetailController {
    @Resource
    private MkBuyOrderDetailService mkBuyOrderDetailService;

    @PostMapping("/add")
    public Result add(MkBuyOrderDetail mkBuyOrderDetail) {
        mkBuyOrderDetailService.save(mkBuyOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkBuyOrderDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkBuyOrderDetail mkBuyOrderDetail) {
        mkBuyOrderDetailService.update(mkBuyOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkBuyOrderDetail mkBuyOrderDetail = mkBuyOrderDetailService.findById(id);
        return ResultGenerator.genSuccessResult(mkBuyOrderDetail);
    }

    @PostMapping("/list")
    public Result list(MkBuyOrderDetailDto mkBuyOrderDetailDto) {
        PageInfo pageInfo = mkBuyOrderDetailService.findList(mkBuyOrderDetailDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
