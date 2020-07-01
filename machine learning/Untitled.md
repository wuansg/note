

$n_x$

$(x^{(i)}, y^{(i)})$

$X=[x^{(1)}, x^{(2)}, ...x^{(m)}]$

$Y=[y^{(1)}, y^{(2)},...,y^{(m)}]$

$M_{train}, M_{test}$

${{y}^{\left( 1 \right)}},{{y}^{\left( m \right)}},...,{{y}^{\left( m \right)}}$

$\hat{y}={{w}^{T}}x+b$

$\sigma \left( z \right)=\frac{1}{1+{{e}^{-z}}}$

$\hat{y}=\sigma \left( {{\theta }^{T}}x \right)$

${{\theta }{0}},{{\theta }{1}},{{\theta }{2}},...,{{\theta }{{{n}{x}}}}$

**Loss function**: $L\left(\hat{y},y \right)$

$L\left( \hat{y},y \right)=-y\log(\hat{y})-(1-y)\log (1-\hat{y})$

$J\left( w,b \right)=\frac{1}{m}\sum\limits_{i=1}^{m}{L\left( {{{\hat{y}}}^{(i)}},{{y}^{(i)}} \right)}=\frac{1}{m}\sum\limits_{i=1}^{m}{\left( -{{y}^{(i)}}\log {{{\hat{y}}}^{(i)}}-(1-{{y}^{(i)}})\log (1-{{{\hat{y}}}^{(i)}}) \right)}$

$dw = \frac{\partial J(w,b)}{\partial w}$, $db = \frac{\partial J(w,b)}{\partial b}$

$\frac{dJ}{du}=\frac{dJ}{dv}\frac{dv}{du}$ ， $\frac{dJ}{db}=\frac{dJ}{du}\frac{du}{db}$ ， $\frac{dJ}{da}=\frac{dJ}{du}\frac{du}{da}$,  $\frac{dJ}{dv}\cdot\frac{dv}{du}$

$da=-\frac{y}{a}, dz=(\frac{dL}{da})\cdot (\frac{da}{dz}), \frac{da}{dz}=a\cdot (1-a)$

所以${dz} = \frac{{dL}(a,y)}{{dz}} = \frac{{dL}}{{dz}} = \left( \frac{{dL}}{{da}} \right) \cdot \left(\frac{{da}}{{dz}} \right) = ( - \frac{y}{a} + \frac{(1 - y)}{(1 - a)})\cdot a(1 - a) = a - y$

$d{{w}{1}}=\frac{1}{m}\sum\limits{i}^{m}{x_{1}^{(i)}}({{a}^{(i)}}-{{y}^{(i)}})$ $d{{w}{2}}=\frac{1}{m}\sum\limits{i}^{m}{x_{2}^{(i)}}({{a}^{(i)}}-{{y}^{(i)}})$ $db=\frac{1}{m}\sum\limits_{i}^{m}{({{a}^{(i)}}-{{y}^{(i)}})}$

 ```python
J=0; dw1=0; dw2=0; db=0;
for i=1 to m:
    z(i) = wx(i)+b;
    a(i) = sigmoid(z(i));
    J += -[y(i)log(a(i))+(1-y(i))log(1-a(i))];
    dz(i) = a(i)-y(i);
    dw1 += x1(i)dz(i);
    dw2 += x2(i)dz(i);
    db += dz(i);
J/=m;
dw1/=m;
dw2/=m;
db/=m;
w=w-alpha*dw;
b=b-alpha*db
 ```

### 向量化（Vectorization)

$w\in {{\mathbb{R}}^{{{n}{x}}}}, x\in {{\mathbb{R}} ^ {{{n}{x}}}}$

**python代码实现计算$z={{w}^{T}}x+b$**

```python
z=0
for i in range(n_x):
    z += w[i]*x[i]
z += b;
```

向量化实现计算$z={{w}^{T}}x+b$

```matlab
z=np.dot(w,x)+b
```

实际比较

