package com.example.myhealthblock.opinion.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.opinion.OpinionService;
import com.example.myhealthblock.opinion.dto.OpinionEnrollDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OpinionController {
    private final OpinionService opinionService;

    @PostMapping("/v1/opinion/enroll")
    public Map<String, String> enroll(@RequestBody OpinionEnrollDTO body) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", opinionService.enroll(body));
        return map;
    }
}
