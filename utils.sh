#!/bin/bash

 docker-compose run tools /bin/bash -c 'kafkacat -b kafka-101:9092 -t sentences -f "%k¦%s\n"'
 docker-compose run tools /bin/bash -c 'kafka-console-consumer   --bootstrap-server kafka-101:9092   --topic words_counts   --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer   --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer   --property print.key=true   --property key.separator=::   --from-beginning'