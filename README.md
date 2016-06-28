# Jack_TouchEvent_demo
目的：研究 dispatchTouchEvent onInterceptTouchEvent onTouchEvent 之间的关系
**示例背景：**MyViewGroup1包含了MyViewGroup2包含了MyViewGroup3包含了MyViewGroup4包含了MyView。
如图：
![](https://github.com/jacky1234/Jack_TouchEvent_demo/blob/master/pic/main.png)

1. 在所有研究的三个函数都是返回 false 时候
  ![](https://github.com/jacky1234/Jack_TouchEvent_demo/blob/master/pic/%E6%89%80%E6%9C%89%E4%B8%8D%E6%8B%A6%E6%88%AA.png)
  
  * 所有父控件的 dispatchTouchEvent 先执行，如果 onInterceptTouchEvent 返回 false，则直接调用子View的dispatchTouchEvent方法，周而复始。如果事件传入到最底层View，事件还是没有消费，则事件开始逐级上传。上级的 onTouchEvent 就会执行，如果上级的 onTouchEvent 都返回 false，则事件将会消失。**之后的不管是 ACTION_MOVE还是ACTION_UP动作都不会在dispatchTouchEvent onInterceptTouchEvent onTouchEvent函数中触发！**
2. 只有 MyViewGroup3 的 onInterceptTouchEvent 返回true 的时候
![](https://github.com/jacky1234/Jack_TouchEvent_demo/blob/master/pic/%E5%8F%AA%E6%9C%89MyViewGroup3%E7%9A%84onInterceptTouchEvent%E8%BF%94%E5%9B%9Etrue.png)
  * 事件只会传到 MyViewGroup3为止，不会向子View传递，这就是 onInterceptTouchEvent 的作用。
  * onInterceptTouchEvent 返回 true，代表要去拦截事件，但是 onTouchEvent 事件返回了 false。相当于没有消耗事件，然后事件又像[1]中的情况那样向上传递。直到一个 Parent 将这个事件消耗掉，**如果大家都不消耗这个事件，则事件又消失了，之后的不管是 ACTION_MOVE还是ACTION_UP动作都不会在dispatchTouchEvent onInterceptTouchEvent onTouchEvent函数中触发！**
3. 只有 MyViewGroup3 的onTouchEvent返回true
![](https://github.com/jacky1234/Jack_TouchEvent_demo/blob/master/pic/%E5%8F%AA%E6%9C%89MyViewGroup3%E7%9A%84onTouchEvent%E8%BF%94%E5%9B%9Etrue.png)
  * 增加对 ACTION_MOVE 和 ACTION_UP 的说明，以为在 ACTION_DOWN 事件中，MyViewGroup3 的子View 都没有消耗这个事件，系统之后就不会把一个事件序列的 ACTION 交给它了。即使 MyViewGroup3 的 onInterceptTouchEvent 返回 false，但是 ACTION_MOVE ACTION_UP 还是将事件直接交给它处理了。
4. MyViewGroup3 的 onInterceptTouchEvent 返回true；MyViewGroup2 的 onTouchEvent 只有 ACTION_DOWN 返回 true，其他 ACTION返回false;MyViewGroup1 的 onTouchEvent 返回 true；
![](https://github.com/jacky1234/Jack_TouchEvent_demo/blob/master/pic/Action_down.png)
* 看到 ACTION_MOVE ACTION_UP 还是直接交个 MyViewGroup2的 onTouchEvent 执行，虽然它在  ACTION_MOVE ACTION_UP 返回false,但是因为它拦截了时间序列的起始事件 ACTION_DOWN.
