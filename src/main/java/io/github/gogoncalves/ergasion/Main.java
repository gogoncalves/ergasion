package io.github.gogoncalves.ergasion;

import io.github.gogoncalves.ergasion.core.TriggerableJob;
import io.github.gogoncalves.ergasion.example.SampleDailyTimeIntervalJob;
import io.github.gogoncalves.ergasion.example.SampleSimpleJob;
import org.quartz.SchedulerException;

public class Main {
    public static void main(String[] args) throws SchedulerException {
        TriggerableJob sampleDailyTimeIntervalJob = new SampleDailyTimeIntervalJob();
        sampleDailyTimeIntervalJob.createTrigger().schedule();

        TriggerableJob sampleSimpleJob = new SampleSimpleJob();
        sampleSimpleJob.createTrigger().schedule();
    }
}
