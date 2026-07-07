package com.adtech.insights.exception;

public class CampaignNotFoundException extends RuntimeException {

    public CampaignNotFoundException(String tenantId, String campaignId) {
        super("Campaign not found. tenant=" + tenantId +
                ", campaign=" + campaignId);
    }
}