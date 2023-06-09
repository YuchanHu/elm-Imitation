# 基于MVC的仿饿了么控制台商家管理系统

该项目为个人的练习项目，并不完善，仅仅是实现了“管理员-商家-食品”的操作。

但其具有完整的MVC架构，MVC模式中的Model（模型）是应用程序中用于处理应用程序业务逻辑的部分。View（视图）是应用程序中处理数据显示的部分，通常视图是依据模型数据创建的。Controller（控制器）是应用程序中协调Model组件和View组件的部分，通常控制器负责从视图读取数据，控制用户输入，并向模型发送数据。



## 环境

**Java版本：1.8**

数据库：MySQL5.7	|	数据库可视化工具：SQLyog Ultimate

集成开发环境：IntelliJ IDEA 2020.3.1

该项目**没有使用Maven、Gradle和任何数据库连接池**

> 编码集为UTF-8，数据库的编码集也全部为UTF-8



## 使用方式

### 1.配置数据库文件

在MySQL中创建一个名为`elm`的数据库

将资源根目录下的`elm.sql`文件导入至这个数据库

### 2.将项目导入至IDEA

直接用IDEA打开该项目的文件夹

### 3.配置JDBC

打开Config目录下的DB.properties文件

编辑你的数据库用户名和密码

> 数据库的地址默认为本地且端口号为3306

### 4.运行

管理员身份入口：View下的`ElmAdminEntry`

商家身份入口：View下的`ElmBusinessEntry`



## 项目介绍

模拟饿了么实现功能

系统中存在2种用户：管理员和商家

管理员可以对商家信息进行管理。比如添加商家、查询商家信息、删除商家、修改商家信息。

商家可以对经营的商品进行管理：比如查询、添加、修改、删除

为管理员和商家提供不同的操作界面

### Pojo层

存放各个实体类：管理员、商家、食品

### View层

控制台界面

### Controller层

每个实体类操作的控制器，存放每个实体类的方法

### DAO层

与数据库的交互，对各个表的操作分别以接口方式定义

在内有DAO的实现方法存放在Impl目录下，每个实现类都继承各自的接口，重写操作数据库的方法

### Util层

存放各种工具类，其中：

- DBUtil：连接数据库的工具类

  > 此类的编码集为GBK，但不需要更改也能正常使用

- FoodUtil：在控制台中规范化输出食品的列表
- BusinessUtil：在控制台中规范化输出商家的列表
- StringUtil：字符串工具类，判断字符串是否为空



## 数据建模

数据库中包含3张表：

管理员表：用户名和密码

商家表：商家信息	一

食品表：食品信息	多	外键表

| No   | 表名称   | 中文名   | 说明                             |
| ---- | -------- | -------- | -------------------------------- |
| 1    | business | 商家表   | 存储所有商家信息                 |
| 2    | food     | 食品表   | 存储每个商家所拥有的所有食品信息 |
| 3    | admin    | 管理员表 | 存储管理员信息                   |

#### business（商家表）

| No   | 字段名          | 数据类型 | size  | 默认値 | 约束       | 说明     |
| ---- | --------------- | -------- | ----- | ------ | ---------- | -------- |
| 1    | businessId      | int      |       |        | PK、AI、NN | 商家编号 |
| 2    | password        | varchar  | 20    |        | NN         | 密码     |
| 3    | businessName    | varchar  | 40    |        | NN         | 商家名称 |
| 4    | businessAddress | varchar  | 50    |        |            | 商家地址 |
| 5    | businessExplain | varchar  | 40    |        |            | 商家介绍 |
| 6    | starPrice       | decimal  | (5,2) | 0.00   |            | 起送费   |
| 7    | deliveryPrice   | decimal  | (5,2) | 0.00   |            | 配送费   |

#### food（食品表）

| No   | 字段名      | 数据类型 | size  | 默认値 | 约束       | 说明         |
| ---- | ----------- | -------- | ----- | ------ | ---------- | ------------ |
| 1    | foodId      | int      |       |        | PK、AI、NN | 食品编号     |
| 2    | foodName    | varchar  | 30    |        | NN         | 食品名称     |
| 3    | foodExplain | varchar  | 30    |        |            | 食品介绍     |
| 4    | foodPrice   | decimal  | (5,2) |        | NN         | 食品价格     |
| 5    | businessId  | int      |       |        | FK、NN     | 所属商家编号 |

#### admin（管理员表）

| No   | 字段名    | 数据类型 | size | 默认値 | 约束       | 说明       |
| ---- | --------- | -------- | ---- | ------ | ---------- | ---------- |
| 1    | adminId   | int      |      |        | PK、AI、NN | 管理员编号 |
| 2    | adminName | varchar  | 20   |        | NN、UQ     | 管理员名称 |
| 3    | password  | varchar  | 20   |        | NN         | 密码       |

