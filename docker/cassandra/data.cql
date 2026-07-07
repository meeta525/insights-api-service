USE ad_insights;

INSERT INTO campaign_metrics (
    tenant_id,
    campaign_id,
    clicks,
    impressions,
    click_to_basket,
    last_updated
)
VALUES (
           'amazon',
           'CAMP1001',
           245,
           1200,
           35,
           toTimestamp(now())
       );

INSERT INTO campaign_metrics (
    tenant_id,
    campaign_id,
    clicks,
    impressions,
    click_to_basket,
    last_updated
)
VALUES (
           'amazon',
           'CAMP1002',
           560,
           3400,
           92,
           toTimestamp(now())
       );

INSERT INTO campaign_metrics (
    tenant_id,
    campaign_id,
    clicks,
    impressions,
    click_to_basket,
    last_updated
)
VALUES (
           'flipkart',
           'CAMP1001',
           785,
           5100,
           164,
           toTimestamp(now())
       );

INSERT INTO campaign_metrics (
    tenant_id,
    campaign_id,
    clicks,
    impressions,
    click_to_basket,
    last_updated
)
VALUES (
           'flipkart',
           'CAMP1002',
           1240,
           8400,
           302,
           toTimestamp(now())
       );