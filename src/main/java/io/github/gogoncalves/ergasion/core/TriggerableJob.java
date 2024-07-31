package io.github.gogoncalves.ergasion.core;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.UUID;

public abstract class TriggerableJob implements Job {

    private static Scheduler scheduler;

    protected String jobName = "job-" + UUID.randomUUID();
    protected String triggerName = "trigger-" + UUID.randomUUID();
    protected String group = "defaultGroup";
    protected String calendar = "defaultCalendar";
    protected Integer interval = 60;
    protected Trigger trigger;

    protected TriggerableJob job(String name) {
        this.jobName = name;
        return this;
    }

    protected TriggerableJob trigger(String name) {
        this.triggerName = name;
        return this;
    }

    protected TriggerableJob group(String name) {
        this.group = name;
        return this;
    }

    public TriggerableJob interval(int intervalInSeconds) {
        this.interval = intervalInSeconds;
        return this;
    }

    public abstract TriggerableJob createTrigger();

    private static Scheduler getScheduler() throws SchedulerException {
        if (scheduler == null) {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        }
        return scheduler;
    }

    public void schedule() throws SchedulerException {
        Scheduler scheduler = getScheduler();
        JobDetail jobDetail = org.quartz.JobBuilder.newJob(getClass()).withIdentity(jobName, group).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
