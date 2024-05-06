package com.example.myhealthblock.opinion.adapter.in;

import com.example.myhealthblock.opinion.OpinionService;
import com.example.myhealthblock.opinion.dto.OpinionEnrollDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OpinionController {
    private final OpinionService opinionService;

    @PostMapping("/v1/opinion/enroll")
    public String enroll(@RequestBody OpinionEnrollDTO body) {
        return opinionService.enroll(body);
    }
}
