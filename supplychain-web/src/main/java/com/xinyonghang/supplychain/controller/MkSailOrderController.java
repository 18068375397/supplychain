package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkSailOrderDto;
import com.xinyonghang.supplychain.model.MkSailOrder;
import com.xinyonghang.supplychain.service.MkSailOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/sail/order")
public class MkSailOrderController {
    @Resource
    private MkSailOrderService mkSailOrderService;

    @PostMapping("/add")
    public Result add(MkSailOrder mkSailOrder) {
        mkSailOrderService.save(mkSailOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkSailOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkSailOrder mkSailOrder) {
        mkSailOrderService.update(mkSailOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkSailOrder mkSailOrder = mkSailOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mkSailOrder);
    }

    @PostMapping("/list")
    public Result list(MkSailOrderDto mkSailOrderDto) {
        PageInfo pageInfo = mkSailOrderService.findList(mkSailOrderDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
