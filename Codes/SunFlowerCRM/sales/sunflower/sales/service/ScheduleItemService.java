package sunflower.sales.service;

import sunflower.sales.entity.ScheduleItem;

public interface ScheduleItemService {
	public boolean addScheduleItem(ScheduleItem scheduleItem);

	public boolean updateScheduleItem(ScheduleItem scheduleItem);

	public boolean deleteScheduleItem(ScheduleItem scheduleItem);

}
