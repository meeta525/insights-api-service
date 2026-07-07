package com.adtech.insights.service.impl;

import com.adtech.insights.model.ClickCountResponse;
import com.adtech.insights.service.HistoricalMetricsService;
import com.adtech.insights.service.InsightsService;
import com.adtech.insights.service.RealtimeMetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InsightsServiceImpl
        implements InsightsService {

    private final RealtimeMetricsService realtimeMetricsService;

    private final HistoricalMetricsService historicalMetricsService;

    @Override
    public ClickCountResponse getClicks(
            String tenantId,
            String campaignId,
            LocalDate from,
            LocalDate to) {


        if (from != null && to == null) {
            throw new IllegalArgumentException(
                    "'to' date is required when 'from' date is provided.");
        }

        if (from == null && to != null) {
            throw new IllegalArgumentException(
                    "'from' date is required when 'to' date is provided.");
        }

        if (from != null) {
            return historicalMetricsService.getClicks(
                    tenantId,
                    campaignId, from, to);
        }

        return realtimeMetricsService.getClicks(
                tenantId,
                campaignId);
    }
}