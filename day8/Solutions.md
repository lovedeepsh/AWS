DAY 8 AWS

Assignment 1
Create an infrastructure that would scale as per load: Create cloudwatch alarms for scaling up and scaling down along with sns topic to notify you during any scaling operation.
Put fake load on the stack 
scale up if av. cpu threashold > 70 
scale down if av. cpu threashold < 40 
First do it via console and then via aws cli 

SOLUTIONS
Completed this assignment in 3 parts :-

Created an AMI Image of an Instance
- Created an Ubuntu t2.micro Instance.
- Clicked on Action and selected Image and Create Image.
- An AMI is been created.

![Snapshot](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/created-snapshot.png)



Created Launch Configuration.
- Enabled Cloud Watch Monitoring
![Launch Configuration](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/launch-conf-1.png)

Created Auto Scaling Group
- Used scaling policies to adjust capacity of the group.
- Used simple scaling policy
- Created 2 simple policy i.e. Increase group size & Decrease group size.
- Created alarm in both for load>=70 and load<=40 and provided warm up time of 300 seconds.
- Added Notification by creating a topic and provided SNS and email ID  lovedeeps789@gmail.com.
- This Notification Topic sends a subscription mail to email ID which was been subscribed.
![subscribe](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/subscription%5C.png)
- Provided minimum, desired and maximum state.
![Auto scaling](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-scaling-groups-1%5C.png)
![Auto scaling](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-security-group.png)
![Auto scaling](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-scaled-added.png)



Created fake load
- Created ssh connection to one Instance which is been created by autoscaling desired state.
- Created a fake load by giving command yes > /dev/null
![load](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/top-up.png)
- Waited for 300 seconds and now autoscaling created an Alarm for load more than 70 and send it to my email ID
![Alarm](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-alarm-1.png)
![Alarm](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-scale-2.png)
![Alarm](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-scale-22.png)
![Alarm](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/scale-up-notify.png)
- Launched Instances one by one.

- Stopped the fake load by giving command killall yes.
![load down](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/top-down.png)
- Auto scaling again created an alarm for load less than 40.
![Alarm](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-scale-down-1.png)
![Alarm](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-scale-down-2.png)
![Alarm](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-scale-down-alarm-1.png)
![Alarm](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/auto-scale-down-alarm-2.png)
![Terminated](https://github.com/lovedeepsh/AWS/blob/master/AWS-day8-images/tereminated.png)
- Terminated Instance one by one.

