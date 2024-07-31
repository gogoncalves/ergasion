package io.github.gogoncalves.ergasion.core.job;

import io.github.gogoncalves.ergasion.core.TriggerableJob;
import org.quartz.Trigger;

import java.util.Date;

import static org.quartz.CalendarIntervalScheduleBuilder.calendarIntervalSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public abstract class CalendarIntervalJob extends TriggerableJob {

    private int intervalInDays;
    private Date startDate;
    private Date endDate;

    public CalendarIntervalJob intervalInDays(int intervalInDays) {
        this.intervalInDays = intervalInDays;
        return this;
    }

    public CalendarIntervalJob startDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public CalendarIntervalJob endDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public TriggerableJob createTrigger() {
        this.trigger = newTrigger()
            .withIdentity(triggerName, group)
            .startAt(startDate)
            .endAt(endDate)
            .withSchedule(calendarIntervalSchedule().withIntervalInDays(intervalInDays))
            .forJob(jobName, group)
            .build();
        return this;
    }
}
