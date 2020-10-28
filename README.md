# OpenImageCV

## Summary

OpenImageCV application is intended to provide operations on poker card images \(card's rank/suit recognition by template\)

## Description

Application can be used for parsing card images with possibility to recognize card's rank/suit by predefined set of templates

## Compile

### For JDK 8

```shell script
mvn clean install -Pdev,assembly,non_module_java -DskipTests
```

### For JDK 11

```shell script
mvn clean install -Pdev,assembly,module_java -DskipTests
```
## Running

Execute the following command to start OpenServiceCV processor:

```shell script
run.bat <source_image_director>
```

## Usage

Choose one of the modules and add to your `pom.xml`

```xml
<dependency>
    <groupId>io.brainshells.api</groupId>
    <artifactId>openimagecv-parent</artifactId>
    <version>{lib.version}</version>
</dependency>
```

Bundle with all OpenImageCV dependencies:

- [**OpenImageCV All**](https://github.com/AlexRogalskiy/openimagecv/tree/master/modules/openimagecv-all)  
  `openimagecv-all` - Library to work with OpenImageCV API.

OpenImageCV module dependencies:

- [**OpenImageCV Commons**](https://github.com/AlexRogalskiy/openimagecv/tree/master/modules/openimagecv-commons)  
  `openimagecv-commons` - Library with utilities for common use cases.

- [**OpenImageCV Processor**](https://github.com/AlexRogalskiy/OpenImageCV/tree/master/modules/openimagecv-processor)  
  `openimagecv-processor` - Library to work with Processor API.
  
## Version Store

[./pom.xml](https://github.com/AlexRogalskiy/openimagecv/blob/master/pom.xml)

## Miscellaneous

  You can find more useful libs and examples on [wiki](https://github.com/AlexRogalskiy/openimagecv/wiki)

## Authors

OpenImageCV is maintained by:

* [Alexander Rogalskiy](https://github.com/AlexRogalskiy) 

with community support please contact with us if you have some question or proposition.

## Team Tools

[![alt tag](http://pylonsproject.org/img/logo-jetbrains.png)](https://www.jetbrains.com/) 

OpenImageCV Team would like inform that JetBrains is helping by provided IDE to develop the application. Thanks to its support program for an Open Source projects!

[![alt tag](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/dashboard?id=org.schemaspy%3Aschemaspy)

OpenImageCV project is using SonarCloud for code quality. 
Thanks to SonarQube Team for free analysis solution for open source projects.

## License

OpenImageCV is distributed under LGPL version 3 or later, see COPYING.LESSER(LGPL) and COPYING(GPL).   
LGPLv3 is additional permissions on top of GPLv3.

![image](https://user-images.githubusercontent.com/19885116/48661948-6cf97e80-ea7a-11e8-97e7-b45332a13e49.png)
