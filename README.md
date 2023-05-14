# MCManager

* NeteaseMusicApi 是一个需要翻墙才能访问的API接口，与Song表相关。给api传入 cloudsearch?keyword=歌名 会返回一堆数据，然后通过找到歌曲的id，存入songid。以后再给此API传入这个id：
song/url?id=歌曲id。 返回的结果是歌曲ID对应的歌曲信息包括url（播放源），以及一堆信息。song表的icon对应专辑图片的url地址。
* 目前我自己部署了一个NeteaseMusicApi，但是也是需要翻墙，因为它在vercel上。后面有时间了我会转移到腾讯云serverless上就不用翻墙了。

* Vue-admin-template 里 npm install, cd vue-admin-template, npm run dev启动后，侧边栏最下面一行是官方文档。

* src里没啥好说的，依托答辩，现在只剩controller了。

### 数据特别说明
* user表里的head(头像), post表里的head(头像), picture(图片)都是字符串，图片被经过base64编码后存储，字节很长很大，建议不用直接在命令行里select这两个表，屏幕会爆满的。

## 如果使用本地数据库，查看创建表SQL

## 如果使用云数据库
登录注册阿里云账号
![image](https://user-images.githubusercontent.com/58733209/233963667-bae91b47-8cda-415a-919d-ad1304c6ca61.png)

![image](https://user-images.githubusercontent.com/58733209/233963528-fda060e0-243a-4704-b94e-e35f69922b9d.png)
然后就可以登录数据库实例直接查看和修改表
