# Firefly-Demo

一个基于 Firefly 框架的完整 Web 应用示例项目，展示了 Firefly 框架的核心功能和使用方法。

## 项目简介

本项目是 Firefly 框架的官方示例应用，旨在帮助开发者快速了解和掌握 Firefly 框架的使用。Firefly 是一个轻量级的 Java Web 框架，提供了 MVC 架构、依赖注入、模板引擎等完整的 Web 开发功能。

**视频讲解**

[firefly-demo示例讲解](http://www.tudou.com/programs/view/XMZo5FrYBVw)

## 技术栈

- **核心框架**: Firefly Framework
  - firefly.jar (184KB) - 核心框架
  - firefly-common.jar (171KB) - 通用工具类
  - firefly-nettool.jar (65KB) - 网络工具
  - firefly-template.jar (60KB) - 模板引擎
- **数据库**: MySQL
  - mysql-connector-java-5.1.23.jar
- **Web 容器**: 内置 HTTP 服务器（基于 Servlet API 2.5）
- **测试框架**: JUnit 4.11, Hamcrest Core 1.3
- **Java 版本**: Java SE (标准版)

## 项目结构

```
firefly-demo/
├── src/                                    # 源代码目录
│   ├── com/firefly/
│   │   ├── benchmark/                      # 性能测试相关
│   │   │   ├── Bootstrap.java              # 应用启动入口
│   │   │   └── controller/
│   │   │       └── IndexController.java    # 性能测试控制器
│   │   └── demo/
│   │       ├── domain/                     # 领域模型
│   │       │   ├── Book.java               # 图书实体类
│   │       │   ├── User.java               # 用户实体类
│   │       │   └── Food.java               # 食品实体类
│   │       ├── service/                    # 服务层
│   │       │   ├── FoodService.java        # 食品服务接口
│   │       │   └── impl/
│   │       │       └── FoodServiceImpl.java
│   │       ├── repository/                 # 数据访问层
│   │       │   └── FoodRepository.java     # 食品仓储类
│   │       └── view/                       # 视图层
│   │           ├── controller/             # 控制器
│   │           │   ├── HelloController.java    # Hello示例控制器
│   │           │   ├── BookController.java     # 图书管理控制器
│   │           │   └── FoodController.java     # 食品管理控制器
│   │           ├── intercepter/            # 拦截器
│   │           │   └── FoodInterceptor.java
│   │           └── util/                   # 工具类
│   │               └── FunctionUtil.java
│   ├── firefly.xml                         # Firefly主配置文件
│   ├── custom-beans.xml                    # 自定义Bean配置
│   └── firefly-log.properties              # 日志配置
├── web/                                    # Web资源目录
│   ├── template/                           # 模板文件
│   │   ├── book.html                       # 图书页面
│   │   ├── book_create.html                # 创建图书页面
│   │   ├── list_book.html                  # 图书列表页面
│   │   ├── food.html                       # 食品页面
│   │   ├── template_demo_ifelse.html       # 模板if-else示例
│   │   ├── template_demo_for.html          # 模板for循环示例
│   │   ├── template_demo_others.html       # 其他模板示例
│   │   ├── common/                         # 公共模板
│   │   │   ├── head.html
│   │   │   └── top.html
│   │   └── error/                          # 错误页面
│   │       └── e404.html
│   ├── index.html                          # 首页
│   └── favicon.ico                         # 网站图标
├── lib/                                    # 依赖库目录
├── doc/                                    # 文档目录
│   └── firefly-guied.doc                   # Firefly使用指南
├── test/                                   # 测试代码目录
└── .gitignore                              # Git忽略配置

```

## 主要功能

### 1. MVC 架构支持
- **控制器（Controller）**: 使用 `@Controller` 注解定义控制器
- **请求映射（Request Mapping）**: 使用 `@RequestMapping` 注解映射 URL 路径
- **视图（View）**: 支持多种视图类型
  - TemplateView: 模板视图
  - JsonView: JSON 视图
  - TextView: 文本视图
  - RedirectView: 重定向视图
  - JspView: JSP 视图（需外部容器支持）

### 2. 依赖注入（DI）
- 使用 `@Inject` 注解实现依赖注入
- 支持 XML 配置方式定义 Bean
- 组件自动扫描（component-scan）

### 3. 拦截器（Interceptor）
- 使用 `@Interceptor` 注解定义拦截器
- 支持 URI 模式匹配和执行顺序配置
- 示例：FoodInterceptor 拦截 `/food*` 路径的请求

### 4. 模板引擎
- 内置模板引擎，支持：
  - 条件语句（if-else）
  - 循环语句（for）
  - 变量输出
  - 模板包含
  - 自定义函数

### 5. 路径参数支持
- 支持 RESTful 风格的 URL 路径参数
- 使用 `@PathVariable` 注解获取路径变量
- 示例：`/hello/text-?/?-?` 匹配动态路径

### 6. HTTP 参数绑定
- 使用 `@HttpParam` 注解自动绑定请求参数到对象
- 支持对象属性自动映射

### 7. 内置 HTTP 服务器
- 默认配置：localhost:7676
- 支持 Keep-Alive 配置
- 可独立运行，无需外部 Web 容器

## 使用方法

### 启动应用

1. **配置服务器参数**

编辑 `src/firefly.xml` 文件，配置 HTTP 服务器：

```xml
<bean class="com.firefly.server.http.Config">
    <property name="serverHome" value="D:/java_prj/my_project/firefly-demo/web"></property>
    <property name="host" value="localhost"></property>
    <property name="port" value="7676"></property>
    <property name="keepAlive" value="false"></property>
</bean>
```

**注意**: 需要将 `serverHome` 修改为你本地项目的实际 web 目录路径。

2. **运行主类**

```bash
java -cp "lib/*:src" com.firefly.benchmark.Bootstrap
```

或在 IDE 中直接运行 `com.firefly.benchmark.Bootstrap` 类的 main 方法。

3. **访问应用**

在浏览器中访问：`http://localhost:7676`

### 示例页面

- **Hello World**: `http://localhost:7676/hello/text`
- **路径参数示例**: `http://localhost:7676/hello/text-a/b-c`
- **重定向示例**: `http://localhost:7676/hello/redirect`
- **文档示例**: `http://localhost:7676/document/java/firefly`
- **图书列表**: `http://localhost:7676/book/list`
- **图书添加**: `http://localhost:7676/book/add`
- **食品页面**: `http://localhost:7676/food`
- **模板if-else示例**: `http://localhost:7676/template/demo_ifelse`
- **模板for循环示例**: `http://localhost:7676/template/demo_for`
- **模板其他功能**: `http://localhost:7676/template/demo_others`

### POST 请求示例

创建图书（需要 POST 请求）：

```bash
curl -X POST http://localhost:7676/book/create \
  -d "book.title=示例图书&book.author=作者名"
```

获取图书 JSON 数据：

```bash
curl -X POST http://localhost:7676/book/json \
  -d "book.id=1&book.title=测试图书"
```

## 依赖说明

### 核心依赖

| 依赖库 | 版本 | 说明 |
|--------|------|------|
| firefly.jar | - | Firefly 核心框架，提供 MVC、DI、HTTP 服务器等功能 |
| firefly-common.jar | - | 通用工具类库 |
| firefly-nettool.jar | - | 网络工具类库 |
| firefly-template.jar | - | 模板引擎 |
| servlet-api | 2.5 | Servlet API 规范 |
| mysql-connector-java | 5.1.23 | MySQL 数据库驱动 |
| junit | 4.11 | 单元测试框架 |
| hamcrest-core | 1.3 | 测试匹配器库 |

### 配置文件说明

- **firefly.xml**: 主配置文件
  - 配置组件扫描路径：`com.firefly`
  - 配置模板路径和编码：`/template`, `UTF-8`
  - 引入自定义 Bean 配置：`custom-beans.xml`
  - 配置 HTTP 服务器参数

- **custom-beans.xml**: 自定义 Bean 配置
  - 定义食品数据（apple, orange, strawberry）
  - 配置 foodRepository

- **firefly-log.properties**: 日志配置文件

## 核心类说明

### 启动类
- **Bootstrap.java**: 应用程序启动入口，通过 `ServerBootstrap.start("firefly.xml")` 启动服务器

### 控制器
- **HelloController.java**: 展示基本的请求处理、视图返回、路径参数、重定向等功能
- **BookController.java**: 图书管理功能，包括添加图书、创建图书、列表展示
- **FoodController.java**: 食品管理和模板引擎功能演示

### 领域模型
- **Book.java**: 图书实体，包含标题、作者、出版社、出版日期、价格、折扣等属性
- **User.java**: 用户实体，包含 ID、姓名、密码、角色、邮箱、年龄等属性
- **Food.java**: 食品实体，包含 ID、名称、价格等属性

### 拦截器
- **FoodInterceptor.java**: 拦截所有 `/food*` 路径的请求，演示拦截器功能和依赖注入

## 技术特点

1. **轻量级**: 核心框架仅 180KB 左右，整体依赖小于 2MB
2. **高性能**: 内置高性能 HTTP 服务器
3. **易用性**: 注解驱动开发，配置简单
4. **完整性**: 提供从 MVC 到模板引擎的完整解决方案
5. **灵活性**: 支持多种视图类型和数据格式

## 其他相关信息

### 学习资源

- **文档**: 项目 `doc` 目录下提供了 `firefly-guied.doc` 使用指南
- **视频教程**: [firefly-demo示例讲解](http://www.tudou.com/programs/view/XMZo5FrYBVw)

### 注意事项

1. **JSP 支持**: Firefly 内置容器不支持 JSP 编译，如需使用 JSP，需要部署到外部 Servlet 容器（如 Tomcat）
2. **路径配置**: 启动前需要修改 `firefly.xml` 中的 `serverHome` 为实际的项目 web 目录绝对路径
3. **端口冲突**: 默认端口为 7676，如有冲突可在配置文件中修改
4. **数据库**: 项目包含 MySQL 驱动，但示例代码未实际连接数据库，主要用于演示框架功能

### 项目作者

- **作者**: luowei
- **创建日期**: 2013-03-08

### 许可证

本项目为 Firefly 框架的示例项目，请参考 Firefly 框架的相关许可协议。

---

**祝您使用愉快！**
