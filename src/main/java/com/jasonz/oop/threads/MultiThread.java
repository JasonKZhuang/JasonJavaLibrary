package com.jasonz.oop.threads;

import java.io.IOException;

/**
 * @creator Jason Zhuang
 * @create-time 2013-6-24 copywrite kkcms.com
 */

//ä¸»çº¿ç¨‹å°†å�¯åŠ¨ThreadUseExtendså’ŒThreadUseRunnableä¸¤ä¸ªçº¿ç¨‹
public class MultiThread
{
	public static void main(String args[])
	{
		System.out.println("æˆ‘æ˜¯ä¸»çº¿ç¨‹!");
		
		// ä¸‹é�¢åˆ›å»ºçº¿ç¨‹å®žä¾‹thread1
		ThreadUseExtends thread1 = new ThreadUseExtends();
		thread1.setName("FirstThread");
		
		// åˆ›å»ºthread2æ—¶ä»¥å®žçŽ°äº†RunnableæŽ¥å�£çš„THhreadUseRunnableç±»å®žä¾‹ä¸ºå�‚æ•°
		Thread thread2 = new Thread(new ThreadUseRunnable(), "SecondThread");
		
		// å�¯åŠ¨çº¿ç¨‹thread1ä½¿ä¹‹å¤„äºŽå°±ç»ªçŠ¶æ€�
		thread1.start();
		
		// thread1.setPriority(6);//è®¾ç½®thread1çš„ä¼˜å…ˆçº§ä¸º6
		// ä¼˜å…ˆçº§å°†å†³å®šcpuç©ºå‡ºæ—¶ï¼Œå¤„äºŽå°±ç»ªçŠ¶æ€�çš„çº¿ç¨‹è°�å…ˆå� é¢†cpuå¼€å§‹è¿�è¡Œ
		// ä¼˜å…ˆçº§èŒƒå›´1åˆ°10,MIN_PRIORITY,MAX_PRIORITY,NORM_PAIORITY
		// æ–°çº¿ç¨‹ç»§æ‰¿åˆ›å»ºå¥¹çš„çˆ¶çº¿ç¨‹ä¼˜å…ˆçº§,çˆ¶çº¿ç¨‹é€šå¸¸æœ‰æ™®é€šä¼˜å…ˆçº§å�³5NORM_PRIORITY
		System.out.println("ä¸»çº¿ç¨‹å°†æŒ‚èµ·7ç§’!");
		try
		{
			Thread.sleep(7000);// ä¸»çº¿ç¨‹æŒ‚èµ·7ç§’
		} catch (InterruptedException e)
		{
			return;
		}
		
		System.out.println("å�ˆå›žåˆ°äº†ä¸»çº¿ç¨‹!");

		//åˆ¤æ–­thread1çŠ¶æ€�
		if (thread1.isAlive())
		{
			thread1.stop();// å¦‚æžœthread1è¿˜å­˜åœ¨åˆ™æ�€æŽ‰ä»–
			System.out.println("thread1ä¼‘çœ è¿‡é•¿,ä¸»çº¿ç¨‹æ�€æŽ‰äº†thread1!");
		} else
		{
			System.out.println("ä¸»çº¿ç¨‹æ²¡å�‘çŽ°thread1,thread1å·²é†’é¡ºåº�æ‰§è¡Œç»“æ�Ÿäº†!");
		}

		// å�¯åŠ¨thread2
		thread2.start();
		System.out.println("ä¸»çº¿ç¨‹å�ˆå°†æŒ‚èµ·7ç§’!");
		try
		{
			Thread.sleep(7000);// ä¸»çº¿ç¨‹æŒ‚èµ·7ç§’
		} catch (InterruptedException e)
		{
			return;
		}
		System.out.println("å�ˆå›žåˆ°äº†ä¸»çº¿ç¨‹!");
		
		//åˆ¤æ–­thread2çŠ¶æ€�
		if (thread2.isAlive())
		{
			thread2.stop();// å¦‚æžœthread2è¿˜å­˜åœ¨åˆ™æ�€æŽ‰ä»–
			System.out.println("thread2ä¼‘çœ è¿‡é•¿ï¼Œä¸»çº¿ç¨‹æ�€æŽ‰äº†thread2!");
		} else
		{
			System.out.println("ä¸»çº¿ç¨‹æ²¡å�‘çŽ°thread2,thread2å·²é†’é¡ºåº�æ‰§è¡Œç»“æ�Ÿäº†!");
		}
		System.out.println("ç¨‹åº�ç»“æ�ŸæŒ‰ä»»æ„�é”®ç»§ç»­!");
		
		try
		{
			System.in.read();
		} catch (IOException e)
		{
			System.out.println(e.toString());
		}

	}// main
}// MultiThread



