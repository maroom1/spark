val textFile=sc.textFile("readme.txt")
textFile.first
val tokenizedFileData=textFile.flatMap(line=>line.split(" "))
val countPrep=tokenizedFileData.map(word=>(word,1))
val counts=countPrep.reduceByKey((accumValue,newValue)=>accumValue+newValue)
val sortedCounts=counts.sortBy(kvPair=>kvPair._2,false)
sortedCounts.saveAsTextFile("file:///D:/git_work/spark/ReadMeWordCount/")
