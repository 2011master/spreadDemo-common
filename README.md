
demo项目，收集常用demo
---

# 了解点

    1. Maven项目子模块如何引用父模块的jar包
        
          如果父pom中使用的是
            <dependencies>....</dependencies>
          的方式，则子pom会自动使用pom中的jar包，
          如果父pom使用  
          <dependencyManagement>
              <dependencies>....</dependencies>
          </dependencyManagement>
          方式，则子pom不会自动使用父pom中的jar包，这时如果子pom想使用的话，就要给出groupId和artifactId，无需给出version
    
    


# spreadDemo-common
