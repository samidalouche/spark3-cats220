# README.md

## build artifacts & download spark
```
sbt clean assembly
wget https://mirror.its.dal.ca/apache/spark/spark-3.0.1/spark-3.0.1-bin-hadoop2.7.tgz && tar xvzf spark-3.0.1-bin-hadoop2.7.tgz
```


## cats 2.1.1

### Main: works fine

```
java -cp cats211/target/scala-2.12/catsspark211-assembly-0.1.0-SNAPSHOT.jar catsspark.TestApp
```

### Spark 2.4.7: works fine
```
spark-2.4.7-bin-hadoop2.7/bin/spark-shell --jars cats211/target/scala-2.12/catsspark211-assembly-0.1.0-SNAPSHOT.jar
catsspark.Boom.boom()
```


### Spark 3.0.1: works fine

```
spark-3.0.1-bin-hadoop2.7/bin/spark-shell --jars cats211/target/scala-2.12/catsspark211-assembly-0.1.0-SNAPSHOT.jar
catsspark.Boom.boom()
```

## cats 2.2.0

### Main: works fine

```
java -cp cats220/target/scala-2.12/catsspark220-assembly-0.1.0-SNAPSHOT.jar catsspark.TestApp
```

### Spark 3.0.1: fails

```

spark-2.4.7-bin-hadoop2.7/bin/spark-shell --jars cats220/target/scala-2.12/catsspark220-assembly-0.1.0-SNAPSHOT.jar
catsspark.Boom.boom()
```

```
java.lang.NoSuchMethodError: 'void cats.kernel.CommutativeSemigroup.$init$(cats.kernel.CommutativeSemigroup)'
  at cats.UnorderedFoldable$$anon$1.<init>(UnorderedFoldable.scala:78)
  at cats.UnorderedFoldable$.<init>(UnorderedFoldable.scala:78)
  at cats.UnorderedFoldable$.<clinit>(UnorderedFoldable.scala)
  at cats.data.NonEmptyListInstances$$anon$2.<init>(NonEmptyList.scala:539)
  at cats.data.NonEmptyListInstances.<init>(NonEmptyList.scala:539)
  at cats.data.NonEmptyList$.<init>(NonEmptyList.scala:458)
  at cats.data.NonEmptyList$.<clinit>(NonEmptyList.scala)
  at catsspark.Boom$.assumeValid_$bang(boom.scala:19)
  at catsspark.Boom$.boom(boom.scala:14)
  ... 47 elided
  ```




  