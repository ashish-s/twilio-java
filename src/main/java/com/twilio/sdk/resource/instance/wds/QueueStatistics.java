package com.twilio.sdk.resource.instance.wds;

import com.twilio.sdk.TwilioWdsClient;
import com.twilio.sdk.resource.InstanceResource;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Statistics about task distribution.
 */
public class QueueStatistics extends InstanceResource<TwilioWdsClient> {

	private static final String CUMULATIVE_PROPERTY = "cumulative";

	private static final String REALTIME_PROPERTY = "realtime";

	private static final String TASKS_BY_STATUS_PROPERTY = "tasks_by_status";

	private static final String WORKSPACE_SID_PROPERTY = "workspace_sid";

	/**
	 * Instantiates a queue.
	 *
	 * @param client the client
	 */
	public QueueStatistics(final TwilioWdsClient client) {
		super(client);
	}

	/**
	 * Instantiates a queue.
	 *
	 * @param client the client
	 * @param properties the properties
	 */
	public QueueStatistics(final TwilioWdsClient client, final Map<String, Object> properties) {
		super(client, properties);
	}

	/**
	 * Instantiates a queue.
	 *
	 * @param client the client
	 * @param workspaceSid the workspace sid
	 * @param queueSid the queue sid
	 */
	public QueueStatistics(final TwilioWdsClient client, final String workspaceSid, final String queueSid) {
		super(client);
		if (workspaceSid == null || "".equals(workspaceSid)) {
			throw new IllegalArgumentException("The workspaceSid for a QueueStatistics cannot be null");
		}
		if (queueSid == null || "".equals(queueSid)) {
			throw new IllegalArgumentException("The queueSid for a QueueStatistics cannot be null");
		}
		setProperty(WORKSPACE_SID_PROPERTY, workspaceSid);
		setProperty(SID_PROPERTY, queueSid);
	}

