DAY 2 AWS

Assignment 1

- Create a vpc not by wizard this time but manually, having 2 public subnets and 2 private subnets and 2 protected subnets.

- setup should be highly available

- Create 1 IGW and 2 NGW in each availability zone and make the appropriate routes in route tables

- Main route will remain intact, instead make 4 route tables

public_route_table 

private_route_table_1 

private_route_table_2 

protected_route_table 

SOLUTIONS

1. Created a VPC manually by :-

- Click on VPC

- Click on My VPC

- Click on Create New VPC

![VPC Second](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Opstree-VPC-second.png)



2. Created 6 Subnets by :-

- Click on VPC

- Click on Subnets below My VPC

- Created 2 Public Subnets, 2 Private Subnets and 2 Protected Subnets.

![Subnets](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Subnets-Details.png)

![Subnets](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Opstree-Subnets-6.png)

3. Created 4 Route Table by :-

- Click on VPC

- Click on Route Tables below Subnets

- Created Route tables and assigned to each Subnet

- Public Route Table attached to both Public Subnets

- Protected Route Table attached to both Protected Subnets

- Private Route Table are being created for each Private Subnet

![Route Tables](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Route-Table-4.png)






4. Created a Internet Gateway :-

- Click on VPC

- Click on Internet Gateways below Route Tables

- Created a Internet Gateway and assigned it to newly created VPC.

![Internet Gateway](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Opstree-igw-second.png)

5. Created 2 NAT gateways

![NAT Gateways](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Natgateway.png)

6. Created 6 Instances i.e. Windows Public A, Windows Public B, Ubuntu Private A, Ubuntu Private B, Ubuntu Private2 A, Ubuntu Private2 B.

![Instances](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/instances-day2.png)

7.   Installed Remmina and created RDP connection with the Windows Public Instances A & B.





8. Installed LAMP-Server on both the Instances and changes the “index.html” file for apache2.

- Index.html file for Windows Public Instance A

![Apache Public A index](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Hiserver1index.png)

- Webpage of Apache on web-browser

![Apache Public A web](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Hiserver1.png)

-  Index.html file for Windows Public Instance B

![Apache Public B index](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Hiserver2index.png)

- Webpage of Apache on web-browser

![Apache Public B web](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/Hiserver2.png)





9. Created a PHP index file in /var/www/html on both the Instances and checked both on thier respective Web page.

-  phpinfo.php file for Windows Public Instance A

![PHPinfo Public A index](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/php1file.png)

- Webpage of PHPinfo.php on web-browser

![PHPinfo.php Public A web](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/php1.png)


-  phpinfo.php file for Windows Public Instance B

![PHPinfo Public B index](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/php2file.png)

- Webpage of PHPinfo.php on web-browser

![PHPinfo.php Public B web](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/php2.png)




10. Create a Load Balancer and attached it to all 4 Private Instances

![Load Balancer](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/loadbalancer.png)

11. Verified on web page on the local machine.

![Web Server](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/mymachineserver1.png)

![Web Server2](https://github.com/lovedeepsh/AWS/blob/master/AWS-day2-images/mymachineserver2.png) 
