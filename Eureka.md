# 组件初识

## 什么是服务治理
Springcloud 封装Netfix公司开发的Eureka来实现服务治理（服务调用，负载均衡、容错，实现服务的发现和注册）

## Eureka 组件
### Eureka server
各个服务节点的配置启动后，会在EurekaServer中注册，这样EurekaServer的服务注册表中会存储所有可用服务节点的信息，服务节点的信息可以
界面中直观看到。

服务注册：将服务信息注册进注册中心，存key 服务名，value 服务地址
服务发现：通过key服务名，取value 服务地址

**消费者获得服务地址后会缓存在本地的jvm中，默认每30s更新一次**

创建cloud-eureka-server7001 ,添加@EnableEurekaServer注解
服务注册中心不需要mvc相关的代码

#### 搭建Eureka server高可用集群
原理：互相注册 
1. 更改hosts文件
2. defalutZone 写其他的地址


---

### Eureke Client
Java客户端，用于简化Eureka server的交互，客户端同时也具备一个内置的，使用轮询负载算法的负载均衡器，在启动应用后，将会想Eureka Server发
送心跳（默认周期30s），如果Eureka Server在多个周期内没有接收到某个节点的心跳，将会从服务注册表中把这个服务节点移除（默认90s）

将order、payment 注册到eureka-server，添加jar包，增加注册中心相关的配置，添加@EanbleEurekaClient注解

#### 搭建服务提供者集群
1. 新建模块cloud-provider-payment8002，与payment8001的内容相同，出了端口
2. 注册中心的地址写多个eureka server的地址
3. order消费者模块调用payment 服务提供者的地址不能写死，此时应该写服务名字
4. _给restTemplate增加负载均衡的功能@LoadBalance_ 否则有多个服务提供者，restTemplate不知道调哪个，会报错



