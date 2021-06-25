#!/bin/bash
sudo apt-get update
sudo apt-get install git -y
sudo apt-add-repository ppa:ansible/ansible -y
sudo apt-get update
sudo apt-get install ansible -y
git clone https://github.com/lovedeepsh/AWS.git
sudo su
cd AWS/day3
sudo ansible-playbook main.yml
 

