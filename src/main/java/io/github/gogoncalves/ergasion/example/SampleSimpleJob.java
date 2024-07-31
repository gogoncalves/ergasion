package io.github.gogoncalves.ergasion.example;

import io.github.gogoncalves.ergasion.core.job.SimpleJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SampleSimpleJob extends SimpleJob {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Executing Simple Job: " + jobName);
    }
}
