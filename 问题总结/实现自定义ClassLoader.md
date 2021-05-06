1. 继承ClassLoader类
2. 重写findClass方法
   1. 通过类完整限定名称得到类的相对路径，查找到该类文件并将其转化为byte[]
   2. 调用defineClass方法。