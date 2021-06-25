DAY 7 AWS

Assignment 1

Rajat is the devops guy in 'abc' organization and he is responsible for creating 't2.micro' and all the 'm' family of instances as per requirement but he can't terminate 'm' family of instances but that's not the case with t2.micro. Tejasvi Rana has got root access to the account but he isn't a technical guy. He is always suspicious about Rajat's actions in company's aws account. Luckily Tejasvi has got a friend, Priyanka jugran, she is amazon certified and knows everything about aws. Tejasvi wants Priyanka to cross check rajat's IAM permissions. In order to do that, he gave priyanaka full access. Now priyanka needs s3 storage for one of her friend, priyanka sharama to run athena queries for data analysis,they don't want to pay for that from their own aws account. Jugran has created a bucket with name 'abc-data' with a policy that sharma will only be able to access this bucket from a particular ec2 instance that she created & provided the user details to sharma. Rajat referenced his friends kavit and vishwas to his organization and now all of then share the same permission level. Kushgra is also one of the team memebers from operations team but recently he has got a task to create and run lambda function that is going to access rds database.






SOLUTIONS

Created the whole scenario in 3 steps :-

1. DevOps group

Created users Anshul , Kavit and Vishwas and added them into DevOps Group with 2 policies i.e. allowed policy for t2.micro and m*.* and denied policy for m*.* (Termination)

- Created an IAM user named Anshul

![User](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/IAM-USER1234.png)

- Created an Allowed INLINE policy to allow the EC2 Instance Type

VISUAL EDITOR

![allowed policy](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/allowed-policy-VisualEditor.png)

JSON FILE

![allowed policy](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/allowed-policy-json.png)

- Created an Denied INLINE policy to allow the EC2 Instance Type

VISUAL EDITOR

![denied policy](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/Denied-Policy-VisualEditor.png)

JSON FILE

![denied policy](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/Denied-policy-json.png)

- Verified by Creating and then Terminating an " m " family instance through Anshul user login

![Instance Terminate Denied](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/Instance-Terminate-denied.png)



![Instance Terminated](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/not-authorized-insstance-type.png)



![Not Authorised Instance](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/Terminate-Instance.png)

- These are the Policies created by me

![Policies](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/policies.png)





2. Created a bucket in S3 and created a policy for allowing access on that bucket and inside bucket and attached that policy to an ec2 instance. 

Created a user and allowed access to that instance for that user.

- Buckets which were used

![Bucket](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/buckets.png)

- Created a role for lovedeep-opstree.tk bucket only and not for the other one

JSON FILE

![Bucket](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/bucket-role-json.png)

VISUAL EDITOR

![Bucket](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/bucket-role-policy-visual-editor.png)

- Verified through cli and pushing some data in the other bucket in which the policy was not attached

![Bucket](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/access-denied-bucket.png)

- Verified through cli and pushing some data in the bucket in which the policy was attached

![Bucket](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/access-done.png)

3. Created a user kushgra and attached a policy to it allowing all lambda access and created a role for lambda service to access RDS.

- Created a User named kushgra

![lambda](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/khushagra.png)

- Attached full lambda access policy to that user

![lambda](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/khushagra-lambda.png)

- Created a role for lambda service to RDS service access

![lambda](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/lambdarole.png)

- Verified through kushgra login that EC2 and other services were not allowed except LAMBDA because only that policy was attached to it

![lambda](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/kushgra-ec2-denied.png)

- Verified the Lambda access for the kushgra user and created a lambda function

![lambda](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/kushgra-lambda-access.png)

- Verified that RDS service was there or not

![lambda](https://github.com/lovedeepsh/AWS/blob/master/AWS-day7-images/kushgra-RDS-allowed.png)

