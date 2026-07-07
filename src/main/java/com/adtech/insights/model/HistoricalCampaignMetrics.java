package com.adtech.insights.model;

public record HistoricalCampaignMetrics(

        String tenantId,

        String campaignId,

        Long clicks,

        Long impressions,

        Long clickToBasket

) {
}