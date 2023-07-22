#!/usr/bin/env bash

echo IMAGE=$1 > .env
sudo docker-compose -f docker-compose.yaml up --detach
echo "success"
