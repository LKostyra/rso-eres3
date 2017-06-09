#!/bin/bash

set -e

if [ $# -ne 1 ]
then
    echo "Not enough arguments - provide container name and sql node to link to"
    exit 1
fi

NET_NAME="eres3-network"
IMAGE_NAME="eres3-frontend"

echo "Initializing backend node $1"
docker run -d --net=${NET_NAME} --name=${1} --hostname=${1} $IMAGE_NAME