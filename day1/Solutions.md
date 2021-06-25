DAY 1 AWS

Assignment 1

1. Create a vpc through wizard, having one public subnet and one private subnet.

SOLUTION
- Created a VPC through wizard by clicking on VPC option and Create new VPC named :-

Lovedeep-Opstree

![Lovedeep VPC](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/VPC.png)

- Created One Public Subnet and One Private Subnet named :-

Lovedeep-Opstree-Public

Lovedeep-Opstree-Private

![Lovedeep Subnet](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/Subnets.png)










Assignment 2

Create two instances within the vpc that you created in task 1, windows instance in public subnet and linux instance in private subnet. check if linux is pingable from windows and vice versa.

SOLUTION

- Created two Istances :-

Lovedeep-Instance-Linux-Private
Lovedeep-Instance-Windows-Public

![Lovedeep Instances](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/Instances.png)

- Created 2 Security group :-

![Security-Group](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/Security-groups.png)

- Created 2 route table :-

![Route Table](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/Route-Table.png)

- Created an Internet Gateway for Public Subnet

![Internet Gateway](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/igw1.png)

- Checked if Windows Instance is Pinging or not

![Instance Ping](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/ping.png)

Assignment 3

Delete all the instances and now make those two instances that you created in previous task using aws-cli.

1. Installing AWS-CLI and Configuring it.
Deleted all created instances and configure awscli on local machine.
```
- sudo apt-get install awscli
- aws --version
- aws config (provided acces key ID, Security key, Region and format).
- save the acces-key-id and security-key-id  in .bashrc file.
- $ source .bashrc
- sudo chmod 600 ~/home/vagrant/.aws/config
```



2. Creating 2 Instances

First created a security group.
```
$ aws ec2 create-security-group --group-name Opstree-security --description "Security Group for EC2 instances to allow port 22" --vpc-id vpc-00df7b97eeeb1e5b1
```
```
output :-
{
    "GroupId": "sg-0e045f2deff611f56"
}
```

![Security Group aws cli](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/security-group-aws-cli.png)


Then Created 2 Instances.

- Ubuntu Instance for Pivate Subnet
```
$ aws ec2 run-instances --image-id ami-41e9c52e --security-group-ids sg-0e045f2deff611f56 --subnet-id subnet-0d0403194f474b88f --instance-type t2.micro --placement AvailabilityZone=ap-south-1a --count 1
```

![Ubuntu Private Ec2](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/instance-ubuntu-private-aws-cli.png)

- Windows Instance for Public Subnet
```
$ aws ec2 run-instances --image-id ami-5f95bd30 --security-group-ids sg-0e045f2deff611f56 --subnet-id subnet-06ff0d535d32bcc7e --instance-type t2.micro --placement AvailabilityZone=ap-south-1a --count 1
```

![Windows Public Ec2](https://github.com/lovedeepsh/AWS/blob/master/AWS-day1-images/Instance-Windows-Public-aws-cli.png)













