DAY 5 AWS

Assignment 1
- create a key pair using ansible 
- create one security group that would allow you to ssh into the instance 
- using the key that you created, launch an instance in default vpc of N.virginia region with tags of your choice 

SOLUTION
---
```
---
- name: "AWS"
  hosts: localhost
  gather_facts: false
  tasks:
  - name: "Creating a new key pair"
    ec2_key:
      name: Lovedeep-Opstree
      region: us-east-1
      state: present
  - name:
    ec2_group:
      name: Anshul-SG
      description: sg with rule descriptions
      vpc_id: vpc-ea02e090
      region: us-east-1
      rules:
       - proto: tcp
         from_port: 80
         to_port: 80
         cidr_ip: 0.0.0.0/0
         from_port: 22
         to_port: 22
         cidr_ip: 10.0.0.0/8

  - name: "Creating an EC2 Instance"
    ec2:
      key_name: Lovedeep-Opstree
      instance_type: t2.micro
      image: ami-a4dc46db
      region: us-east-1
      volumes:
         - device_name: /dev/sda1
           volume_type: gp2
           volume_size: 8
           delete_on_termination: true
      instance_tags:
         key: Name
         value: love
      count: 1
      vpc_subnet_id: subnet-426c0508
      assign_public_ip: yes
      state: present
...
```
For IAM User
```
- name: "Creating an IAM User"
  iam:
   iam_type: user
   name: Anshul
   state: present
   groups: lovedeep
   password: 123
   access_key_state: create
```
   
- Running Playbook
 
![Playbook Run](https://github.com/lovedeepsh/AWS/blob/master/AWS-day5-images/Playbook-Run.png)

- Created Key Pair

![Key Pair](https://github.com/lovedeepsh/AWS/blob/master/AWS-day5-images/Key-Pair.png)

- Created Security Group

![Security Group](https://github.com/lovedeepsh/AWS/blob/master/AWS-day5-images/Security-Group.png)

- Created Instance

![Instance](https://github.com/lovedeepsh/AWS/blob/master/AWS-day5-images/love-Instance.png)

- Created IAM User

![IAM User](https://github.com/lovedeepsh/AWS/blob/master/AWS-day5-images/IAM.png)
