I have the same problem using spark 1.5.2 and windows 7 x64 and none of above fixes helped. The permissions to folder /tmp/hive are ok but they are changed during code execution.
In my case the problem is in hadoop-common:2.6.0:jar in org.apache.hadoop.fs.RawLocalFileSystem class in loadPermissionInfo() method.
It is trying to execute command F:\spark\bin\winutils.exe ls -F D:\tmp\hive in shell and this command returns "Incorrect command line arguments." this result in exception which is catched in loadPermissionInfo and the permissions are changed to default because of that:
line 609 RawLocalFileSystem.java

Getting Started with Spark on Windows 7 (64 bit)

Lets get started on Apache Spark 1.6 on Windows 7 (64 Bit). [ Mac, Ubuntu, other OS steps are similar except winutils step that is only for Windows OS ]

-  Download and install Java  (Needs Java 1.7 or 1.8, Ignore if already installed)
-  Download & Install Anaconda Python 3.5+.  (Extract to C:\Anaconda3 or any folder )
-  Download Spark  ( Download 7-zip to unzip .gz files) : Extract to C:\BigData\Spark making sure that all 15 folders go under C:\BigData\Spark folder and not in long folder name with version number
-  Download winutils.exe  ( Put in C:\BigData\Hadoop\bin )  -- This is for 64-bit
-  Download Sample Data  (Extract to C:\BigData\Data)

1. Create Environment Variables :-