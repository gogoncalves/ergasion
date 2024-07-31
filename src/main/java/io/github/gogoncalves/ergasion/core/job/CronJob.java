package io.github.gogoncalves.ergasion.core.job;

import io.github.gogoncalves.ergasion.core.TriggerableJob;
import org.quartz.Trigger;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public abstract class CronJob extends TriggerableJob {

    private String expression;

    public CronJob expression(String expression) {
        this.expression = expression;
        return this;
    }

    @Override
    public TriggerableJob createTrigger() {
        this.trigger = newTrigger()
            .withIdentity(triggerName, group)
            .withSchedule(cronSchedule(expression))
            .build();
        return this;
    }
}
