package com.example.myhealthblock.opinion.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.opinion.OpinionService;
import com.example.myhealthblock.opinion.adapter.in.request.RequestOpinionEnroll;
import com.example.myhealthblock.opinion.adapter.in.response.ResponseOpinions;
import com.example.myhealthblock.opinion.adapter.in.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/test-0/opinion/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return new ResponseResult();
    }

    @GetMapping("/test-0/opinions")
    public ResponseOpinions getOpinions(
            @RequestParam(required = false) Integer questionId,
            @RequestParam(required = false) String userId
    ) {
        if (userId != null) {
//            특정 사용자가 작성한 의견 조회
        } else {
//            특정 질문에 대한 의견 조회
        }
        return new ResponseOpinions();
    }
}
