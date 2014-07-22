package sunflower.sales.service.impl;

import sunflower.sales.dao.ScheduleItemDao;
import sunflower.sales.service.ScheduleItemService;

public class ScheduleItem implements ScheduleItemService {
	ScheduleItemDao sd = new ScheduleItemDao();

	@Override
	public boolean addScheduleItem(sunflower.sales.entity.ScheduleItem scheduleItem) {
		return sd.saveScheduleItem(scheduleItem);
	}

	@Override
	public boolean updateScheduleItem(sunflower.sales.entity.ScheduleItem scheduleItem) {
		return sd.updateScheduleItem(scheduleItem);
	}

	@Override
	public boolean deleteScheduleItem(sunflower.sales.entity.ScheduleItem scheduleItem) {
		return sd.deleteScheduleItem(scheduleItem);
	}

}