```python
import numpy as np #导入numpy库
a = np.array([1,2,3,4]) #创建一个数据a
print(a)
# [1 2 3 4]

import time #导入时间库
a = np.random.rand(1000000)
b = np.random.rand(1000000) #通过round随机得到两个一百万维度的数组
tic = time.time() #现在测量一下当前时间

#向量化的版本
c = np.dot(a,b)
toc = time.time()
print("Vectorized version:" + str(1000*(toc-tic)) +"ms") #打印一下向量化的版本的时间

#继续增加非向量化的版本
c = 0
tic = time.time()
for i in range(1000000):
    c += a[i]*b[i]
toc = time.time()
print(c)
print("For loop:" + str(1000*(toc-tic)) + "ms")#打印for循环的版本的时间
```

$u_{i} =\sum_{j}^{}{A_{\text{ij}}v_{i}}$,

$ \begin{array}{r} {x }\ {W^{[1]}}\ {b^{[1]}} \end{array}\implies{z^{[1]}=W^{[1]}x+b^{[1]}} \implies{a^{[1]} = \sigma(z^{[1]})} $

$ a^{[1]} = [ \begin{array}{ccc} a^{[1]}*{1}\ a^{[1]}*{2}\ a^{[1]}*{3}\ a^{[1]}*{4} \end{array} ] $

$z^{[1]}_1 = w^{[1]T}_1x + b^{[1]}_1, a^{[1]}_1 = \sigma(z^{[1]}_1)$

$z^{[1]}_2 = w^{[1]T}_2x + b^{[1]}_2, a^{[1]}_2 = \sigma(z^{[1]}_2)$

$z^{[1]}_3 = w^{[1]T}_3x + b^{[1]}_3, a^{[1]}_3 = \sigma(z^{[1]}_3)$

$z^{[1]}_4 = w^{[1]T}_4x + b^{[1]}_4, a^{[1]}_4 = \sigma(z^{[1]}_4)$

$a^{[1]} = \left[ \begin{array}{c} a^{[1]}*{1}\ a^{[1]}*{2}\ a^{[1]}*{3}\ a^{[1]}*{4} \end{array} \right] = \sigma(z^{[1]}) $$ 公式3.11： $$ \left[ \begin{array}{c} z^{[1]}*{1}\ z^{[1]}*{2}\ z^{[1]}*{3}\ z^{[1]}*{4}\ \end{array} \right] = \overbrace{ \left[ \begin{array}{c} ...W^{[1]T}*{1}...\ ...W^{[1]T}*{2}...\ ...W^{[1]T}*{3}...\ ...W^{[1]T}*{4}... \end{array} \right] }^{W^{[1]}} * \overbrace{ \left[ \begin{array}{c} x_1\ x_2\ x_3\ \end{array} \right] }^{input} + \overbrace{ \left[ \begin{array}{c} b^{[1]}_1\ b^{[1]}_2\ b^{[1]}_3\ b^{[1]}_4\ \end{array} \right] }^{b^{[1]}} $

$x = \left[ \begin{array}{c} \vdots & \vdots & \vdots & \vdots\ x^{(1)} & x^{(2)} & \cdots & x^{(m)}\ \vdots & \vdots & \vdots & \vdots\ \end{array} \right] $

$Z^{[1]} = \left[ \begin{array}{c} \vdots & \vdots & \vdots & \vdots\ z^{[1]} & z^{[1]} & \cdots & z^{[1]}\ \vdots & \vdots & \vdots & \vdots\ \end{array} \right] $

$A^{[1]} = \left[ \begin{array}{c} \vdots & \vdots & \vdots & \vdots\ \alpha^{[1]} & \alpha^{[1]} & \cdots & \alpha^{[1]}\ \vdots & \vdots & \vdots & \vdots\ \end{array} \right] $

