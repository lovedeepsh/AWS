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
