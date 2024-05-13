package com.example.myhealthblock.opinion.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.opinion.OpinionService;
import com.example.myhealthblock.opinion.adapter.in.request.RequestOpinionEnroll;
import com.example.myhealthblock.opinion.adapter.in.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OpinionController {
    private final OpinionService opinionService;

    @PostMapping("/v1/opinion/enroll")
    public ResponseResult enroll(@RequestBody RequestOpinionEnroll body) {
        ResponseResult response = new ResponseResult();
        response.setResult(opinionService.enroll(body));
        return response;
    }
}
