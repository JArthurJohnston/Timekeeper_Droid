package com.jarthur.timekeeper_droid.application.models;

import junit.framework.TestCase;

import org.json.JSONObject;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by arthur on 4/6/16.
 */
public class ActivityModelTest extends TestCase {

    @Test
    public void testConstructedFromJson() throws Exception{
        String json = "{\"id\":58,\"start_time\":\"2015-01-01T05:30:00.000Z\",\"end_time\":\"2015-01-01T07:45:00.000Z\",\"timesheet_id\":76,\"story_card_id\":8 }";

        JSONObject jsonObject = new JSONObject(json);

        ActivityModel activityModel = new ActivityModel(jsonObject);

        assertEquals(58, activityModel.getId());
        assertEquals(76, activityModel.getTimesheetId());
        assertEquals(8, activityModel.getStoryCardId());

        assertNotNull(activityModel.getStartTime());
        assertNotNull(activityModel.getEndTime());
    }

}