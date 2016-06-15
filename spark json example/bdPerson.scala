val df1=sqlContext.read.json("file:///home/edureka/Downloads/scala notes/spark json example/bdPerson.json")
df1.saveAsTable("persondata")
sql("select * from persondata").show
sql("desc persondata").show
1580  sql("select birthdate,id,join_date,phone_number from persondata").show
1581  sql("alter table persondata change birthdate birthdate date").show
1582  sql("desc persondata").show
1583  sql("alter table persondata change birthdate birthdate Date").show
1584  sql("desc persondata").show
1585  sql("alter table persondata change birthdate birthdate date").show
1586  sql("desc persondata").show
1587  sql("alter table persondata change id id int").show
1588  sql("desc persondata").show
1589  sql("show tables").show
1591  sql("select birthdate,id,join_date,phone_number from  persondata").show
1592  sql("desc ersondata").show
1593  sql("desc persondata").show
1594  :history
1595  :history 100

