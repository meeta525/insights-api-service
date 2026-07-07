package com.adtech.insights.service;

import com.adtech.insights.model.ClickCountResponse;

import java.time.LocalDate;

public interface InsightsService {

    ClickCountResponse getClicks(
            String tenantId,
            String campaignId,
            LocalDate from,
            LocalDate to);

}