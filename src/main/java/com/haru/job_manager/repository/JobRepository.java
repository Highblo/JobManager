package com.haru.job_manager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.haru.job_manager.entity.Job;

@Repository
public class JobRepository {

    public List<Job> findAll() {

        return List.of(
                new Job(1L, "外貨預金取引明細表", "正常終了"),
                new Job(2L, "流動性集計", "実行中"),
                new Job(3L, "月次レポート作成", "異常終了")
        );

    }

}