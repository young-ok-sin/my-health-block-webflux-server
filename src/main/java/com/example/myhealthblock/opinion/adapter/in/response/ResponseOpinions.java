package com.example.myhealthblock.opinion.adapter.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOpinions {
    private Opinion[] opinions;

    @Getter
    @Setter
    public static class Opinion {
        private Integer id;
        private String userId;
        private String content;
        private Date createDate;
    }
}
