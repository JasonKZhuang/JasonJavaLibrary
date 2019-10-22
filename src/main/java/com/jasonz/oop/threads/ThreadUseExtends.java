package com.jasonz.oop.threads;
/**
 * @creator Jason Zhuang
 * @create-time 2013-6-24
 * copywrite kkcms.com
 */
//é€šè¿‡ç»§æ‰¿Threadç±»,å¹¶å®žçŽ°å®ƒçš„æŠ½è±¡æ–¹æ³•run()
//é€‚å½“æ—¶å€™åˆ›å»ºè¿™ä¸€Threadå­�ç±»çš„å®žä¾‹æ�¥å®žçŽ°å¤šçº¿ç¨‹æœºåˆ¶
//ä¸€ä¸ªçº¿ç¨‹å�¯åŠ¨å�Žï¼ˆä¹Ÿå�³è¿›å…¥å°±ç»ªçŠ¶æ€�ï¼‰ä¸€æ—¦èŽ·å¾—CPUå°†è‡ªåŠ¨è°ƒç”¨å®ƒçš„run()æ–¹æ³•
public class ThreadUseExtends extends Thread
{
	ThreadUseExtends()
	{
	}// æž„é€ å‡½æ•°

	public void run()
	{
		System.out.println("æˆ‘æ˜¯Threadå­�ç±»çš„çº¿ç¨‹å®žä¾‹!");
		System.out.println("æˆ‘å°†æŒ‚èµ·10ç§’!");
		System.out.println("å›žåˆ°ä¸»çº¿ç¨‹,è¯·ç¨�ç­‰,åˆšæ‰�ä¸»çº¿ç¨‹æŒ‚èµ·å�¯èƒ½è¿˜æ²¡é†’è¿‡æ�¥ï¼�");
		try
		{
			sleep(10000);// æŒ‚èµ·5ç§’
		} catch (InterruptedException e)
		{
			return;
		}
		// å¦‚æžœè¯¥run()æ–¹æ³•é¡ºåº�æ‰§è¡Œå®Œäº†,çº¿ç¨‹å°†è‡ªåŠ¨ç»“æ�Ÿ,è€Œä¸�ä¼šè¢«ä¸»çº¿ç¨‹æ�€æŽ‰
		// ä½†å¦‚æžœä¼‘çœ æ—¶é—´è¿‡é•¿,åˆ™çº¿ç¨‹è¿˜å­˜æ´»,å�¯èƒ½è¢«stop()æ�€æŽ‰
	}
}