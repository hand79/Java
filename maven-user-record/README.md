# maven

## Introduction
How to package jar file 

## maven-assembly-plugin (Uou can use directly to execute the jar file.)
```
<plugin>
	<artifactId>maven-assembly-plugin</artifactId>
	<version>3.0.0</version>
	<configuration>
		<archive>
			<manifest>
				<mainClass>com.max.Main</mainClass>
			</manifest>
		</archive>
		<descriptorRefs>
			<descriptorRef>jar-with-dependencies</descriptorRef>
		</descriptorRefs>
	</configuration>
	<executions>
		<execution>
			<id>make-assembly</id> <!-- this is used for inheritance merges -->
			<phase>package</phase> <!-- bind to the packaging phase -->
			<goals>
				<goal>single</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```

## maven-jar-plugin & maven-dependency-plugin (Your dependencies are not in the jar file.)
```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-jar-plugin</artifactId>
	<version>2.6</version>
	<configuration>
		<archive>
			<manifestEntries>
				<Built-By>max</Built-By>
				<Class-Path>./</Class-Path>
			</manifestEntries>
			<manifest>
				<mainClass>com.max.Main</mainClass>
				<addClasspath>true</addClasspath>
				<classpathPrefix>classes/lib</classpathPrefix>
			</manifest>
		</archive>
	</configuration>
</plugin>
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-dependency-plugin</artifactId>
	<version>2.9</version>
	<executions>
		<execution>
			<id>copy-dependencies</id>
			<phase>package</phase>
			<goals>
				<goal>copy-dependencies</goal>
			</goals>
			<configuration>
				<!-- exclude junit, we need runtime dependency only -->
				<includeScope>runtime</includeScope>
				<outputDirectory>${project.build.directory}/classes/lib</outputDirectory>
			</configuration>
		</execution>
	</executions>
```
comment: You need to upload dependencies file(path: ${project.build.directory}/classes/lib/***) before you execute the jar file.
