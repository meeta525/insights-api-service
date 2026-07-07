CREATE KEYSPACE IF NOT EXISTS ad_insights
    WITH replication = {
        'class': 'SimpleStrategy',
        'replication_factor': 1
        };

USE ad_insights;

CREATE TABLE IF NOT EXISTS campaign_metrics (

                                                tenant_id text,

                                                campaign_id text,

                                                clicks bigint,

                                                impressions bigint,

                                                click_to_basket bigint,

                                                last_updated timestamp,

                                                PRIMARY KEY ((tenant_id), campaign_id)

);