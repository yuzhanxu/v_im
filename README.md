### 需要购买的阿里云的同学 请点击支持 [阿里云优惠券2000元](https://chuangke.aliyun.com/invite?userCode=d4l0ykh3)
### 务必记得点赞哦
### QQ群：617853658 验证请说明 V-IM （并且附上点赞的 gitee 用户名，不点赞不让进哦）
### Create by  [webstorm and intellij IDEA]


### 结构
>   1. V-IM-PC 是客户端
>   2. V-IM-Server 是服务端代码
>   3. doc 下面有数据库。
>   4. V-IM-PC/src/views/im/conf/index.js 里面配置端口等信息。

### 常见问题
>   1. 如果出现 Parsing error: x-invalid-end-tag  vue/no-parsing-error 类似的错误，可用用 webstorm 右键src 目录 Fix eslint problems，
>   2. 安装不成功，请先执行 npm install node-sass。如果还是错误请多重试下！

#### 文档
> 	1. 打包好的测试文件-->[下载exe安装文件 64位](doc/v-im Setup 0.6.4.exe)。
>   2. 打包好的web文件，在dist/web 目标下（运行的时候需要有容器，例如nginx tomcat之类的）。
>   3. 消息推送接口，调用方式：http://localhost:8080/api/user/sendMsg?access_token=你的token&userId=接收人&msg=我是消息
>   4. 获取token：http://localhost:8080/oauth/token?client_id=v-client&client_secret=v-client-ppp&grant_type=password&scope=select&username=wangwu&password=123456
>   5. 测试地址：http://101.200.151.183   wangwu/123456   zhangsan/123456。
>   6. 安装依赖命令：yarn 。
>   7. 开发环境命令：npm run serve 和 npm run electron:serve。
>   8. 打包安装文件：npm run electron:build，打包完成的文件在/dist_electron 下。
>   9. 打包web文件：npm run build，打包完成的文件在/dist 下。

### 注意事项

> 1. 打包时候项目路径不能有中文，包括你 windows 用户都不能有中文字符，因为npm 缓存都是在用户目录下（如果原先的用户名是中文，再修改成英文也不好用，因为原先的npm包都还在中文目录下，可以新建个window 英文账号，登录新账号打包）。
> 2. 使用yarn 安装依赖，npm 不是很好用，尝试过，都不能打包成功。如果yarn 不能安装依赖成功，可以多试几次，或者翻墙后再打包！
> 3. 基于 t-io websocket 协议， 据说能支持百万级并发，但是此项目并没有进行此方面的测试，还请知晓 ！

![logo](https://gitee.com/lele-666/V-IM/raw/master/V-IM-PC/public/static/icon.ico)


