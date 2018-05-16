package com.xinyonghang.supplychain.valid;

import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by CodeGeneratorTool on 2018/04/26.
 */
@Component("mkProductValid")
public class MkProductValid {
    public Result add(Map<String, Object> param) {
        List<String> msgList = new ArrayList<String>();
        System.out.println("进入参数验证:" + param.get("attributeOne"));


        return ResultGenerator.genSuccessResult();
    }
}
