DAY 3 AWS

Assignment 1

Create a linux t2.micro ec2 instance. After logging into this instance move /etc/sudoers file with /etc/sudoers.bkp
        
        Now try to login, If can't - resolve this issue

SOLUTION

- Created a t2.micro ec2 Instance named Ubuntu-Instance-A
- Created ssh connection to the Instance using Private-key.pem
- Changed the name /etc/sudoers to /etc/sudoers.bkp

![Error](https://github.com/lovedeepsh/AWS/blob/master/AWS-day3-images/error123.png)

- I was not able to login then i followed this document : https://superuser.com/questions/1087048/how-to-fix-broken-etc-sudoers-ownership-on-ec2

- Created another Instance named Recovery
- Stopped my main Instance and detached the colume from it.
- Now again attached that colume to Recovery Instance
- Now mounted the volume to /home/ubuntu/Recover
- Changed the name again from sudoers.bkp to sudoers
- Unmounted the volume and detached the volume on aws
- Now again attached that volume to the main Instance.
- Now i was able to login.

![Access](https://github.com/lovedeepsh/AWS/blob/master/AWS-day3-images/ubuntu-publicA.png)



Assignment 2

create an ansible role before pushing the same to your public github repository.

This Role will simply host an nginx webpage saying

"Hi i am ninja and my name is {yourname}" 

Execute this role in user data script while launching another instance

Your website should be up & running after the system boots up

tag this instance as ninja:yourname

SOLUTION

- Created an ansible role for nginx and pushed it into github
- Role was hosting nginx webpage saying "Hi i am ninja and my name is {yourname}"

Nginx Role

https://github.com/lovedeepsh/AWS/tree/master/day3/nginx

- First prepared a script and tried it into vagrant

```
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
```

- Now Created a new Instance and provided the script from the starting page of creation in Advance section
- Finally it was working properly

![Nginx Output](https://github.com/lovedeepsh/AWS/blob/master/AWS-day3-images/output-nginx.png)


Assignment 3

write a jobDsl to start stop this instance through jenkins

SOLUTION

- Created a IAM role for Jenkins User on AWS and configured the access-key-id and secure-id in jenkins user awscli.
- Created an Job-DSL for starting and stopping the Instances using string prameters.
```
job('Ec2Instances') {
  parameters {
    stringParam('Control','')
    stringParam('InstanceID','')
  }
  steps
  {
    shell('''
#!/bin/bash
if [ $Control = start ]
then
aws ec2 start-instances --instance-ids $InstanceID
elif [ $Control = stop ]
then
aws ec2 stop-instances --instance-ids $InstanceID
fi
''')
   
  }
}
```

![IAM](https://github.com/lovedeepsh/AWS/blob/master/AWS-day3-images/IAM.png)

![DSL](https://github.com/lovedeepsh/AWS/blob/master/AWS-day3-images/dsl.png)

![Ninja:Lovedeep_Sharma](https://github.com/lovedeepsh/AWS/blob/master/AWS-day3-images/Ninja:Lovedeep_Sharma.png)

![Start Instance](https://github.com/lovedeepsh/AWS/blob/master/AWS-day3-images/start-instance.png)

![Stop Instance](https://github.com/lovedeepsh/AWS/blob/master/AWS-day3-images/stop-Instance.png)
