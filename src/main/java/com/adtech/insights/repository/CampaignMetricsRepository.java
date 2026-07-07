package com.adtech.insights.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.adtech.insights.entity.CampaignMetrics;
import com.adtech.insights.entity.CampaignMetricsKey;

@Repository
public interface CampaignMetricsRepository
        extends CassandraRepository<CampaignMetrics, CampaignMetricsKey> {

    Optional<CampaignMetrics> findByKeyTenantIdAndKeyCampaignId(
            String tenantId,
            String campaignId);
}