	/**
	 * Get the activity statistics.
	 *
	 * @return the activity statistics
	 */
	public Set<ActivityStatistic> getActivityStatistics() {
		try {
			List<Map<String, Object>> props = (List<Map<String, Object>>) getRealtime().get("activity_statistics");

			Set<ActivityStatistic> activityStatistics = new HashSet<ActivityStatistic>();

			for (Map<String, Object> prop : props) {
				ActivityStatistic activityStatistic = mapToActivityStatistic(prop);
				activityStatistics.add(activityStatistic);
			}

			return Collections.unmodifiableSet(activityStatistics);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	/**
	 * Get the number of assigned tasks.
	 *
	 * @return number of assigned tasks
	 */
	public Integer getAssignedTasks() {
		Map<String, Object> tasksByStatus = (Map<String, Object>) getRealtime().get(TASKS_BY_STATUS_PROPERTY);
		return (Integer) tasksByStatus.get("assigned");
	}

	/**
	 * Get the average time of task acceptance in seconds.
	 *
	 * @return the average time of task acceptance in seconds
	 */
	public Double getAverageTaskAcceptanceTime() {
		try {
			Object prop = getCumulative().get("avg_task_acceptance_time");
			if (prop instanceof Integer) {
				return Double.parseDouble(prop.toString());
			} else {
				return (Double) prop;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	/**
	 * Get the end time.
	 *
	 * @return the end time
	 */
	public Date getEndTime() {
		return parseDate((String) getCumulative().get("start_time"));
	}

	/**
	 * Get the longest task waiting age in seconds.
	 *
	 * @return the longest task waiting age in seconds
	 */
	public Integer getLongestTaskWaitingAge() {
		return (Integer) getRealtime().get("longest_task_waiting_age");
	}

	/**
	 * Get the sid of the longest waiting task.
	 *
	 * @return the sid of the longest waiting task
	 */
	public String getLongestTaskWaitingSid() {
		return (String) getRealtime().get("longest_task_waiting_sid");
	}

	/**
	 * Get the number of pending tasks.
	 *
	 * @return the number of pending tasks
	 */
	public Integer getPendingTasks() {
		Map<String, Object> tasksByStatus = (Map<String, Object>) getRealtime().get(TASKS_BY_STATUS_PROPERTY);
		return (Integer) tasksByStatus.get("pending");
	}

	/**
	 * Get the number of accepted reservations.
	 *
	 * @return the number of accepted reservations
	 */
	public Integer getReservationsAccepted() {
		return (Integer) getCumulative().get("reservations_accepted");
	}

	/**
	 * Get the number of rejected reservations.
	 *
	 * @return the number of rejected reservations
	 */
	public Integer getReservationsRejected() {
		return (Integer) getCumulative().get("reservations_rejected");
	}

	/**
	 * Get the number of timed out reservations.
	 *
	 * @return the number of timed out reservations
	 */
	public Integer getReservationsTimedOut() {
		return (Integer) getCumulative().get("reservations_timed_out");
	}

	/**
	 * Get the number of reserved tasks.
	 *
	 * @return the number of reserved tasks
	 */
	public Integer getReservedTasks() {
		Map<String, Object> tasksByStatus = (Map<String, Object>) getRealtime().get(TASKS_BY_STATUS_PROPERTY);
		return (Integer) tasksByStatus.get("reserved");
	}

	/**
	 * Get the start time.
	 *
	 * @return the start time
	 */
	public Date getStartTime() {
		return parseDate((String) getCumulative().get("start_time"));
	}

	/**
	 * Get the number of tasks canceled.
	 *
	 * @return the number of tasks canceled
	 */
	public Integer getTasksCanceled() {
		return (Integer) getCumulative().get("tasks_canceled");
	}

	/**
	 * Get the number of tasks entered.
	 *
	 * @return the number of tasks entered
	 */
	public Integer getTasksEntered() {
		return (Integer) getCumulative().get("tasks_entered");
	}

	/**
	 * Get the number of tasks moved.
	 *
	 * @return the number of tasks moved
	 */
	public Integer getTasksMoved() {
		return (Integer) getCumulative().get("tasks_moved");
	}

	/**
	 * Get the total number of available workers.
	 *
	 * @return the total number of available workers
	 */
	public Integer getTotalAvailableWorkers() {
		return (Integer) getRealtime().get("total_available_workers");
	}

	/**
	 * Get the total number of eligible workers.
	 *
	 * @return the total number of eligible workers
	 */
	public Integer getTotalEligibleWorkers() {
		return (Integer) getRealtime().get("total_eligible_workers");
	}

	/**
	 * Get the total number of tasks.
	 *
	 * @return the total number of tasks
	 */
	public Integer getTotalTasks() {
		return (Integer) getRealtime().get("total_tasks");
	}

	/**
	 * Gets the sid.
	 *
	 * @return the sid
	 */
	public String getSid() {
		return getProperty(SID_PROPERTY);
	}

	/**
	 * Gets the workspace sid.
	 *
	 * @return the workspace sid
	 */
	public String getWorkspaceSid() {
		return getProperty(WORKSPACE_SID_PROPERTY);
	}

	@Override
	protected String getResourceLocation() {
		return "/" + TwilioWdsClient.DEFAULT_VERSION + "/Accounts/" + getRequestAccountSid() + "/Workspaces/" +
		       getWorkspaceSid() + "Statistics/TaskQueues/" + getSid();
	}

	private Map<String, Object> getCumulative() {
		return (Map<String, Object>) getObject(CUMULATIVE_PROPERTY);
	}

	private Map<String, Object> getRealtime() {
		return (Map<String, Object>) getObject(REALTIME_PROPERTY);
	}

	private ActivityStatistic mapToActivityStatistic(Map<String, Object> data) {
		String sid;
		String friendlyName;
		Integer workers;

		try {
			sid = (String) data.get(SID_PROPERTY);
			friendlyName = (String) data.get(ActivityStatistic.FRIENDLY_NAME_PROPERTY);
			workers = (Integer) data.get(ActivityStatistic.WORKERS_PROPERTY);
		} catch (Exception e) {
			throw new IllegalStateException("An Activity Statistic contained improperly formatted data.", e);
		}

		return new ActivityStatistic(sid, friendlyName, workers);
	}
}