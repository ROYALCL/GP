package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.BaseJunitTest;
import org.jlxy.cmm.entity.Job;
import org.jlxy.cmm.services.JobService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class JobServiceImplTest extends BaseJunitTest {
    @Autowired
    private JobService jobService;

    @Test
    public void save() throws Exception {
        Job job = new Job("test1", "skdjfhaklsdjf");
        if (jobService.save(job)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void selectByParamWithPage() throws Exception {

    }

    @Test
    public void delete() throws Exception {
        if (jobService.delete(7)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void update() throws Exception {
        Job job = new Job("test1", "skdjfasdfasdfhaklsdjf");
        jobService.update(job);
    }

    @Test
    public void selectById() throws Exception {
        Job job = jobService.selectById(1);
        logger.info(job.toString());
    }

    @Test
    public void selectByAll() throws Exception {
        List<Job> jobs = jobService.selectByAll();
        for (Job job : jobs) {
            logger.info(job.toString());
        }
    }

    @Test
    public void countByAll() throws Exception {
        System.out.println(jobService.countByAll());
    }

}