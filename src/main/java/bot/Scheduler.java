package bot;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.repeatSecondlyForever;
import static org.quartz.TriggerBuilder.newTrigger;

public class Scheduler {

    static final int COOLDOWN_SECONDS = 20;
    static int jobExecutionNumber = 0;

    public static void main(String[] args) throws Exception {
        org.quartz.Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        JobDetail jobDetail = newJob(LaunchJob.class).build();

        Trigger trigger = newTrigger()
                .startNow()
                .withSchedule(repeatSecondlyForever(COOLDOWN_SECONDS))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    public static class LaunchJob implements Job {
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

            Launcher.launch();
            System.out.println("job : " + jobExecutionNumber++);
        }
    }
}