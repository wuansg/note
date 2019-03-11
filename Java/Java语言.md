# Java语言

#### Java字符串

如果想重载（override）toString（）方法来打印对象的内存地址，不能使用this去打印内存地址，因为在调用this后需要返回String类型的数据，所以需要调用this.toString()方法，这样会造成自身调用，从而引起栈溢出错误。

可以通过调用super.toString()来打印内存地址。**这种方法仅限于该类的超类为Object时才生效**



