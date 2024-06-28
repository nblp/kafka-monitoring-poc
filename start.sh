if [[ $# -lt 1 ]];then
    echo "$0 <cluster;activity>"
    exit 1
fi

start_cluster() {
    echo "start cluster"
    docker-compose up \
    kafka-101 kafka-102 kafka-201 \
    create-topics \
    node-exporter \
    prometheus grafana > cluster-logs.txt 2>&1
}

start_activity() {
    echo "start activity"
    cd kafka-stream-app/kafka_stream_app/
    mvn clean install -DskipTests > activity-logs.txt 2>&1
    cd ..
    docker build -t app . >> activity-logs.txt 2>&1
    cd ..
    docker-compose up app >> activity-logs.txt 2>&1
}

if [[ "$1" == "cluster" ]];then
    start_cluster
elif [[ "$1" == "activity" ]];then
    start_activity
fi
