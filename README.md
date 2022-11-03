# todo
A todo app in geektime course

## 基本需求

### 1. 第一阶段：基本功能

(1) 添加 Todo 项
```

todo add <item>


1. <item>


Item <itemIndex> added
```

(2) 完成 Todo 项
```

todo done <itemIndex>


Item <itemIndex> done.
```

(3) 查看 Todo 列表，缺省情况下，只列出未完成的 Todo 项
```

todo list


1. <item1>
2. <item2>


Total: 2 items
```

(4) 使用 all 参数，查看所有的 Todo 项
```

todo list --all


1. <item1>
2. <item2>
3. [Done] <item3>


Total: 3 items, 1 item done
```

要求：
1. Todo 项存储在本地文件中；
2. Todo 项索引逐一递增。

### 第二阶段：支持多用户

(1) 用户登录
```

todo login -u user
Password: 


Login success!
```
(2) 用户退出
```

todo logout


Logout success!
```

要求：
1. 只能看到当前用户的 Todo 列表；
2. 同一个用户的 Todo 项索引逐一递增；
3. 当前用户信息存储在配置文件中 ~/.todo-config。

### 第三阶段：支持 Todo 列表导入和导出
(1) Todo 列表导出
```

todo export > todolist
```
(2) Todo 列表导入
```

todo import -f todolist
```

### 第四阶段：支持数据库持久化
在配置文件中，配置数据库连接信息。

（1）初始化数据库
```

todo init
```

要求：
1. 没有数据库的情况下，使用本地文件；
2. 在有数据库的情况下，使用数据库；
3. 在本地文件已经存在的情况，将本地信息导入到数据库中。

为了方便代码的阅读，请你按如下要求编写你的代码：

* 在项目的 README 文件中，写出如何构建和执行你的应用；
* 需求分成四个阶段，请你按顺序依次完成每个阶段的需求；
* 每完成一个阶段的代码，创建一个 tag，tag 名称分别为 todo-phase-1、todo-phase-2、todo-phase-3、todo-phase-4。