---
marp: true
theme: gaia
_class: lead
paginate: true
backgroundColor: #fff
---

# Kafka Monitoring Demo

---

# Plan

1. General Presentation of the **docker-compose components**
1. Introduction to the tools : **Prometheus and Grafana**
1. The existing beans through **JConsole**
1. Sending metics to **Prometheus with an agent**
1. Sending metics to **Prometheus through Spring Boot** libraries
1. Tour of **Grafana Dashboards** and **Key Metrics**

---

# Links

* JConsole: localhost:10092
* broker metrics: http://localhost:7071/metrics
* app metrics: http://localhost:8080/actuator/prometheus
* prometheus : http://localhost:9090
* grafana : http://localhost:3000

---

# Appendix

* Throughput:
    * Records Processed per Second: The rate at which records are being processed by the Kafka Streams application.
    * Bytes Read/Write per Second: The amount of data being read from and written to Kafka topics per second.
* Latency:
    * Processing Latency: The time taken to process each record.
    * End-to-End Latency: The time from when a record is produced to when it is fully processed.

<!--
Throughput:

    Records Processed per Second: kafka_streams_processor_task_process_total
    Bytes Read per Second: kafka_streams_consumer_fetch_manager_bytes_consumed_total
    Bytes Written per Second: kafka_streams_producer_outgoing_byte_rate

Latency:

    Processing Latency: kafka_streams_processor_node_avg_latency_ms
    End-to-End Latency: kafka_streams_stream_metrics_record_e2e_latency_avg

Error Rates:

    Deserialization Errors: kafka_streams_stream_metrics_deserialization_error_total
    Production Errors: kafka_streams_producer_produce_errors_total

Consumer Lag:

    Consumer Lag: kafka_consumer_group_lag

Task Metrics:

    Task Creation/Destruction Rate: kafka_streams_task_created_total / kafka_streams_task_closed_total
    Active/Standby Tasks: kafka_streams_stream_thread_active_tasks / kafka_streams_stream_thread_standby_tasks

Commit Metrics:

    Commit Rate: kafka_streams_stream_metrics_commit_total
    Commit Latency: kafka_streams_stream_metrics_commit_latency_avg

State Store Metrics:

    Store Size: kafka_streams_state_store_size_bytes
    Read/Write Rate: kafka_streams_state_store_put_latency_avg / kafka_streams_state_store_get_latency_avg

Thread Metrics:

    Thread Count: kafka_streams_thread_count
    Thread Idle Ratio: kafka_streams_stream_thread_total_idle_ratio
-->
---
* Error Rates:
    * Deserialization Errors: Number of errors encountered while deserializing records.
    * Production Errors: Number of errors encountered while producing records to Kafka topics.
* Consumer Lag:
    * Consumer Lag: The difference between the latest offset in the Kafka topic and the current offset processed by the consumer. High lag indicates the consumer is falling behind.
---
* Task Metrics:
    * Task Creation/Destruction Rate: The rate at which tasks are created and destroyed, which can indicate rebalancing activities.
    * Active/Standby Tasks: Number of active and standby tasks, indicating the current load distribution.
* Commit Metrics:
    * Commit Rate: Frequency of commit operations.
    * Commit Latency: Time taken to commit the processed records.
---
* State Store Metrics:
    * Store Size: Size of the state stores, which can indicate the volume of data being maintained.
    * Read/Write Rate: Rate at which read and write operations are performed on state stores.
* Thread Metrics:
    * Thread Count: Number of threads currently running in the Kafka Streams application.
    * Thread Idle Ratio: Percentage of time threads are idle, which can indicate the application's efficiency.

---