$\begin{array}{r} \text{z^{1} = W^{[1]}x^{(i)} + b^{[1]}}\ \text{\alpha ^{[1]} = \sigma(z^{[1]})}\ \text{z^{[2]} = W^{[2]}\alpha^{[1]} + b^{[2]}}\ \text{\alpha^{[2]} = \sigma(z^{[2]})}\ \end{array} \implies \begin{cases} \text{A^{[1]} = \sigma(z^{[1]})}\ \text{z^{[2]} = W^{[2]}A^{[1]} + b^{[2]}}\ \text{A^{[2]} = \sigma(z^{[2]})}\ \end{cases}$

 $z^{[1]} = W^{[1]}x^{(1)} + b^{[1]}$

$z^{[1]} = W^{[1]}x^{(2)} + b^{[1]}$

$z^{[1]} = W^{[1]}x^{(3)} + b^{[1]}$

$z^{[1]} = W^{[1]}x^{(1)} + b^{[1]}$

$z^{[1]} = W^{[1]}x^{(2)} + b^{[1]}$

$z^{1}=W^1x^{(3)}+b^1$

$\left[
​	\begin{array}{c}
​	\vdots &\vdots & \vdots & \vdots \\
​	x^{(1)} & x^{(2)} & x^{(3)} & \vdots\\
​	\vdots &\vdots & \vdots & \vdots \\
​	\end{array}
​	\right]
​	=
​	\left[
​	\begin{array}{c}
​	\vdots &\vdots & \vdots & \vdots \\
​	w^{(1)}x^{(1)} & w^{(1)}x^{(2)} & w^{(1)}x^{(3)} & \vdots\\
​	\vdots &\vdots & \vdots & \vdots \\
​	\end{array}
​	\right]
​	=\\
​	\left[
​	\begin{array}{c}
​	\vdots &\vdots & \vdots & \vdots \\
​	z^{[1](1)} & z^{[1](2)} & z^{[1](3)} & \vdots\\
​	\vdots &\vdots & \vdots & \vdots \\
​	\end{array}
​	\right]
​	=
​	Z^{[1]}$

$a^{[1]} = \sigma(z^{[1]})$和$a^{[2]} =\sigma(z^{[2]})$

$a= tanh(z) = \frac{e^{z} - e^{- z}}{e^{z} + e^{- z}}$

### 激活函数的导数

#### 1. Sigmoid activation function

$\frac{d}{dz}g(z) = {\frac{1}{1 + e^{-z}} (1-\frac{1}{1 + e^{-z}})}=g(z)(1-g(z))$

当$z$ = 10或$z= -10$ ; $\frac{d}{dz}g(z)\approx0$

当$z $= 0 , $\frac{d}{dz}g(z)\text{=g(z)(1-g(z))=}{1}/{4}$

在神经网络中$a= g(z)$; $g{{(z)}^{'}}=\frac{d}{dz}g(z)=a(1-a)$

#### 2. Tanh activation function

$g(z) = tanh(z) = \frac{e^{z} - e^{-z}}{e^{z} + e^{-z}} $

$\frac{d}{{d}z}g(z) = 1 - (tanh(z))^{2}$   

当$z$ = 10或$z= -10$ $\frac{d}{dz}g(z)\approx0$

当$z$ = 0, $\frac{d}{dz}g(z)\text{=1-(0)=}1$

#### 3. Rectified Linear Unit （ReLU）

$g(z) =max (0,z)$

$ g(z)^{'}= \begin{cases} 0&	\text{if z < 0}\ 1&	\text{if z > 0}\ undefined&	\text{if z = 0} \end{cases} $

注：通常在$z$= 0的时候给定其导数1,0；当然$z$=0的情况很少

#### 4. Leaky Linear Unit(Leaky ReLU)

与**ReLU**类似 $$ g(z)=\max(0.01z,z) \ \ \ g(z)^{'}= \begin{cases} 0.01& \text{if z < 0}\ 1&	\text{if z > 0}\ undefined&	\text{if z = 0} \end{cases} $$

第二步是计算**协方差矩阵**（**covariance matrix**）$Σ$： $\sum=\dfrac {1}{m}\sum^{n}_{i=1}\left( x^{(i)}\right) \left( x^{(i)}\right) ^{T}$