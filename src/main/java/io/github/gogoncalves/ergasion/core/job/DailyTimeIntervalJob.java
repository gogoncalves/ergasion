package io.github.gogoncalves.ergasion.core.job;

import io.github.gogoncalves.ergasion.core.TriggerableJob;
import org.quartz.TimeOfDay;
import org.quartz.Trigger;

import java.time.LocalTime;

import static org.quartz.DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public abstract class DailyTimeIntervalJob extends TriggerableJob {

    private LocalTime startAt;
    private LocalTime endAt;

    public DailyTimeIntervalJob startAt(LocalTime startAt) {
        this.startAt = startAt;
        return this;
    }

    public DailyTimeIntervalJob endAt(LocalTime endAt) {
        this.endAt = endAt;
        return this;
    }

    @Override
    public TriggerableJob createTrigger() {
        this.trigger = newTrigger()
            .withIdentity(triggerName, group)
            .withSchedule(
                dailyTimeIntervalSchedule()
                    .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(startAt.getHour(), startAt.getMinute()))
                    .endingDailyAt(TimeOfDay.hourAndMinuteOfDay(endAt.getHour(), endAt.getMinute()))
                    .withIntervalInSeconds(interval)
                    .withMisfireHandlingInstructionDoNothing()
            )
            .modifiedByCalendar(calendar)
            .forJob(jobName, group)
            .build();
        return this;
    }
}
