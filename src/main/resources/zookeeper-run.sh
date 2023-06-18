#!/bin/bash

# Start ZooKeeper server with provided arguments using sudo
source "$HOME/.sdkman/bin/sdkman-init.sh"
sudo /Users/vpernar/Desktop/RAF/pds/apache-zookeeper-3.8.1-bin/bin/zkServer.sh start-foreground /Users/vpernar/Desktop/RAF/pds/apache-zookeeper-3.8.1-bin/conf/zoo.cfg
