package io.github.gogoncalves.ergasion.example;

import io.github.gogoncalves.ergasion.core.job.DailyTimeIntervalJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalTime;

public class SampleDailyTimeIntervalJob extends DailyTimeIntervalJob {

    public SampleDailyTimeIntervalJob() {
        super.startAt(LocalTime.of(8, 0))
            .endAt(LocalTime.of(23, 59))
            .interval(1);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Executing Sample Daily Time Interval Job: " + jobName);
    }
}
