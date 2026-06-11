[README.md](https://github.com/user-attachments/files/28833933/README.md)
# Task-Management-System-F27SB

> F27SB Software Development 2 — 任务管理系统课程项目

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://openjdk.org/)
[![Course](https://img.shields.io/badge/Course-F27SB-green.svg)]()

---

## 📖 项目简介

本项目是 **Heriot-Watt University** 计算机科学专业课程 **F27SB Software Development 2（软件开发2）** 的课程作业，使用 **Java** 语言开发的一个面向对象的任务管理系统。

该系统实现了任务管理的核心功能，包括任务的增删改查、优先级排序、分类管理、截止日期提醒等，旨在巩固面向对象编程（OOP）的核心概念，如封装、继承、多态、接口以及集合框架（Collections）的使用。citeweb_search:10#1

---

## 🗂️ 项目结构

```
Task-Management-System-F27SB/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/              # 数据模型层
│   │   │   │   ├── Task.java       # 任务实体类（ID、标题、描述、优先级、截止日期、状态等）
│   │   │   │   ├── User.java       # 用户实体类（用户名、密码、任务列表等）
│   │   │   │   ├── Priority.java   # 枚举：任务优先级（LOW, MEDIUM, HIGH, URGENT）
│   │   │   │   ├── Status.java     # 枚举：任务状态（TODO, IN_PROGRESS, DONE）
│   │   │   │   └── Category.java   # 枚举/类：任务分类
│   │   │   ├── controller/         # 控制层
│   │   │   │   ├── TaskController.java      # 任务管理控制器
│   │   │   │   ├── UserController.java      # 用户认证与管理控制器
│   │   │   │   └── NotificationController.java # 提醒通知控制器
│   │   │   ├── view/               # 视图层（CLI/GUI）
│   │   │   │   ├── MainMenu.java            # 主菜单界面
│   │   │   │   ├── TaskView.java            # 任务操作界面
│   │   │   │   └── UserView.java            # 用户操作界面
│   │   │   ├── service/            # 业务逻辑层
│   │   │   │   ├── TaskService.java         # 任务CRUD业务逻辑
│   │   │   │   ├── UserService.java         # 用户相关业务逻辑
│   │   │   │   └── SortService.java         # 排序与过滤服务
│   │   │   ├── dao/                # 数据访问层（Data Access Object）
│   │   │   │   ├── TaskDAO.java             # 任务数据持久化接口
│   │   │   │   ├── UserDAO.java             # 用户数据持久化接口
│   │   │   │   └── FileTaskDAO.java         # 基于文件的实现
│   │   │   ├── util/               # 工具类
│   │   │   │   ├── FileHandler.java         # 文件读写工具
│   │   │   │   ├── Validator.java           # 输入验证工具
│   │   │   │   └── DateUtil.java            # 日期处理工具
│   │   │   └── Main.java           # 程序入口
│   │   └── resources/
│   │       └── data/               # 数据存储目录
│   │           ├── tasks.json      # 任务数据文件
│   │           └── users.json      # 用户数据文件
│   └── test/
│       └── java/
│           ├── model/              # 模型层单元测试
│           ├── service/            # 业务逻辑层测试
│           └── integration/        # 集成测试
├── docs/
│   ├── class-diagram.png           # UML类图
│   ├── sequence-diagram.png        # 时序图
│   └── report.pdf                  # 课程报告
├── lib/                            # 外部依赖（如 JSON 处理库）
├── .gitignore
├── build.gradle / pom.xml          # 构建工具配置（Gradle/Maven）
└── README.md
```

---

## 🚀 快速开始

### 环境要求

- **Java 17** 或更高版本
- **Gradle 8.x** 或 **Maven 3.8+**（如使用构建工具）
- 可选：IntelliJ IDEA / Eclipse / VS Code

### 克隆与运行

```bash
# 克隆仓库
git clone https://github.com/LeoWinter15/Task-Management-System-F27SB.git
cd Task-Management-System-F27SB

# 使用 Gradle 构建并运行
./gradlew build
./gradlew run

# 或使用 Maven
mvn compile
mvn exec:java -Dexec.mainClass="Main"

# 或直接使用 javac 编译运行（无构建工具）
cd src/main/java
javac -d ../../../out -cp ../../../lib/* $(find . -name "*.java")
cd ../../../
java -cp "out:lib/*" Main
```

---

## ✨ 功能特性

### 核心功能

| 功能模块 | 描述 |
|---------|------|
| **用户管理** | 注册、登录、注销、修改密码、多用户支持 |
| **任务CRUD** | 创建、查看、编辑、删除任务 |
| **优先级管理** | 设置任务优先级：`LOW` / `MEDIUM` / `HIGH` / `URGENT` |
| **状态跟踪** | 任务状态流转：`TODO` → `IN_PROGRESS` → `DONE` |
| **分类管理** | 自定义任务分类（工作、学习、生活等） |
| **截止日期** | 设置截止日期，支持逾期提醒 |
| **排序与过滤** | 按优先级、截止日期、状态排序；按分类/状态过滤 |
| **搜索功能** | 按关键词搜索任务标题和描述 |
| **数据持久化** | 任务数据自动保存到本地 JSON 文件 |

### 面向对象设计亮点

- **封装（Encapsulation）**：所有实体类属性私有，通过 getter/setter 访问
- **继承（Inheritance）**：抽象基类 `BaseEntity` 提供通用 ID 和时间戳
- **多态（Polymorphism）**：`TaskDAO` 接口支持多种持久化实现（文件、内存、数据库）
- **接口（Interface）**：`Sortable`、`Filterable`、`Serializable` 等接口定义契约
- **集合框架**：使用 `ArrayList`、`HashMap`、`PriorityQueue`、`TreeSet` 等实现高效数据管理
- **异常处理**：自定义异常类 `TaskNotFoundException`、`InvalidDateException` 等
- **设计模式**：应用了 **单例模式**（控制器）、**工厂模式**（DAO创建）、**策略模式**（排序策略）

---

## 📐 UML 设计

### 核心类关系

```
┌─────────────────┐         ┌─────────────────┐
│   <<interface>> │         │   <<interface>> │
│    TaskDAO      │◄────────┤    UserDAO      │
└────────┬────────┘         └────────┬────────┘
         │                           │
    ┌────┴────┐                 ┌────┴────┐
    │FileTask │                 │FileUser │
    │  DAO    │                 │  DAO    │
    └────┬────┘                 └────┬────┘
         │                           │
         └───────────┬───────────────┘
                     │
         ┌───────────▼───────────┐
         │    TaskController     │
         │    UserController     │
         └───────────┬───────────┘
                     │
         ┌───────────▼───────────┐
         │    Main / CLI View    │
         └───────────────────────┘
```

### 任务状态机

```
    ┌─────────┐    开始执行    ┌─────────────┐    完成    ┌──────┐
    │  TODO   │ ────────────► │ IN_PROGRESS │ ────────► │ DONE │
    └─────────┘               └─────────────┘           └──────┘
         ▲                        │    │
         └────────────────────────┘    │
              重新打开                  │
                                       ▼
                                 ┌──────────┐
                                 │ CANCELLED│
                                 └──────────┘
```

---

## 🧪 测试

运行单元测试和集成测试：

```bash
# Gradle
./gradlew test

# Maven
mvn test

# 查看测试报告
open build/reports/tests/test/index.html
```

### 测试覆盖范围

- **Model 测试**：验证实体类的构造、getter/setter、equals/hashCode
- **Service 测试**：验证业务逻辑（CRUD、排序、过滤、搜索）
- **DAO 测试**：验证数据持久化与读取的正确性
- **集成测试**：验证各层协作的完整流程

---

## 📋 课程要求对照

本项目的实现覆盖了 F27SB 课程的核心学习目标：citeweb_search:10#0

| 课程要求 | 本项目实现 |
|---------|-----------|
| 面向对象基础（类、对象、封装） | `Task`、`User` 等实体类的完整封装 |
| 继承与多态 | `BaseEntity` 抽象类、`Sortable`/`Filterable` 接口 |
| 集合框架 | `ArrayList<Task>`、`HashMap<String, User>`、`PriorityQueue` |
| 异常处理 | 自定义异常 + 输入验证 + 文件IO异常处理 |
| 文件IO / 序列化 | JSON 格式数据持久化 |
| 设计模式 | 单例、工厂、策略模式 |
| 单元测试 | JUnit 5 全面覆盖 |
| 文档与UML | 完整 README + UML 类图 + 时序图 |

---

## 📝 示例操作

```
========================================
      任务管理系统 - F27SB
========================================
1. 用户登录
2. 用户注册
3. 退出
请选择: 1

用户名: alice
密码: *****

登录成功！欢迎, alice!

========================================
           主菜单
========================================
1. 查看所有任务
2. 添加新任务
3. 编辑任务
4. 删除任务
5. 按优先级排序
6. 按截止日期排序
7. 搜索任务
8. 过滤（按状态/分类）
9. 退出登录
请选择: 2

--- 添加新任务 ---
标题: 完成F27SB作业
描述: 编写Java任务管理系统
优先级 (1-LOW, 2-MEDIUM, 3-HIGH, 4-URGENT): 3
分类: 学习
截止日期 (yyyy-MM-dd): 2024-12-15

任务添加成功！ID: T-20241201-001
```

---

## 🛠️ 技术栈

- **语言**：Java 17
- **构建工具**：Gradle / Maven
- **测试框架**：JUnit 5
- **数据格式**：JSON（`org.json` 或 Gson）
- **开发工具**：IntelliJ IDEA / Eclipse / VS Code

---

## 📚 参考资料

- Heriot-Watt University — F27SB Software Development 2 课程大纲 citeweb_search:10#0
- Heriot-Watt University CS Courses citeweb_search:10#2
- Oracle Java Documentation — [Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)
- Oracle Java Documentation — [Object-Oriented Programming Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)

---

## 🤝 贡献

本项目为课程作业项目，欢迎 Fork 和参考学习。如有改进建议，欢迎提交 Issue。

---

## 📄 许可证

本项目采用 [Apache License 2.0](LICENSE) 开源许可证。

---

> **免责声明**：本项目为 Heriot-Watt University F27SB 课程的个人学习项目，仅供学习参考使用。
