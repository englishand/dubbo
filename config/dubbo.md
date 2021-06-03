dubbo搭建：  
    
    1.结构  
      api:公共接口，传输对象(必须要序列化)
      consumer:消费者
      privider:提供者
    2.privider
      dubbo配置文件：privider.xml。Dubbo采用全spring配置方式，透明化接入应用，对应用每有任何api入侵，
      只需要spring加载dubbo配置即可，Dubbo基于spring的schema的扩展进行加载。配置项：1.服务名 2.zookeeper
      注册中心，3.配置扫描包，暴露服务接口。
      业务类：实现api中声明接口即可，@Service采用dubbo的service注解。
    3.consumer
      dubbo配置文件：consumer.xml。配置项：1.服务名，2.zookeeper注册中心，3.扫描包，暴露调用接口
      controller:使用dubbo的@Reference注解，引入service来调用其方法。
调用关系说明：  
      
      1.服务容器负责启动、加载、运行服务提供者。
      2.服提供者在启动时，向注册中心注册自己提供的服务。
      3.服务消费者在启动时，向注册中心订阅自己需要的服务。
      4.注册中心返回服务提供者地址列表给消费者，如有变更，注册中心加ing基于长连接推送变更数据给消费者。
      5.服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，若失败，再选另一台调用。
      6.服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心。
dubbo_admin搭建：
    
    1.dubbo_admin起监控作用，可查看发布接口的提供者和消费者。
    2.搭建：
      https://github.com/alibaba/dubbo下载dubbo_admin,将dubbo_admin打包（mvn package -Dmaven.skip.test=true)。将打包好的war包部署到tomcat中，
      必要时修改tomcat的端口，因为zookeeper默认端口时8080.启动并停止tomcat后，查看生成的dubbo_admin文件里的WEB-INF/dubbo.properties。用户名/密码
      一般为：root/root、guest/guest。最后，将war包改名为ROOT.war,即启动tomcat就是启动dubbo_admin.
zookeeper搭建：
      
      1.下载：http://www.apache.org/dyn/closer.cgi/zookeeper/
      2.配置：conf目录下，将zoo_sample.cfg改名为zoo.cfg。因为zookeeper启动时会找这个默认配置文件。
        tickTime：这个时间是作为 Zookeeper 服务器之间或客户端与服务器之间维持心跳的时间间隔，也就是每个 tickTime 时间就会发送一个心跳。
        dataDir：顾名思义就是 Zookeeper 保存数据的目录，默认情况下，Zookeeper 将写数据的日志文件也保存在这个目录里。
        clientPort：这个端口就是客户端连接 Zookeeper 服务器的端口，Zookeeper 会监听这个端口，接受客户端的访问请求。
        我们需要进行的操作是修改dataDir这个配置的值，我们在Zookeeper的根目录下新建一个文件夹dataTmp，
        修改配置文件对应地方为（注意一定是双\哦）：      
        dataDir=D:\\Zookeepertest\\zookeeper-3.4.6\\dataTmp
      3.启动项为：/bin/zkServer.cmd
#####dubbo和zookeeper关系
    dubbo将注册中心进行抽象，使得它可以外接不同的存储媒介给注册中心提供服务，有zookeeper、memcached、redis等。
    引入zookeeper作为存储媒介，也就是把Zookeeper的特性引进来了。1.负载均衡，但注册中心的承载能力有限，在流量达到一定程度时要进行分流，负载均衡就是
    为分流而生的，一个zookeeper群配合响应的web应用就可以很容易达到负载均衡；2资源同步：单单有负载均衡还不够，节点之间的数据和资源需要同步，
    zookeeper集群就天然具备这样的功能；3命名服务：将树状结构用于维护全局的服务地址列表，服务提供者在启动的时候，向zookeeper上指定的节点
    /dubbo/${serviceName}/providers目录下写入自己的url地址，这个操作就完成了服务的发布。
#####测试
    1.先启动zookeeper注册中心，这里用了三个zookeeper做负载均衡，所以要启动三个，D:\Program Files\Zookeeper
    2.启动dubbo admin做监控以及相关配置，如privider的权重配置,C:\tools\apache-tomcat-8.5.55\bin
    3.启动服务提供者（有两个做负载均衡），一个本地使用dubbo协议在20880端口暴露服务地址，一个在tomcat（D:\Program Files\apache-tomcat-9.0.46）
      使用dubbo协议在20881端口暴露服务地址。
    4.启动消费者，在本地启动即可。
          