对于每个请求，DispatcherServlet会将当前的HttpServletRequest绑定到RequestContextHolder的一个static的ThreadLocal中。

所以当在同一个Thread时，可以通过一下方式获取到HttpServletRequest：

```java
HttpServletRequest request = ((ServletRequestAttributes)) RequestContextHolder.currentRequestAttributes()).getRequest();
```

