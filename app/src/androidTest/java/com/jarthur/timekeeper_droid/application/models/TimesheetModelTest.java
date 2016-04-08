package com.jarthur.timekeeper_droid.application.models;

import com.jarthur.timekeeper_droid.TimekeeperTestCase;

import junit.framework.TestCase;

import org.json.JSONObject;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by arthur on 4/7/16.
 */
public class TimesheetModelTest extends TimekeeperTestCase {


    @Test
    public void testParsesJsonCorrectly() throws Exception{
        String timesheetJson = "{\"id\":78,\"user_id\":10,\"activities\":" +
                "[{\"id\":59,\"start_time\":null,\"end_time\":null,\"timesheet_id\":78,\"story_card_id\":null,\"is_deleted\":null}," +
                "{\"id\":60,\"start_time\":null,\"end_time\":null,\"timesheet_id\":78,\"story_card_id\":null,\"is_deleted\":null}]}";

        JSONObject jsonObject = new JSONObject(timesheetJson);
        TimesheetModel timesheetModel = new TimesheetModel(jsonObject);

        assertEquals(78, timesheetModel.getId());
        assertEquals(10, timesheetModel.getUserId());

        List<ActivityModel> activities = timesheetModel.getActivities();
        assertEquals(2, activities.size());
        assertTypeAndGet(ActivityModel.class, activities.get(0));
        assertTypeAndGet(ActivityModel.class, activities.get(1));

        assertEquals(78, activities.get(0).getTimesheetId());
        assertEquals(59, activities.get(0).getId());
        assertEquals(78, activities.get(1).getTimesheetId());
        assertEquals(60, activities.get(1).getId());

    }

}