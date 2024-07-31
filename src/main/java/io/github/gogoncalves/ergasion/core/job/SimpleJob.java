package io.github.gogoncalves.ergasion.core.job;

import io.github.gogoncalves.ergasion.core.TriggerableJob;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public abstract class SimpleJob extends TriggerableJob {

    @Override
    public TriggerableJob createTrigger() {
        this.trigger = newTrigger()
            .withIdentity(triggerName, group)
            .startNow()
            .withSchedule(simpleSchedule().withIntervalInSeconds(interval).repeatForever())
            .build();
        return this;
    }
}
