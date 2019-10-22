package com.jasonz.oop.threads;

/**
 * @creator Jason Zhuang
 * @create-time 2013-6-24 copywrite kkcms.com
 */
// é€šè¿‡å®žçŽ°RunnableæŽ¥å�£ä¸­çš„run()æ–¹æ³•,å†�ä»¥è¿™ä¸ªå®žçŽ°äº†run()æ–¹æ³•çš„ç±»
// ä¸ºå�‚æ•°åˆ›å»ºThreadçš„çº¿ç¨‹å®žä¾‹
public class ThreadUseRunnable implements Runnable

{
	// Thread thread2=new Thread(this);
	// ä»¥è¿™ä¸ªå®žçŽ°äº†RunnableæŽ¥å�£ä¸­run()æ–¹æ³•çš„ç±»ä¸ºå�‚æ•°åˆ›å»ºThreadç±»çš„çº¿ç¨‹å®žä¾‹
	ThreadUseRunnable()
	{
	}// æž„é€ å‡½æ•°

	public void run()
	{
		System.out.println("æˆ‘æ˜¯Threadç±»çš„çº¿ç¨‹å®žä¾‹å¹¶ä»¥å®žçŽ°äº†RunnableæŽ¥å�£çš„ç±»ä¸ºå�‚æ•°!");
		System.out.println("æˆ‘å°†æŒ‚èµ·1ç§’!");
		System.out.println("å›žåˆ°ä¸»çº¿ç¨‹,è¯·ç¨�ç­‰ jn0-120 e20-040 ,åˆšæ‰�ä¸»çº¿ç¨‹æŒ‚èµ·å�¯èƒ½è¿˜æ²¡é†’è¿‡æ�¥ï¼�");
		try
		{
			Thread.sleep(1000);// æŒ‚èµ·5ç§’
		} catch (InterruptedException e)
		{
			return;
		}
		// å¦‚æžœè¯¥run()æ–¹æ³•é¡ºåº�æ‰§è¡Œå®Œäº†,çº¿ç¨‹å°†è‡ªåŠ¨ç»“æ�Ÿ,è€Œä¸�ä¼šè¢«ä¸»çº¿ç¨‹æ�€æŽ‰
		// ä½†å¦‚æžœä¼‘çœ æ—¶é—´è¿‡é•¿,åˆ™çº¿ç¨‹è¿˜å­˜æ´»,å�¯èƒ½è¢«stop()æ�€æŽ‰
	}
}