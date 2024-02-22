<p align="center">
	<a href="https://maimengcloud.com/"  target="_blank">
	    <img src="https://maimengcloud.com/img/728c2dec5c1055349455.png" width="400" alt="logo">
	</a>
</p>
<p align="center">
	<strong>唛盟xm：涵盖项目规划、需求管理、开发迭代、版本控制、缺陷跟踪、测试管理、工时管理、效能分析等环
节，实现项目全过程、全方位管理的一站式企业研发项目管理解决方案</strong>
</p>

<p align="center">
	<a target="_blank" href="https://gitee.com/maimengcloud/xm-ui-web">
        <img src='https://gitee.com/maimengcloud/xm-ui-web/badge/star.svg?theme=gvp' alt='gitee star'/>
    </a> 
</p>
<p align="center">
	👉 <a target="_blank" href="https://maimengcloud.com/xm/m1/">https://maimengcloud.com</a>  👈
</p>

## 快速导航
- [前端组件](https://gitee.com/maimengcloud/xm-ui-web)
- [后端服务](https://gitee.com/maimengcloud/xm-backend)
- [体验环境](https://maimengcloud.com/xm/m1/)
  登陆界面上选择演示账号登陆或者直接扫码登陆，无须注册

## 📢 简介[唛盟xm](/)
唛盟企业级研发管理系统简称唛盟xm,属于唛盟生态的专业子系统之一，以研发管理为核心，涵盖项目规划、需求管理、开发迭代、版本控制、缺陷跟踪、测试管理、工时管理、效能分析等环节，实现全过程、全方位的研发管理。通过该系统，企业能够优化研发流程，提高研发效率，降低研发成本，提高市场竞争力。
💪唛盟生态遵循 <strong>“一个底座+N个专业子系统”</strong> 的架构，基于同一个底座的各个专业子系统可以任意组合形成一个大的业务系统  
一个底座： [mdp-core](https://gitee.com/maimengcloud/mdp-core)  
N个专业子系统： [低代码mdp-lcode](https://gitee.com/maimengcloud/mdp-lcode-ui-web) 、
[系统及账户管理mdp-sys](https://gitee.com/maimengcloud/mdp-sys-backend) 、
[第三方支付登录等mdp-tpa](https://gitee.com/maimengcloud/mdp-tpa-backend) 、
[统一认证中心mdp-oauth2](https://gitee.com/maimengcloud/mdp-oauth2-backend) 、
[内容管理mdp-arc](https://gitee.com/maimengcloud/mdp-arc-ui-web) 、
[工作流mdp-workflow](https://gitee.com/maimengcloud/mdp-workflow-backend) 、
[短信mdp-sms](https://gitee.com/maimengcloud/mdp-sms-ui-web) 、
[代码生成器mdp-code](https://gitee.com/maimengcloud/mdp-code-generator) 、
[研发项目管理xm](https://gitee.com/maimengcloud/xm-ui-web) 、
[即时通讯mdp-im](https://gitee.com/maimengcloud/mdp-im-web) 、
[财务ac](https://gitee.com/maimengcloud/ac-core-ui-web) 、
[协同办公oa](https://gitee.com/maimengcloud/oa-ui-web)  
上述专业子系统全部开源


### 唛盟xm主体工程
唛盟xm使用[唛盟低代码开发平台](https://gitee.com/maimengcloud/mdp-lcode-ui-web)开发，属于前后端严格分离的一套系统，分为前端工程、后端工程两部分
- [xm-ui-web](https://gitee.com/maimengcloud/xm-ui-web)
  唛盟的前端工程,以vue.js为主
- [xm-backend](https://gitee.com/maimengcloud/xm-backend)
  唛盟的后端工程，java语言为主

### 唛盟账号管理工程
唛盟xm的账户管理、组织管理、菜单管理等沿用唛盟低代码的功能
- [mdp-lcode-ui-web](https://gitee.com/maimengcloud/mdp-lcode-ui-web)
  唛盟低代码的前端工程,以vue.js为主
- [mdp-lcode-backend](https://gitee.com/maimengcloud/mdp-lcode-backend)
  唛盟低代码的后端工程，java语言为主

### 高级配套工程
- [mdp-cloud-backend](https://gitee.com/maimengcloud/mdp-cloud-backend)   
  该工程作为spring cloud的扩展工程，如果需要将系统发布到spring cloud环境，需要下载该工程重新打包，不包含任何的业务功能，仅作为后端接入cloud环境使用

- [mdp-oauth2-backend](https://gitee.com/maimengcloud/mdp-oauth2-backend)   
  该工程为统一认证中心，作为spring oauth2的扩展工程，如果需要将系统接入oauth2环境，需要下载该工程重新打包，该工程实现分布式单点登陆；支持微信、支付宝、短信、账户密码等多种登陆方式

### 开发辅助工具
- [mdp-code-generator](https://gitee.com/maimengcloud/mdp-code-generator) 代码生成器  
  生成代码两种方式，  
  一、使用代码生成器本地工程，好处是代码可以直接覆盖到本地业务工程，避免复制黏贴出错。  
  二、如果不需要本地生成代码，也可以在低代码平台在线生成。[在线生成代码](https://maimengcloud.com/lcode/m1/#/mdp/lcode/gen)

## ⚙ 快速开始

xm的部分服务会调用mdp-lcode中的用户信息，开发前最好把[mdp-lcode-backend](https://gitee.com/maimengcloud/mdp-lcode-backend)部署起来，提供用户管理等服务

### 开发
```bash

# 克隆开发底座项目
git clone https://gitee.com/maimengcloud/mdp-core.git
# 安装开发底座依赖
mvn install 

# 克隆oauth2项目(非必须)
git https://gitee.com/maimengcloud/mdp-oauth2-backend.git
# 安装oauth2依赖
mvn install

# 克隆cloud项目(非必须)
git https://gitee.com/maimengcloud/mdp-cloud-backend.git
# 安装cloud依赖
mvn install

# 克隆xm项目
git clone https://gitee.com/maimengcloud/xm-backend.git
# 安装xm依赖
mvn install

# 导入数据库脚本 
创建xm数据库,找到[xm.sql](./sql/xm.sql),导入相关表到xm数据库中

# 配置数据库链接 + redis 链接(需要提前准备数据库及redis环境)
[application-dev.yml](./xm-core/src/main/resources/application-dev.yml)

# 启动服务 
找到并运行[XmApplication.java](./xm-core/src/test/java/com/mdp/XmApplication.java) 
```

访问端口 http://localhost:7067

### 发布
```bash
# 构建 
在xm-backend下执行 
mvn instal

# 部署
在xm-backend下执行
mvn deploy

# 手工发布到测试环境或者生产环境
如果是单体应用则拷贝并推送到服务器上[xm-bootstrap-2.0.0-RELEASE.jar](./xm-bootstrap/target/xm-bootstrap-2.0.0-RELEASE.jar)
如果是微服务则拷贝并推送到服务器上[xm-cloud-bootstrap-2.0.0-RELEASE.jar](./xm-cloud-bootstrap/target/xm-cloud-bootstrap-2.0.0-RELEASE.jar)

# 启动应用（单体、cloud对jar包的引用不同，需要根据情况修改下脚本bootstrap-xm.sh，默认是单体）初次部署把./start-service/bootstrap-xm.sh拷贝到服务器上
sh bootstrap-xm.sh
```

### 🔔️ 特别提醒

mdp 3.0 版本已经开始规划更新了，尽请期待新版本的诞生吧

 
## 💯 项目管理演示环境

1. [账户管理平台](https://maimengcloud.com/lcode/m1/)  
2. [唛盟众包-网页](https://maimengcloud.com)
3. [项目管理-网页](https://maimengcloud.com/xm/m1/)
4. 项目管理-小程序   
   <img src="https://maimengcloud.com/img/77639c6907935d3b699f.png" alt="drawing" width="200"/>


## 🐞 交流讨论 、反馈 BUG、提出建议等

1. 快扫描下方左侧微信二维码和我们一起交流讨论吧！（备注 唛盟-mdp 进群）
   <img src="https://maimengcloud.com/img/5ff0a747a4a1f14cf6a5.png" alt="drawing" width="200"/>

2. 唛盟微信公众号查看一些基础教程  
   <img src="https://maimengcloud.com/img/f3f91bac3a3735264a66.png" alt="drawing" width="200"/>

3. 反馈 BUG、提出建议，欢迎新建：[issues](https://gitee.com/maimengcloud/mdp-lcode-ui-web/issues)，开发人员会不定时查看回复。
4. 参与贡献，请查看[贡献指南](#🔨贡献指南)。

## 💲 打赏
**感谢所有赞赏以及参与贡献的小伙伴，你们的支持是我们不断更新前进的动力！微信扫一扫，赏杯咖啡呗！**    
<img src="https://maimengcloud.com/img/97094cc1553fe0b0046c.jpg" alt="drawing" width="300"/>

## 🔔商务合作

序号|合作项目| 详细介绍 | 费用说明|
----------------------|------------|----------------------|-----|
1.| 打赏获得赞助商名额| 在赞助商列表展示（添加微信沟通） |不限额度|
2.| 新组件开发| 提供组件扩展、优化服务 |视复杂程度而定|
3.| 开发问题解答|如果使用该产品遇到棘手问题需要解决，添加微信进行沟通解决 |免费|
4.| 开发培训|提供开发流程介绍、技术介绍、功能介绍、部署流程介绍，仅限线上培训 |加微信详聊|
5.| 扩展问题解答|如果需要使用该产品进行自有业务系统研发，需要我方提供意见建议，我方收取一定费用后提供相应服务 |加微信详聊|
6.| 广告合作|广告位(精品项目推荐、赞助商展位) |加微信沟通|



