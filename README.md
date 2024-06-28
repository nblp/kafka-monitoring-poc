# kafka-monitor-demo

## How to start

./start.sh cluster
./start.sh activity

### To generate messages

./generate-messages.sh

## What it does not cover

* persistent storage (db for prometheus) and management
* strong authentication
* ssl/tls communication
* alerting
* resilient HA deployment
* udpate, maintenance and potential changes in metrics name
* access management to the tools (especially grafana)

## References

* https://docs.spring.io/spring-cloud-stream/reference/observability.html
* https://www.confluent.io/blog/monitor-kafka-clusters-with-prometheus-grafana-and-confluent/
* https://www.confluent.io/blog/monitoring-event-streams-visualize-kafka-clients-in-confluent-cloud/
* https://github.com/confluentinc/jmx-monitoring-stacks/tree/6.1.0-post/shared-assets/jmx-exporter
* https://docs.confluent.io/cloud/current/monitoring/ccloud-observability.html
* https://docs.confluent.io/platform/current/streams/monitoring.html
* https://github.com/confluentinc/examples/blob/6.1.0-post/ccloud-observability/docker-compose.yml
* https://github.com/nbuesing/kafka-streams-dashboards/blob/main/README.md
* https://github.com/kineticedge/kafka-streams-dashboards
* https://www.confluent.io/events/kafka-summit-europe-2what-is-the-state-of-my-kafka-streams-application-unleashing-metrics/ -->
* https://docs.confluent.io/platform/current/streams/monitoring.html
* https://www.baeldung.com/spring-boot-kafka-streams
* https://github.com/prometheus/jmx_exporter
* https://mvnrepository.com/artifact/io.prometheus.jmx/jmx_prometheus_javaagent
* https://jolokia.org/download.html
* https://github.com/confluentinc/jmx-monitoring-stacks/tree/6.1.0-post/jmxexporter-prometheus-grafana
