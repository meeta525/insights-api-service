package com.adtech.insights.service;

import com.adtech.insights.model.ClickCountResponse;

public interface RealtimeMetricsService {

    ClickCountResponse getClicks(
            String tenantId,
            String campaignId);

}